package com.example.lenovo.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lenovo.myapplication.Global;

import java.util.Date;

/**
 * Created by lenovo on 2019/8/17.
 */

public class DBOpen extends SQLiteOpenHelper{

    private static  DBOpen db;

    public DBOpen(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createHotNews="create table HotNews values(id integer not null primary key autoincrement," +
                "newsTitle string not null," +
                "publishedTime datetime not null," +
                "sourceName string," +
                "summary string," +
                "numberOfView int," +
                "numberOfComments int," +
                "numberOfDiggs int)";

        String createLatestNews="create table LatestNews values(id integer not null primary key autoincrement," +
                "newsTitle string not null," +
                "publishedTime datetime not null," +
                "sourceName string," +
                "summary string," +
                "numberOfView int," +
                "numberOfComments int," +
                "numberOfDiggs int)";

        String createCommendNews="create table CommendNews values(id integer not null primary key autoincrement," +
                "newTitle string not null," +
                "publishedTime datetime not null," +
                "sourceName string," +
                "summary string," +
                "numberOfView int," +
                "numberOfComments int," +
                "numberOfDiggs int)";


        sqLiteDatabase.execSQL(createHotNews);
        sqLiteDatabase.execSQL(createLatestNews);
        sqLiteDatabase.execSQL(createCommendNews);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HotNews");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LatestNews");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CommendNews");

        onCreate(sqLiteDatabase);

    }


    public static DBOpen getDB(){
        if(db==null){
            db=new DBOpen(Global.GLOBAL_CONTEXT,"db");
        }
        return db;
    }
}
