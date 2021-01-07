package adapter.presenter.gateway;

import core.entity.Keyword;
import core.entity.Post;
import core.entity.SocialAccount;
import core.usecase.socialaccount.CheckSocialAccountExist;
import core.usecase.socialaccount.CreateSocialAccount;
import core.usecase.source.CreateSource;
import core.usecase.source.GetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TwitterCrawler  implements core.usecase.crawler.TwitterCrawler {

   @Autowired
   CheckSocialAccountExist checkSocialAccountExist;
   @Autowired
   GetSource getSource;

   @Autowired
   CreateSocialAccount createSocialAccount;

    @Override
    public List<Post> crawl(Set<Keyword> keywords) throws TwitterException {
        Twitter twitter = getTwitterCrawlerInstance();
        Query query=createQueryString(keywords);
        QueryResult result = twitter.search(query);
        return convertCrawledResultToPost(keywords,result.getTweets());
    }

    @Override
    public String getSourceName() {
        return sourceName;
    }

    private List<Post> convertCrawledResultToPost(Set<Keyword> keywords,List<Status> tweets){
        List<Post> newPosts=new ArrayList<>();
        for (Status tweet:tweets) {
            Post newPost=new Post();
            newPost.setBody(tweet.getText());
            newPost.setKeywords(keywords);
            SocialAccount newSocialAccount=createSocialAccount(tweet);
            newPost.setSocialAccount(newSocialAccount);
            newPost.setSource(getSource.getByName(getSourceName()));
            newPosts.add(newPost);
        }
        return newPosts;
    }

    private SocialAccount createSocialAccount(Status tweet){
       SocialAccount newSocialAccount=new SocialAccount();
        newSocialAccount.setUserName(tweet.getUser().getName());
        newSocialAccount.setDisplayName(tweet.getUser().getScreenName());
        newSocialAccount.setUuid(String.valueOf(tweet.getUser().getId()));
        newSocialAccount.setSource(getSource.getByName(getSourceName()));
        newSocialAccount=createSocialAccount.createSocialAccount(newSocialAccount);
        return newSocialAccount;
    }

    private Twitter  getTwitterCrawlerInstance(){
        TwitterFactory tf = new TwitterFactory();
        return tf.getInstance();

    }

    private Query createQueryString(Set<Keyword> keywords){
        String queryString="source:";
        for (Keyword keyword:keywords) {
            queryString+=keyword.getText()+" ";
        }
        Query query = new Query(queryString);
        return query;
    }
}
