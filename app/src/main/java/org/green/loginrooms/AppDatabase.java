package org.green.loginrooms;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by wilsoncastiblanco on 8/8/17.
 */
@Database(entities = {User.class, Roles.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}