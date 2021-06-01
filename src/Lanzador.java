import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length >0){
            System.out.println(args[0]);
            String parametroEntrda = args[0];
            System.out.println("estoy dentro de " + parametroEntrda);
        }
        /*Thread.currentThread().setName("Hilo principal");
        //Thread.currentThread(MemberCreator.MemberCreator("correo.txt"));
        MemberThread thread = new MemberThread();
        Thread myThread = new Thread(thread);
        myThread.setName("el numero #1");
        myThread.start();*/

        while (true) {
            CreatorThread thread = new CreatorThread();
            Thread myThread = new Thread(thread);
            myThread.setName("el numero #1");
            myThread.start();

            MemberThread thread2 = new MemberThread();
            Thread myThread2 = new Thread(thread2);
            myThread2.setName("el numero #2");
            myThread2.start();
        }






    }

}
