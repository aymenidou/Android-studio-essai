package com.aymen.essai;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Activity_sqlite extends AppCompatActivity implements View.OnClickListener {
    Button b_add, b_remove, b_update, b_rechercher;
    Db_helper db;
    EditText t_id, t_nom, t_prenom, t_age, t_phone;
    RadioButton f, m;
    RadioGroup r;
    Spinner s_id;
    Contact c;
    FileOutputStream file;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gest__contact__sqlite);
        b_add = findViewById(R.id.b_add);
        b_remove = findViewById(R.id.b_remove);
        b_update = findViewById(R.id.b_update);
        b_rechercher = findViewById(R.id.b_rechercher);
        b_add.setOnClickListener(this);
        b_remove.setOnClickListener(this);
        b_update.setOnClickListener(this);
        b_rechercher.setOnClickListener(this);
        db = new Db_helper(this);
        t_nom = findViewById(R.id.t_nom);
        t_prenom = findViewById(R.id.t_prenom);
        t_phone = findViewById(R.id.t_phone);
        t_age = findViewById(R.id.t_age);
        f = findViewById(R.id.r_f);
        m = findViewById(R.id.r_m);
        r = findViewById(R.id.r_group);
        s_id = findViewById(R.id.t_id);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item);
        try {
            file = new FileOutputStream("hey.db");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == b_add.getId()) {
            c = new Contact();
            c.setNom(t_nom.getText().toString());
            c.setPrenom(t_nom.getText().toString());
            if (f.isChecked()) {
                c.setSexe("F");
            } else {
                c.setSexe("M");
            }
            c.setAge(Integer.parseInt("" + t_age.getText()));
            c.setPhone(Integer.parseInt("" + t_phone.getText()));
            db.insert(c);
            Cursor cur = db.getAllData();
            while (cur.moveToNext()) {
                Log.e("Tag", cur.getString(1));

            }
            adapter.add(cur.getString(1));
        }
        if (v.getId() == b_update.getId()) {


        }
    }
}
