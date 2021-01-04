package adapter.presenter.viewmodel;

import core.entity.Source;

import java.util.List;


class StreamKeyword{

    Long id;
    String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class StreamSource {
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class StreamView {

     private Long id;
     private String name;
     private StreamSource source;
     private List<StreamKeyword> keywords;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StreamSource getSource() {
        return source;
    }

    public void setSource(StreamSource source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StreamKeyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<StreamKeyword> keywords) {
        this.keywords = keywords;
    }
}
