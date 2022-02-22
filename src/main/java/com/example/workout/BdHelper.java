package com.example.workout;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class BdHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "tabata";
    public static final String COL_1 = "name";
    public static final String COL_2 = "exercice1";
    public static final String COL_3 = "exercice2";
    public static final String COL_4 = "exercice3";
    public static final String COL_5 = "exercice4";
    public static final String COL_6 = "exercice5";
    public static final String COL_7 = "exercice6";
    public static final String COL_8 = "exercice7";

    public BdHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
