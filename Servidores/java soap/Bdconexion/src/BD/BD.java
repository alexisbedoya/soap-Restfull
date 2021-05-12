/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class BD {

    String driver, url, login, password;
    Connection conexion = null;

    public BD() {

        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://j21q532mu148i8ms.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/m6fl4gi1gtab1m7l";
        login = "w4f1agseuwgbanl3";
        password = "t1tpfcm1640win1k";
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, login, password);
            System.out.println("Conexion con Base de datos Ok....");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException exc) {
            System.out.println("Error al tratar de abrir la base de datos");
            System.out.println(exc.getMessage());
        }

    }

    // guardar registros en BD
    public void AgregarInfo(int id,String nombre, String cedula, String placa) {
       
        String estado = "1";
     
       // String ComandoSQL = "INSERT INTO listado(nombre,cedula,placa,estado)  VALUES ('" + nombre + "' , '" + cedula + "' ,'" + placa + "','" + estado + "' )";
         String ComandoSQL = "CALL listadoAddOrEdit('"+id+"','" + nombre + "' , '" + cedula + "' ,'" + placa + "','" + estado + "' )";
        try {

            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(ComandoSQL);
            System.out.println("Registro agregado!");

            stmt.close();

        } catch (java.sql.SQLException er) {
            System.out.println("No se pudo realizar la operación.");
        }
    }

    // traer lista de registros desde BD
    public ArrayList<Registro> ListarRegistros() {
        String id, nombre, cedula, placa, estado, fechaE, fechaS;
        String ComandoSQL = "SELECT * FROM listado";
        ArrayList<Registro> cts = new ArrayList<>();

        try {
            Statement stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery(ComandoSQL);

            while (resultado.next()) {
                id = resultado.getString(5);
                nombre = resultado.getString(1);
                cedula = resultado.getString(2);
                placa = resultado.getString(3);
                estado = resultado.getString(4);
                fechaE = resultado.getString(6);
                fechaS = resultado.getString(7);
                cts.add(new Registro(id, nombre, cedula, placa, estado, fechaE, fechaS));
            }
            stmt.close();
        } catch (java.sql.SQLException er) {
            System.out.println("No se pudo realizar la operación.");
        }
        return cts;
    }

    public void AgregarSalida(String id) {
        System.out.println("dentro;"+id);
        String ComandoSQL = "UPDATE `listado` SET `estado`=0  WHERE id="+id;
        System.out.println("okis");
        try {

            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(ComandoSQL);
            System.out.println("Salida registrada");

            stmt.close();

        } catch (java.sql.SQLException er) {
            System.out.println("No se pudo realizar la operación.");
            System.out.println(er.getMessage());
        }
    }

}
