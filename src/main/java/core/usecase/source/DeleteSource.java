package core.usecase.source;

import core.exception.SourceNotExist;
import core.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSource {


    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private CheckSourceExist checkSourceExist;

    public void deleteIfExist(long id) throws SourceNotExist {

        if (checkSourceExist.isSourceExistById(id) == true) {
            sourceRepository.deleteById(id);
        }else{
            throw new SourceNotExist();
        }
    }
}
