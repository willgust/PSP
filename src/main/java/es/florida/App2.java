package es.florida;

import java.io.IOException;
import java.util.Scanner;

public class App2 {

    public static void main(String[] args) throws IOException {

        Scanner consola =new Scanner(System.in);
        System.out.println("introduce una letra x consola");
        String comando = consola.next();
        System.out.println("letra introducida " + comando);
        App1.EliminandoItems(comando);;

    }


}
