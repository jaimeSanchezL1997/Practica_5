import data.Processing;
import templates.Persona;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
    ArrayList<Persona> personas = new ArrayList<>();
    ArrayList<Persona> outPersonas = new ArrayList<>();

        personas.add(new Persona(
                "Pedro Rodirguez",
                24,
                1.70,
                75
        ));
        personas.add(new Persona(
                "Juan Perez",
                44,
                1.60,
                80
        ));
        personas.add(new Persona(
                "Jose Jimenez",
                32,
                1.80,
                67
        ));
        personas.add(new Persona(
                "jaime sanchez",
                21,
                1.73,
                52
        ));
        Processing processing = new Processing();
        processing.guardarPersonasEnArchivo(personas,"personas.txt");
//        processing.guardarPersonasEnArchivo(personas, "personas.txt");
       outPersonas = processing.leerPersonasDeArchivo("personas.txt");
      /* for (int i=0; i< outPersonas.size(); i++){
            System.out.println(
                    outPersonas.get(i).getNombre() + " | " +
                            outPersonas.get(i).getEdad() + " | " +
                            outPersonas.get(i).getEstatura() + " | " +
                            outPersonas.get(i).getPeso() + " | "
            );
        }*/
       processing.persona(personas,"personas.txt");


    }
}
