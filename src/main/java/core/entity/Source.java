package core.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

    @OneToMany(targetEntity = Post.class,cascade = CascadeType.ALL)
    private Set<Post> posts;

    @OneToMany(targetEntity = Stream.class,cascade = CascadeType.ALL)
    private Set<Stream> streams;

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

    public String getAddress() {
        return url;
    }

    public void setAddress(String url) {
        this.url = url;
    }

    public Set<Stream> getStreams() {
        return streams;
    }

    public void setStreams(Set<Stream> streams) {
        this.streams = streams;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
