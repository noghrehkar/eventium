package adapter.presenter.gateway;


import core.usecase.crawler.MainCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import twitter4j.TwitterException;

@Service
public class ScheduledCrawl {

    @Autowired
    MainCrawler mainCrawler;

    @Scheduled(fixedDelay = 10000)
    public void crawl() throws TwitterException {

      //  mainCrawler.crawl();
    }

}
