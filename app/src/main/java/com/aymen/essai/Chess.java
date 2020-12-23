package com.aymen.essai;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class Chess extends AppCompatActivity implements View.OnClickListener {
    ImageView[][] list_sol = new ImageView[8][8];
    String[][] list_pos = new String[8][8];
    int[][] list_active = new int[8][8];
    TextView t_player;
    Chronometer timer;
    Button b_restart, b_pause;
    int img_x, img_o;
    int i, j, i1 = -1, j1 = -1, i2 = -1, j2 = -1;
    String tour = "x";
    //    ImageView soldat, place;
    int cas = 0;
    int cas1 = 1, cas2 = 2;
    MediaPlayer m = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);
        b_pause = findViewById(R.id.but_pause);
        b_restart = findViewById(R.id.but_restart);
        b_restart.setOnClickListener(this);
        b_pause.setOnClickListener(this);
        t_player = findViewById(R.id.nom_player);
        timer = findViewById(R.id.temp_match);
        img_o = R.drawable.cercle;
        img_x = R.drawable.croix;
        initialiser();
        m = MediaPlayer.create(getApplicationContext(), R.raw.punch);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == b_restart.getId()) {
            vider();
            initialiser();
        }
//        if (v.getId() == b_pause.getId()) {
//            if (b_pause.getText().equals("Pause")) {
//
//                timer.stop();
//                allShutDown();
//                b_pause.setText("Start");
//            } else if (b_pause.getText().equals("Start")) {
//                timer.start();
//                allWakeUp();
//                b_pause.setText("Pause");
//            }
//        }
        else {
            jouer(v);
        }

    }


    public void initialiser() {
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
        t_player.setText(tour);

        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {

                String soldat = "sol" + (i + 1) + "_" + (j + 1);
                int ident = getResources().getIdentifier(soldat, "id", getPackageName());
                list_sol[i][j] = findViewById(ident);
                list_sol[i][j].setClickable(true);
                list_active[i][j] = 1;
                list_pos[i][j] = "";
                list_sol[i][j].setOnClickListener(this);
            }
        }
        //initial_couleur();
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 8; j++) {
                list_sol[i][j].setImageResource(img_o);
                list_pos[i][j] = "o";
                list_sol[list_sol.length - i - 1][j].setImageResource(img_x);
                list_pos[list_sol.length - i - 1][j] = "x";
            }
        }
        desactiver();
    }

    public void vider() {
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                list_sol[i][j].setClickable(true);
                list_sol[i][j].setImageResource(0);
                list_active[i][j] = 1;
            }
        }
    }

    public void allShutDown() {
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                list_sol[i][j].setClickable(false);
                list_active[i][j] = 0;
                if (list_active[i][j] == 0) {
                    list_sol[i][j].setBackgroundColor(Color.YELLOW);
                } else {
                    list_sol[i][j].setBackgroundColor(Color.WHITE);

                }
            }
        }
    }

    public void allWakeUp() {
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                list_sol[i][j].setClickable(true);
                list_active[i][j] = 1;

            }
        }
        //initial_couleur();
    }

    public void desactiver() {
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {
                if (!list_pos[i][j].equals(tour)) {

                    list_sol[i][j].setClickable(false);
                    list_active[i][j] = 0;
                    list_sol[i][j].setBackgroundColor(Color.YELLOW);
                } else {
                    list_sol[i][j].setClickable(true);
                    list_active[i][j] = 1;

                }
            }
        }

    }

//    public void tst_desactiver() {
//        for (i = 0; i < 8; i++) {
//
//            for (j = 0; j < 8; j++) {
//                if (list_active[i][j] == 0 && (list_pos[i][j] == "o" || list_pos[i][j] == "x")) {
//                    list_sol[i][j].setClickable(false);
//                    list_sol[i][j].setBackgroundColor(Color.YELLOW);
//                }
//
//            }
//
//        }
//    }

    int cpt = 0;

    public void jouer(View v) {

        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                if (v.getId() == list_sol[i][j].getId()) {

                    if (tour.equals("x")) {
                        cpt++;
                        switch (cpt) {
                            case 1:
                                i1 = i;
                                j1 = j;
                                list_sol[i][j].setBackgroundColor(Color.GREEN);
                                list_sol[i - 1][j].setBackgroundColor(Color.GREEN);
                                list_sol[i - 2][j].setBackgroundColor(Color.GREEN);
                                allShutDown();
                                list_sol[i][j].setClickable(false);
                                list_sol[i - 1][j].setClickable(true);
                                list_sol[i - 2][j].setClickable(true);
//                                tst_desactiver();
                                break;
                            case 2:
                                i2 = i;
                                j2 = j;
                                list_sol[i2][j2].setImageResource(img_x);
                                list_sol[i1][j1].setImageResource(0);
                                list_sol[i1][j1].setClickable(true);
                                list_pos[i1][j1] = "";
                                list_pos[i2][j2] = tour;
                                m.start();
//                                tst_desactiver();

//                                initial_couleur();
                                desactiver();
                                cpt = 0;
//                                tour = "o";
//                                t_player.setText("O");
                                i1 = -1;
                                j1 = -1;
                                i2 = -1;
                                j2 = -1;
                                break;
                        }
                    }
//                    if (tour.equals("o")) {
//                        cpt++;
//                        switch (cpt) {
//                            case 1:
//                                i1 = i;
//                                j1 = j;
//                                list_sol[i][j].setBackgroundColor(Color.GREEN);
//                                list_sol[i + 1][j].setBackgroundColor(Color.GREEN);
//                                list_sol[i + 2][j].setBackgroundColor(Color.GREEN);
//                                list_sol[i][j].setClickable(false);
//                                list_sol[i + 1][j].setClickable(true);
//                                list_sol[i + 2][j].setClickable(true);
//                                break;
//                            case 2:
//                                i2 = i;
//                                j2 = j;
//                                list_sol[i2][j2].setImageResource(img_o);
//                                list_sol[i1][j1].setImageResource(0);
//                                list_sol[i1][j1].setClickable(true);
//                                list_sol[i1][j1].setBackgroundColor(Color.TRANSPARENT);
//                                list_sol[i1 - 1][j1].setBackgroundColor(Color.TRANSPARENT);
//                                list_sol[i1 - 2][j1].setBackgroundColor(Color.TRANSPARENT);
//                                cpt = 0;
//                                tour = "x";
//                                t_player.setText("X");
//                                i1=-1;
//                                j1=-1;
//                                i2=-1;
//                                j2=-1;
//                                break;
//
//                        }
//
//
//                    }
                }
            }
        }
    }

//    public void initial_couleur() {
//        for (i = 0; i < list_sol.length; i++) {
//
//            for (j = 0; j < list_sol.length; j++) {
//                cas++;
//                if (cas == cas1) {
//
//                    list_sol[i][j].setBackgroundColor(getResources().getColor(R.color.colorcase2));
//                    if (cas1 == 2) {
//
//                        cas = 0;
//                    }
//                }
//                if (cas == cas2) {
//                    list_sol[i][j].setBackgroundColor(getResources().getColor(R.color.colorcase1));
//                    if (cas2 == 2) {
//
//                        cas = 0;
//                    }
//
//                }
//            }
//            cas = 0;
//            if (cas1 == 1) {
//                cas1 = 2;
//                cas2 = 1;
//            } else {
//                cas1 = 1;
//                cas2 = 2;
//            }
//        }
//    }


}
