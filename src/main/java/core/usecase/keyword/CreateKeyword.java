package core.usecase.keyword;

import core.entity.Keyword;
import core.exception.KeywordExist;
import core.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CreateKeyword {

    @Autowired
    private KeywordRepository keywordRepository;

    @Autowired
    private CheckKeywordExist checkKeywordExist;

    public Keyword createKeywordIfNotExist(Keyword newKeyword) throws KeywordExist {
        if(checkKeywordExist.checkKeywordExistByText(newKeyword.getText())==false){
            return keywordRepository.save(newKeyword);
        }else{
            throw new KeywordExist();
        }
    }

    public Set<Keyword> createKeywordIfNotExist(Set<Keyword> keywords) {
        Set<Keyword> newKeywords=new HashSet<>();
        for (Keyword newKeyword:keywords) {
            if(checkKeywordExist.checkKeywordExistByText(newKeyword.getText())==false){
                newKeywords.add(keywordRepository.save(newKeyword));
            }else{
                newKeywords.add(keywordRepository.findByText(newKeyword.getText()).get());
            }
        }
        return newKeywords;
    }
}
