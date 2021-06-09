package es.florida;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App1 {

    public static void main(String[] args) throws IOException {

        List<String> lista = readFile("origen.txt");
        List<String> listaDescartes = new ArrayList<>();
        for(String items : lista){
            System.out.println(items);
            String[] descomponer = items.split("");
            for (int i = 0; i < descomponer.length; i++) {
                System.out.println(descomponer[i]);
                if(descomponer[i].equals("p")  || descomponer[i].equals("x")){
                    System.out.println("esto dentro de descartes");
                    listaDescartes.add(items);
                }
            }
        }
        for(String descartes : listaDescartes){
            System.out.println("lista descartes " + descartes);
            lista.remove(descartes);
        }
        for(String elementos : lista ){
            System.out.println("elementos q quedan " + elementos);
        }
        WriteFile("destino.txt", (ArrayList<String>) lista);

    }

    public static void EliminandoItems(String letra) throws IOException {
        List<String> lista = readFile("origen.txt");
        List<String> listaDescartes = new ArrayList<>();
        for(String items : lista){
            //System.out.println(items);
            String[] descomponer = items.split("");
            for (int i = 0; i < descomponer.length; i++) {
                //System.out.println(descomponer[i]);
                if(descomponer[i].equals(letra)){
                    //System.out.println("esto dentro de descartes");
                    listaDescartes.add(items);
                }
            }
        }
        for(String descartes : listaDescartes){
            //System.out.println("lista descartes " + descartes);
            lista.remove(descartes);
        }
        for(String elementos : lista ){
            System.out.println("elementos q quedan " + elementos);
        }
        WriteFile("destino.txt", (ArrayList<String>) lista);
    }




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

    public static void WriteFile(String pathname, ArrayList<String> arraylist) throws IOException {
        File file = new File(pathname);
        FileWriter writer = new FileWriter(file);
        PrintWriter printer = new PrintWriter(writer);
        for (String list : arraylist){
            printer.println(list);
        }
        printer.close();
    }
}
