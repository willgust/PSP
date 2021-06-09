package es.florida;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DronController {

    public static final int SERVER_PROT = 9876;

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ServerSocket server = new ServerSocket(SERVER_PROT);
        Socket clientConecction;

        while (true){
            clientConecction = server.accept();//en el momento q conecta un cliente delegamos esa conexion
            System.out.println("el cliente se conecto al puerto " + clientConecction.getPort());
            executorService.execute(new ServiceWorker(clientConecction));//aqui entra en serviceworker, queremos lanzar un runnable

        }
    }

    private static class ServiceWorker implements Runnable{

        private Socket connection;
        public ServiceWorker(Socket clientConecction) {
            this.connection = clientConecction;
        }

        @Override
        public void run() {

            System.out.println("cliente activo " + Thread.currentThread().getName());
            try {
                OutputStream output = connection.getOutputStream();//para mandarle cosas al cliente
                InputStream input = connection.getInputStream();// para recibir cosas del cliente

                BufferedReader reader = new BufferedReader(new InputStreamReader(input));//leemos lo q nos viene del cliente,usaremos un while
                PrintWriter printer = new PrintWriter(new OutputStreamWriter(output)); //

                String line;
                while ((line = reader.readLine()) !=null){
                    String comando = line;

                    if(comando.equals("TAKE-OFF")){
                        takeOff();
                    }else if(comando.equals("LAND")){
                        land();
                    }else if(comando.equals("FIRE_P_W")){
                        firePrimaryCannon();
                    }else if(comando.equals("FIRE_S_W")){
                        fireSecondaryWeapon();
                    }else if(comando.equals("OFF")){
                        shutDown();
                    }else {
                        System.out.println("comando desconocido");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }




    public Socket connect() {
        // FIXME please implement solution or remove this method
        return new Socket();
    }

    public static void takeOff() {
        System.out.println("Taking off...");
    }

    public static void land() {
        System.out.println("Landing");
    }

    public static void firePrimaryCannon() {
        System.out.println("Ratatatatatatata!");
    }

    public static void fireSecondaryWeapon() {
        System.out.println("Piñau! Piñau!");
    }

    public static void shutDown() {
        System.out.println("Shutting down system...");
    }

}
