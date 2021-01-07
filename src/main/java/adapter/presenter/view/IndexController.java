package adapter.presenter.view;

import core.entity.Post;
import core.usecase.post.GetPost;
import core.usecase.stream.GetStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    GetPost getPost;

    @Autowired
    GetStream getStream;

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = getPost.getAll(0,50);
        model.addAttribute("posts", posts);
        model.addAttribute("totalStream", getStream.getTotalStream());
        model.addAttribute("totalCrawledPost", getPost.getTotalPost());
        return "index";
    }

}
