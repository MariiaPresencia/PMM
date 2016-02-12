package com.example.mariiasmiith.figurasaleatorias;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Final extends Activity {
    static String figura;
    static TextView textv1, textv2, textv3, textv4, textv5, textv6;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujofigura);
        //lo cogemos del bundle
        textv1 = (TextView) findViewById(R.id.tLBR);
        textv2 = (TextView) findViewById(R.id.tLBR2);
        textv3 = (TextView) findViewById(R.id.tLA);
        textv4 = (TextView) findViewById(R.id.tLA4);
        textv5 = (TextView) findViewById(R.id.tA);
        textv6 = (TextView) findViewById(R.id.tA2);
        Bundle bundle = getIntent().getExtras();
        figura = bundle.getString("FIGURA");

    }

    public static class FiguraVisualizacion extends View {
        public FiguraVisualizacion(Context contexto, AttributeSet attr) {
            super(contexto, attr);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //Dentro de este método utilizamos los métodos para dibujar BitmapDrawable

            Paint miPincel= new Paint();
            miPincel.setColor(Color.BLACK);
            float x = canvas.getWidth()/2;
            float y = canvas.getHeight()/2;
            miPincel.setStrokeWidth(10);
            miPincel.setStyle(Paint.Style.STROKE);
            RectF rectF;
            if(figura.equals("Circulo")){
                float radio = (float)Dibujo3.circulo.getRadio();
                textv3.setText("Radio es: ");
                textv4.setText(String.valueOf(radio));
                textv1.setVisibility(TextView.INVISIBLE);
                textv2.setVisibility(TextView.INVISIBLE);
                textv5.setText("Area es: ");
                textv6.setText(String.valueOf(Dibujo3.circulo.area()));

                canvas.drawCircle(x, y, radio, miPincel);
            }
            if(figura.equals("Cuadrado")) {
                float lado = (float) (Dibujo3.cuadrado.getLado());
                textv3.setText("Los Lados son: ");
                textv4.setText(String.valueOf(lado) + " x " + String.valueOf(lado));
                textv1.setVisibility(TextView.INVISIBLE);
                textv2.setVisibility(TextView.INVISIBLE);
                textv5.setText("Area es: ");
                textv6.setText(String.valueOf(Dibujo3.cuadrado.area()));

                rectF = new RectF((x - (lado / 2)), (y - (lado / 2)), (x + (lado / 2)), (y + (lado / 2)));
                canvas.drawRect(rectF, miPincel);
            }

            if(figura.equals("Rectangulo")){
                float base = (float)(Dibujo3.rectangulo.getBase());
                float altura = (float)(Dibujo3.rectangulo.getAltura());
                textv1.setText(" La Base es: ");
                textv2.setText(String.valueOf(base));
                textv3.setText("La Altura es: ");
                textv4.setText(String.valueOf(altura));
                textv5.setText("Area es: ");
                textv6.setText(String.valueOf(Dibujo3.rectangulo.area()));

                rectF = new RectF((x-(base/2)), (y-(altura/2)), (x+(base/2)), (y+(altura/2)));
                canvas.drawRect(rectF, miPincel);
            }

        }
    }
    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
