package core.repository;

import core.entity.Keyword;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends PagingAndSortingRepository<Keyword,Long> {
}
