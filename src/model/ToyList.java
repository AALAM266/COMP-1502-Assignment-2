package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ToyList {

    // I got help with using the BufferedReader from this website: https://sentry.io/answers/read-file-java/ and StackOverflow questions
    public static ArrayList<Toys> createToysFromFile(String fileName) throws Exception {
        ArrayList<Toys> toyList = new ArrayList<>();

        // im not sure if we should use the old method of readinf the file using scanner instead of bufferedreader like the first assignment or if we should use the buffered reader
        // i also dont know if we should add a way to check if the file exists or not
        BufferedReader br = new BufferedReader(new FileReader("res/toys.txt"));
        String line;
        while ((line = br.readLine()) != null) {
        String[] parts = line.split(";");
        Toys toy = findToyType(parts);
        toyList.add(toy);
        }
        br.close();
        return toyList;

    }

    private static Toys findToyType (String[] parts) {
        String serialNumber = parts[0];

        // to do list: add code here to figure out what the toy is based on the serial number
        // 


    }  
}  