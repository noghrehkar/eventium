package core.exception;

public class KeywordNotExist extends  Exception{

    public KeywordNotExist(){
        super();
    }

    public KeywordNotExist(String errorMessage){
        super(errorMessage);
    }
}
