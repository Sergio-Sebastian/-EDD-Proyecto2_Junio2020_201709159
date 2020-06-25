package Estructuras;

import java.math.BigInteger;

public class NodoLCD {
   public NodoLCD Siguiente;
   public NodoLCD Anterior;
   public Long DPI;
   public String Nombres;
   public String Apellidos;
   public String TipoLicencia;
   public String Genero;
   public String FechaNac;
   public String Telefono;
   public String Direccion;
   public NodoLCD(Long DPI, String Nombres, String Apellidos, String Licencia, String Genero, String fecha, String Telefono, String Direccion){
       this.Siguiente = null;
       this.Anterior = null;
       this.DPI = DPI;
       this.Nombres = Nombres;
       this.Apellidos = Apellidos;
       this.TipoLicencia = Licencia;
       this.Genero = Genero;
       this.FechaNac = fecha;
       this.Telefono = Telefono;
       this.Direccion = Direccion;
   }
   //********************************************************************GET***********************************************************************
    public NodoLCD getSiguiente() {
        return Siguiente;
    }
    public NodoLCD getAnterior() {
        return Anterior;
    }
    public Long getDPI() {
        return DPI;
    }
    public String getNombres() {
        return Nombres;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public String getTipoLicencia() {
        return TipoLicencia;
    }
    public String getGenero() {
        return Genero;
    }
    public String getFechaNac() {
        return FechaNac;
    }
    public String getTelefono() {
        return Telefono;
    }
    public String getDireccion() {
        return Direccion;
    }
   //********************************************************************SET***********************************************************************
    public void setSiguiente(NodoLCD Siguiente) {
        this.Siguiente = Siguiente;
    }
    public void setAnterior(NodoLCD Anterior) {
        this.Anterior = Anterior;
    }
    public void setDPI(Long DPI) {
        this.DPI = DPI;
    }
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
    public void setTipoLicencia(String TipoLicencia) {
        this.TipoLicencia = TipoLicencia;
    }
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }  
    public void setDatos(NodoLCD nuevo){
       this.Nombres = nuevo.Nombres;
       this.Apellidos = nuevo.Apellidos;
       this.TipoLicencia = nuevo.TipoLicencia;
       this.Genero = nuevo.Genero;
       this.FechaNac = nuevo.FechaNac;
       this.Telefono = nuevo.Telefono;
       this.Direccion = nuevo.Direccion;
    }
}
