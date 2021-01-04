package core.usecase.post;

import core.entity.Post;
import core.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CheckPostExist {

    @Autowired
    private PostRepository postRepository;

    public boolean isPostExistBySourceAndUuid(Post post){
        Optional<Post> foundPost = postRepository.findBySourceAndUuid(post.getSource(), post.getUuid());
        if(foundPost.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public boolean isPostExistById(Long id){
        Optional<Post> foundPost = postRepository.findById(id);
        if(foundPost.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

}
