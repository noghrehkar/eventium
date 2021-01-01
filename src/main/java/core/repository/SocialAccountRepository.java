package core.repository;

import core.entity.SocialAccount;
import core.entity.Stream;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialAccountRepository extends PagingAndSortingRepository<SocialAccount,Long> {
}
