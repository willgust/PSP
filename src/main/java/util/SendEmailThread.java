package util;

import com.google.common.base.Preconditions;
import es.florida.MailSender;
import org.apache.commons.mail.EmailException;

import java.io.IOException;

public class SendEmailThread implements Runnable {

    private final String parametro_entrada;

    public SendEmailThread(String parametro_entrada) {
        this.parametro_entrada = parametro_entrada;
    }

    public static void main(String[] args) {

        Preconditions.checkArgument(args.length == 1, "No se han introducido datos. Introduce una direccion de correo");
        System.out.println(args[0]);

    }

    @Override
    public void run() {
        //MailSender.correoMiembros(args[0]);
        try {
            System.out.println("hola desde " + Thread.currentThread().getName());
            MailSender.correoMiembros(this.parametro_entrada);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }
}
