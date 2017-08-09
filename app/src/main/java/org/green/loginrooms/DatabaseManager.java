package org.green.loginrooms;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by wilsoncastiblanco on 8/9/17.
 */

public class DatabaseManager {

    private static DatabaseManager INSTANCE;
    private AppDatabase database;

    private DatabaseManager(Context context) {
        database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "globant-database").build();
    }

    public synchronized static void init(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseManager(context);
        }
    }

    public static DatabaseManager getInstance() {
        return INSTANCE;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
