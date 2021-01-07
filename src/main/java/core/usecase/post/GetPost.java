package core.usecase.post;

import core.entity.Post;
import core.entity.Source;
import core.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetPost {

    @Autowired
    PostRepository postRepository;

    private final String SORT_FIELD="createdAt";


    public Optional<Post> getById(Long id){
            return postRepository.findById(id);
    }


    public List<Post> getAll(int page,int pageSize){
        Sort sort=Sort.by(Sort.Direction.DESC, SORT_FIELD);

        Pageable pageData=PageRequest.of(page,pageSize, sort);
        Page<Post> postPages = postRepository.findAll(pageData);
        return postPages.getContent();
    }

    public List<Post> getAll(){
        Iterable<Post> posts = postRepository.findAll();
        return (List<Post>) posts;
    }

    public Optional<Post> getPostBySourceAndUuid(Source source, String uuid){
        return   postRepository.findBySourceAndUuid(source, uuid);

    }

    public Long getTotalPost(){
        return postRepository.count();
    }

}
