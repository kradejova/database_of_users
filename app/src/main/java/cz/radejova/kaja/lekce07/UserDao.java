package cz.radejova.kaja.lekce07;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertAll(User ... users); //metoda pro vkladani do DB, tri tecky rikaji, ze tech objektu muze byt vice

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid = :uid")
    User getByUid(int uid);

    @Query("SELECT * FROM user WHERE firstName = :firstName AND lastName = :lastName") //metoda na overeni, ze ten uzivatel v DB existuje nebo ne
    User getByNames(String firstName, String lastName);
}

