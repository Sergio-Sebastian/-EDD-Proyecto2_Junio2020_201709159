
import Estructuras.*;

public class Main {
    public static void main(String[] args) {
        ListaCircularDoble Conductores = new ListaCircularDoble();
        Conductores.InsertarInicio("1", "Conductor 1", "Apellido 1", "A", "M", "Tel1", "Dir1");
        Conductores.InsertarInicio("2", "Conductor 2", "Apellido 2", "B", "F", "Tel2", "Dir2");
        Conductores.InsertarInicio("3", "Conductor 3", "Apellido 3", "C", "M", "Tel3", "Dir3");
        Conductores.InsertarInicio("4", "Conductor 4", "Apellido 4", "A", "F", "Tel4", "Dir4");
        Conductores.InsertarInicio("5", "Conductor 5", "Apellido 5", "B", "F", "Tel5", "Dir5");
        Conductores.InsertarInicio("6", "Conductor 6", "Apellido 6", "A", "F", "Tel6", "Dir6");
        Conductores.InsertarInicio("7", "Conductor 7", "Apellido 7", "A", "M", "Tel7", "Dir7");
        Conductores.InsertarInicio("8", "Conductor 8", "Apellido 8", "C", "M", "Tel8", "Dir8");
        Conductores.InsertarInicio("9", "Conductor 9", "Apellido 9", "C", "F", "Tel9", "Dir9");
        Conductores.InsertarInicio("10", "Conductor 10", "Apellido 10", "A", "M", "Tel10", "Dir10");
        Conductores.RecorrerLCD();
        Conductores.EliminarNodo("5");
        System.out.println("");
        Conductores.RecorrerLCD();
    }
}
