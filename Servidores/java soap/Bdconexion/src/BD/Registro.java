/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author alexi
 */
import java.io.Serializable;

public class Registro implements Serializable {
    String id;
    String nombre;
    String cedula;
    String placa;
    String estado;
    String horaE;
    String horaS;

    public Registro() {
    }

    public Registro(String id, String nombre, String cedula, String placa, String estado , String horaE, String horaS ) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.placa = placa;
        this.estado = estado;
        this.horaE = horaE;
        this.horaS = horaS;

    }
    
    public Registro(String nombre, String cedula, String placa) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.placa = placa;
    }
    
      public Registro(String id) {
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoraE() {
        return horaE;
    }

    public void setHoraE(String horaE) {
        this.horaE = horaE;
    }

    public String getHoraS() {
        return horaS;
    }

    public void setHoraS(String horaS) {
        this.horaS = horaS;
    }
}
    

