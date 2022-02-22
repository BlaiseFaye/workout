package com.example.workout;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
public class WorkoutManager {
    public static ArrayList<com.example.workout.Workout> getAll(Context context) {
        ArrayList<com.example.workout.Workout> retour = null;
        SQLiteDatabase bd = com.example.workout.ConnexionBD.getBd(context);
        String query = "select * from tabata";
        Cursor cursor = bd.rawQuery(query, null);
        if (cursor.isBeforeFirst()) {
            retour = new ArrayList<>();
            while (cursor.moveToNext()) {
                retour.add(new com.example.workout.Workout(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("exercice1")),
                        cursor.getString(cursor.getColumnIndex("exercice2")),
                        cursor.getString(cursor.getColumnIndex("exercice3")),
                        cursor.getString(cursor.getColumnIndex("exercice4")),
                        cursor.getString(cursor.getColumnIndex("exercice5")),
                        cursor.getString(cursor.getColumnIndex("exercice6")),
                        cursor.getString(cursor.getColumnIndex("exercice7"))
                ));
            }
        }
        return retour;
    }
    public static boolean insertData(Context context, String name, String exercice1, String exercice2, String exercice3, String exercice4, String exercice5, String exercice6,String exercice7) {
        SQLiteDatabase bd = com.example.workout.ConnexionBD.getBd(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(BdHelper.COL_1, name);
        contentValues.put(BdHelper.COL_2, exercice1);
        contentValues.put(BdHelper.COL_3, exercice2);
        contentValues.put(BdHelper.COL_4, exercice3);
        contentValues.put(BdHelper.COL_5, exercice4);
        contentValues.put(BdHelper.COL_6, exercice5);
        contentValues.put(BdHelper.COL_7, exercice6);
        contentValues.put(BdHelper.COL_8, exercice7);
        long result = bd.insert(BdHelper.TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public static ArrayList<com.example.workout.Workout> getWorkout(Context context, String value) {
        ArrayList<com.example.workout.Workout> retour = null;
        SQLiteDatabase bd = com.example.workout.ConnexionBD.getBd(context);
        String query = "select * from tabata where name='" + value + "'";
        Cursor cursor = bd.rawQuery(query, null);
        // Cursor cursor =  bd.rawQuery("select * from tabata where id="+theId );
        if (cursor.isBeforeFirst()) {
            retour = new ArrayList<>();
            while (cursor.moveToNext()) {
                retour.add(new com.example.workout.Workout(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("exercice1")),
                        cursor.getString(cursor.getColumnIndex("exercice2")),
                        cursor.getString(cursor.getColumnIndex("exercice3")),
                        cursor.getString(cursor.getColumnIndex("exercice4")),
                        cursor.getString(cursor.getColumnIndex("exercice5")),
                        cursor.getString(cursor.getColumnIndex("exercice6")),
                        cursor.getString(cursor.getColumnIndex("exercice7"))
                ));
            }
        }
        return retour;
    }
}
