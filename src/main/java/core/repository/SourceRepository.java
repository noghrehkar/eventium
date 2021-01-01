package core.repository;

import core.entity.Source;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends PagingAndSortingRepository<Source,Long> {

     Source findByName(String name);
}
