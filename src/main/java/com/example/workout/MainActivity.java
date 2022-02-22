package com.example.workout;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class MainActivity extends Activity {
    private Button btnAddWorkout;

    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddWorkout = findViewById(R.id.addWorkout);
        btnAddWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewWorkout();
            }
        });

        //copier la bd la 1ere fois qu'on lance l'application ensuite
//       if (!doesDatabaseExist(this, "workout")){
//           ConnexionBD.copyFromAsset(this);
//       }

        ArrayList<Workout> arrayListAll = WorkoutManager.getAll(this);

        Display(arrayListAll);



    }
    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }

    public void AddNewWorkout() {
        Intent intent = new Intent(this, AddWorkout.class);
        startActivity(intent);
    }
    public void Display(ArrayList<Workout> a) {
        LinearLayout container = findViewById(R.id.container);

        for (Workout w : a) {

            TextView tv = new TextView(this);
            tv.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            tv.setText(w.getName());
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ctx, StartWorkout.class);
                    intent.putExtra("key",w.getName());
                    startActivity(intent);
                }
            });
            ImageView img = new ImageView(this);
            // load image
            try {
                // get input stream
                InputStream ims = getAssets().open("trainlogo.jpg");
                // load image as Drawable
                Drawable d = Drawable.createFromStream(ims, null);
                // set image to ImageView
                img.setImageDrawable(d);
            } catch (IOException ex) {
                return;
            }
            LinearLayout ll_workout = new LinearLayout(this);
            ll_workout.setOrientation(LinearLayout.HORIZONTAL);
            int width = 200;
            int height = 100;
            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, height);
            img.setLayoutParams(parms);
            ll_workout.setPadding(5, 5, 5, 5);
            ll_workout.addView(img);
            ll_workout.addView(tv);
            container.addView(ll_workout);
        }
    }
}