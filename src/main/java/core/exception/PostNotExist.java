package core.exception;

public class PostNotExist extends Exception {

    public PostNotExist(String errorMessage){
        super(errorMessage);
    }

    public PostNotExist() {
        super();
    }
}
