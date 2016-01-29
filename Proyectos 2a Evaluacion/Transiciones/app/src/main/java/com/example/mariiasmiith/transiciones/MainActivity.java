package com.example.mariiasmiith.transiciones;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imagen1;
    ImageView imagen2;
    TransitionDrawable miTransaccion;
    AnimationDrawable miAnimacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen1 = (ImageView)findViewById(R.id.trans);
        //transicion
        miTransaccion = (TransitionDrawable)getResources().getDrawable(R.drawable.transition);
        imagen1.setImageDrawable(miTransaccion);
        miTransaccion.startTransition(2000);

        //animacion
        imagen2 = (ImageView)findViewById(R.id.anim);
        miAnimacion = (AnimationDrawable)getResources().getDrawable(R.drawable.animacion);
        imagen2.setImageDrawable(miAnimacion);
    }
    public boolean onTouchEvent(MotionEvent evento){
        if(evento.getAction() == MotionEvent.ACTION_DOWN){
            miAnimacion.start();
            return true;
        }
        return super.onTouchEvent(evento);
    }
}
