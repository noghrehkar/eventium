package core.usecase.stream;

import core.entity.Stream;
import core.exception.StreamNotExist;
import core.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditStream {

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private CheckStreamExist checkStreamExist;

    @Autowired
    private GetStream getStream;

    public Stream editIfExist(Stream streamNewData) throws StreamNotExist {
        if(checkStreamExist.isStreamExistById(streamNewData.getId())){
            Stream oldStream = getStream.getById(streamNewData.getId()).get();
            oldStream.setKeywords(streamNewData.getKeywords());
            oldStream.setSource(streamNewData.getSource());
            oldStream.setName(streamNewData.getName());
            Stream updatedStream = streamRepository.save(oldStream);
            return updatedStream;
        }else{
            throw new StreamNotExist();
        }

    }
}
