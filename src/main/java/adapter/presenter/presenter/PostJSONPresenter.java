package adapter.presenter.presenter;

import adapter.presenter.viewmodel.PostView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostJSONPresenter implements core.presenter.PostJSONPresenter {

    @Autowired
    private ObjectMapper jacksonJSONConverter;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String convertToJSON(Post post) throws JsonProcessingException {

        PostView postView = modelMapper.map(post, PostView.class);
        return jacksonJSONConverter.writeValueAsString(postView);

    }

    @Override
    public String convertToJSON(List<Post> posts) throws JsonProcessingException {
        PostView[] postView = modelMapper.map(posts, PostView[].class);
        return jacksonJSONConverter.writeValueAsString(postView);
    }


}
