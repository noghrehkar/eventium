package core.presenter;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface BaseJSONPresenter<T> {
     String convertToJSON(T t) throws JsonProcessingException;
}
