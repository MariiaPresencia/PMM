package com.example.mariiasmiith.probandodibujar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.RectF;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class Punto{
        float x;
        float y;
        public Punto(float coordx, float coordy){
            this.x = coordx;
            this.y = coordy;
        }
    }

    class MiDibujo extends View {
        public MiDibujo(Context c){
            super(c);
        }

        protected void onDraw(Canvas lienzo){
            Paint miPincel= new Paint();
            miPincel.setColor(Color.RED);
            miPincel.setStyle(Paint.Style.FILL);
            miPincel.setStrokeWidth(5);
            lienzo.drawCircle(245, 175, 80, miPincel);

            miPincel.setColor(Color.RED);
            miPincel.setStyle(Paint.Style.FILL);
            miPincel.setStrokeWidth(5);
            RectF miRec = new RectF(220,300,265,162);
            lienzo.drawRect(miRec, miPincel);

            RectF miTri = new RectF(300,380,340,240);


            miPincel.setColor(Color.BLUE);
            miPincel.setStrokeWidth(5);
            miPincel.setTextSize(60);
            lienzo.drawText("MI CIRCULO", 50, 200, miPincel);
        }
    }
}
