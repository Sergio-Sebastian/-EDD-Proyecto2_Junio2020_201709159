package Estructuras;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class NodoBlockChain {
    public String Llave;
    public String Origen;
    public String Destino;
    public String FechaHora;
    //public NodoHash Cliente;
    public NodoLCD Conductor;
    //public NodoArbolB Vehiculo;
    public ListaArista Ruta;
    public NodoBlockChain(String origen, String destino, NodoLCD conductor, ListaVertice vertices){
        this.Origen = origen;
        this.Destino = destino;
        this.FechaHora = new SimpleDateFormat("ddMMyyyyHH:mm").format(new java.util.Date());
        this.Conductor = conductor;
        this.Ruta = vertices.CaminoCorto(origen, destino);
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
