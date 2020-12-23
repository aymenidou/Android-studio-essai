package com.aymen.essai;

import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class Goals extends AppCompatActivity implements GestureDetector.OnGestureListener {
    ImageView ball;
    CountDownTimer compteur;

    GestureDetector gest_d;
    Point p = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        ball = findViewById(R.id.ball);
        gest_d = new GestureDetector(Goals.this, Goals.this);
        getWindowManager().getDefaultDisplay().getSize(p);
        ball.setX(p.x / 5);
        ball.setY(p.y - p.y / 4);
        ball.setMaxHeight(50);
        ball.setMaxWidth(50);
        move_ball();

    }

    boolean right = true;
    boolean tirer = false;

    public void move_ball() {
        compteur = new CountDownTimer(1000000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (right) {

                    if (ball.getX() < (p.x - ((p.x / 6) + ball.getWidth()))) {
                        ball.setX(ball.getX() + 10);
                    } else {
                        right = false;
//                        ball.setX(p.x / 4);
                    }
                } else {
                    if (ball.getX() > ((p.x / 5) - ball.getWidth())) {
                        ball.setX(ball.getX() - 10);
                    } else {
                        right = true;
//                        ball.setX(p.x / 4);
                    }

                }
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void tirer() {
        tirer = true;
        compteur = new CountDownTimer(1000000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (tirer) {

                    if (ball.getY() > (p.y / 10)) {
                        ball.setY(ball.getY() - 20);
                        win();
                    } else {
                        tirer = false;
//                        ball.setX(p.x / 4);
                    }
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void win() {
        if (ball.getY() < p.y / 10) {
            compteur.cancel();
        }
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
        if (Math.abs(e1.getX() - e2.getX()) < Math.abs(e1.getY() - e2.getY())) {
            if (e1.getY() - e2.getY() > 50) {
                compteur.cancel();
                tirer();
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return gest_d.onTouchEvent(motionEvent);
    }
}
