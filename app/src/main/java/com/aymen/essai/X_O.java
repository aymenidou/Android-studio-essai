package com.aymen.essai;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class X_O extends AppCompatActivity implements View.OnClickListener {

    Button b_stop, b_restart;
    Button[] list_button = new Button[9];
    TextView t_nom;
    Chronometer t_temp;
    String t = "X"; 
    String[] list_xo = new String[9];
    int position = -1;
    Random ran = new Random();
    CountDownTimer time;
    MediaPlayer m;
    int play = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x__o);
        m= MediaPlayer.create(getApplicationContext(),R.raw.punch);

        b_stop = findViewById(R.id.bstop);
        b_restart = findViewById(R.id.brestart);
        b_restart.setOnClickListener(this);
        b_stop.setOnClickListener(this);

        t_temp = findViewById(R.id.t_temp);
//        t_temp.setText(String.valueOf(timerr));
        t_nom = findViewById(R.id.t_j);
        t_nom.setText(t);
        list_button[0] = findViewById(R.id.b_1);
        list_button[1] = findViewById(R.id.b_2);
        list_button[2] = findViewById(R.id.b_3);
        list_button[3] = findViewById(R.id.b_4);
        list_button[4] = findViewById(R.id.b_5);
        list_button[5] = findViewById(R.id.b_6);
        list_button[6] = findViewById(R.id.b_7);
        list_button[7] = findViewById(R.id.b_8);
        list_button[8] = findViewById(R.id.b_9);

        for (int i = 0; i < 9; i++) {

            // list_button[i].setClickable(true);
            list_button[i].setOnClickListener(this);
            list_button[i].setBackgroundColor(Color.GRAY);
            list_xo[i] = String.valueOf(ran.nextInt());
        }
        // ToDo : add Play screen + Chosing player X/O + Fixing the timing + add win/lose screen + save result
        t_temp.setBase(SystemClock.elapsedRealtime());
        t_temp.start();
//        PlayerTime();
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < list_button.length; i++) {
            if (v.getId() == list_button[i].getId()) {
                position = i;
                tour(list_button[position]);
                t_nom.setText(t);
                m.stop();
                m.start();


            }
        }
        if (v.getId() == b_restart.getId()) {
            allStartUp();
//            time.cancel();
            t_temp.setBase(SystemClock.elapsedRealtime());
            t_temp.start();
//            PlayerTime();
            for (int i = 0; i < list_button.length; i++) {
                list_button[i].setClickable(true);
                list_button[i].setText("");
                list_button[i].setBackgroundColor(Color.GRAY);
                list_xo[i] = String.valueOf(ran.nextInt());

            }
        }
    }

    public void tour(Button b) {

        switch (t) {
            case "X":
                b.setText("X");
                b.setBackgroundColor(Color.GREEN);
                b.setClickable(false);
                list_xo[position] = t;
                verifier();
                t = "O";
                play++;
                break;
            case "O":
                b.setText("O");
                b.setBackgroundColor(Color.RED);
                b.setClickable(false);
                list_xo[position] = t;
                verifier();
                t = "X";
                play++;
                break;


        }
    }

    public void allShutDown() {
        for (Button aList_button : list_button) {

            aList_button.setClickable(false);

        }
    }

    public void allStartUp() {
        for (Button aList_button : list_button) {

            aList_button.setClickable(true);

        }
    }

    public void verifier() {

        if (list_xo[0] == list_xo[1] && list_xo[1] == list_xo[2]) {
            Toast.makeText(getApplicationContext(), "Player " + t + " Win", Toast.LENGTH_LONG).show();
            allShutDown();


        }
        if (list_xo[3] == list_xo[4] && list_xo[4] == list_xo[5]) {
            Toast.makeText(getApplicationContext(), "Player " + t + " Win", Toast.LENGTH_LONG).show();
            allShutDown();

        }
        if (list_xo[6] == list_xo[7] && list_xo[7] == list_xo[8]) {
            Toast.makeText(getApplicationContext(), "Player " + t + " Win", Toast.LENGTH_LONG).show();
            allShutDown();

        }

        if (list_xo[0] == list_xo[3] && list_xo[3] == list_xo[6]) {
            Toast.makeText(getApplicationContext(), "Player " + t + " Win", Toast.LENGTH_LONG).show();
            allShutDown();

        }
        if (list_xo[1] == list_xo[4] && list_xo[4] == list_xo[7]) {
            Toast.makeText(getApplicationContext(), "Player " + t + " Win", Toast.LENGTH_LONG).show();
            allShutDown();

        }
        if (list_xo[2] == list_xo[5] && list_xo[5] == list_xo[8]) {
            Toast.makeText(getApplicationContext(), "Player " + t + " Win", Toast.LENGTH_LONG).show();
            allShutDown();

        }
        if (list_xo[0] == list_xo[4] && list_xo[4] == list_xo[8]) {
            Toast.makeText(getApplicationContext(), "Player " + t + " Win", Toast.LENGTH_LONG).show();
            allShutDown();

        }
        if (list_xo[6] == list_xo[4] && list_xo[4] == list_xo[2]) {
            Toast.makeText(getApplicationContext(), "Player " + t + " Win", Toast.LENGTH_LONG).show();
            allShutDown();

        }
        if (play == 8) {
            Toast.makeText(getApplicationContext(), "No one win \n Try again", Toast.LENGTH_LONG).show();
            allShutDown();

        }
    }


    public void PlayerTime() {
//        time = new CountDownTimer(1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                t_temp.setText(String.valueOf(Integer.parseInt(t_temp.getText().toString()) + 1));
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
        time = new CountDownTimer(30000, 100) {
            int i = 0;

            public void onTick(long millisUntilFinished) {

                t_temp.setText(" " + i);
                i++;
            }

            public void onFinish() {
                t_temp.setText("done!");
            }
        }.start();
    }
}
