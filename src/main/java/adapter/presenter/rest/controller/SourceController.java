package adapter.presenter.rest.controller;

import adapter.presenter.presenter.ResourceBundleUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.entity.Source;
import core.exception.SourceExist;
import core.exception.SourceNotExist;
import core.presenter.SourceJSONPresenter;
import core.usecase.source.CreateSource;
import core.usecase.source.DeleteSource;
import core.usecase.source.EditSource;
import core.usecase.source.GetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    private CreateSource createSource;

    @Autowired
    private DeleteSource deleteSource;

    @Autowired
    private EditSource editSource;

    @Autowired
    private GetSource getSource;

    @Autowired
    private SourceJSONPresenter sourceJSONPresenter;

    @PostMapping("/")
    public @ResponseBody
    String createSource(@RequestBody Source source) {

        try {
            Source createdSource = createSource.createIfNotExist(source);
            return sourceJSONPresenter.convertToJSON(createdSource);
        } catch (SourceExist | JsonProcessingException sourceExist) {
            return ResourceBundleUtil.getMessage("source.exist");

        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    String deleteSource(@PathVariable long id) {

        try {
            deleteSource.deleteIfExist(id);
            return ResourceBundleUtil.getMessage("source.delete_successful");
        } catch (SourceNotExist sourceExist) {
            return ResourceBundleUtil.getMessage("source.not_exist");

        }
    }

    @PutMapping("/")
    public @ResponseBody
    String editSource(@RequestBody Source source) {

        try {
            Source updatedSource = editSource.editIfExist(source);
            return sourceJSONPresenter.convertToJSON(updatedSource);
        } catch (SourceNotExist | JsonProcessingException sourceExist) {
            return ResourceBundleUtil.getMessage("source.not_exist");

        }
    }

    @GetMapping("/{id}")
    public @ResponseBody
    String getSource(@PathVariable Long id) throws JsonProcessingException {

        Optional<Source> source = getSource.getById(id);
        if (source.isEmpty() == false) {
            return sourceJSONPresenter.convertToJSON(source.get());
        } else {
            return ResourceBundleUtil.getMessage("source.not_exist");
        }
    }

    @GetMapping("/")
    public @ResponseBody
    String getAllSource() throws JsonProcessingException {

        List<Source> allSource = getSource.getAll();
        return sourceJSONPresenter.convertToJSON(allSource);
    }


}
