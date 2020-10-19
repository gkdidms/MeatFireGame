package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;


public class GameStage extends AppCompatActivity {
    private static final String IMAGEVIEW_TAG = "icon bitmap";

    TextView time, score;
    Timer timer = new Timer();
    TimerTask timerTask;
    ImageView gogi1,gogi2,gogi3,gogi4,gogi5,gogi6,gogi7,gogi8,gogi9,gogi10;
    ImageView life1, life2,life3,life4,life5;
    FrameLayout finish, framegogi;

    Thread plusTr1,plusTr2,plusTr3,plusTr4,plusTr5,plusTr6,plusTr7,plusTr8,plusTr9,plusTr10;
    Boolean flag1,flag2,flag3,flag4,flag5,flag6,flag7,flag8,flag9,flag10;
    int count1=0, count2=0, count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0;




    float oldXvalue;
    float oldYvalue;
    Handler handler;
    int sc = 0, death = 0;
    int tag2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_stage);


        time = findViewById(R.id.time);
        score = findViewById(R.id.score);
        framegogi = findViewById(R.id.framegogi);
        finish = findViewById(R.id.finish);
        handler = new Handler();

        gogi1 = findViewById(R.id.imggogi1);
        gogi1.setTag(1);

        gogi1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr1 != null){
                        flag1 = false;
                    }


                }
                else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr1 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi1.getTag();
                            @Override
                            public void run() {

                                if (count1 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi1.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count1 >= 3 && count1 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi1.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count1 >= 5 && count1 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi1.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count1 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi1.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }


                            }
                        });
                    }
                    flag1 = true;
                    FireGogi1(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi2 = findViewById(R.id.imggogi2);
        gogi2.setTag(2);
        gogi2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr2 != null){
                        flag2 = false;
                    }


                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr2 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi2.getTag();
                            @Override
                            public void run() {

                                if (count2 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi2.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count2 >= 3 && count2 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi2.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count2 >= 5 && count2 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi2.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count2 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi2.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }


                            }
                        });
                    }

                    flag2 = true;
                    FireGogi2(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi3 = findViewById(R.id.imggogi3);
        gogi3.setTag(3);
        gogi3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr3 != null){
                        flag3 = false;
                    }

                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr3 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi3.getTag();
                            @Override
                            public void run() {

                                if (count3 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi3.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count3 >= 3 && count3 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi3.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count3 >= 5 && count3 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi3.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count3 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi3.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }


                            }
                        });
                    }
                    flag3 = true;
                    FireGogi3(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi4 = findViewById(R.id.imggogi4);
        gogi4.setTag(2);
        gogi4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr4 != null){
                        flag4 = false;
                    }


                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr4 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi4.getTag();
                            @Override
                            public void run() {

                                if (count4 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi4.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count4 >= 3 && count4 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi4.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count4 >= 5 && count4 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi4.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count4 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi4.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }


                            }
                        });
                    }
                    flag4 = true;
                    FireGogi4(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi5 = findViewById(R.id.imggogi5);
        gogi5.setTag(1);
        gogi5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr5 != null){
                        flag5 = false;
                    }


                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr5 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi5.getTag();
                            @Override
                            public void run() {

                                if (count5 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi5.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count5>= 3 && count5 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi5.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count5 >= 5 && count5 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi5.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count5 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi5.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }
                            }
                        });
                    }
                    flag5 = true;
                    FireGogi5(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi6 = findViewById(R.id.imggogi6);
        gogi6.setTag(3);
        gogi6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr6 != null){
                        flag6 = false;
                    }


                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr6 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi6.getTag();
                            @Override
                            public void run() {

                                if (count6 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi6.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count6 >= 3 && count6 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi6.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count6 >= 5 && count6 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi6.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count6 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi6.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }


                            }
                        });
                    }
                    flag6 = true;
                    FireGogi6(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi7 = findViewById(R.id.imggogi7);
        gogi7.setTag(1);
        gogi7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr7 != null){
                        flag7 = false;
                    }


                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr7 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi7.getTag();
                            @Override
                            public void run() {

                                if (count7 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi7.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count7 >= 3 && count7 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi7.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count7 >= 5 && count7 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi7.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count7 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi7.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }


                            }
                        });
                    }
                    flag7 = true;
                    FireGogi7(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi8 = findViewById(R.id.imggogi8);
        gogi8.setTag(3);
        gogi8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr8 != null){
                        flag8 = false;
                    }

                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr8 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi8.getTag();
                            @Override
                            public void run() {

                                if (count8 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi8.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count8 >= 3 && count8 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi8.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count8 >= 5 && count8 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi8.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count8 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi8.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }


                            }
                        });
                    }
                    flag8 = true;
                    FireGogi8(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi9 = findViewById(R.id.imggogi9);
        gogi9.setTag(1);
        gogi9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr9 != null){
                        flag9 = false;
                    }


                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr9 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi9.getTag();
                            @Override
                            public void run() {

                                if (count9 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi9.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count9 >= 3 && count9 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi9.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count9 >= 5 && count9 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi9.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count9 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi9.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }


                            }
                        });
                    }
                    flag9 = true;
                    FireGogi9(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

                }
                return true;
            }
        });
        gogi10 = findViewById(R.id.imggogi10);
        gogi10.setTag(1);
        gogi10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();

                    if(plusTr10 != null){
                        flag10 = false;
                    }

                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    if(v.getX() > width && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() < 0 && v.getY() > height){
                        v.setX(width);
                        v.setY(height);
                    }else if(v.getX() > width && v.getY() < 0){
                        v.setX(width);
                        v.setY(0);
                    }else if(v.getX() < 0 && v.getY() < 0){
                        v.setX(0);
                        v.setY(0);
                    }else if(v.getX() < 0 || v.getX() > width){
                        if(v.getX() < 0){
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }else{
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    }else if (v.getY() < 0 || v.getY() > height){
                        if(v.getY() < 0){
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        }else{
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                    if(plusTr10 != null){
                        handler.post(new Runnable() {
                            int resourceId;
                            int tag = (int) gogi10.getTag();
                            @Override
                            public void run() {

                                if (count10 < 3){
                                    resourceId = getResources().getIdentifier("gogi"+tag,"drawable","com.example.game");
                                    gogi10.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count10 >= 3 && count10 < 5){
                                    resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");
                                    gogi10.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count10 >= 5 && count10 <8){
                                    resourceId = getResources().getIdentifier("blackgogi"+tag,"drawable","com.example.game");
                                    gogi10.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }else if(count10 >= 8){
                                    resourceId = getResources().getIdentifier("realblackgogi"+tag,"drawable","com.example.game");
                                    gogi10.setImageResource(resourceId);
                                    tag2 = resourceId;
                                }
                            }
                        });
                    }
                    flag10 = true;
                    FireGogi10(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);


                }
                return true;
            }
        });

        life1 = findViewById(R.id.count1);
        life2 = findViewById(R.id.count2);
        life3 = findViewById(R.id.count3);
        life4 = findViewById(R.id.count4);
        life5 = findViewById(R.id.count5);

        TimerTask();





    }

