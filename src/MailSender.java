import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void envioCorreo(String nuevoCorreo) throws IOException, InterruptedException {
        /*List<String> correoComparado = new ArrayList<>();
        correoComparado = Reader.readFile("correoComparado.txt");
        List<String> correo = new ArrayList<>();
        correo = Reader.readFile("correo.txt");
        List<String> nuevosMiembros = new ArrayList<>();
        nuevosMiembros = Reader.readFile("nuevosMiembros.txt");
        for( String mandar : nuevosMiembros ){
            for (String envios : correo){
                System.out.println("direccion correo " + envios + " informo de nuevo miembro " + mandar);
            }
            correoComparado.add(mandar);
            Writer.WriteFile("correoComparar.txt", (ArrayList<String>) correoComparado);

        }*/
        List<String> correoComparado = new ArrayList<>();
        correoComparado = Reader.readFile("correoComparar.txt");
        List<String> correo = new ArrayList<>();
        correo = Reader.readFile("correo.txt");
        for (String envio : correo){
            System.out.println("direccion correo " + envio + " informo de nuevo miembro " + nuevoCorreo);
        }
        correoComparado.add(nuevoCorreo);
        Writer.WriteFile("correoComparar.txt", (ArrayList<String>) correoComparado);
        Thread.sleep(500);

        /*File file = new File("correo.txt");
        List<String> result = new ArrayList<>();
        FileReader reader = new FileReader("correo.txt");
        BufferedReader bReader = new BufferedReader(reader);
        String line;
        while ((line=bReader.readLine()) !=null){
            result.add(line);
            System.out.println("direccion correo " + line + " informo de nuevo miembro " + nuevoCorreo);
        }
        bReader.close();*/

    }
}
