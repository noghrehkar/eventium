package core.usecase.post;

import core.entity.Post;
import core.entity.SocialAccount;
import core.exception.PostExist;
import core.repository.PostRepository;
import core.usecase.socialaccount.CheckSocialAccountExist;
import core.usecase.socialaccount.CreateSocialAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePost {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CheckPostExist checkPostExist;

    @Autowired
    private CreateSocialAccount socialAccount;

    public Post createPostIfNotExist(Post newPost) throws PostExist {
        if(checkPostExist.isPostExistBySourceAndUuid(newPost)==false){

            SocialAccount persistedSocialAccount = socialAccount.createSocialAccount(newPost.getSocialAccount());
            newPost.setSocialAccount(persistedSocialAccount);
            Post createdPost = postRepository.save(newPost);
            return createdPost;
        }else{
            throw new PostExist();
        }
    }


}
