package core.repository;

import core.entity.Source;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SourceRepository extends PagingAndSortingRepository<Source,Long> {

     Optional<Source> findByName(String name);
}
