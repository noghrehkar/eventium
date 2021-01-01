package core.usecase.admin.source;

import core.entity.Source;
import core.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckSourceExist {

    @Autowired
    private SourceRepository sourceRepository;

    public boolean isSourceExist(Source source) {
        if (sourceRepository.findByName(source.getName()) == null) {
            return false;
        } else {
            return true;
        }

    }
}
