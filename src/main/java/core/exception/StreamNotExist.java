package core.exception;

public class StreamNotExist extends Exception {
    public StreamNotExist(String errorMessage){
        super(errorMessage);
    }

    public StreamNotExist() {
        super();
    }
}
