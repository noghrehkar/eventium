package adapter.presenter.presenter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.entity.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceJSONPresenter implements core.presenter.SourceJSONPresenter {

    @Autowired
    private ObjectMapper jacksonJSONConverter ;

    @Override
    public String convertToJSON(Source source) throws JsonProcessingException {
        return jacksonJSONConverter.writeValueAsString(source);

    }

    @Override
    public String convertToJSON(List<Source> sources) throws JsonProcessingException {
        return jacksonJSONConverter.writeValueAsString(sources);
    }
}
