package core.usecase.crawler;


import core.entity.Post;
import core.entity.Stream;
import core.usecase.post.CreatePost;
import core.usecase.source.GetSource;
import core.usecase.stream.GetStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.TwitterException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MainCrawler {

    @Autowired
    TwitterCrawler twitterCrawler;

    @Autowired
    GetStream getStream;

    @Autowired
    GetSource getSource;

    @Autowired
    CreatePost createPost;

    @Transactional
    public void crawl() throws TwitterException {
        Crawler[] crawlerList=new Crawler[]{twitterCrawler};
        for (Crawler crawler:crawlerList) {
            List<Stream> allStreams = getStream.getBySource(getSource.getByName(crawler.getSourceName()));
            for (Stream stream:allStreams) {
                List<Post> newPosts = crawler.crawl(stream.getKeywords());
                createPost.createPostsForStream(stream,newPosts);
            }
        }
    }
}
