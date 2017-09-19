package org.green.loginrooms;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

/**
 * Created by wilsoncastiblanco on 8/9/17.
 */

public class DatabaseManager {

    private static DatabaseManager INSTANCE;
    private AppDatabase database;

    private DatabaseManager(Context context) {
        database = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class, "globant-database")
                .addMigrations(MIGRATION_1_2, MIGRATION_4_5)
                .build();
    }

    static final Migration MIGRATION_1_2 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE users ADD COLUMN age INTEGER");
        }
    };
    static final Migration MIGRATION_4_5 = new Migration(5, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS UserNameUnique ON users (user_name)");
        }
    };

    public synchronized static void init(Context context) {
            INSTANCE = new DatabaseManager(context);
    }

    public static DatabaseManager getInstance() {
        return INSTANCE;
    }

    public AppDatabase getDatabase() {
        return database;


    }
}
