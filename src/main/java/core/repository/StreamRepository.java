package core.repository;

import core.entity.Stream;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends PagingAndSortingRepository<Stream,Long> {
}
