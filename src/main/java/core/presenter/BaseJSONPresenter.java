package core.presenter;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface BaseJSONPresenter<T> {
     String convertToJSON(T t) throws JsonProcessingException;

     String convertToJSON(List<T> t) throws JsonProcessingException;
}
