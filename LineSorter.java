import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class LineSorter {
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(args[0]));
                PrintWriter out = new PrintWriter(new FileWriter(args[1]))) {
            String line;
            ArrayList<String> listOfStrings = new ArrayList<String>();
            while ((line = in.readLine()) != null) {
                listOfStrings.add(line);
            }
            Collections.sort(listOfStrings);
           // out.print(listOfStrings);
             for(String s: listOfStrings){
             out.println(String.valueOf(s));
             }
             
        }
    }
}
