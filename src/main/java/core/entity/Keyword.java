package core.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;



@Entity
@Where(clause = "deleted_at is null")
@SQLDelete(sql = "UPDATE keyword SET deleted_at=current_time() WHERE id=?")
public class Keyword extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToMany(mappedBy = "keywords")
    private Set<Post> posts;

    @ManyToMany(mappedBy = "keywords")
    private Set<Stream> streams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String body) {
        this.text = body;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Stream> getStreams() {
        return streams;
    }

    public void setStreams(Set<Stream> streams) {
        this.streams = streams;
    }

}
