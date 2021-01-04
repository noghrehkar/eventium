package adapter.presenter.rest.controller;


import adapter.presenter.presenter.ResourceBundleUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.entity.Stream;
import core.exception.StreamNotExist;
import core.presenter.StreamJSONPresenter;
import core.usecase.stream.CreateStream;
import core.usecase.stream.DeleteStream;
import core.usecase.stream.EditStream;
import core.usecase.stream.GetStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stream")
public class StreamController {

    @Autowired
    private CreateStream createStream;

    @Autowired
    private GetStream getStream;

    @Autowired
    private DeleteStream deleteStream;

    @Autowired
    private EditStream editStream;

    @Autowired
    private StreamJSONPresenter streamJSONPresenter;

    @PostMapping("/")
    public @ResponseBody String createStream(@RequestBody Stream newStream) throws JsonProcessingException {
        Stream createdStream = createStream.createStream(newStream);
        return streamJSONPresenter.convertToJSON(createdStream);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    String getStream(@PathVariable Long id) throws JsonProcessingException {

        Optional<Stream> stream = getStream.getById(id);
        if (stream.isEmpty() == false) {
            return streamJSONPresenter.convertToJSON(stream.get());
        } else {
            return ResourceBundleUtil.getMessage("stream.not_exist");
        }
    }

    @GetMapping("/")
    public @ResponseBody
    String getAllStream() throws JsonProcessingException {

        List<Stream> stream = getStream.getAll();
        return streamJSONPresenter.convertToJSON(stream);

    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    String deleteStream(@PathVariable Long id) throws  StreamNotExist {

        Optional<Stream> stream = getStream.getById(id);
        if (stream.isEmpty() == false) {
            deleteStream.deleteById(id);
            return ResourceBundleUtil.getMessage("stream.delete_successful");
        } else {
            return ResourceBundleUtil.getMessage("stream.not_exist");
        }
    }

    @PutMapping("/")
    public @ResponseBody
    String editStream(@RequestBody Stream stream) {

        try {
            Stream updatedStream = editStream.editIfExist(stream);
            return streamJSONPresenter.convertToJSON(updatedStream);
        } catch (JsonProcessingException | StreamNotExist sourceExist) {
            return ResourceBundleUtil.getMessage("stream.not_exist");

        }
    }








}
