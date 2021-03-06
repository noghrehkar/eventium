package core.repository;

import core.entity.Post;
import core.entity.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post,Long> {

    Optional<Post> findBySourceAndUuid(Source source, String uuid);
    Page<Post> findBySource(Source source,Pageable pageable);
}
