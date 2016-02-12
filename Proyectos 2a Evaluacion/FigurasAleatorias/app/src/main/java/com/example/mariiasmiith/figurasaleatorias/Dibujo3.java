package com.example.mariiasmiith.figurasaleatorias;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mariiasmiith.figurasaleatorias.Clases.*;


public class Dibujo3 extends Activity {

    TextView radiolado;
    TextView altura;
    EditText introducradiolado;
    EditText introducaltura;
    Button btir;

    String elegida;

    static Cuadrado cuadrado = new Cuadrado();

    static Rectangulo rectangulo = new Rectangulo();

    static Circulo circulo = new Circulo();


    public static int COD_RESPUESTA=0;

    //Array que contiene las figuras, las imagenes
    private Figuras[] figura = new Figuras[]{
            new Figuras("Cuadrado", R.drawable.cuadrado, cuadrado),
            new Figuras("Rectangulo", R.drawable.rectangulo, rectangulo),
            new Figuras("Circulo", R.drawable.circulo, circulo)
    };

    static class ViewHolder {
        TextView name;
        ImageView im;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo3);

        radiolado = (TextView) findViewById(R.id.radiolado);
        altura = (TextView) findViewById(R.id.altura);
        introducradiolado = (EditText) findViewById(R.id.introducradiolado);
        introducaltura = (EditText) findViewById(R.id.introducaltura);
        btir = (Button) findViewById(R.id.btir);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int ancho = size.x;
        final int alto = size.y;


        //calcular y dibujar
        btir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float lado1, lado2;
                if (String.valueOf(introducradiolado.getText()).equals("")){
                    lado1 = Float.valueOf(10);
                }else {
                    lado1 = Float.valueOf(String.valueOf(introducradiolado.getText()));
                }
                if (String.valueOf(introducaltura.getText()).equals("")){
                    lado2 = Float.valueOf(10);
                }else {
                    lado2 = Float.valueOf(String.valueOf(introducaltura.getText()));
                }
                Intent miIntent = new Intent(Dibujo3.this , Final.class);
                Bundle miBundle = new Bundle();


                //En caso de que el circulo sea vertical
                if(lado1>((ancho-10)/2) && elegida.equals("Circulo")){
                    showToast("Error el radio no puede superar: " + ((ancho-10) / 2));

                }else if(lado1>(((alto-10)/2)-100)&&elegida.equals("Circulo")){
                    showToast("\"Error el radio no puede superar: " + (((alto-10) / 2)-100));

                    //en el mismo caso que el circulo pero para el cuadrado y rectangulo
                }else if (lado1>(ancho-10)){
                    switch (elegida){
                        case "Cuadrado":
                            showToast("El lado no puede superar: "+(ancho-10));
                            break;
                        case "Rectangulo":
                            showToast("La base no puede superar: "+(ancho-10));
                            break;
                    }

                    //caso horizontal del cuadrado
                }else if ((lado1>(alto-200)) && elegida.equals("Cuadrado")){
                    showToast("El lado no puede superar: "+(alto-200));

                    //caso horizontal del rectangulo
                }else if (elegida.equals("Rectangulo") && lado2>(alto-200)){
                    showToast("La altura no puede superar: "+(alto-200));

                }else{

                    //nos redirige al circulo
                    miBundle.putString("FIGURA", elegida);

                    //redirige al cuadrado
                    if (elegida.equals("Cuadrado")) {
                        cuadrado.setLado(lado1);
                        miBundle.putDouble("AREA", cuadrado.area());

                    }
                    //redirige al rectangulo
                    if (elegida.equals("Rectangulo")) {
                        rectangulo.setBase(lado1);
                        rectangulo.setAltura(lado2);
                        miBundle.putDouble("AREA", rectangulo.area());

                    }
                    if (elegida.equals("Circulo")) {
                        circulo.setRadio(lado1);
                        miBundle.putDouble("AREA", circulo.area());
                    }
                    miIntent.putExtras(miBundle);
                    startActivityForResult(miIntent, COD_RESPUESTA);
                }

            }
        });
        //para el spinner que nos muestras las figuras que queremos seleccionar
        Spinner miSpinner = (Spinner) findViewById(R.id.spinner1);
        //creamos el adaptador para el spinner
        AdaptadorSpinner miAdaptador = new AdaptadorSpinner(this);

        miSpinner.setAdapter(miAdaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                elegida = figura[position].getNombre();
                Figura f = figura[position].getFigura();

                //en caso de seleccionar el circulo
                if (elegida.equals("Circulo")) {
                    radiolado.setText("Radio: ");
                    radiolado.setVisibility(EditText.VISIBLE);
                    altura.setVisibility(EditText.INVISIBLE);
                    introducradiolado.setVisibility(EditText.VISIBLE);
                    introducaltura.setVisibility(EditText.INVISIBLE);

                }
                //en caso de seleccionar el cuadrado
                if (elegida.equals("Cuadrado")){
                    radiolado.setText("Lado: ");
                    radiolado.setVisibility(TextView.VISIBLE);
                    introducradiolado.setVisibility(EditText.VISIBLE);
                    altura.setText("Lado 2: ");
                    altura.setVisibility(TextView.INVISIBLE);
                    introducaltura.setVisibility(EditText.INVISIBLE);
                }
                //en caso de seleccionar el rectangulo
                if (elegida.equals("Rectangulo")){
                    radiolado.setText("Base: ");
                    radiolado.setVisibility(TextView.VISIBLE);
                    introducradiolado.setVisibility(EditText.VISIBLE);
                    altura.setText("Altura: ");
                    altura.setVisibility(TextView.VISIBLE);
                    introducaltura.setVisibility(EditText.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }


    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    class AdaptadorSpinner extends ArrayAdapter<Figuras> {
        public Activity activity;

        public AdaptadorSpinner(Activity laActividad){
            super (laActividad, R.layout.lista, figura);
            this.activity = laActividad;

        }
        // Vista del spinner
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View view = getView(position, convertView, parent);
            return view;
        }
        //mejora para el spinner utilizando holder
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;
            if (item == null) {
                LayoutInflater inflater = activity.getLayoutInflater();
                item = inflater.inflate(R.layout.lista, null);
                holder = new ViewHolder();
                holder.name = (TextView) item.findViewById(R.id.Nombre);
                holder.im = (ImageView) item.findViewById(R.id.imagenfig);
                item.setTag(holder);
            }else{
                holder = (ViewHolder)item.getTag();
            }
            //para versiones anteriores
            holder.name.setText(figura[position].getNombre());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.im.setBackground(getDrawable(figura[position].getImagen()));
            } else {
                holder.im.setBackgroundDrawable(getResources().getDrawable(figura[position].getImagen()));
            }

            return(item);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        introducradiolado.setText("");
        introducaltura.setText("");
    }

}
