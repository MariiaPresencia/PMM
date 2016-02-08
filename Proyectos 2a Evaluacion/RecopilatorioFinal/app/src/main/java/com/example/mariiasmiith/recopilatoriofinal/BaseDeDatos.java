package com.example.mariiasmiith.recopilatoriofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.*;


public class BaseDeDatos extends SQLiteOpenHelper{
    String tablaUsuarios = "CREATE TABLE IF NOT EXISTS 'clientes' (" +
            "  'id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
            "  'usuario' TEXT NOT NULL UNIQUE," +
            "  'direccion' TEXT NOT NULL,"+
            "  'email' TEXT NOT NULL UNIQUE,"+
            "  'contrasenya' TEXT NOT NULL"+
            "  );";
    String createPedidos = "CREATE TABLE IF NOT EXISTS 'pedidos' (" +
            "  'id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "  'idCliente' INTEGER NOT NULL," +
            "  'farmaco' TEXT NOT NULL," +
            "  'dosis' TEXT NOT NULL," +
            "  'forma' TEXT NOT NULL," +
            "  'unidad' REAL NOT NULL," +
            "  'precio' REAL NOT NULL," +
            "  'imagen' INTEGERf NOT NULL," +
            "   FOREIGN KEY(idCliente) REFERENCES clientes(id) ON DELETE CASCADE" +
            "  );";

    public BaseDeDatos(Context contexto, String nombreBD, CursorFactory basededatos, int version){
        super(contexto, nombreBD, basededatos, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuarios);
        db.execSQL(createPedidos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Eliminamos la version anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS 'clientes'");
        db.execSQL("DROP TABLE IF EXISTS 'pedidos'");
        //Creamos la nueva versi�n de la tabla
        db.execSQL(tablaUsuarios);
        db.execSQL(createPedidos);
    }
}

