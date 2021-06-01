package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<String> readFile(String filename) throws IOException {
        //creamo una precondicion
        File file = new File(filename);
        if(file.isFile()){//compruebo si ese fichero existe
            //aqui meteria el cuerpo del metodo

        }
        List<String> result = new ArrayList<>();
        //empezamos a leer
        FileReader reader = new FileReader(filename);
        BufferedReader bReader = new BufferedReader(reader);
        String line;
        //creo un while q mete en la linea lo q lea mientras esto no sea null
        while ((line=bReader.readLine()) !=null){
            result.add(line);
        }
        //cerramos el reader
        bReader.close();
        return result;
    }
}
