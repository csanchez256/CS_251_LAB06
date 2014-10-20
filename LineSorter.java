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

public class LineSorter implements java.util.Comparator<String> {

    public static void main(String[] args) throws IOException {
        
        /* try with resources ensures you close the resource with a
         * lot less code
         */
        try (
                BufferedReader in = new BufferedReader(new FileReader(args[0]));
                PrintWriter out = new PrintWriter(new FileWriter(args[1]))) {
            String line;
            
            ArrayList<String> listOfStrings = new ArrayList<String>();
            /*Read in an entire line of text, and add to ArrayList*/
            while ((line = in.readLine()) != null) {
                listOfStrings.add(line);
            }
            LineSorter lObj = new LineSorter();
            Collections.sort(listOfStrings, lObj);

            /*
             * Now iterate through the ArrayList and print out the values using
             * for-each loop
             */
            for (String s : listOfStrings) {
                out.println(String.valueOf(s));
            }
        }
    }

    /* Params: o1 - the first object to be compared. o2 - the second object to be compared.
     * Compares its two arguments for order. Returns a negative integer, zero, or a positive 
     * integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
