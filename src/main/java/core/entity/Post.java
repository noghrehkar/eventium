package core.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Where(clause = "deleted_at is null")
@SQLDelete(sql = "UPDATE post SET deleted_at=current_time() WHERE id=?")
public class Post extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    private String uuid;

    @ManyToOne
    private SocialAccount socialAccount;

    @ManyToOne
    private Source source;


    @ManyToMany
    @JoinTable(
            name = "post_stream",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "stream_id") }
    )
    private Set<Stream> streams;

    @ManyToMany(targetEntity = Keyword.class)
    @JoinTable(
            name = "post_keyword",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "keyword_id") }
    )
    private Set<Keyword> keywords;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public SocialAccount getSocialAccount() {
        return socialAccount;
    }

    public void setSocialAccount(SocialAccount socialAccount) {
        this.socialAccount = socialAccount;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Set<Stream> getStreams() {
        return streams;
    }

    public void setStreams(Set<Stream> streams) {
        this.streams = streams;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
