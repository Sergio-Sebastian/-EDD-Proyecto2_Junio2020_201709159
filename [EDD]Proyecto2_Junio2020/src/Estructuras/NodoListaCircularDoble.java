package Estructuras;

public class NodoListaCircularDoble {
   public NodoListaCircularDoble Siguiente;
   public NodoListaCircularDoble Anterior;
   public String DPI;
   public String Nombres;
   public String Apellidos;
   public String TipoLicencia;
   public String Genero;
   public String Telefono;
   public String Direccion;
   public NodoListaCircularDoble(String DPI, String Nombres, String Apellidos, String Licencia, String Genero, String Telefono, String Direccion){
       this.Siguiente = null;
       this.Anterior = null;
       this.DPI = DPI;
       this.Nombres = Nombres;
       this.Apellidos = Apellidos;
       this.TipoLicencia = Licencia;
       this.Genero = Genero;
       this.Telefono = Telefono;
       this.Direccion = Direccion;
   }
   //********************************************************************METODOS GET***********************************************************************
    public NodoListaCircularDoble getSiguiente() {
        return Siguiente;
    }
    public NodoListaCircularDoble getAnterior() {
        return Anterior;
    }
    public String getDPI() {
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
    public String getTelefono() {
        return Telefono;
    }
    public String getDireccion() {
        return Direccion;
    }
   //********************************************************************METODOS SET***********************************************************************
    public void setSiguiente(NodoListaCircularDoble Siguiente) {
        this.Siguiente = Siguiente;
    }
    public void setAnterior(NodoListaCircularDoble Anterior) {
        this.Anterior = Anterior;
    }
    public void setDPI(String DPI) {
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
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
}
