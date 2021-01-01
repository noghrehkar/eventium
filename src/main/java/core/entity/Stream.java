package core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany(targetEntity = Keyword.class,cascade = CascadeType.ALL)
    @JoinTable(
            name = "stream_keyword",
            joinColumns = { @JoinColumn(name = "stream_id") },
            inverseJoinColumns = { @JoinColumn(name = "keyword_id") }
    )
    private Set<Keyword> keywords;

    @ManyToMany(mappedBy = "streams")
    private Set<Post> posts;

    @ManyToOne
    private Source source;

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

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
