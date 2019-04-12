package data;
import templates.Persona;
import  java.io.*;
import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.input.ReversedLinesFileReader;

public class Processing {

    public void mostrarPersona(ArrayList<Persona> personas) {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(
                    personas.get(i).getNombre() + " " +
                            personas.get(i).getEdad() + " " +
                            personas.get(i).getEstatura() + " " +
                            personas.get(i).getPeso() + " "
            );
        }
    }

    public void guardarPersonasEnArchivo(ArrayList<Persona> personas, String nombreArchivo) {
        File fout = new File(nombreArchivo);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        try {
            for (int i = 0; i < personas.size(); i++) {
                bufferedWriter.write(
                        "(" + personas.get(i).getNombre() + ")" +
                                "(" + personas.get(i).getEdad() + ")" +
                                "(" + personas.get(i).getEstatura() + ")" +
                                "(" + personas.get(i).getPeso() + ")\n"
                );
//                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Persona> leerPersonasDeArchivo(String nombreArchivo){
        ArrayList<Persona> outPersona = new ArrayList<>();
        File fin = new File(nombreArchivo);
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(fin);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String thisLine = null;

            try {
                while ((thisLine = bufferedReader.readLine()) != null){
//                    \\(([^)]+)\\)
                    String pattern = "\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)";
                    Matcher matcher = Pattern.compile(pattern).matcher(thisLine);
                    if (matcher.find()){
                        outPersona.add( new Persona(
                                matcher.group(1),
                                Integer.parseInt( matcher.group(2) ),
                                Double.parseDouble( matcher.group(3) ),
                                Integer.parseInt( matcher.group(4) )
                        ));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        return outPersona;
    }

    public String persona(ArrayList<Persona> personas,String NombreArchvio) throws IOException {
        String per;
        File file = new File("personas.txt");
        ReversedLinesFileReader object = null;
        try {
            object = new ReversedLinesFileReader(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = object.readLine();
        System.out.println(line);
        String pattern = "\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)";
        Matcher matcher = Pattern.compile(pattern).matcher(line);
        Persona personaUltima = null;
        if (matcher.find()) {
            personaUltima = new Persona(
                    matcher.group(1),
                    Integer.parseInt( matcher.group(2) ),
                    Double.parseDouble( matcher.group(3) ),
                    Integer.parseInt( matcher.group(4) )
            );
        }
        per=personaUltima.toString();
        //System.out.println(personaUltima.toString());
return per;
    }
}
