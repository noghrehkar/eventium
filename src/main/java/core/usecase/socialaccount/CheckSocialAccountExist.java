package core.usecase.socialaccount;

import core.entity.SocialAccount;
import core.repository.SocialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckSocialAccountExist {

    @Autowired
    private SocialAccountRepository socialAccountRepository;

    public boolean isSocialAccountExistBySourceAndUuid(SocialAccount socialAccount) {
        Optional<SocialAccount> foundSocialAccount = socialAccountRepository.findBySourceAndUuid(socialAccount.getSource(), socialAccount.getUuid());
        if (foundSocialAccount.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
