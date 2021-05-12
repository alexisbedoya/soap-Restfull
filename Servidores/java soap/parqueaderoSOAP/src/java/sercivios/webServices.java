/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sercivios;





import BD.BD;
import BD.Registro;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alexi
 */
@WebService(serviceName = "webServices")
public class webServices {

    /**
     * This is a sample web service operation
     * @param nombre
     * @param cedula
     * @param placa
     * @param estado
     * @param id
     */
     BD bd = new BD();
    @WebMethod(operationName = "listarAddorEdit")
    public void listarAddorEdit(@WebParam(name = "id") int id,@WebParam(name = "nombre") String nombre,@WebParam(name = "cedula") String cedula ,@WebParam(name = "placa") String placa) {
       bd.AgregarInfo(id, nombre, cedula, placa); 
       
        
     

    }
    
    
 

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Listar")
    public List<Registro> Listar() {
      
        return bd.ListarRegistros();
    }
    
    
}
