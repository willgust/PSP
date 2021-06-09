package es.florida;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App4 implements Runnable{

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {


        executorService.execute(new App4());// asi mandamos los correo desde multiples hilos
        executorService.shutdown();


    }

    public static void Dividiendo() throws IOException {
        long inicio = System.currentTimeMillis();
        List<String> lista = App1.readFile("origen.txt");
        for (String items : lista){
            //System.out.println(items);
            System.out.println(Thread.currentThread().getName() +" # "+ items);
        }

    }

    @Override
    public void run() {
        try {
            Dividiendo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
