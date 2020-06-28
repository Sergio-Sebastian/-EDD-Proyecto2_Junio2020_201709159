package Objetos;
/*
 * Objeto que almacenará el árbol b en sus nodos paginas
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private long anio;
    private String color;
    private String precio;
    private String transmision;
    
    public Vehiculo(String placa, String ma, String mo, long a, String c, String p, String t){
        this.placa=placa;
        this.marca=ma;
        this.modelo=mo;
        this.anio=a;
        this.color=c;
        this.precio=p;
        this.transmision=t;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmision() {
        return transmision;
    }
    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
    public long getAnio() {
        return anio;
    }
    public void setAnio(long anio) {
        this.anio = anio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
