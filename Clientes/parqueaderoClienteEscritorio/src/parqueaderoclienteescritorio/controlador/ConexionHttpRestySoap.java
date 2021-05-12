/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderoclienteescritorio.controlador;


import java.net.URI;

import java.net.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONObject;
import parqueaderoclienteescritorio.ParqueaderoClienteEscritorio;
import parqueaderoclienteescritorio.datos.Registro;
/**
 *
 * @author alexi
 */
public class ConexionHttpRestySoap {
   
    public ConexionHttpRestySoap() {
    }

  public  List<Registro> listar()throws InterruptedException, ExecutionException, TimeoutException{
      HttpClient client = HttpClient.newHttpClient();
     HttpRequest request = HttpRequest.newBuilder().uri(URI.create
        ("https://seminario-update.herokuapp.com")).build();
      CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        JSONArray albums = new JSONArray(response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS));
        List<Registro> l = new ArrayList<Registro>();
        for (int i = 0; i < albums.length(); i++) {
            JSONObject album = albums.getJSONObject(i);
            l.add(new Registro(album.getString("nombre"),album.getString("cedula"),
                    album.getString("placa"),String.valueOf(album.getInt("estado")),
                    String.valueOf(album.getInt("id")),album.getString("horaEntrada"),
                    album.get("horaSalida").toString()));
        }
    return l;
    } 
  public void salida(String id){
      listarAddorEdit(Integer.parseInt(id),"","","");
 
  }
  
  public void entrada(String nombre, String cedula, String placa){
      listarAddorEdit(0,nombre,cedula,placa);
  
  }

    private static void listarAddorEdit(int id, java.lang.String nombre, 
            java.lang.String cedula, java.lang.String placa) {
        parqueaderoclienteescritorio.ws.WebServices_Service service = 
                new parqueaderoclienteescritorio.ws.WebServices_Service();
        parqueaderoclienteescritorio.ws.WebServices port = 
                service.getWebServicesPort();
        port.listarAddorEdit(id, nombre, cedula, placa);
    }





   
  
  
}
