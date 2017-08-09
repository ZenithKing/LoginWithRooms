package org.green.loginrooms;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by wilsoncastiblanco on 8/8/17.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM users WHERE " +
            "user_name = :userName AND " +
            "password  = :password")
    User login(String userName, String password);

    @Insert
    void insertUser(User user);
}
