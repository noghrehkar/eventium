package adapter.gateway;


import core.exception.SourceNotExist;
import core.usecase.crawler.MainCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledCrawl {

    @Autowired
    MainCrawler mainCrawler;

    @Scheduled(fixedDelay = 864000000)
    public void crawl() throws  SourceNotExist {

        mainCrawler.crawl();
    }

}
