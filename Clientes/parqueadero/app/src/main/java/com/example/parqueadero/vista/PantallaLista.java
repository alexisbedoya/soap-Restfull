package com.example.parqueadero.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parqueadero.R;
import com.example.parqueadero.controlador.ConexionHttpGetServer;
import com.example.parqueadero.controlador.ConexionHttpSoap;
import com.example.parqueadero.datos.Registro;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class PantallaLista extends AppCompatActivity {
    private ListView listaRegistro;
    private ConexionHttpGetServer conexionServidor;
    private Button btnSalida, btnAtras;
    private ProgressDialog barraProgreso;
    private String ids;
    List<Registro> listaR;
    ArrayAdapter<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_lista);
        listaRegistro = (ListView) findViewById(R.id.listaUsuarios);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        btnSalida = (Button) findViewById(R.id.btnSalida);
        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        conexionServidor = new ConexionHttpGetServer();
        conexionServidor.direccionDelServidor = "https://seminario-update.herokuapp.com";
        new TareaListarTodo().execute("", "");
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(PantallaLista.this,Agregar.class);

                startActivity(intento);
            }
        });
        listaRegistro.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ids =  parent.getItemAtPosition(position).toString().split("-")[0];

            }
        });
        btnSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificar();
                System.out.println(ids);
            }
        });

    }

    private void modificar(){
        GetXMLTask tarea = new GetXMLTask();
        tarea.execute("");
        new TareaListarTodo().execute("", "");
    }

    private class GetXMLTask extends AsyncTask<String, Void, String> {
        ProgressDialog barraDeprogreso;
        String codigo, password, nombre, accion;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barraDeprogreso = new ProgressDialog(PantallaLista.this);
            barraDeprogreso.setMessage("Conectando...");
            barraDeprogreso.setIndeterminate(false);
            barraDeprogreso.setCancelable(false);
            barraDeprogreso.show();
        }
        @Override
        protected String doInBackground(String... urls) {
            ConexionHttpSoap p = new ConexionHttpSoap();

            p.salida(ids);

            return null;
        }





        @Override
        protected void onPostExecute(String output) {

            try {
                Thread.sleep(2000);
                barraDeprogreso.dismiss();
                Intent intento = new Intent(PantallaLista.this,

                        Agregar.class);
                Toast.makeText(PantallaLista.this, " Guardado con Exito", Toast.LENGTH_LONG).show();
                startActivity(intento);
            } catch (InterruptedException e) {
                barraDeprogreso.dismiss();
            }


        }
    }



    class TareaListarTodo extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            barraProgreso = new ProgressDialog(PantallaLista.this);
            barraProgreso.setMessage("Conectando...");
            barraProgreso.setIndeterminate(false);
            barraProgreso.setCancelable(false);
            barraProgreso.show();
        }
        @Override
        protected String doInBackground(String... params) {
            boolean resultado = procesarRespuestaPeticion();
            if (resultado == true) {
                return "OK";
            } else {
                return "NO";
            }
        }
        @Override
        protected void onPostExecute(String resultado) {
            barraProgreso.dismiss();
            if (resultado.equals("OK")) {
                mostrarUsuariosEnLista();
            } else {
                Toast.makeText(PantallaLista.this, "Error en la Tarea",

                        Toast.LENGTH_LONG).show();

            }
        }
    }
    private void mostrarUsuariosEnLista() {
        int i = 1;
// for (Map.Entry<String, Usuario> alguien : listaUsuarios.entrySet() ) {
        for (Registro alguien : listaR) {
            if(alguien.getEstado().equals("1")){
            i++;
            System.out.println("No. " + i + " " + alguien);
            String elemento = alguien.getId()+"-  "+alguien.getNombre() + " - " + alguien.getPlaca();
            items.add(elemento);}
        }
        listaRegistro.setAdapter(items);
    }
    private boolean procesarRespuestaPeticion() {
        //ArrayList<NameValuePair> listaParametros = new ArrayList<NameValuePair>();
        //NameValuePair parametro = new NameValuePair("accion", "listar");
        //listaParametros.add(parametro);
        try {
            String resultadoDelServidor =  conexionServidor.conexionConElServidor( conexionServidor.direccionDelServidor);

            if (resultadoDelServidor != null && resultadoDelServidor.length() > 0) {
                System.out.println("JSON: " + resultadoDelServidor);
                Gson json = new Gson();
//Type lista = new TypeToken<Map<String,Usuario>>(){}.getType();
                Type lista = new TypeToken<List<Registro>>() {
                }.getType();
                listaR = json.fromJson(resultadoDelServidor, lista);
                return true;
            } else {
                return false;
            }
        } catch (Exception error) {
            error.printStackTrace();
            Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
            return false;
        }
    }
}