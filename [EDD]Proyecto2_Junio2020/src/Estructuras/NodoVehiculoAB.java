package Estructuras;
import Objetos.Vehiculo;
/*
 * NODO PARA EL ÁRBOL B DE VEHICULOS
 * 
 * 
 */
public class NodoVehiculoAB {
    //podria tener el atributo grado aqui
    private Vehiculo[] clavesVehiculos;
    private NodoVehiculoAB[] nodosHijos;
    private int cantVehiculos;
    private int cantHijos;
    private int posHijoRemovido;
    
    private NodoVehiculoAB padre = null;
    
    public NodoVehiculoAB(NodoVehiculoAB padre, int orden) {//OTRA OPCION ES:
        this.clavesVehiculos = new Vehiculo[orden];//sin -1
        this.nodosHijos = new NodoVehiculoAB[orden+1];//+1, porque si
        this.cantVehiculos = 0;
        this.cantHijos = 0;
        this.posHijoRemovido=0;
        this.padre = padre;
    }

    //DEVUELVEN ARREGLOS
    public Vehiculo[] getClavesVehiculos() {
        return clavesVehiculos;
    }
    public void setClavesVehiculos(Vehiculo[] clavesVehiculos) {
        this.clavesVehiculos = clavesVehiculos;
    }
    public NodoVehiculoAB[] getNodosHijos() {
        return nodosHijos;
    }
    public void setNodosHijos(NodoVehiculoAB[] nodosHijos) {
        this.nodosHijos = nodosHijos;
    }

    
    //DEVUELVEN OBJETOS ESPECIFICOS
    public Vehiculo getCVehiculo(int pos) {
        return clavesVehiculos[pos];
    }
    public void setCVehiculo(int pos, Vehiculo cVehiculos) {
        this.clavesVehiculos[pos] = cVehiculos;
    }
    public void setCVehiculo(int pos, Vehiculo cVehiculos, int a) {
        this.clavesVehiculos[pos] = cVehiculos;
        cantVehiculos++;
    }

    public NodoVehiculoAB getNHijo(int pos) {
        if(pos >= cantHijos){
            return null;
        }
        return nodosHijos[pos];
    }
    public void setHijo(int pos, NodoVehiculoAB nodoHijo) {
        nodoHijo.padre=this;
        this.nodosHijos[pos] = nodoHijo;
        
    }
    public void setNHijo(int pos, NodoVehiculoAB nodoHijo) {
        nodoHijo.padre=this;
        cantHijos++;
        this.nodosHijos[pos] = nodoHijo;
        
    }
    
    
    //OTROS SETS Y GETS
    public int getCantVehiculos() {
        return cantVehiculos;
    }
    public void setCantVehiculos(int cantVehiculos) {
        this.cantVehiculos = cantVehiculos;
    }

    public int getCantHijos() {
        return cantHijos;
    }
    public void setCantHijos(int cantHijos) {
        this.cantHijos = cantHijos;
    }

    public NodoVehiculoAB getPadre() {
        return padre;
    }
    public void setPadre(NodoVehiculoAB padre) {
        this.padre = padre;
    }
    
    
    //OTROS METODOS AUXILIARES
    public void agregarClaveOrdenada(Vehiculo v){
        System.out.println("aco");
        int i=cantVehiculos-1;
        //System.out.println("i: " + i + "P:"+getCVehiculo(i).getPlaca()+"-P:"+v.getPlaca());
        while (i >= 0 && getCVehiculo(i).getPlaca().compareTo(v.getPlaca()) > 0) {
            System.out.println("i: " + i + "P:"+getCVehiculo(i).getPlaca()+"-P:"+v.getPlaca());
            setCVehiculo(i + 1, getCVehiculo(i));
            System.out.println("i: " + i + "P:"+getCVehiculo(i).getPlaca()+"-P:"+v.getPlaca());
            i--;
        }
        // Insert the new key at found location 
        setCVehiculo(i + 1, v);
        setCantVehiculos(getCantVehiculos()+1);
    }
    
    public void agregarHijoOrdenado(NodoVehiculoAB nodoHijo){
        System.out.println("aho");
        int i=cantHijos-1;
        //System.out.println("i: " + i + "P:"+getCVehiculo(i).getPlaca()+"-P:"+v.getPlaca());
        while (i >= 0 && getNHijo(i).getCVehiculo(0).getPlaca().compareTo(
                nodoHijo.getCVehiculo(0).getPlaca()) > 0) {
            System.out.println("i: " + i + "P:"+getNHijo(i).getCVehiculo(0).getPlaca()+
                    "-P:"+nodoHijo.getCVehiculo(0).getPlaca());
            setHijo(i + 1, getNHijo(i));
            
            //System.out.println("i: " + i + "P:"+getCVehiculo(i).getPlaca()+"-P:"+nodoHijo.getPlaca());
            i--;
        }
        // Insert the new key at found location 
        setNHijo(i + 1, nodoHijo);
//        setCantHijos(getCantHijos()+1);
    }
    
    public boolean removerHijo(NodoVehiculoAB hijo){
        boolean encontrado=false;
        if(cantHijos == 0){
            return encontrado;
        }
        for(int i=0; i < cantHijos; i++){
            if(nodosHijos[i].equals(hijo)){
                encontrado=true;
            }else if(encontrado){
                nodosHijos[i-1] = nodosHijos[i];
            }
        }
        if(encontrado){
            cantHijos--;
            nodosHijos[cantHijos] = null;
        }
        return encontrado;
    }
    
    
}