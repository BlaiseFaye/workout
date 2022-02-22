package com.example.workout;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ContentInfo;
import android.view.Gravity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class StartWorkout extends Activity {
    Context ctx=this;
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    int x=0;
    String value;

    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);
        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("%s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer chronometer) {


                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 6000) {

                    chronometer.setBase(SystemClock.elapsedRealtime());
                    if (list.get(x)!=null){
                        Toast.makeText(StartWorkout.this, "next move is "+list.get(x), Toast.LENGTH_SHORT).show();
                    }
                     x=x+1;
                    if (x==list.size()+1 || list.get(x-1) ==null ){
                        Intent intent = new Intent(ctx, MainActivity.class);
                        startActivity(intent);

                    }
                }

            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");

            //The key argument here must match that used in the other activity
        }
        ArrayList<Workout> arrayListAll = WorkoutManager.getWorkout(this,value);
        DisplayExe(arrayListAll);
        //ConnexionBD.copyFromAsset(this);



    }
    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
    public void DisplayExe(ArrayList<Workout> a) {
        LinearLayout listExercises = findViewById(R.id.listExercises);


        for (Workout w : a) {

            TextView tv1 = new TextView(this);
            tv1.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            tv1.setText(w.getExercice1());
            TextView tv2 = new TextView(this);
            tv2.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            tv2.setText(w.getExercice2());
            list.add(w.getExercice2());
            TextView tv3 = new TextView(this);
            tv3.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            tv3.setText(w.getExercice3());
            list.add(w.getExercice3());
            TextView tv4 = new TextView(this);
            tv4.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            tv4.setText(w.getExercice4());
            list.add(w.getExercice4());
            TextView tv5 = new TextView(this);
            tv5.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            tv5.setText(w.getExercice5());
            list.add(w.getExercice5());
            TextView tv6 = new TextView(this);
            tv6.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            tv6.setText(w.getExercice6());
            list.add(w.getExercice6());
            TextView tv7 = new TextView(this);
            tv7.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            tv7.setText(w.getExercice7());
            list.add(w.getExercice7());


            LinearLayout ll_workout = new LinearLayout(this);
            ll_workout.setOrientation(LinearLayout.VERTICAL);

            ll_workout.addView(tv1);
            ll_workout.addView(tv2);
            ll_workout.addView(tv3);
            ll_workout.addView(tv4);
            ll_workout.addView(tv5);
            ll_workout.addView(tv6);
            ll_workout.addView(tv7);
            listExercises.addView(ll_workout);
        }
    }

}