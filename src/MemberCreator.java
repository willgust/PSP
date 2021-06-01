import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MemberCreator {


    public static void MemberCreator(String pathname) throws IOException {
        Random number = new Random();
        int numberRandom = number.nextInt(1000);
        File file = new File(pathname);
        FileWriter writer = new FileWriter(file.getAbsoluteFile(),true);
        PrintWriter printer = new PrintWriter(writer);
        printer.println("email" + numberRandom);
        printer.close();
    }

}
