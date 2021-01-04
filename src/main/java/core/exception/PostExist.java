package core.exception;

public class PostExist extends Exception {

    public PostExist(String errorMessage){
        super(errorMessage);
    }

    public PostExist() {
        super();
    }
}
