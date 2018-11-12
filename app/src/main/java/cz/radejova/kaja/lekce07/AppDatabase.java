package cz.radejova.kaja.lekce07;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(version = 1, entities = {User.class}) //zadefinovani databaze
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
