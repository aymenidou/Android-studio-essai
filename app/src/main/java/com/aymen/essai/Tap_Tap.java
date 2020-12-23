package com.aymen.essai;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tap_Tap extends AppCompatActivity implements View.OnClickListener {
    Button[] list_tap = new Button[12];
    Button but;
    int[] list_pos = new int[12];
    CountDownTimer timer;
    TextView t_ready, t_go;
    int tour = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap__tap);
        but = findViewById(R.id.clickk);
        but.setOnClickListener(this);
        t_ready = findViewById(R.id.txt_watch);
        t_go = findViewById(R.id.txt_Go);
        for (int i = 0; i < list_tap.length; i++) {
            String tap = "tap" + (i + 1);
            int ident = getResources().getIdentifier(tap, "id", getPackageName());
            list_tap[i] = findViewById(ident);
            list_tap[i].setOnClickListener(this);
        }
        vider();

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == but.getId()) {


            vider();
            jouer();
            allStart();
        } else {
            valider(v);
        }
    }

    public void jouer() {
        timer = new CountDownTimer(10000, 1000) {
            int cpt = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                if (cpt == 4) {
                    timer.cancel();
                    onFinish();
                } else {

                    int a;
                    a = (int) Math.floor(Math.random() * list_tap.length);
                    while (!pos_verifier(a)) {
                        a = (int) Math.floor(Math.random() * list_tap.length);

                    }

                    list_tap[a].setBackgroundColor(Color.BLUE);
                    System.err.println(a);
                    list_tap[a].setText(String.valueOf(cpt + 1));
                    list_pos[cpt] = a;
                    cpt++;
                    t_ready.setText("Watch");
                }

            }

            @Override
            public void onFinish() {
                vider();
                t_go.setText("Time to play");
            }
        }.start();


//        for (int i = 0; i < 4; i++) {
//            int a;
//            a = (int) Math.floor(Math.random() * list_tap.length);
//            while (!pos_verifier(a)) {
//                a = (int) Math.floor(Math.random() * list_tap.length);
//
//            }
//            list_tap[a].setBackgroundColor(Color.BLUE);
//            list_pos[i] = a;
//        }
    }

    public boolean pos_verifier(int a) {
        for (int i = 0; i < list_pos.length; i++) {
            if (list_pos[i] == a) {
                return false;
            }
        }
        return true;
    }

    public void vider() {
        for (int i = 0; i < list_tap.length; i++) {

            list_tap[i].setBackgroundColor(Color.LTGRAY);
//            list_tap[i].setText("");
        }
    }

    public void valider(View v) {
        for (int i = 0; i < list_tap.length; i++) {
            if (v.getId() == list_tap[i].getId()) {
                list_tap[i].setBackgroundColor(Color.BLUE);
                win(i);
            }
        }
    }

    public void allStop() {
        for (int i = 0; i < list_pos.length; i++) {
            list_pos[i] = -1;
            list_tap[i].setClickable(false);
        }

    }

    public void allStart() {
        for (int i = 0; i < list_pos.length; i++) {
            list_pos[i] = -1;
            list_tap[i].setClickable(true);
        }
    }

    public void win(int i) {
        if (list_pos[tour] == i) {
            tour++;
        } else {
            Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show();
            tour = 0;
            allStop();
        }
        if (tour == 4) {
            Toast.makeText(this, "You Win", Toast.LENGTH_SHORT).show();
            tour = 0;
            allStop();
        }
    }
}
