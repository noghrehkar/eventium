package core.usecase.post;

import core.entity.Post;
import core.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPost {

    @Autowired
    PostRepository postRepository;

    public Optional<Post> getById(Long id){
            return postRepository.findById(id);
    }

    public List<Post> getAll(){
        return (List<Post>) postRepository.findAll();
    }

}
