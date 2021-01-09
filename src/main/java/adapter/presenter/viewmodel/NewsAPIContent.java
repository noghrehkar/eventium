package adapter.presenter.viewmodel;

import java.util.List;

public class NewsAPIContent {

    private String Status;
    private List<Article> articles;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

