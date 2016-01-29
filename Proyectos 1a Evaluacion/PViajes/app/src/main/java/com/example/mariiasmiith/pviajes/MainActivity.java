package com.example.mariiasmiith.pviajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.view.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner mySpinner;
    private String[] viaje = {"Zona A",  "Zona B","Zona C"};
    private int[] imagenes = {R.drawable.america_africa,R.drawable.asia_oceania, R.drawable.europa};


    private RadioButton r1;
    private RadioButton r2;
    private int imagenSeleccionada;

    private CheckBox box1;
    private CheckBox box2;

    private EditText txt1;

    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = (RadioButton)findViewById(R.id.radioButton);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        box1 = (CheckBox)findViewById(R.id.checkBox);
        box2 = (CheckBox)findViewById(R.id.checkBox2);
        txt1 = (EditText)findViewById(R.id.editText);
        b1 = (Button)findViewById(R.id.button);
        mySpinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, viaje);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(miAdaptador);


        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                double total = 0;
                double total1 = 0;
                double totalBox = 0;
                String box = " ";
                String n = txt1.getText().toString();
                double num = Double.parseDouble(n);
                if(num <= 5){
                    total += (1.0 * num);
                }
                if((num >= 6)&&(num <=10) ){
                    total += (1.5 * num);
                }
                if(num > 10){
                    total += (2.0 * num);
                }


                String seleccion = mySpinner.getSelectedItem().toString();
                if(seleccion.equals("Zona A")){
                    total += 30;
                    imagenSeleccionada = imagenes[0];
                }
                if(seleccion.equals("Zona B")){
                    total += 20;
                    imagenSeleccionada = imagenes[1];
                }
                if(seleccion.equals("Zona C")){
                    total += 10;
                    imagenSeleccionada = imagenes[2];
                }

                if(box1.isChecked()==true){
                    total1 += 0;
                    box += box1.getText()+" ";
                }
                if(box2.isChecked()==true){
                    if(num <= 5){
                        total1 += (1.0 * num);
                    }
                    if((num >= 6)&&(num <=10) ) {
                        total1 += (1.5 * num);
                    }
                    if(num > 10){
                        total1 += (2.0 * num);
                    }


                    if(seleccion.equals("Zona A")){
                        total1 += 30;
                    }
                    if(seleccion.equals("Zona B")){
                        total1 += 20;
                    }
                    if(seleccion.equals("Zona C")){
                        total1 += 10;
                    }
                    totalBox = total1 * 0.3;
                    total += totalBox;
                    box += box2.getText() +" ";
                }
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                String zonaSeleccionada = "La zona "+seleccion;
                String peso = "El peso es:"+num+" kg.";
                String mensajeBox = "Paquete: "+box;
                String mensajePaso = "Coste final: "+ total;
                miBundle.putString("ZONA",zonaSeleccionada);
                miBundle.putString("PESO", peso);
                miBundle.putString("SELECCION",mensajeBox);
                miBundle.putString("TEXTO", mensajePaso);
                miBundle.putInt("IMAGEN",imagenSeleccionada);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);

            }
        });
    }


}
