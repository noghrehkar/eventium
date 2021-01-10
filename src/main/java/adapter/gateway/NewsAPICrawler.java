package adapter.gateway;

import adapter.presenter.viewmodel.Article;
import adapter.presenter.viewmodel.NewsAPIContent;
import core.entity.Keyword;
import core.entity.Post;
import core.exception.SourceNotExist;
import core.usecase.post.GetPost;
import core.usecase.source.GetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class NewsAPICrawler implements core.usecase.crawler.NewsAPICrawler {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GetSource getSource;

    @Autowired
    private Environment env;

    @Autowired
    private GetPost getPost;

    @Override
    public List<Post> crawl(Set<Keyword> keywords)  {
        NewsAPIContent result = restTemplate.getForObject(createQueryString(keywords), NewsAPIContent.class);
        List<Post> posts = null;
        try {
            posts = convertCrawledDataToPost(keywords, result);
        } catch (SourceNotExist sourceNotExist) {
            sourceNotExist.printStackTrace();
        }
        System.out.println(result);
        return posts;
    }

    private String createQueryString(Set<Keyword> keywords){
        String url=env.getProperty("newsapi.url")+"sortBy="+env.getProperty("newsapi.sortBy")+"&apiKey="+env.getProperty("newsapi.apikey")+"&";
        String query="q=";
        for (Keyword keyword : keywords) {
            query=query+keyword.getText()+"&";
        }
        query=url+query+"from="+getLatestDate();
        return query;
    }

    private List<Post> convertCrawledDataToPost(Set<Keyword> keywords,NewsAPIContent newsAPIContent) throws SourceNotExist {
        List<Post> posts=new ArrayList<>();
        for (Article article:newsAPIContent.getArticles()) {
            Post post=new Post();
            if(getSource.getByName(getSourceName()).isEmpty()==false){
                post.setSource(getSource.getByName(getSourceName()).get());
            }else{
                throw new SourceNotExist();
            }
            post.setKeywords(new HashSet<>());
            post.getKeywords().addAll(keywords);
            post.setBody(article.getContent());
            post.setUuid(article.getUrl().substring(0,255));
            post.setSocialAccount(null);
            post.setStreams(new HashSet<>());
            posts.add(post);
        }
        return posts;
    }



    @Override
    public String getSourceName() {
        return sourceName;
    }

    private String getLatestDate(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        return getPost.getLatestPostBySource(getSource.getByName(getSourceName()).get()).getCreatedAt().format(myFormatObj);
    }
}
