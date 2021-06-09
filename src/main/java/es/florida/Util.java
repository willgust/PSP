package es.florida;

import org.apache.commons.mail.EmailException;

import java.io.*;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Util {

    public static void main(String[] args) throws IOException, EmailException, InterruptedException {

        SimpleDateFormat formattime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(formattime.format(new Date()));
        //AnyadirMiembros("usuarios.txt", "Javi2;Ferrer;algo@correo;");
        //Bloqueo("bloqueo.txt", false);

        /*String prueba_semparar = "carlos;salas;corre@gmail;";

        String[] separado = prueba_semparar.split(";");
        for (int i = 0; i < separado.length; i++) {
            System.out.println(separado[i]);

        }*/

        //BorrarMiembros("usuarios.txt","JORGE");
        //EmailService emailService = new EmailService();
        //emailService.sendEmail("usuarios.txt","compraVenta","compra");
        //Bloqueo("bloqueo.txt", "false");

    }

    public static void AnyadirMiembros(String pathname, String usuario) throws IOException {

        File file = new File(pathname);
        FileWriter writer = new FileWriter(file.getAbsoluteFile(),true);
        PrintWriter printer = new PrintWriter(writer);
        printer.println(usuario);
        printer.close();
    }

    public static void BorrarMiembros(String filename,String nombreUsuario) throws IOException {
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



        for(String miembros : result){
            System.out.println("mostrando miembros " + miembros);
            String[] separado = miembros.split(";");
            String comando = separado[0];
            System.out.println("MOSTRANDO USUARIO " + separado[0] +" "+ separado[1] +" "+ separado[2]);
            System.out.println("mostrando nombre de parametro " + nombreUsuario);
            System.out.println("mostrando nombre del split " + separado[0]);
            if( comando.equals(nombreUsuario)){
                //result.remove(miembros);
                System.out.println("hemos eliminado al usuario " + miembros);
                System.out.println("ESTOY DENTRO DEL IF");
                //result.remove(miembros); //!!!!!XQ NO FUNCIONAS!!!!!!!!!!

            }
        }

        //result.remove("JORGE;SOLAZ;CORREO3");
        GuardarMiembros("usuarios.txt", (ArrayList<String>) result);

    }

    public static void Bloqueo(String pathname, String estasbloqueado) throws IOException {
        File file = new File(pathname);
        FileWriter writer = new FileWriter(file);
        PrintWriter printer = new PrintWriter(writer);
        printer.println(estasbloqueado);
        printer.close();
    }

    public static void GuardarMiembros(String pathname, ArrayList<String> arraylist) throws IOException {
        File file = new File(pathname);
        FileWriter writer = new FileWriter(file);
        PrintWriter printer = new PrintWriter(writer);
        for (String list : arraylist){
            printer.println(list);
        }
        printer.close();
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
