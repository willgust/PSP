package es.florida;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    public static final int SERVER_PROT = 1234;

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
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
                    if(comando.equals("ENEMY_SPOTTED")){

                        printer.println("ROGER REQUESTING REINFORCEMENT");
                        printer.flush();
                        System.out.println("ROGER COMANDO RECIBIDO");

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}