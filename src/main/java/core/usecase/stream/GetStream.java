package core.usecase.stream;

import core.entity.Stream;
import core.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetStream {

    @Autowired
    private StreamRepository streamRepository;

    public Optional<Stream> getById(Long id) {
        Optional<Stream> stream = streamRepository.findById(id);
        return stream;
    }

    public List<Stream> getAll() {
        return (List<Stream>) streamRepository.findAll();
    }

}
