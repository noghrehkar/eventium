package core.entity;

import core.repository.SocialAccountRepository;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;


@Entity
@Where(clause = "deleted_at is null")
@SQLDelete(sql = "UPDATE source SET deleted_at=current_time() WHERE id=?")
public class Source extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

    @OneToMany(targetEntity = Post.class)
    private Set<Post> posts;

    @OneToMany(targetEntity = Stream.class,cascade = CascadeType.ALL)
    private Set<Stream> streams;

    @OneToMany(targetEntity = SocialAccount.class)
    private Set<SocialAccount> socialAccounts;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
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

    public Set<SocialAccount> getSocialAccounts() {
        return socialAccounts;
    }

    public void setSocialAccounts(Set<SocialAccount> socialAccounts) {
        this.socialAccounts = socialAccounts;
    }
}
