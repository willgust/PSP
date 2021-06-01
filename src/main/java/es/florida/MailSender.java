package es.florida;

import com.google.common.base.Preconditions;
import com.sun.deploy.association.utility.AppConstants;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import util.Reader;
import util.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MailSender {

    public static void main(String[] args) throws IOException, InterruptedException, EmailException {

        Preconditions.checkArgument(args.length == 1, "No se han introducido datos. Introduce una direccion de correo");
        System.out.println(args[0]);
        correoMiembros(args[0]);
    }

    public static void correoMiembros(String nuevoCorreo) throws IOException, InterruptedException, EmailException {

        List<String> correo = new ArrayList<>();
        correo = Reader.readFile("correo.txt");
        for (String envio : correo){
            System.out.println("direccion correo " + envio + " informo de nuevo miembro " + nuevoCorreo);
            Email email = new SimpleEmail();
            email.setHostName("0.0.0.0");
            email.setSmtpPort(1025);
            //email.setAuthenticator(new DefaultAuthenticator("username", "password"));
            //email.setSSLOnConnect(true);
            email.setFrom("nuevoCorreo@gmail.com");
            email.setSubject("TestMail");
            email.setMsg("estoy informando de un nuevo miembro q es : " + nuevoCorreo );
            email.addTo("foo@bar.com");
            email.send();
            Thread.sleep(1000);
        }
        correo.add(nuevoCorreo);
        Writer.WriteFile("correo.txt", (ArrayList<String>) correo);

    }



   /* private static void enviarEmail(String direccion) throws EmailException, InterruptedException {
        Email email = new SimpleEmail();
        email.setHostName("0.0.0.0");
        email.setSmtpPort(1025);
        //email.setAuthenticator(new DefaultAuthenticator("username", "password"));
        //email.setSSLOnConnect(true);
        email.setFrom("nuevoCorreo@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("estoy informando de un nuevo miembro q es : " + direccion );
        email.addTo("foo@bar.com");
        email.send();
        Thread.sleep(1000);

    }*/




}
