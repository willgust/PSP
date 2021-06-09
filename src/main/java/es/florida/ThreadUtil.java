package es.florida;

import org.apache.commons.mail.EmailException;

import java.io.IOException;

public class ThreadUtil implements Runnable {

    private final String compraVenta;
    private final String compra;




    public ThreadUtil(String compraVenta, String compra) {
        this.compraVenta = compraVenta;
        this.compra = compra;
    }

    @Override
    public void run() {
        EmailService emailService = new EmailService();
        try {
            emailService.sendEmail("usuarios.txt",compraVenta,compra);//String archivo,String compraVenta, String Operacion
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
