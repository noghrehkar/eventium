package core.exception;

import core.entity.Keyword;

public class KeywordExist extends  Exception{

    public KeywordExist(){
        super();
    }

    public KeywordExist(String errorMessage){
        super(errorMessage);
    }
}
