package org.green.loginrooms;

import android.app.IntentService;
import android.content.Intent;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class DatabaseIntentService extends IntentService {

    public static final String LOGIN_ACTION = "org.example.rooms.LOGIN";
    public static final String REGISTER_ACTION = "org.example.rooms.REGISTER";

    public DatabaseIntentService() {
        super("DatabaseIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(LOGIN_ACTION.equals(intent.getAction())){

        } else if(REGISTER_ACTION.equals(intent.getAction())){
        }
    }
}
