package cz.radejova.kaja.lekce07;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "user") //anotace
public class User {

    public User() {}

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public Integer uid;

    //@ColumnInfo - nazev sloupce v DB @ColumnInfo(name = "prijmeni") -> specificke pojmenovani sloupcu, nzv, ktery se bude zobrazovat v DB
    public String firstName;

    //@Ignore - neco, co nechci pouzit v DB
    public String lastName;
}
