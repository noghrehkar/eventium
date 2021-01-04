package adapter.presenter.presenter;

import java.util.ResourceBundle;

public abstract class ResourceBundleUtil {

    public static final String getMessage(String messageKey){
        return ResourceBundle.getBundle("messages").getString(messageKey);
    }
}
