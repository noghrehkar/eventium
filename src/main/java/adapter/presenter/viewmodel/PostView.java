package adapter.presenter.viewmodel;

import java.util.List;

class PostSocialAccount{

    String userName;
    String displayName;
    String uuid;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

class PostKeyword{

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

class PostSource {
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

public class PostView {

     private Long id;
     private String body;
     private PostSource source;
     private List<PostKeyword> keywords;
     private PostSocialAccount socialAccount;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public PostSource getSource() {
        return source;
    }

    public void setSource(PostSource source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PostKeyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<PostKeyword> keywords) {
        this.keywords = keywords;
    }

    public PostSocialAccount getSocialAccount() {
        return socialAccount;
    }

    public void setSocialAccount(PostSocialAccount socialAccount) {
        this.socialAccount = socialAccount;
    }
}
