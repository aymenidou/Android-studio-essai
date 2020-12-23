package com.aymen.essai;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivityList extends AppCompatActivity {
    ListView list_view;
    ArrayList<String> list_nom = new ArrayList<>();
    Random r = new Random();
//    ArrayList<Contact> list_contact = new ArrayList<>();
//    ArrayAdapter<String> tab ;
//    String[] list_nom = new String[]{"alpha", "beta", "gama"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        list_view = findViewById(R.id.list_view);
//        CustomAdapter tab = new CustomAdapter(MainActivityList.this, list_contact);

//         tab = new ArrayAdapter<>(list_view.getContext(), R.layout.activity_ligne, R.id.text_view);
//        ArrayAdapter<String> tab = new ArrayAdapter<>(list_view.getContext(),R.layout.complex,R.id.text_view_1);
//        for (int i = 0; i < 20; i++) {
//            list_nom.add(i + " - " + "ab " + i * 2+r.nextInt());
//        }
//        for (int i = 0; i < 20; i++) {
//            Contact c = new Contact(i, "ab" + i * 2, String.valueOf(r.nextInt()),i);
//            tab.add(c);
//        }
//        for (int i = 0; i < 20; i++) {
//            Contact c = new Contact(r.nextInt(), "DBA" + i * 2, "alpha" + i);
//            list_contact.add(c);
//        }

//        list_view.setAdapter(tab);


        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = list_view.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), "Position: " + itemPosition + " Item Clicked: " + itemValue, Toast.LENGTH_LONG).show();
                for (int i = 0; i < list_view.getChildCount(); i++) {
                    list_view.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                list_view.getChildAt(position).setBackgroundColor(Color.GREEN);

            }


        });


    }
}

