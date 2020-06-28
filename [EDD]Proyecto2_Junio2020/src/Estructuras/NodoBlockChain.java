package Estructuras;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class NodoBlockChain {
    public int Llave;
    public String Origen;
    public String Destino;
    public String FechaHora;
    public NodoClienteLS Cliente;
    public NodoLCD Conductor;
    public NodoVehiculoAB Vehiculo;
    public ListaArista Ruta;
    public NodoBlockChain Siguiente;
    public NodoBlockChain Anterior;
    public NodoBlockChain(int llave, String origen, String destino, NodoClienteLS cliente, NodoLCD conductor, NodoVehiculoAB vehiculo, ListaVertice vertices){
        //this.Llave = placa + new SimpleDateFormat("ddMMyyyyHH:mm").format(new java.util.Date());
        this.Llave = llave;
        this.Origen = origen;
        this.Destino = destino;
        this.FechaHora = new SimpleDateFormat("ddMMyyyyHH:mm").format(new java.util.Date());
        this.Cliente = cliente;
        this.Conductor = conductor;
        this.Vehiculo = vehiculo;
        this.Ruta = vertices.CaminoCorto(origen, destino);
        this.Siguiente = null;
        this.Anterior = null;
    }
    private String EncriptarMD5(String textoaenc){
        try{
            MessageDigest mensaje = MessageDigest.getInstance("MD5");
            byte [] messageDigest = mensaje.digest(textoaenc.getBytes());
            BigInteger numero = new BigInteger(1, messageDigest);
            String hashText = numero.toString(16);
            
            while(hashText.length() < 32){
                hashText = "0" + hashText;
            }
            return hashText;
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
