package es.florida;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    public static final int SERVER_PROT = 9876;
    private static ExecutorService executorService2 = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(5); //creamos 5 hilos para gestionar las conexiones de los clientes
        ServerSocket server = new ServerSocket(SERVER_PROT);
        Socket clientConecction;
        while (true){
            clientConecction = server.accept();//en el momento q conecta un cliente delegamos esa conexion
            System.out.println("el cliente se conecto al puerto " + clientConecction.getPort());
            executorService.execute(new ServiceWorker(clientConecction));//aqui entra en serviceworker, queremos lanzar un runnable

        }
    }

    private static class ServiceWorker implements Runnable {

        private Socket connection;

        public ServiceWorker(Socket clientConecction) {
            this.connection = clientConecction;
        }


        @Override
        public void run() {
            //aqui gestionamos lo q queremos de la conexion
            //contestar al cliente declarando el:
            //OutputStream output = connection.getOutputStream();//para mandarle cosas al cliente
            //InputStream input = connection.getInputStream();// para recibir cosas del cliente
            System.out.println("cliente activo " + Thread.currentThread().getName());




            try {
                OutputStream output = connection.getOutputStream();//para mandarle cosas al cliente
                InputStream input = connection.getInputStream();// para recibir cosas del cliente

                BufferedReader reader = new BufferedReader(new InputStreamReader(input));//leemos lo q nos viene del cliente,usaremos un while
                PrintWriter printer = new PrintWriter(new OutputStreamWriter(output)); //

                printer.println("estas conectado al servidor, escribe OPERACIONES para conocer las opciones");
                printer.flush();


                System.out.println("llegas?" + reader);


                String line;

                List<String> bloqueado = Reader.readFile("bloqueo.txt");
                String block = bloqueado.get(0);
                //System.out.println(bloqueado.get(0));
                //System.out.println(block);

                while ((line = reader.readLine()) !=null){

                    String[] separado = line.split(";");
                    String comando = separado[0];

                    System.out.println("el comando introducido es " + comando);

                    System.out.println(line);//aqui de normal procesariamos las procesiones del cliente con el parametro q nos ha pasado
                    //String algo = "GET";
                    System.out.println("valor de algo " + line);
                    System.out.println("el tipo de valor es " + ((Object)line).getClass().getSimpleName());
                    if(block.equals("false") ){
                        System.out.println("hago lo de siempre");
                        if(comando.equals("NUEVO")){

                            System.out.println("estoy dentro de USUARIO ");
                            String usuario = separado[1] +";"+ separado[2] +";"+ separado[3];
                            Util.AnyadirMiembros("usuarios.txt", usuario);
                            System.out.println("GUARDANDO USUARIO " + separado[1] +" "+ separado[2] +" "+ separado[3]);
                            printer.println("desde NUEVO, GUARDADO CON EXITO");
                            printer.flush();

                        }else if(comando.equals("DELETE")){
                            System.out.println("estoy dentro de DELETE ");
                            String delete = separado[1];
                            Util.BorrarMiembros("usuarios.txt", delete);
                            printer.println("desde DELETE");
                            printer.flush();

                        }else if(comando.equals("BUY")){
                            System.out.println("estoy dentro de compras ");
                            String compra = separado[1];
                            String compraVenta = separado[0];
                            System.out.println( compraVenta + compra);
                            //executorService2.execute(new ThreadUtil(compraVenta,compra)); //NO VA,parece q existe un problema con la libreria importada

                            printer.println("desde compras");
                            printer.flush();

                        }else if(comando.equals("SELL")){
                            System.out.println("estoy dentro de ventas ");
                            String compra = separado[1];
                            String compraVenta = separado[0];
                            System.out.println( compraVenta + compra);
                            //executorService2.execute(new ThreadUtil(compraVenta,compra));

                            printer.println("desde VENTAS");
                            printer.flush();

                        } else if(comando.equals("OPERACIONES")){
                            System.out.println("estoy dentro de operaciones ");

                            printer.println("desde operaciones, las operaciones disponibles son: NUEVO(;USUARIO),DELETE(;USUARIO),BUY(;OPERACION),BLOQUEO(;NECESARIO CODIGO),ETC... ");
                            printer.flush();

                        }else if(comando.equals("BLOQUEO")){
                            System.out.println("estoy dentro de bloqueo ");

                            if(separado[1].equals("codigoSinBloqueo")){
                                Util.Bloqueo("bloqueo.txt", "true");
                                printer.println("desde bloqueo,el servidor esta bloqueado");
                                printer.flush();
                                System.out.println("SERVIDOR BLOQUEADO");

                            }


                        }
                        else{
                            System.out.println("estas en el else ");
                            printer.println("COMANDO DESCONOCIDO");
                            printer.flush();
                        }
                    }else {
                        printer.println("EL SERVIDOR ESTA BLOQUEADO, INTRODUCE LA CONTRASEÑA CORRECTA");
                        printer.flush();
                        System.out.println("servidor bloqueado, intriduce la contraseña");
                        if(comando.equals("codigoSinBloqueo")){
                            Util.Bloqueo("bloqueo.txt", "false");
                            printer.println("el servidor esta desbloqueado");
                            printer.flush();
                            System.out.println("SERVIDOR DESBLOQUEADO");
                            break;
                        }else {
                            printer.println("el codigo introducido no es correcto");
                            printer.flush();
                        }
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
