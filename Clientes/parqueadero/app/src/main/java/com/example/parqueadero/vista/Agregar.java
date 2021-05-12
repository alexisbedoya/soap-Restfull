package com.example.parqueadero.vista;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.parqueadero.R;
import com.example.parqueadero.controlador.ConexionHttpSoap;
import com.example.parqueadero.datos.Registro;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Agregar extends AppCompatActivity {
    private EditText inputNombre,inputCedula,inputPlaca;
    private Button btnAgregar,btnListar;

    public static final String  URL = "http://192.168.1.2:8090/server/Server?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        inputNombre = (EditText) findViewById(R.id.inputNombre);
        inputCedula = (EditText) findViewById(R.id.inputCedula);
        inputPlaca = (EditText) findViewById(R.id.inputPlaca);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnListar = (Button) findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Agregar.this,PantallaLista.class);

                startActivity(intento);
            }
        });
      btnAgregar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              GetXMLTask gt = new GetXMLTask();

              gt.execute();
          }
      });
    }




    private class GetXMLTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            ConexionHttpSoap p = new ConexionHttpSoap();
            Registro r = new Registro();
            r.setCedula(inputCedula.getText().toString());
            r.setNombre(inputNombre.getText().toString());
            r.setPlaca(inputPlaca.getText().toString());
            p.entrada(r);
            return null;
        }

        private String getOutputFromUrl(String url) {
            StringBuffer output = new StringBuffer("");
            try {
                InputStream stream = getHttpConnection(url);
                BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
                String s = "";
                while ((s = buffer.readLine()) != null)
                    output.append(s);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return output.toString();
        }

        // Makes HttpURLConnection and returns InputStream
        private InputStream getHttpConnection(String urlString) throws IOException {
            InputStream stream = null;

            java.net.URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            try {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
                httpConnection.connect();

                if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    stream = httpConnection.getInputStream();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return stream;
        }

        @Override
        protected void onPostExecute(String output) {
            Toast.makeText(Agregar.this, " Guardado con Exito", Toast.LENGTH_LONG).show();
            inputCedula.setText( "");
            inputNombre.setText("");
            inputPlaca.setText("");


        }
    }


}