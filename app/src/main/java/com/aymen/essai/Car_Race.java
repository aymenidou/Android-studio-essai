package com.aymen.essai;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Car_Race extends AppCompatActivity implements GestureDetector.OnGestureListener {
    ImageView car;
    CountDownTimer counter;
    Point p = new Point();
    Display d;
    GestureDetector gest_d;
    int w, h;
    TextView t_car, t_en1, t_en2;
    ImageView[] cars = new ImageView[2];
    MediaPlayer punch;
    int[] enemys = new int[12];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car__race);
        car = findViewById(R.id.car1);
        gest_d = new GestureDetector(Car_Race.this, Car_Race.this);
        d = getWindowManager().getDefaultDisplay();
        d.getSize(p);
        w = p.x;
        h = p.y;
        punch = MediaPlayer.create(getApplicationContext(), R.raw.punch);
        car.setX(20);
        car.setY(h - 500);
        for (int i = 0; i < 2; i++) {
            int id = getResources().getIdentifier("en" + (i + 1), "id", getPackageName());
            cars[i] = findViewById(id);
            System.err.println("<<<< " + id);
            cars[i].setY(0);
            float a = (float) Math.floor(Math.random() * p.x - 30);
            while (a > 80 && a < 500) {
                cars[i].setX(a);
                a = (float) Math.floor(Math.random() * p.x - 30);
            }
        }
        for(int i=0;i<9;i++){
            int id= getResources().getIdentifier("en"+(i+1),"drawable",getPackageName());
            enemys[i]=id;

        }
        enemys[9]=R.drawable.velo;
        enemys[10]=R.drawable.camion1;
        enemys[11]=R.drawable.camion2;
        t_en1 = findViewById(R.id.adresse_en1);
        t_en2 = findViewById(R.id.adresse_en2);
        t_car = findViewById(R.id.adresse_car);
        cars[0].setX(20);
        cars[1].setX(350);
        anim();
//        Toast.makeText(this, "width : " + w + " height : " + h, Toast.LENGTH_SHORT).show();
    }

    

    public void anim() {

        counter = new CountDownTimer(100000000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                car.setImageResource(R.drawable.car3);
                System.err.println(">>>>>>>  Animation starting");

                for (int i = 0; i < 2; i++) {

//                    cars[i].setY(cars[i].getY() + 5);
                    cars[i].setY(cars[i].getY() + 10);

                }
                for (int i = 0; i < 2; i++) {

                    verifier(car, cars[i]);
                }

                for (int i = 0; i < 2; i++) {
                    if (cars[i].getY() == h) {
                        cars[i].setY(0);
                        cars[i].setImageResource(enemys[(int) Math.floor(Math.random()*enemys.length)]);
                        float a = (float) Math.floor(Math.random() * p.x - 30);
                        while (a > 80 && a < 600) {

                            cars[i].setX(a);
                            a = (float) Math.floor(Math.random() * p.x - 30);
                        }
                    }
                }
                t_en1.setText("x : " + String.valueOf(cars[0].getX()) + " y: " + String.valueOf(cars[0].getY()));
                t_en2.setText("x : " + String.valueOf(cars[1].getX()) + " y: " + String.valueOf(cars[1].getY()));

            }

            @Override
            public void onFinish() {

                System.err.println(">>>>>>>  Animation finished");

            }
        }.start();

    }

    public void verifier(ImageView car, ImageView en) {
        float xcar = car.getX();
        float ycar = car.getY();
        float yen = en.getY();
        float xen = en.getX();
        float hcar = car.getHeight();
        float hen = car.getHeight();
        float wcar = car.getWidth();
        float wen = car.getWidth();
        if (Math.abs(xcar - xen) < wen && Math.abs(ycar - yen) < hen) {

            counter.cancel();
            car.setImageResource(R.drawable.bang);
            punch.start();
            Toast.makeText(Car_Race.this, "you lose", Toast.LENGTH_SHORT).show();


        }
//        if(((xcar+wcar)<(xen+wen) || (xcar+wcar)>(xen+wen))&& ((xcar<xen)||(xcar>xen))){
//        }
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
        anim();
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
        if (e1.getX() - e2.getX() < 50) {
            car.setX(car.getX() - (e1.getX() - e2.getX()));
            t_car.setText("x : " + String.valueOf(car.getX()) + " y: " + String.valueOf(car.getY()));
        }
        if (e1.getX() - e2.getX() > 50) {
            car.setX(car.getX() - (e1.getX() - e2.getX()));
            t_car.setText("x : " + String.valueOf(car.getX()) + " y: " + String.valueOf(car.getY()));
        }

        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return gest_d.onTouchEvent(motionEvent);
    }
}
