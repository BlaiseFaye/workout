package com.example.workout;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.File;
public class AddWorkout extends Activity {
    Context ctx = this;
    BdHelper myDb;
    EditText editName, editExe1, editExe2, editExe3, editExe4, editExe5, editExe6, editExe7;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworkout);
        //ConnexionBD.copyFromAsset(this);
        editName = (EditText) findViewById(R.id.editText_name);
        editExe1 = (EditText) findViewById(R.id.editText_exe1);
        editExe2 = (EditText) findViewById(R.id.editText_exe2);
        editExe3 = (EditText) findViewById(R.id.editText_exe3);
        editExe4 = (EditText) findViewById(R.id.editText_exe4);
        editExe5 = (EditText) findViewById(R.id.editText_exe5);
        editExe6 = (EditText) findViewById(R.id.editText_exe6);
        editExe7 = (EditText) findViewById(R.id.editText_exe7);

        btnAddData = (Button) findViewById(R.id.button_add);
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutManager.insertData(ctx,editName.getText().toString(),editExe1.getText().toString(),editExe2.getText().toString(),editExe3.getText().toString(),editExe4.getText().toString(),editExe5.getText().toString(),editExe6.getText().toString(),editExe7.getText().toString());
                Intent intent = new Intent(ctx, MainActivity.class);
                LinearLayout container = findViewById(R.id.container);
                container.removeAllViews();
                startActivity(intent);
            }
        });
    }

}