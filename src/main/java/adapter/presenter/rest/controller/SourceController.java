package adapter.presenter.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.entity.Source;
import core.exception.SourceExist;
import core.presenter.SourceJSONPresenter;
import core.usecase.admin.source.CreateSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SourceController {

    @Autowired
    private CreateSource createSource;

    @Autowired
    private SourceJSONPresenter sourceJSONPresenter;

    @PostMapping("/source")
    public @ResponseBody String createSource(@RequestBody Source source){

        try {
            Source createdSource=createSource.createIfNotExist(source);
            return sourceJSONPresenter.convertToJSON(createdSource);
        } catch (SourceExist | JsonProcessingException sourceExist) {
            return sourceExist.getMessage();

        }
    }


}
