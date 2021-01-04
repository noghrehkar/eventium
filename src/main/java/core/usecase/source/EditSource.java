package core.usecase.source;

import core.entity.Source;
import core.exception.SourceNotExist;
import core.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditSource {


    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private GetSource getSource;

    public Source editIfExist(Source source) throws SourceNotExist {

        Optional<Source> foundSource = getSource.getById(source.getId());
        if (foundSource.isEmpty() == false) {
            Source oldSource = foundSource.get();
            oldSource.setName(source.getName());
            oldSource.setUrl(source.getUrl());
            oldSource = sourceRepository.save(oldSource);
            return oldSource;
        } else {
            throw new SourceNotExist();
        }
    }
}
