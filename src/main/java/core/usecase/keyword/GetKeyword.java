package core.usecase.keyword;

import core.entity.Keyword;
import core.exception.KeywordNotExist;
import core.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetKeyword {

    @Autowired
    private KeywordRepository keywordRepository;

    @Autowired
    private CheckKeywordExist checkKeywordExist;

    public Keyword getKeywordByText(String text) throws KeywordNotExist {

        if(checkKeywordExist.checkKeywordExistByText(text)){
            return keywordRepository.findByText(text).get();
        }
        else{
            throw new KeywordNotExist();
        }

    }
}
