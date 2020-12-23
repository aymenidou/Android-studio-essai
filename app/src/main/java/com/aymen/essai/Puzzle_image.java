package com.aymen.essai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Puzzle_image extends AppCompatActivity implements View.OnClickListener {
    ImageView i1, i2, i3, i4, i5, i6;
    ImageView[] list_image = new ImageView[6];
    int[] image_draw = {R.drawable.car, R.drawable.comedy, R.drawable.pubg};
    Button b_start;
    TextView t_time;
    ImageView v1 = null;
    ImageView v2 = null;
    int a = -1, b = -1;
    int[] tfois = new int[]{0, 0, 0};
    int[] tjimages = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_image);

        i1 = findViewById(R.id.image_click1);
        i2 = findViewById(R.id.image_click2);
        i3 = findViewById(R.id.image_click3);
        i4 = findViewById(R.id.image_click4);
        i5 = findViewById(R.id.image_click5);
        i6 = findViewById(R.id.image_click6);

        t_time = findViewById(R.id.t_time);
        b_start = findViewById(R.id.b_start);
        b_start.setOnClickListener(this);

        list_image[0] = i1;
        list_image[1] = i2;
        list_image[2] = i3;
        list_image[3] = i4;
        list_image[4] = i5;
        list_image[5] = i6;
        for (int i = 0; i < list_image.length; i++) {
            list_image[i].setClickable(true);
            list_image[i].setImageResource(R.drawable.ask);
        }

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        i5.setOnClickListener(this);
        i6.setOnClickListener(this);

        commencer();

    }


//    public void afficherImage(ImageView v) {
//        int i = (int) Math.floor(Math.random() * 3);
//        v.setImageResource(image_draw[i]);
//    }

    public void commencer() {
        for (int i = 0; i < list_image.length; i++) {
            list_image[i].setClickable(true);
            list_image[i].setImageResource(R.drawable.ask);
        }
        tfois[0] = 0;
        tfois[1] = 0;
        tfois[2] = 0;
        int position = 0;
        int ok = 1;
        for (int i = 0; i < 6; i++) {
            ok = 1;
            position = (int) Math.floor(Math.random() * 3);
            tfois[position] = tfois[position] + 1;
            if (tfois[position] > 2) {
                ok = 0;
                i--;
                if (i < 0) {
                    i = 0;
                }
            }
            if (ok == 1) {
                tjimages[i] = image_draw[position];
                list_image[i].setImageResource(R.drawable.ask);
            }
        }
    }

    @Override
    public void onClick(View v) {
//        for (int i = 0; i < 6; i++) {
//            if (v.getId() == list_image[i].getId()) {
//                afficherImage(list_image[i]);
//            }
//        }
//        commencer();
        if (v.getId() == b_start.getId()) {
            commencer();
        }
        if (v.getId() == list_image[0].getId()) {
            list_image[0].setImageResource(tjimages[0]);
            if (v1 == null) {
                v1 = list_image[0];
                a = tjimages[0];
            } else {
                v2 = list_image[0];
                b = tjimages[0];
            }
        }
        if (v.getId() == list_image[1].getId()) {
            list_image[1].setImageResource(tjimages[1]);
            if (v1 == null) {
                v1 = list_image[1];
                a = tjimages[1];
            } else {
                v2 = list_image[1];
                b = tjimages[1];
            }
        }
        if (v.getId() == list_image[2].getId()) {
            list_image[2].setImageResource(tjimages[2]);
            if (v1 == null) {
                v1 = list_image[2];
                a = tjimages[2];
            } else {
                v2 = list_image[2];
                b = tjimages[2];
            }
        }
        if (v.getId() == list_image[3].getId()) {
            list_image[3].setImageResource(tjimages[3]);
            if (v1 == null) {
                v1 = list_image[3];
                a = tjimages[3];
            } else {
                v2 = list_image[3];
                b = tjimages[3];
            }
        }
        if (v.getId() == list_image[4].getId()) {
            list_image[4].setImageResource(tjimages[4]);
            if (v1 == null) {
                v1 = list_image[4];
                a = tjimages[4];
            } else {
                v2 = list_image[4];
                b = tjimages[4];
            }
        }
        if (v.getId() == list_image[5].getId()) {
            list_image[5].setImageResource(tjimages[5]);
            if (v1 == null) {
                v1 = list_image[5];
                a = tjimages[5];
            } else {
                v2 = list_image[5];
                b = tjimages[5];
            }
        }
        if (a > -1 && b > -1) {
            if (a != b) {
                v1.setImageResource(R.drawable.ask);
                v2.setImageResource(R.drawable.ask);
                v1.setClickable(true);
                v2.setClickable(true);
            } else {
                v1.setClickable(false);
                v2.setClickable(false);
            }
            a = -1;
            b = -1;
            v1 = null;
            v2 = null;
        }

    }
}