/*
    View.OnTouchListener mTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
            int height = ((ViewGroup)v.getParent()).getHeight() - v.getWidth();

            if(event.getAction() == MotionEvent.ACTION_DOWN){
                oldXvalue = event.getX();
                oldYvalue = event.getY();


            }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                v.setX(event.getRawX() - oldXvalue);
                v.setY(event.getRawY() - (oldYvalue + v.getHeight()));

            }else if(event.getAction() == MotionEvent.ACTION_UP){
                if(v.getX() > width && v.getY() > height){
                    v.setX(width);
                    v.setY(height);
                }else if(v.getX() < 0 && v.getY() > height){
                    v.setX(width);
                    v.setY(height);
                }else if(v.getX() > width && v.getY() < 0){
                    v.setX(width);
                    v.setY(0);
                }else if(v.getX() < 0 && v.getY() < 0){
                    v.setX(0);
                    v.setY(0);
                }else if(v.getX() < 0 || v.getX() > width){
                    if(v.getX() < 0){
                        v.setX(0);
                        v.setY(event.getRawY() - oldYvalue - v.getHeight());
                    }else{
                        v.setX(width);
                        v.setY(event.getRawY() - oldYvalue - v.getHeight());
                    }
                }else if (v.getY() < 0 || v.getY() > height){
                    if(v.getY() < 0){
                        v.setX(event.getRawX() - oldXvalue);
                        v.setY(0);
                    }else{
                        v.setX(event.getRawX() - oldXvalue);
                        v.setY(height);
                    }
                }
                FireGogi(v.getX(),v.getY(), (Integer) v.getTag(), (ImageView) v);

            }
            return true;
        }
    };


 */

    public void FireGogi1(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr1 = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (flag1){
                        try {
                            Thread.sleep(1000);
                            count1 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            plusTr1.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi2(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag2){
                        try {
                            Thread.sleep(1000);
                            count2 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            plusTr2.start();

        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi3(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag3){
                        try {
                            Thread.sleep(1000);
                            count3 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            plusTr3.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi4(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag4){
                        try {
                            Thread.sleep(1000);
                            count4 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            plusTr4.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi5(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr5 = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (flag5){
                        try {
                            Thread.sleep(1000);
                            count5 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            plusTr5.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi6(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr6 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag6){
                        try {
                            Thread.sleep(1000);
                            count6 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            plusTr6.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi7(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr7 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag7){
                        try {
                            Thread.sleep(1000);
                            count7 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            plusTr7.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi8(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr8 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag8){
                        try {
                            Thread.sleep(1000);
                            count8 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            plusTr8.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi9(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr9 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag9){
                        try {
                            Thread.sleep(1000);
                            count9 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            plusTr9.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
    public void FireGogi10(float x, float y, final int tag, final ImageView v)  {

        int resourceId = getResources().getIdentifier("goodgogi"+tag,"drawable","com.example.game");


        if((framegogi.getX() < x && x < framegogi.getX() + framegogi.getWidth()) && (framegogi.getY() < y && y< framegogi.getY() + framegogi.getHeight())){
            plusTr10 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag10){
                        try {
                            Thread.sleep(1000);
                            count10 ++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            plusTr10.start();
        }
        else if((finish.getX() < x && x < finish.getX() + finish.getWidth()) && (finish.getY() < y && y < finish.getY() + finish.getHeight())){
            v.setVisibility(View.GONE);
            if (tag2 == resourceId){
                sc += 500;
                score.setText(sc+"점");
                if(sc >= 3000){
                    Intent intent = new Intent(getApplicationContext(), GoodActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            else{
                Log.e("왜?", String.valueOf(death));
                if(death == 0){
                    life1.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 1){
                    life2.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 2){
                    life3.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 3){
                    life4.setImageResource(R.drawable.gogicount2);
                    death += 1;
                }else if(death == 4){
                    life5.setImageResource(R.drawable.gogicount2);
                    death += 1;
                    Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }

    private void TimerTask(){
        timerTask = new TimerTask() {
            int count = 161;
            @Override
            public void run() {
                count--;
                time.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count >= 0){
                            time.setText(count+"초");
                        }
                        else{
                            Intent intent = new Intent(getApplicationContext(),BadActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
            }
        };
        timer.schedule(timerTask,0,1000);
    }





    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}