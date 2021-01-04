package core.usecase.source;

import core.entity.Source;
import core.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckSourceExist {

    @Autowired
    private SourceRepository sourceRepository;

    public boolean isSourceExistByName(Source source) {
        if (sourceRepository.findByName(source.getName()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSourceExistById(long id) {
        if (sourceRepository.findById(id).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
