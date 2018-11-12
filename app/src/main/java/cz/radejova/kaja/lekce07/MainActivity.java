package cz.radejova.kaja.lekce07;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.jmeno)
    public EditText jmeno;
    @BindView(R.id.prijmeni)
    public EditText prijmeni;

    User user;
    private AppDatabase app;
    private ListView main_list;
    private ArrayAdapter arrayAdapter;
    private ArrayList arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //ButterKnife se musi volat az po tom, co zavolam setContentView!!!

        app = Room.databaseBuilder(this, AppDatabase.class, "db").allowMainThreadQueries().build();

        main_list = findViewById(R.id.main_list);

        arrayList = new ArrayList();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        main_list.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();


    }

    public void pridatUzivateleDoDb(View view) {
        String firstName = jmeno.getText().toString();
        String lastName = prijmeni.getText().toString();


        if (firstName.length() == 0 || lastName.length() == 0) {
            Toast.makeText(this, "Zadejte minimálně jeden znak do pole Jméno nebo Příjmení.", Toast.LENGTH_LONG).show();
        } else {
            if (app.userDao().getByNames(firstName, lastName) != null) {
                Toast.makeText(this, "Tento uživatel už v databázi existuje.", Toast.LENGTH_LONG).show();
            } else {
                User user = new User(firstName, lastName);
                arrayList.add(user);
                arrayAdapter.notifyDataSetChanged();
                app.userDao().insertAll(user);
                Toast.makeText(this, "Uživatel byl uložen do databáze.", Toast.LENGTH_LONG).show();
            }
        }


    }
}
