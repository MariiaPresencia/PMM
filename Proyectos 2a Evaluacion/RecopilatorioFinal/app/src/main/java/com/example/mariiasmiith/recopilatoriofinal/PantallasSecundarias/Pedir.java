package com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mariiasmiith.recopilatoriofinal.BaseDeDatos;
import com.example.mariiasmiith.recopilatoriofinal.Clases.Farmacos;
import com.example.mariiasmiith.recopilatoriofinal.PantallasFinales.PantallaFinal;
import com.example.mariiasmiith.recopilatoriofinal.R;
import java.text.DecimalFormat;

public class Pedir extends AppCompatActivity{

    public Spinner mySpinner;
    public TextView textView1,textView2;
    public RadioButton radio1,radio2;
    public CheckBox checkBox1,checkBox2,checkBox3;
    public ImageView imageView1;
    public EditText editText1;
    public Button button1;
    double total, precioF;
    String farmaco1;
    Integer img;
    int idCliente;

    private Farmacos[] farmaco = new Farmacos[]{
            new Farmacos("Aspirina", 3.4, R.drawable.aspirina),
            new Farmacos("Ibuprofeno", 4.6, R.drawable.ibuprofeno),
            new Farmacos("Flumucil", 6.7, R.drawable.flumucil),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recopilatorio);

        Bundle recoge = getIntent().getExtras();
        idCliente = recoge.getInt("IDCLIENTE");

        //creamos las variables
        textView1 = (TextView) findViewById(R.id.textView1);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        radio1 = (RadioButton) findViewById(R.id.radioButton1);
        radio2 = (RadioButton) findViewById(R.id.radioButton2);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        textView2 = (TextView) findViewById(R.id.textView2);
        editText1 = (EditText) findViewById(R.id.editText1);
        button1 = (Button) findViewById(R.id.button1);


        class AdaptadorFarmacos extends ArrayAdapter<Farmacos> {
            public Activity AdaptadorFarmacos;
            public AdaptadorFarmacos(Activity AdaptFarmaco) {
                super(AdaptFarmaco, R.layout.spinner_lista, farmaco);
                this.AdaptadorFarmacos = AdaptFarmaco;
            }
            public View getDropDownView (int position, View convertView, ViewGroup parent) {
                View vistaDesplegada = getView(position, convertView, parent);
                return vistaDesplegada;
            }
            //ADAPTACION PARA EL SPINNER
            public  View getView (int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = AdaptadorFarmacos.getLayoutInflater();
                View item=inflater.inflate(R.layout.spinner_lista, null);
                textView1 = (TextView) item.findViewById(R.id.LblNombre);
                textView2 = (TextView) item.findViewById(R.id.LblPrecio);
                imageView1 = (ImageView) item.findViewById(R.id.LblImagen);

                textView1.setText(farmaco[position].getFarmaco());
                textView2.setText(String.valueOf(farmaco[position].getPrecio()));
                imageView1.setImageResource(farmaco[position].getImagen()); //EL ERROR ES POR QUE ANTES DE UNA VERSION DE LOLIPORP SE HACICA DE OTRA FORMA PE

                return item;
            }

        }

        mySpinner = (Spinner) findViewById(R.id.myspinner);
        AdaptadorFarmacos adaptador = new AdaptadorFarmacos(this);
        mySpinner.setAdapter(adaptador);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                farmaco1 = farmaco[position].getFarmaco();
                precioF = farmaco[position].getPrecio();
                img = farmaco[position].getImagen();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                farmaco1 = "No ha seleccionado ningun ordenador";
            }
        });

        //Click del boton
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                DecimalFormat formateador = new DecimalFormat("##.##");
                String precioTotal;
                double total = 0;
                double cantidad = Double.parseDouble(editText1.getText().toString());
                String box = " ";
                String sele = " ";
                String seleccionado = mySpinner.getSelectedItem().toString();
                if (checkBox1.isChecked() == true) {
                    total = total + 1.5;
                    sele += checkBox1.getText()+" ";
                }
                if (checkBox2.isChecked() == true) {
                    total = total + 2.5;
                    sele += checkBox2.getText()+" ";
                }
                if (checkBox3.isChecked() == true) {
                    total = total + 3.5;
                    sele += checkBox3.getText()+" ";
                }

                if (radio1.isChecked() ==true) {
                    total = total + 3;
                    box += radio1.getText()+ " ";
                }
                if (radio2.isChecked() ==true) {
                    total = total;
                    box += radio2.getText()+ " ";
                }

                //Precio segun la cantidad
                total = total + precioF;
                total = total * cantidad;

                registrarPedidos(idCliente,farmaco1,sele,box,cantidad,total,img);

                Intent miIntent = new Intent(Pedir.this, PantallaFinal.class);
                Bundle miBundle = new Bundle();
                String unidad = "Unidades :"+cantidad;
                String tp1 = "Tipo: "+box;
                String tp2 = "Cantidad: "+sele;
                String precioBase = "PRECIO BASE: "+precioF;
                String precioFinal = "COSTE FINAL : "+total;

                miBundle.putString("FARMACO",farmaco1);
                miBundle.putString("UNIDAD", unidad);
                miBundle.putString("SELECCION",tp1);
                miBundle.putString("TEXTO", precioFinal);
                miBundle.putString("PRECIO",precioBase);
                miBundle.putString("EXTRA",tp2);
                miBundle.putInt("IMAGEN",img);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);


            }

        });


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.opcion1:
                startActivity(new Intent(this,DibujoApp.class));
                return true;
            case R.id. opcion2:
                startActivity(new Intent(this,AcercaDe.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void registrarPedidos(int idCliente, String farmaco, String dosis, String forma, double unidad , double precio , int imagen){

        BaseDeDatos ad = new BaseDeDatos(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = ad.getWritableDatabase();

        ContentValues registro1 = new ContentValues();

        registro1.put("idCliente",idCliente);
        registro1.put("farmaco", farmaco);
        registro1.put("dosis", dosis);
        registro1.put("forma", forma);
        registro1.put("unidad", unidad);
        registro1.put("precio", precio);
        registro1.put("imagen", imagen);


        db.insert("pedidos", null, registro1);
        //db.execSQL("INSERT INTO 'pedidos' (idCliente , farmaco , dosis, forma , unidades , precio, imagen) VALUES " + registro);
        db.close();

        Toast.makeText(this, "Guardado correctamente", Toast.LENGTH_SHORT).show();
    }
}
