package core.usecase.source;

import core.entity.Source;
import core.exception.SourceExist;
import core.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSource {

    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private CheckSourceExist checkSourceExist;



    public Source createIfNotExist(Source source) throws SourceExist{

            if (checkSourceExist.isSourceExistByName(source) == false) {
               Source createdSource= sourceRepository.save(source);
                return createdSource;
            }else{
                throw new SourceExist();
            }
    }



}
