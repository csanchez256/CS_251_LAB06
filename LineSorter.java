/*
 * Author:Christopher Sanchez;
 * File: LineSorter.java
 * CS 251 Lab06
 * This program takes an I/O buffered stream (text file)
 * and outputs the result in another textfile
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class LineSorter implements java.util.Comparator<String>{
    
    private int refLength;

    public LineSorter (String s) {
        super();
        this.refLength = s.length();
    }
    
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(args[0]));
                PrintWriter out = new PrintWriter(new FileWriter(args[1]))) {
            String line;
            ArrayList<String> listOfStrings = new ArrayList<String>();
            while ((line = in.readLine()) != null) {
                listOfStrings.add(line);
            }
            LineSorter c = new LineSorter(line);
            Collections.sort(listOfStrings,c);
            out.print(listOfStrings);
//             for(String s: listOfStrings){
//             out.println(String.valueOf(s));
//             }
        }
    }

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        int dist1 = Math.abs(o1.length() - refLength);
        int dist2 = Math.abs(o2.length() - refLength);
        
        return dist1 - dist2;
    }
}
