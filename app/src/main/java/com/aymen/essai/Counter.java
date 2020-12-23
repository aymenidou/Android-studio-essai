package com.aymen.essai;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.Random;

public class Counter extends AppCompatActivity implements View.OnClickListener {
    CountDownTimer compteur;
    EditText entrer;
    TextView t1, t2, t3,t_message;
    Button ok, stop, start;
    String r1, r;
    SecureRandom ran = new SecureRandom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        t1 = findViewById(R.id.t_n1);
        t2 = findViewById(R.id.t_n2);
        t3 = findViewById(R.id.t_n3);
        entrer = findViewById(R.id.t_entrer);
        start = findViewById(R.id.b_start);
        ok = findViewById(R.id.b_valider);
        stop = findViewById(R.id.b_stop);
        t_message = findViewById(R.id.t_message);

        ok.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    public void afficher() {

        compteur = new CountDownTimer(10000, 100) {

            @Override
            public void onTick(long millisUntilFinished) {
                int a = (int) Math.floor(Math.random() * 5);
                int b = (int) Math.floor(ran.nextInt(2));

//                t1.setText("" + a);
//                r1 = "" + a;
//                a = (int) Math.floor(Math.random() * 5);
//                t2.setText("" + a);
//                r1 = r1 + a;
//                a = (int) Math.floor(Math.random() * 5);
//                t3.setText("" + a);
//                r1 = r1 + a;
                //
                t1.setText("" + b);
                r1 = "" + b;
                b = (int) Math.floor(ran.nextInt(2));
                t2.setText("" + b);
                r1 = r1 + b;
                b = (int) Math.floor(ran.nextInt(2));
                t3.setText("" + b);
                r1 = r1 + b;

            }


            @Override
            public void onFinish() {
                start.setText("Replay");
            }
        }.start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_start:
                afficher();
                break;
            case R.id.b_stop:
                compteur.cancel();
                if (r1.equals(r)) {
                    t_message.setText("You win");
                    t_message.setTextColor(Color.GREEN);
                    t1.setBackgroundColor(Color.GREEN);
                    t2.setBackgroundColor(Color.GREEN);
                    t3.setBackgroundColor(Color.GREEN);

                }else{
                    t_message.setText("You Lost :(");
                    t_message.setTextColor(Color.RED);
                    t1.setBackgroundColor(Color.RED);
                    t2.setBackgroundColor(Color.RED);
                    t3.setBackgroundColor(Color.RED);
                }start.setText("Replay");
                break;
            case R.id.b_valider:
                restart();
                r=entrer.getText().toString();
                afficher();
                start.setText("Start");


        }

    }
    public void restart(){
        t_message.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t1.setBackgroundColor(Color.WHITE);
        t2.setBackgroundColor(Color.WHITE);
        t3.setBackgroundColor(Color.WHITE);
    }
}
