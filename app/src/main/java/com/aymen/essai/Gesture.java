package com.aymen.essai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Gesture extends AppCompatActivity implements GestureDetector.OnGestureListener {
    ImageView img;
    TextView txt;
    GestureDetector gest_d;
    ArrayList<Integer> list_img = new ArrayList<>();
    ArrayList<String> list_txt = new ArrayList<>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        img = findViewById(R.id.image_g);
        txt = findViewById(R.id.text_g);
        gest_d = new GestureDetector(Gesture.this, Gesture.this);
        list_img.add(R.drawable.black_panther);
        list_txt.add("Black Panther");
        list_img.add(R.drawable.porshe);
        list_txt.add("White Porsche");
        list_img.add(R.drawable.annapurna_dakshin_mountains);
        list_txt.add("Annapurna Dakshin Mountains");
        list_img.add(R.drawable.aurora_borealis_hd_1920x1080);
        list_txt.add("Aurora Borealis");
        list_img.add(R.drawable.maserati_granturismo);
        list_txt.add("Maserati Granturismo");
        list_img.add(R.drawable.elena_siberian_tigress_4k_1920x1080);
        list_txt.add("Elena Siberian Tigress");
        img.setImageResource(list_img.get(0));
        txt.setText(list_txt.get(0));

    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (Math.abs(e1.getX() - e2.getX()) > Math.abs(e1.getY() - e2.getY())) {

            if (e1.getX() - e2.getX() > 80) {
                i++;
                if (i == list_img.size()) {
                    i = 0;
                }
                Toast.makeText(this, " vers le gauche <<<<< la position >>>> " + i, Toast.LENGTH_SHORT).show();
                img.setImageResource(list_img.get(i));
                txt.setText(list_txt.get(i));
            } else if (e1.getX() - e2.getX() < 80) {
                i--;
                if (i == -1) {
                    i = list_img.size() - 1;
                }
                Toast.makeText(this, " vers le droit <<<<< la position >>>> " + i, Toast.LENGTH_SHORT).show();

                img.setImageResource(list_img.get(i));
                txt.setText(list_txt.get(i));
            }
        } else {

            if (e1.getY() - e2.getY() > 80) {
                i++;
                if (i == list_img.size()) {
                    i = 0;
                }

                Toast.makeText(this, " vers le haut <<<<< la position >>>> " + i, Toast.LENGTH_SHORT).show();
                img.setImageResource(list_img.get(i));
                txt.setText(list_txt.get(i));
            } else if (e1.getY() - e2.getY() < 80) {
                i--;
                if (i == -1) {
                    i = list_img.size() - 1;
                }

                Toast.makeText(this, " vers le bas <<<<< la position >>>> " + i, Toast.LENGTH_SHORT).show();
                img.setImageResource(list_img.get(i));
                txt.setText(list_txt.get(i));
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return gest_d.onTouchEvent(motionEvent);
    }
}
