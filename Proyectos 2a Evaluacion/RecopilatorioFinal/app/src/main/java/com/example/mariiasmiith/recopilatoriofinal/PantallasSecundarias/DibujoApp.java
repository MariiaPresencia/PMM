package com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias;

import android.app.*;
import android.support.v7.app.ActionBarActivity;
import android.os.*;
import android.view.*;
import android.content.*;
import android.graphics.*;

public class DibujoApp extends ActionBarActivity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView (Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            
        }
    }
}
