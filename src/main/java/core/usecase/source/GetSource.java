package core.usecase.source;

import core.entity.Source;
import core.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetSource {



    @Autowired
    private SourceRepository sourceRepository;

    public List<Source> getAll() {
        return (List<Source>) sourceRepository.findAll();

    }

    public Optional<Source> getById(long id){
        return sourceRepository.findById(id);
    }

    public Optional<Source> getByName(String name) {
            return sourceRepository.findByName(name);

    }
}
