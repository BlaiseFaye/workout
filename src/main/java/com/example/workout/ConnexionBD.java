package com.example.workout;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
public class ConnexionBD {

    private static String nomBd = "workout.db";
    private static int version = 1;
    private static SQLiteDatabase db;

    public static SQLiteDatabase getBd(Context context){
        com.example.workout.BdHelper bdHelper = new com.example.workout.BdHelper(context, nomBd, null, version);
        db = bdHelper.getWritableDatabase();
        return  db;
    }
    public static void close(){
        db.close();
    }

    public static void copyFromAsset(Context ctx){
        try {

            InputStream in = ctx.getAssets().open(nomBd);
            File file = ctx.getDatabasePath(nomBd);
            FileOutputStream out = new FileOutputStream(file);
            byte[] tampon = new byte[10];
            while (in.read(tampon)!= -1){
                out.write(tampon);
                tampon = new byte[10];
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
