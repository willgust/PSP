package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {

    public static void WriteFile(String pathname, ArrayList<String> arraylist) throws IOException {
        File file = new File(pathname);
        FileWriter writer = new FileWriter(file);
        PrintWriter printer = new PrintWriter(writer);
        for (String list : arraylist){
            printer.println(list);
        }
        printer.close();
    }
}
