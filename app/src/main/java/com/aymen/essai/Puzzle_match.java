package com.aymen.essai;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Puzzle_match extends AppCompatActivity implements View.OnClickListener {
    ImageView[][] list_image = new ImageView[5][5];
    //    TextView[] list_image = new TextView[25];
    Button restart;
    ImageView image_f, image_s;
    TextView text1_1, text1_2, text2_1, text2_2;

    int[] list_draw = {R.drawable.pubg, R.drawable.car, R.drawable.comedy, R.drawable.gift};
    int[][] background = new int[5][5];
    //    int position;
    int i1 = -1, i2 = -1, tmp;
    int j1 = -1, j2 = -1;
    int nbr_image = 0;
    int i, j, copie_h = 0, copie_v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_match);
        text1_1 = findViewById(R.id.image1_1);
        text1_2 = findViewById(R.id.image1_2);
        text2_1 = findViewById(R.id.image2_1);
        text2_2 = findViewById(R.id.image2_2);
        restart = findViewById(R.id.restart_puzzle);
        restart.setOnClickListener(this);
        actualiser();
        verifier_horizontal();
        verifier_vertical();


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == restart.getId()) {
            actualiser();
            verifier_horizontal();
            verifier_vertical();

        } else {
            select_image(v);

        }

    }

    public void actualiser() {
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {

                String image = "match" + (i + 1) + "_" + (j + 1);
                int ident = getResources().getIdentifier(image, "id", getPackageName());
                list_image[i][j] = findViewById(ident);
                int a = (int) Math.floor(Math.random() * 4);
                list_image[i][j].setClickable(true);
                list_image[i][j].setOnClickListener(this);
                list_image[i][j].setImageResource(list_draw[a]);
                background[i][j] = a;
                System.err.println(background[i][j]);
            }
        }
    }

    public void select_image(View v) {
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (v.getId() == list_image[i][j].getId()) {
                    nbr_image++;
                    switch (nbr_image) {
                        case 1:
                            image_f = list_image[i][j];
                            list_image[i][j].setClickable(false);
                            image_f.setPadding(10, 10, 10, 10);
                            image_f.setBackgroundColor(Color.GRAY);
                            i1 = i;
                            j1 = j;
                            text1_1.setText("" + i1 + " " + j1);
                            break;
                        case 2:
                            image_s = list_image[i][j];
                            list_image[i][j].setClickable(false);
                            i2 = i;
                            j2 = j;
                            text1_2.setText("" + i2 + " " + j2);
                            echange_image();
                            break;
                    }
                }
            }
        }
    }

    public void echange_image() {
        image_s.setImageResource(list_draw[background[i1][j1]]);
        image_f.setImageResource(list_draw[background[i2][j2]]);
        list_image[i1][j1].setClickable(true);
        list_image[i2][j2].setClickable(true);
        image_f.setBackgroundColor(Color.TRANSPARENT);
        image_f.setPadding(0, 0, 0, 0);
        tmp = background[i1][j1];
        background[i1][j1] = background[i2][j2];
        background[i2][j2] = tmp;
        verifier_horizontal();
        verifier_vertical();
        image_s = null;
        image_f = null;
        nbr_image = 0;
    }


    public void verifier_horizontal() {
        for (i = 0; i < 5; i++) {
            copie_h = 0;
            for (j = 0; j < 4; j++) {
                if (background[i][j] == background[i][(j + 1)]) {
                    System.err.println("<< Horizon >>   " + background[i][j] + "   /   " + background[i][(j + 1)]);

                    copie_h++;
                    System.err.println("copie_h = " + copie_h);
                    System.err.println(i + " ++ " + j);
                    if (copie_h == 2) {
                        text2_2.setText(i + " ++ " + (j - 1) + "\n" + i + " ++ " + (j) + "\n" + i + " ++ " + (j + 1));
                        int a = (int) Math.floor(Math.random() * 4);
                        int b = (int) Math.floor(Math.random() * 4);
                        int c = (int) Math.floor(Math.random() * 4);
                        System.err.println("a : " + a + "  --  " + "b : " + b + "  --  " + "c : " + c);
                        System.err.println("i : " + (i) + "  --  " + i + "  --  " + (i));
                        System.err.println("j : " + (j - 1) + "  --  " + j + "  --  " + (j + 1));
                        list_image[i][j].setImageResource(list_draw[a]);
                        list_image[i][j + 1].setImageResource(list_draw[b]);
                        list_image[i][j - 1].setImageResource(list_draw[c]);
                        background[i][j] = a;
                        background[i][j + 1] = b;
                        background[i][j - 1] = c;
                        copie_h = 0;
                        verifier_horizontal();
                    }
                } else {
                    copie_h = 0;
                }
            }

        }
    }


    public void verifier_vertical() {
        for (j = 0; j < 5; j++) {
            copie_v = 0;
            for (i = 0; i < 4; i++) {
                if (background[i][j] == background[(i + 1)][j]) {
//                    System.err.println("<< Verticaal >>   " + background[i][j] + "   /   " + background[(i + 1)][j]);
                    copie_v++;
//                    System.err.println("copie_v = " + copie_v);
//                    System.err.println(i + " ++ " + j);
                    if (copie_v == 2) {
                        text2_2.setText((i - 1) + " ++ " + (j) + "\n" + i + " ++ " + j + "\n" + (i + 1) + " ++ " + j);
                        int a = (int) Math.floor(Math.random() * 4);
                        int b = (int) Math.floor(Math.random() * 4);
                        int c = (int) Math.floor(Math.random() * 4);
//                        System.err.println("a : " + a + "  --  " + "b : " + b + "  --  " + "c : " + c);
//                        System.err.println("j : " + (j) + "  --  " + j + "  --  " + (j));
//                        System.err.println("i : " + (i - 1) + "  --  " + i + "  --  " + (i + 1));
                        list_image[i][j].setImageResource(list_draw[a]);
                        list_image[i + 1][j].setImageResource(list_draw[b]);
                        list_image[i - 1][j].setImageResource(list_draw[c]);
                        background[i][j] = a;
                        background[i + 1][j] = b;
                        background[i - 1][j] = c;
                        copie_v = 0;
                        verifier_vertical();
                    }
                } else {
                    copie_v = 0;
                }
            }

        }
    }

    public void strict_move() {
        for (i = 0; i < list_image.length; i++) {

        }
    }
}
