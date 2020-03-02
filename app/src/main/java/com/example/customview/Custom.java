package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class Custom extends View implements GestureDetector.OnGestureListener{
    private int[] colors = {RED, YELLOW, GREEN, BLUE, WHITE};
    private int curr=4;

    int W, H;

    Paint p1, p2, p3, p4, p5;

    GestureDetector gd;

    public Custom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gd.onTouchEvent(event);
                return true;
            }
        });
        gd = new GestureDetector(getContext(), this);
        p1 = new Paint();
        p2 = new Paint();
        p3 = new Paint();
        p4 = new Paint();
        p5 = new Paint();
    }
    public boolean onDown(MotionEvent e){
        int X = (int) e.getX();
        int Y = (int) e.getY();
        W = getWidth();
        H = getHeight();
        if(X<(W/2)&&Y<(H/2)){
            curr = 0;
        }
        else if(X>(W/2)&&Y<(H/2)){
            curr = 1;
        }
        else if(X<(W/2)&&Y>(H/2)){
            curr = 2;
        }
        else curr = 3;
        invalidate();
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
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        W = getWidth();
        H = getHeight();
        p1.setColor(colors[0]);
        p1.setStyle(Paint.Style.FILL);
        p2.setColor(colors[1]);
        p2.setStyle(Paint.Style.FILL);
        p3.setColor(colors[2]);
        p3.setStyle(Paint.Style.FILL);
        p4.setColor(colors[3]);
        p4.setStyle(Paint.Style.FILL);
        p5.setColor(colors[curr]);
        p5.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, W/2, H/2, p1);
        canvas.drawRect(W/2, 0, W, H/2, p2);
        canvas.drawRect(0, H/2, W/2, H, p3);
        canvas.drawRect(W/2, H/2, W, H, p4);
        canvas.drawCircle(W/2, H/2, W/4, p5);
    }
}
