package es.florida;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.*;

public class Cliente {

    public static final int PORT_HTTP = 9876;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(); //creamos un nuevo socket
        socket.connect(new InetSocketAddress("localhost" , PORT_HTTP));//lo conectamos aun socekt address , InetSocketAddress es una clase le pasamos la direccion (o nombre de dominio) y el puerto q pasaremos como constante, no como numero

        //socket.connect(new InetSocketAddress("www.google.com" , 80));

        InputStream inputStream = socket.getInputStream();//necesitamos una entrada de datos y una salida
        OutputStream outputStream = socket.getOutputStream();//salida

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));//para poder escribir lo q recibimos
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream));//para poder envniar lo q necesitemos
        //PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream), true);//para poder envniar lo q necesitemos, con este metodo lo hacemos con autoflahs, y cuando lance un comando lo envia directamente
        String line;
        System.out.println("ANTES");
        String comando;
        Scanner consola =new Scanner(System.in);



        while (true){
            BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword("miCodigoDeBloqueo");
            //System.out.println("dentro del while infinito");
            line = reader.readLine();
            System.out.println("respuesta servidor: " + line);
            System.out.println("Introduce la orden del sistema ");
            comando = consola.next();
            String encryptedText = textEncryptor.encrypt(comando);
            printer.println(encryptedText);
            printer.flush();
            if (comando.equals("adios")) break;

            /*while ((line = reader.readLine())!=null){
                System.out.println(line);
            }*/

        }
        /*printer.println("GET");// con esto estoy enviendo info al servidor o no del xq no cerramos el envio

        printer.flush(); // hacemos el envio
        String line;//ahora necesitamos leer la respuesta
        System.out.println("funciona??");
        while ((line = reader.readLine())!=null){
            System.out.println(line);
            System.out.println("estoy dentro del while de lectura");
        }*/
        /*printer.close();
        reader.close();
        socket.close();*/

    }
}
