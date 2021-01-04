package core.usecase.stream;

import core.exception.StreamNotExist;
import core.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStream {

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private CheckStreamExist checkStreamExist;

    public void deleteById(Long id) throws StreamNotExist {
        if(checkStreamExist.isStreamExistById(id)==true) {
            streamRepository.deleteById(id);
        }else{
            throw  new StreamNotExist();
        }

    }
}
