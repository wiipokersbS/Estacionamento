package com.example.estacionamento.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbGateway {

    private static DbGateway gw;
    private SQLiteDatabase db;

    public DbGateway(Context context) {

        DbHelper helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public static DbGateway getInstance(Context context){
        if(gw == null)
            gw = new DbGateway(context);
            return gw;

    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }
}
