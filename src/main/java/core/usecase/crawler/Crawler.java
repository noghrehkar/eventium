package core.usecase.crawler;

import core.entity.Keyword;
import core.entity.Post;
import core.entity.Source;
import core.entity.Stream;
import twitter4j.TwitterException;

import java.util.List;
import java.util.Set;

public interface Crawler {
    List<Post> crawl(Set<Keyword> keywords) ;
    String getSourceName();


}
