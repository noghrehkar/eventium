package core.repository;

import core.entity.Source;
import core.entity.Stream;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreamRepository extends PagingAndSortingRepository<Stream,Long> {

    List<Stream> findBySource(Source source);
}
