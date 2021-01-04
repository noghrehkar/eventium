package core.usecase.keyword;

import core.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckKeywordExist {

    @Autowired
    private KeywordRepository keywordRepository;

    public boolean checkKeywordExistByText(String text){
        if(keywordRepository.findByText(text).isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
