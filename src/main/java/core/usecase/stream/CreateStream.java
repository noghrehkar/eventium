package core.usecase.stream;

import core.entity.Keyword;
import core.entity.Source;
import core.entity.Stream;
import core.repository.StreamRepository;
import core.usecase.keyword.CreateKeyword;
import core.usecase.source.GetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CreateStream {

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private CreateKeyword createKeyword;



    public Stream createStream(Stream newStream){
        Set<Keyword> keywords = createKeyword.createKeywordIfNotExist(newStream.getKeywords());
        newStream.setKeywords(keywords);
        Stream createdStream = streamRepository.save(newStream);
        return createdStream;
    }


}
