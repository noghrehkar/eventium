package core.exception;

public class SocialAccountExist extends Exception {

    public SocialAccountExist(String errorMessage){
        super(errorMessage);
    }

    public SocialAccountExist() {
        super();
    }
}
