/*
 * Ejecuta el comando dot
 */
package Objetos;

public class GraphvizJava {

    public GraphvizJava() {
    }
    
    public GraphvizJava(String direccionDot, String direccionPng) {
        dibujar(direccionDot, direccionPng);
    }

    public void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;
            /*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}