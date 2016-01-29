package com.example.mariiasmiith.mpresencia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    private String[] pizza= {"Margarita - 12€","Tres Quesos - 15€","Barbacoa - 18€"};
    private String[] descripcion = {"jamon/tomate","queso1/queso2","carne/tomate"};
    private double[] precio = {12,15,18};
    private int[] imagenes = {R.drawable.pizza1, R.drawable.pizza2,R.drawable.pizza3};
    private int imagenSeleccionada;
    private double precioSeleccionado;

    private Spinner mySpinner;
    private CheckBox box1,box2,box3;
    private RadioButton b1,b2;
    private EditText txt1;
    private Button boton1;
    private TextView t1;
    private TextView lblMensaje1;


    public boolean onCreateOptionsMenu ( Menu menu){
        getMenuInflater().inflate(R.menu.menu_menu_principa, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje1.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MnuOpc2:
                lblMensaje1.setText("Opcion 2 pulsada!");;
                return true;
            case R.id.MnuOpc3:
                lblMensaje1.setText("Opcion 3 pulsada!");;
                return true;
            case R.id.SubMnuOpc1:
                lblMensaje1.setText("Subitem 1 seleccionado!");
                return true;
            case R.id.SubMnuOpc2:
                lblMensaje1.setText("Subitem Acerca de.. seleccionado!");
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner = (Spinner)findViewById(R.id.spinner);
        box1 = (CheckBox)findViewById(R.id.checkBox);
        box2 = (CheckBox)findViewById(R.id.checkBox2);
        box3 = (CheckBox)findViewById(R.id.checkBox3);
        b1 = (RadioButton)findViewById(R.id.radioButton);
        b2 = (RadioButton)findViewById(R.id.radioButton2);
        txt1 = (EditText)findViewById(R.id.editText);
        boton1 = (Button)findViewById(R.id.button);
        t1 = (TextView)findViewById(R.id.textView2);
        lblMensaje1 = (TextView)findViewById(R.id.lblMensaje);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, pizza);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(miAdaptador);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String mensaje = "";
                mensaje = "Has seleccionado " + pizza[pos] +" con descripcion "+descripcion[pos]+ " con el precio " + precio[pos];
                showToast(mensaje);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                double total = 0 ;
                double total1 = 0;
                String box = " ";
                String sele = " ";
                String n = txt1.getText().toString();
                double num = Double.parseDouble(n);
                String seleccion = mySpinner.getSelectedItem().toString();
                if(seleccion.equals("Margarita - 12€")){
                    total1 += 12;
                    imagenSeleccionada = imagenes[0];
                    precioSeleccionado = precio[0];
                }
                if(seleccion.equals("Tres Quesos - 15€")){
                    total1 += 15;
                    imagenSeleccionada = imagenes[1];
                    precioSeleccionado = precio[1];
                }
                if(seleccion.equals("Barbacoa - 18€")){
                    total1 += 18;
                    imagenSeleccionada = imagenes[2];
                    precioSeleccionado = precio[2];
                }

                if(box1.isChecked() == true){
                    total1 += 1;
                    sele += box1.getText()+" ";

                }
                if(box2.isChecked() == true){
                    total1 += 1;
                    sele += box2.getText()+" ";
                }
                if(box3.isChecked() == true){
                    total1+= 1;
                    sele += box3.getText()+" ";
                }
                if(num >= 0){
                    total1 = total1 * num;
                }
                if(b1.isChecked() == true){
                    total1 += 0;
                    box = b1.getText()+" ";
                }
                if(b2.isChecked() == true){
                    total = total1 * 0.1 ;
                    total1 += total;
                    box = b2.getText()+" ";
                }
                String mensaje = "Total: "+total1+" euros.";
                t1.setText(mensaje);

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                String pizzaSeleccion = "Pizza "+seleccion;
                String unidad = "Unidades :"+num;
                String mensajeEnvio = "Envio: "+box;
                String extra = "Extra: "+sele;
                String precioBase = "PRECIO BASE: "+precioSeleccionado;
                String precioFinal = "COSTE FINAL : "+total1;
                miBundle.putString("PIZZA",pizzaSeleccion);
                miBundle.putString("UNIDAD", unidad);
                miBundle.putString("SELECCION",mensajeEnvio);
                miBundle.putString("TEXTO", precioFinal);
                miBundle.putString("PRECIO",precioBase);
                miBundle.putString("EXTRA",extra);
                miBundle.putInt("IMAGEN",imagenSeleccionada);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }}
        );

    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
