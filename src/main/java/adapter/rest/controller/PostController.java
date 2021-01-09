package adapter.rest.controller;


import adapter.presenter.presenter.PostJSONPresenter;
import adapter.presenter.presenter.ResourceBundleUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.entity.Post;
import core.entity.Source;
import core.exception.PostExist;
import core.exception.PostNotExist;
import core.usecase.post.CreatePost;
import core.usecase.post.DeletePost;
import core.usecase.post.GetPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    CreatePost createPost;

    @Autowired
    DeletePost deletePost;

    @Autowired
    GetPost getPost;

    @Autowired
    PostJSONPresenter postJSONPresenter;

    @PostMapping("/")
    public @ResponseBody
    String createPost(@RequestBody Post post) {

        try {
            Post createdPost = createPost.createPostIfNotExist(post);
            return postJSONPresenter.convertToJSON(createdPost);
        } catch (PostExist | JsonProcessingException postExist) {
            return ResourceBundleUtil.getMessage("post.exist");
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    String deletePost(@PathVariable long id) {
        try {
            deletePost.deleteById(id);
            return ResourceBundleUtil.getMessage("post.delete_successful");
        } catch ( PostNotExist postExist) {
            return ResourceBundleUtil.getMessage("post.not_exist");
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody
    String getPost(@PathVariable Long id) throws JsonProcessingException {

        Optional<Post> post = getPost.getById(id);
        if (post.isEmpty() == false) {
            return postJSONPresenter.convertToJSON(post.get());
        } else {
            return ResourceBundleUtil.getMessage("post.not_exist");
        }
    }

    @GetMapping("/")
    public @ResponseBody
    String getAllPost() throws JsonProcessingException {

        List<Post> posts = getPost.getAll();
        return postJSONPresenter.convertToJSON(posts);

    }





}
