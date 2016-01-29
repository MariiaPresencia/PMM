package com.example.mariiasmiith.ejemplorefresco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    private Spinner mySpinner;
    final static String bebidas[] = {"Coca cola","Fanta","Monster"};
    final static Double precio[] = {2.5,1.5,3.0};
    private CheckBox box1 , box2, box3;
    private RadioButton b1,b2;
    private Button miboton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miboton = (Button)findViewById(R.id.button);
        b1 = (RadioButton)findViewById(R.id.radioButton);
        b2 = (RadioButton)findViewById(R.id.radioButton2);
        box1 = (CheckBox)findViewById(R.id.checkBox);
        box2 = (CheckBox)findViewById(R.id.checkBox2);
        box3 = (CheckBox)findViewById(R.id.checkBox3);
        mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, bebidas);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(miAdaptador);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String mensaje = "";
                mensaje = "Bebida seleccionada " + bebidas[pos] + " con el precio " + precio[pos];
                showToast(mensaje);
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        miboton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                double total = 0;
                String box = "";
                String vaso = "";
                String seleccion = mySpinner.getSelectedItem().toString();
                if(seleccion.equals("Coca cola")){
                    total += 2.5;
                }
                if(seleccion.equals("Fanta")){
                    total += 1.5;
                }
                if(seleccion.equals("Monster")){
                    total += 3;
                }

                if(box1.isChecked() == true){
                    total += 1.20;
                    box += box1.getText()+" ";
                }
                if(box2.isChecked() == true){
                    total += 1.75;
                    box += box2.getText()+" ";
                }
                if(box3.isChecked() == true){
                    total += 1;
                    box += box3.getText()+" ";
                }
                if(b1.isChecked() == true){
                    total += 0;
                    vaso += b1.getText()+" ";
                }
                if(b2.isChecked() == true){
                    total += 1.5;
                    vaso += b2.getText()+" ";
                }

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();

                String mensajePaso = "Total del pedido "+ total;
                String mensajeBebida = "Has seleccionado :"+seleccion;
                String mensajeComplemento ="El complemento elegido es :"+box;
                String mensajeVaso = "El vaso elegido : " +vaso;

                miBundle.putString("BEBIDA", mensajeBebida);
                miBundle.putString("COMPLEMENTO",mensajeComplemento);
                miBundle.putString("VASO",mensajeVaso);
                miBundle.putString("TEXTO", mensajePaso);

                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }

        });
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}

