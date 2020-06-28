package Estructuras;

import Objetos.Vehiculo;

/**
 * En el proyecto utilizaremos Orden = 5 Eso deja el número maximo de claves por
 * nodo de 4 y el número maximo de hijos por nodo de 5 (Es el orden)
 */
public class ArbolB_Vehiculos {

    private NodoVehiculoAB raiz;
    private int grado;//Sinonimo de orden

    private int minHijos;
    private int minClaves;//TALVEZ BORRAR
    private int tamanio;
    private boolean existe;

    public ArbolB_Vehiculos(int grado) {
        this.grado = grado;
        this.minHijos = (grado / 2) + 1;//3
        this.minClaves = grado / 2;//TALVEZ BORRAR
        this.raiz = null;
        this.tamanio = 0;
        this.existe = false;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (getRaiz() == null) {
            setRaiz(new NodoVehiculoAB(null, grado));
            getRaiz().setCVehiculo(0, vehiculo, 1);////////////////////////////////////////////////////////
            //getRaiz().agregarClaveOrdenada(vehiculo);
        } else {
            NodoVehiculoAB aux = getRaiz();
            while (aux != null) {
                if (aux.getCantHijos() == 0) {
                    aux.agregarClaveOrdenada(vehiculo);
                    System.out.println("cant: "+aux.getCantVehiculos() + "gra: "+ grado);
                    if (aux.getCantVehiculos() <= grado - 1) {
                        System.out.println("Si");
                        break;
                    }
                    dividirNodo(aux);
                    break;
                }//cierro if
                
                if(vehiculo.getPlaca().compareTo(aux.getCVehiculo(0).getPlaca()) <= 0){
                    aux=aux.getNHijo(0);
                    //continue;
                }else if(vehiculo.getPlaca().compareTo(aux.getCVehiculo(aux.getCantVehiculos()-1).getPlaca())>0){
                    System.out.println("MEYOR cantV: "+ aux.getCantVehiculos());
                    aux=aux.getNHijo(aux.getCantVehiculos());
                    //continue;
                }else{
                    for(int pos=1; pos < aux.getCantVehiculos(); pos++){
                        if(vehiculo.getPlaca().compareTo(aux.getCVehiculo(pos).getPlaca()) < 0){
                            aux=aux.getNHijo(pos);
                            break;
                        }
                    }
                }

            }//termina while
        }
    }

    public void dividirNodo(NodoVehiculoAB nodoLleno) {
        System.out.println("DIVIDIENDO");
        NodoVehiculoAB aux = nodoLleno;
        //En nuestro caso 5 al insertar
        int cantVehiculos = aux.getCantVehiculos();
        //En nuestro caso 2 al insertar
        int indicePivote = cantVehiculos / 2;
        //En nuestro caso la 3ra clave al insertar
        Vehiculo clavePivote = aux.getCVehiculo(indicePivote);
        System.out.println("clavePivote: "+clavePivote.getPlaca());
        //CREANDO Y OBTENIENDO HIJOS!!!
        NodoVehiculoAB hijoIzquierdo = crearHijoIzq(aux, indicePivote);
        NodoVehiculoAB hijoDerecho = crearHijoDer(aux, indicePivote, cantVehiculos);

        //VALIDACION DE PADRES
        if (aux.getPadre() == null) {//La raiz se esta dividiendo, el árbol crece
            NodoVehiculoAB nuevaRaiz = new NodoVehiculoAB(null, grado);
            nuevaRaiz.setCVehiculo(0, clavePivote, 1);
            aux.setPadre(nuevaRaiz);
            setRaiz(nuevaRaiz);
            aux = getRaiz();
            aux.setNHijo(0, hijoIzquierdo);
            aux.setNHijo(1, hijoDerecho);
        } else {//Un nodo hoja se divide, la clavePivote sube al padre
            NodoVehiculoAB padreAux = aux.getPadre();
            padreAux.agregarClaveOrdenada(clavePivote);
            padreAux.removerHijo(aux);
            //padreAux.setNHijo(padreAux.getCantHijos(), hijoIzquierdo);
            //padreAux.setNHijo(padreAux.getCantHijos(), hijoDerecho);
            padreAux.agregarHijoOrdenado(hijoIzquierdo);
            padreAux.agregarHijoOrdenado(hijoDerecho);
            if (padreAux.getCantVehiculos() > grado-1) {
                dividirNodo(padreAux);
            }
        }

    }

    public NodoVehiculoAB crearHijoIzq(NodoVehiculoAB nodo, int indicePivote) {
        //CREANDO HIJO IZQ
        NodoVehiculoAB nodoHijo = new NodoVehiculoAB(null, grado);
        //AGREGANDO VALORES
        for (int a = 0; a < indicePivote; a++) {
            //nodoHijo.agregarClaveOrdenada(nodo.getCVehiculo(a));/////////////////////////////////////
            nodoHijo.setCVehiculo(a, nodo.getCVehiculo(a), 1);////////////////////
        }
        //SI NO ES HOJA, ACOMODAMOS LOS HIJOS
        if (nodo.getCantHijos() > 0) {
            for (int b = 0; b <= indicePivote; b++) {
                NodoVehiculoAB c = nodo.getNHijo(b);//R E C O M E N D A C I O N: unir esas 2 lineas
                nodoHijo.setNHijo(b, c);
            }
        }
        return nodoHijo;
    }

    public NodoVehiculoAB crearHijoDer(NodoVehiculoAB nodo, int indicePivote, int nClaves) {
        //CREANDO HIJO DER
        NodoVehiculoAB nodoHijo = new NodoVehiculoAB(null, grado);
        int pos = 0;
        //AGREGANDO VALORES
        for (int a = indicePivote + 1; a < nClaves; a++) {
            nodoHijo.setCVehiculo(pos, nodo.getCVehiculo(a), 1);
            pos++;
        }
        //SI NO ES HOJA, ACOMODAMOS LOS HIJOS
        pos = 0;
        if (nodo.getCantHijos() > 0) {
            for (int b = indicePivote + 1; b < nodo.getCantHijos(); b++) {
                NodoVehiculoAB c = nodo.getNHijo(b);//R E C O M E N D A C I O N: unir esas 2 lineas
                nodoHijo.setNHijo(pos, c);
                pos++;
            }
        }
        return nodoHijo;
    }

    public NodoVehiculoAB getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoVehiculoAB raiz) {
        this.raiz = raiz;
    }
}

/**
 * Buscar(Nodo, valor);
 */
