package org.green.loginrooms;

import android.app.Application;

/**
 * Created by wilsoncastiblanco on 8/9/17.
 */

public class GlobantApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(getApplicationContext());
    }
}
