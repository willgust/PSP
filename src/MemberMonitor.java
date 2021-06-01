import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberMonitor {

    /*public static  List<String> memberMonitor(String filename) throws IOException {
        File file2 = new File("correoComparar.txt");
        List<String> correoComparar = new ArrayList<>();
        FileReader reader2 = new FileReader(file2);
        BufferedReader bReader2 = new BufferedReader(reader2);
        String line2;
        while ((line2=bReader2.readLine()) !=null){
            correoComparar.add(line2);
        }
        bReader2.close();

        File file = new File(filename);
        List<String> result = new ArrayList<>();
        FileReader reader = new FileReader(filename);
        BufferedReader bReader = new BufferedReader(reader);
        String line;
        while ((line=bReader.readLine()) !=null){
            result.add(line);
        }
        bReader.close();
        return result;
    }*/

    public static void memberMonitor() throws IOException, InterruptedException {
        List<String> correoComparar = new ArrayList<>();
        correoComparar = Reader.readFile("correoComparar.txt");
        List<String> correo = new ArrayList<>();
        correo = Reader.readFile("correo.txt");

        for(String miembros : correoComparar){
            System.out.println(miembros);
        }

        ArrayList<String> newMember = new ArrayList<String>();
        for (String element : correo) {
            if (!correoComparar.contains(element)) {
                newMember.add(element);
                System.out.println("estoy comparando " + element);
            }
        }
        int tamanio = newMember.size();
        System.out.println("El número de elementos es de "+tamanio);
        if (0 != tamanio) {
            System.out.println("estoy dentro del if");
            for(String envio : newMember){
                String nuevaDireccion = envio;
                System.out.println("estoy enviando " + envio);
                MailSender.envioCorreo(nuevaDireccion);
            }
        }

        Writer.WriteFile("nuevosMiembros.txt", newMember);


    }


}
