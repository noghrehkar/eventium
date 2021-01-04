package core.repository;

import core.entity.Post;
import core.entity.SocialAccount;
import core.entity.Source;
import core.entity.Stream;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocialAccountRepository extends PagingAndSortingRepository<SocialAccount,Long> {

    Optional<SocialAccount> findBySourceAndUuid(Source source,String uuid);
}
