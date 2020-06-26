package Objetos;
/*
 * Objeto que almacenará la tabla hash en listas simples
*/
public class Cliente {
    private long DPI;
    private String nombre;
    private String apellido;
    private String genero;
    private String fNacimiento;
    private long telefono;
    private String direccion;
    
    public Cliente(long DPI, String n, String a, String g, String f, long t, String d){
        this.DPI=DPI;
        this.nombre=n;
        this.apellido=a;
        this.genero=g;
        this.fNacimiento=f;
        this.telefono=t;
        this.direccion=d;
    }

    public long getDPI() {
        return DPI;
    }
    public void setDPI(long DPI) {
        this.DPI = DPI;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }
}