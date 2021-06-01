package es.florida;

import com.google.common.base.Preconditions;
import util.Creator;
import util.SendEmailThread;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    private static ExecutorService executorService = Executors.newFixedThreadPool(20); //creamos 20 hilos xq son 2 procesadores de 20 nucleos cada uno, asi usamos un hilo xa la mitad de nucleos totales

    public static void main(String[] args) throws IOException {
        //Preconditions.checkArgument(args.length == 1, "No se han introducido datos. Introduce una direccion de correo");
        //System.out.println(args[0]);
        System.out.println("estoy ejecutandome");
        Thread thread = new Thread(new SendEmailThread());
        executorService.execute(new SendEmailThread()); // esto nos deberia dar el mismo resultado,pero el programa no termina, xq executor se queda a la escucha
        thread.setName("soy el 1");
        executorService.execute(new SendEmailThread());
        thread.setName("soy el 2");
        executorService.execute(new SendEmailThread());
        thread.setName("soy el 3");
        executorService.execute(new SendEmailThread());
        thread.setName("soy el 20");//hasta llegar al q queremos
        executorService.shutdown();
    }
}
