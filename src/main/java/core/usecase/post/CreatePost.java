package core.usecase.post;

import core.entity.Post;
import core.entity.SocialAccount;
import core.entity.Stream;
import core.exception.PostExist;
import core.repository.PostRepository;
import core.usecase.socialaccount.CheckSocialAccountExist;
import core.usecase.socialaccount.CreateSocialAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreatePost {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CheckPostExist checkPostExist;

    @Autowired
    private CreateSocialAccount socialAccount;

    @Autowired
    private GetPost getPost;

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

    public List<Post> createPostsForStream(Stream stream, List<Post> newPosts) {
        List<Post> newCreatedPosts=new ArrayList<>();
        for (Post newPost:newPosts) {
            if(checkPostExist.isPostExistBySourceAndUuid(newPost)==false){
                SocialAccount persistedSocialAccount = socialAccount.createSocialAccount(newPost.getSocialAccount());
                newPost.setSocialAccount(persistedSocialAccount);
                newPost.getStreams().add(stream);
                Post createdPost = postRepository.save(newPost);
                newCreatedPosts.add(createdPost);
            }else{
                Post existPost = getPost.getPostBySourceAndUuid(newPost.getSource(), newPost.getUuid()).get();
                existPost.getStreams().add(stream);
                existPost=postRepository.save(existPost);
                newCreatedPosts.add(existPost);
            }
        }
        return newCreatedPosts;

    }


}
