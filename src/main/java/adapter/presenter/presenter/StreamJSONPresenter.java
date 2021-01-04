package adapter.presenter.presenter;

import adapter.presenter.viewmodel.StreamView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import core.entity.Source;
import core.entity.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamJSONPresenter implements core.presenter.StreamJSONPresenter {

    @Autowired
    private ObjectMapper jacksonJSONConverter ;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public String convertToJSON(Stream stream) throws JsonProcessingException {

        StreamView streamView = modelMapper.map(stream, StreamView.class);
        return  jacksonJSONConverter.writeValueAsString(streamView);

    }

    @Override
    public String convertToJSON(List<Stream> streams) throws JsonProcessingException {
        StreamView[] streamView = modelMapper.map(streams, StreamView[].class);
        return  jacksonJSONConverter.writeValueAsString(streamView);
    }
}
