package com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.content.*;
import android.graphics.*;



public class DibujoApp extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View{
        float pantallaH;
        float pantallaV;
        float pantallaV2;
        float pantallaH2;

        public MiDibujo(Context c){
            super(c);
        }
        protected void onDraw(Canvas p){
            p.drawColor(Color.WHITE);
            Paint miPincel= new Paint();

            pantallaH=p.getWidth();
            pantallaV=p.getHeight();
            pantallaV2= p.getHeight()/2;
            pantallaH2 = p.getWidth()/2;

            miPincel.setStyle(Paint.Style.FILL);
            //dibujo la cabeza
            miPincel.setStrokeWidth(5);
            miPincel.setColor(Color.parseColor("#fdddca"));
            p.drawCircle(375, 250, 100, miPincel);
            miPincel.setStrokeWidth(1);
            //los ojos
            miPincel.setColor(Color.BLACK);
            p.drawCircle(330, 220, 15, miPincel);
            p.drawCircle(430, 220, 15, miPincel);
            //la boca
            miPincel.setColor(Color.RED);
            p.drawCircle(380, 300, 20, miPincel);
            //dibujo cuello
            miPincel.setColor(Color.parseColor("#fdddca"));
            p.drawRect(355, 345, pantallaH - 365, 400, miPincel);
            //el brazo
            miPincel.setStrokeWidth(40);
            miPincel.setColor(Color.parseColor("#fdddca"));
            p.drawLine(400, 600, 140, 400, miPincel);
            p.drawLine(500,475,625,400, miPincel);
            //dibujo la camisa
            miPincel.setStrokeWidth(5);
            miPincel.setColor(Color.parseColor("#00FF80"));
            p.drawCircle(375, 525, 150, miPincel);
            //cinturon
            miPincel.setColor(Color.RED);
            p.drawRect(225, (pantallaV / 2) + 30, pantallaH - 245, pantallaV2 + 50, miPincel);
            //pantalon(las dos piernas)
            miPincel.setColor(Color.parseColor("#00FF80"));
            p.drawRect(225, (pantallaV / 2) + 50, pantallaH2 -65, pantallaV2 + 275, miPincel);
            p.drawRect(pantallaH2 + 55, (pantallaV / 2) + 50,pantallaH - 245, pantallaV2+275,miPincel);

            //titulo de abajo
            miPincel.setColor(Color.GREEN);
            miPincel.setStrokeWidth(15);
            miPincel.setTextSize(60);
            p.drawText("Farmacia Presencia", 125, 900, miPincel);
        }
    }
}
