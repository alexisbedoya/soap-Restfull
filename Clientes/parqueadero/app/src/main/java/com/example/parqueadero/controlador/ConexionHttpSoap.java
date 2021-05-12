package com.example.parqueadero.controlador;

import com.example.parqueadero.datos.Registro;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class ConexionHttpSoap {
    final String WSDL_TARGET_NAMESPACE = "http://sercivios/";
    final String SOAP_ADDRESS="http://10.0.2.2:8090/parqueaderoSOAP/webServices";
    final String OPERATION_NAME = "listarAddorEdit";
    final String SOAP_ACTION = "http://sercivios/webServices/listarAddorEdit";
    public ConexionHttpSoap(){}
    public void entrada(Registro r){


        String result="";
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
                OPERATION_NAME);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER10);

        // Con esta opción indicamos que el web service no es .net
        envelope.dotNet = false;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);

        // Enviando un parámetro al web service
        request.addProperty("id",0);
        request.addProperty("nombre",r.getNombre());
        request.addProperty("cedula",r.getCedula());
        request.addProperty("placa", r.getPlaca());

        try {

            // Enviando la petición al web service
            httpTransport.call(SOAP_ACTION, envelope);

            // Recibiendo una respuesta del web service
            SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope
                    .getResponse();



            httpTransport.getServiceConnection().disconnect();
        } catch (IOException | XmlPullParserException e) {
            e.getMessage();

        }

    }

    public void salida(String id){

        String result="";
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
                OPERATION_NAME);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER10);

        // Con esta opción indicamos que el web service no es .net
        envelope.dotNet = false;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);

        // Enviando un parámetro al web service
        request.addProperty("id",id);

        request.addProperty("nombre","");
        request.addProperty("cedula","");
        request.addProperty("placa", "");

        try {

            // Enviando la petición al web service
            httpTransport.call(SOAP_ACTION, envelope);

            // Recibiendo una respuesta del web service
            SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope
                    .getResponse();



            httpTransport.getServiceConnection().disconnect();
        } catch (IOException | XmlPullParserException e) {
            e.getMessage();

        }





    }
}
