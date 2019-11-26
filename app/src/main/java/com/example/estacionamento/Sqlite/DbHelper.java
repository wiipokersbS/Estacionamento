package com.example.estacionamento.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Crud.db";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE =
            "CREATE TABLE Estacionamento" +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, nomeFantasia TEXT NOT NULL, razaoSocial TEXT NOT NULL, cnpj TEXT NOT NULL, cep TEXT NOT NULL," +
                    "logradouro TEXT NOT NULL, numero TEXT NOT NULL, bairro TEXT NOT NULL, cidade TEXT NOT NULL, estado TEXT NOT NULL);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}