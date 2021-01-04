package core.usecase.post;


import core.exception.PostNotExist;
import core.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePost {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CheckPostExist checkPostExist;


    public void deleteById(Long id) throws PostNotExist {
        if(checkPostExist.isPostExistById(id)){
            postRepository.deleteById(id);
        }else{
            throw new PostNotExist();
        }

    }
}
