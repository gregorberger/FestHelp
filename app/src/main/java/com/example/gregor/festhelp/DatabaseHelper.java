package com.example.gregor.festhelp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="festhelp.db";
    public static final String TABLE_NAME="Tabela_koncertov";
    public static final String COL_1="ID";
    public static final String COL2="ODER";
    public static final String COL3="IME";
    public static final String COL4="URA";


    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,ODER TEXT,IME TEXT,URA TIME) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllDataGlavni()
    {
       SQLiteDatabase db= this.getWritableDatabase();
       Cursor res= db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+ COL2+" IN ('Glavni')",null);
       return res;
    }
    public Cursor getAllDataTechno()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res= db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+ COL2+" IN ('Techno')",null);
        return res;
    }
}
//Cursor res= db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COL2+"('Glavni')",null);