package es.florida;

import com.google.common.base.Preconditions;
import util.Creator;
import util.SendEmailThread;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class App {

    private static ExecutorService executorService = Executors.newFixedThreadPool(20); //creamos 20 hilos xq son 2 procesadores de 20 nucleos cada uno, asi usamos un hilo xa la mitad de nucleos totales

    public static void main(String[] args) throws IOException {
        //Queue<String> colaCorreo = new LinkedList<String>();
        BlockingQueue<Runnable> colaCorreo = new ArrayBlockingQueue<Runnable>(50);
        colaCorreo = MailSender.listaQueue();
        System.out.println("cantidad de elementos " + colaCorreo.size());
        String parametro_entrada = args[0];
        ExecutorService executorService1 = new ThreadPoolExecutor(19,20,3, TimeUnit.SECONDS,colaCorreo, new Thread(new SendEmailThread(parametro_entrada));

        //Preconditions.checkArgument(args.length == 1, "No se han introducido datos. Introduce una direccion de correo");
        //System.out.println(args[0]);
        //String parametro_entrada = args[0];
        /*System.out.println("estoy ejecutandome");
        Thread thread = new Thread(new SendEmailThread(parametro_entrada));
        executorService.execute(new SendEmailThread(parametro_entrada)); // esto nos deberia dar el mismo resultado,pero el programa no termina, xq executor se queda a la escucha
        thread.setName("soy el 1");
        executorService.execute(new SendEmailThread(parametro_entrada));
        thread.setName("soy el 2");
        executorService.execute(new SendEmailThread(parametro_entrada));
        thread.setName("soy el 3");
        executorService.execute(new SendEmailThread(parametro_entrada));
        thread.setName("soy el 20");//hasta llegar al q queremos
        executorService.shutdown();*/


    }
}
