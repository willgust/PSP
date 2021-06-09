package es.florida;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static final int PORT_HTTP = 9876;

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket(); //creamos un nuevo socket
        socket.connect(new InetSocketAddress("localhost" , PORT_HTTP));

        InputStream inputStream = socket.getInputStream();//necesitamos una entrada de datos y una salida
        OutputStream outputStream = socket.getOutputStream();//salida

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));//para poder escribir lo q recibimos
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(outputStream));//para poder envniar lo q necesitemos

        String line;
        String comando;
        Scanner consola =new Scanner(System.in);
        System.out.println("ANTES");

        printer.println("TAKE-OFF");
        printer.flush();
        Thread.sleep(3000);
        printer.println("FIRE_P_W");
        printer.flush();
        Thread.sleep(1000);
        printer.println("FIRE_S_W");
        printer.flush();
        Thread.sleep(1000);
        printer.println("LAND");
        printer.flush();
        Thread.sleep(3000);
        printer.println("OFF");
        printer.flush();


        /*while (true){


            comando = consola.next();
            if (comando.equals("adios")) break;
        }*/

    }
}
