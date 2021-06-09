package es.florida;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App3 implements Runnable {

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {

        //Dividiendo();
        Thread thread = new Thread(new App3());
        executorService.execute(new App3()); // esto nos deberia dar el mismo resultado,pero el programa no termina, xq executor se queda a la escucha
        thread.setName("soy el 1");
        executorService.execute(new App3());
        thread.setName("soy el 2");
        executorService.execute(new App3());
        thread.setName("soy el 3");
        executorService.execute(new App3());
        thread.setName("soy el 4");//hasta llegar al q queremos
        executorService.shutdown();
    }


    public static void Dividiendo() throws IOException {
        long inicio = System.currentTimeMillis();
        List<String> lista = App1.readFile("origen.txt");
        for (String items : lista){
            //System.out.println(items);
        }
        List<String> lista1 = lista.subList(0,4);
        List<String> lista2 = lista.subList(5,9);
        List<String> lista3 = lista.subList(10,14);
        List<String> lista4 = lista.subList(15,19);
        for(String miembros : lista1){
            System.out.println(Thread.currentThread().getName() +" # "+ miembros);
        }
        for(String miembros : lista2){
            System.out.println(Thread.currentThread().getName() +" # "+ miembros);
        }
        for(String miembros : lista3){
            System.out.println(Thread.currentThread().getName() +" # "+ miembros);
        }
        for(String miembros : lista4){
            System.out.println(Thread.currentThread().getName() +" # "+ miembros);
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio));
        System.out.println("el tiempo de ejecucion fue de " + tiempo +" milisegundos");
    }



    @Override
    public void run() {
        try {
            System.out.println("hola desde " + Thread.currentThread().getName());
            Dividiendo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
