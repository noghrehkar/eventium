package core.usecase.socialaccount;

import core.entity.SocialAccount;
import core.exception.SocialAccountExist;
import core.repository.SocialAccountRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSocialAccount {

    @Autowired
    private SocialAccountRepository socialAccountRepository;

    @Autowired
    private CheckSocialAccountExist checkSocialAccountExist;

    public SocialAccount createSocialAccount(SocialAccount socialAccount)  {
        if(checkSocialAccountExist.isSocialAccountExist(socialAccount)==false) {
            SocialAccount createdSocialAccount = socialAccountRepository.save(socialAccount);
            return createdSocialAccount;
        }else{
            return socialAccountRepository.findBySourceAndUuid(socialAccount.getSource(),socialAccount.getUuid()).get();
        }
    }

}
