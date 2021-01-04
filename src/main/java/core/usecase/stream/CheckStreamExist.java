package core.usecase.stream;

import core.entity.Stream;
import core.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckStreamExist {

    @Autowired
    private StreamRepository streamRepository;

    public boolean isStreamExistById(Long id){
        Optional<Stream> foundStream = streamRepository.findById(id);
        if(foundStream.isEmpty()) {
            return false;
        }else{
            return true;
        }
    }
}
