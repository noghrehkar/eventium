package core.exception;

public class SourceNotExist extends Exception {

    public SourceNotExist(String errorMessage){
        super(errorMessage);
    }

    public SourceNotExist() {
        super();
    }
}
