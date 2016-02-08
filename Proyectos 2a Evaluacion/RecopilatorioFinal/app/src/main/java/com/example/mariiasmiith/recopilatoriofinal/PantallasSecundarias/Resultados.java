package com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.*;
import com.example.mariiasmiith.recopilatoriofinal.*;
import com.example.mariiasmiith.recopilatoriofinal.BaseDeDatos;
import com.example.mariiasmiith.recopilatoriofinal.Clases.PedidosCompleto;
import android.app.*;
import android.view.*;
import android.database.sqlite.SQLiteDatabase;
import android.database.*;
import android.content.*;

public class Resultados extends AppCompatActivity{

    TextView t1,t3,t4,t5,t6,t7;
    String idN , titulo;
    Spinner list;
    Button b1,b2;
    ImageView i1;
    int id;
    String farmaco;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_clientespedidos);

        Bundle recogido = getIntent().getExtras();
        id = recogido.getInt("ID");
        idN = recogido.getString("Nombre");
        titulo = "Tus pedidos " + idN + " son:";
        t1 = (TextView) findViewById(R.id.tit);
        t1.setText(titulo);

        b1 = (Button)findViewById(R.id.button7);
        b2 = (Button)findViewById(R.id.button8);

        mostrar();
        Adaptador adaptador = new Adaptador(this);
        list = (Spinner) findViewById(R.id.list);
        list.setAdapter(adaptador);

        Adaptador adaptado = new Adaptador(this);
        list.setAdapter(adaptado);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int i, long id) {
                i1.setImageResource(listapedido[i].getImagen());
                t3.setText(listapedido[i].getFarmaco());
                t4.setText("Precio " + listapedido[i].getPrecio());
                t5.setText(listapedido[i].getForma());
                t6.setText("Unidad " + listapedido[i].getUnidad());
                t7.setText(listapedido[i].getDosis());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                farmaco = "No ha seleccionado ningun farmaco";
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarPedido();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagina = new Intent(getApplicationContext(), Resultados.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle b= new Bundle();
                b.putInt("ID",id);
                pagina.putExtras(b);
                startActivity(pagina);
            }
        });

    }

    BaseDeDatos bd = new BaseDeDatos(this, "DBUsuarios", null, 1);
    PedidosCompleto[] listapedido;
    int idPedido;

    class Adaptador extends ArrayAdapter<PedidosCompleto>{
        public Activity context;
        public Adaptador(Activity context) {
            super(context, R.layout.spinner_pedidos, listapedido);
            this.context = context;
        }
        public View getDropDownView (int i, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(i, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {
            View item = convertView;
                LayoutInflater inflater = getLayoutInflater();
                item = inflater.inflate(R.layout.spinner_pedidos, null);
                i1 = (ImageView) item.findViewById(R.id.img);
                t3 = (TextView) item.findViewById(R.id.Farmaco);
                t4 = (TextView) item.findViewById(R.id.precio);
                t5 = (TextView) item.findViewById(R.id.forma);
                t6 = (TextView) item.findViewById(R.id.uni);
                t7 = (TextView) item.findViewById(R.id.dosis);

                i1.setImageResource(listapedido[i].getImagen());
                t3.setText(listapedido[i].getFarmaco());
                t4.setText("" + listapedido[i].getPrecio());
                t5.setText(listapedido[i].getForma());
                t6.setText(""+listapedido[i].getUnidad());
                t7.setText(listapedido[i].getDosis());
                idPedido = i;

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eliminarPedido();
                }
            });
            return item;
        }
    }

    public void eliminarPedido(){
        final SQLiteDatabase b = bd.getReadableDatabase();
        b.execSQL("DELETE FROM pedidos WHERE id = " + listapedido[idPedido].getIdPedido());
        Toast.makeText(this,"Pedido borrado correctamente",Toast.LENGTH_SHORT).show();
    }
    public void mostrar(){
            BaseDeDatos b = new BaseDeDatos(this, "DBUsuarios", null, 1);
            SQLiteDatabase bd = b.getReadableDatabase();
            if(bd != null) {
                Cursor c = bd.rawQuery("SELECT * FROM pedidos WHERE idCliente = "+id, null);
                int cont = c.getCount();
                int i = 0;
                listapedido = new PedidosCompleto[cont];
                if(c.moveToFirst()){
                    do {
                        int id = c.getInt(0);
                        int idCliente = c.getInt(1);
                        String farmaco = c.getString(2);
                        String dosis = c.getString(3);
                        String forma = c.getString(4);
                        int unidad = c.getInt(5);
                        Double precio = c.getDouble(6);
                        int imagen = c.getInt(7);

                        listapedido[i] = new PedidosCompleto(id,idCliente,farmaco,dosis,forma,unidad,precio,imagen);
                        i++;
                    } while (c.moveToNext());
                }
                c.close();
                bd.close();
        }
    }
}

