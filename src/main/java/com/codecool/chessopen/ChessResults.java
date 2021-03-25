package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    private static int yearColumnIndex;
    private static List<String> valueLines = new ArrayList<>();
    private static String[] fields;
    private static int numRows = -1;
    private static Map<Integer, String> hmap = new HashMap<Integer, String>();

    public static void main(String[] args) {
        getCompetitorsNamesFromFile("src/main/resources/results.txt");
    }

    public static List<String> getCompetitorsNamesFromFile(String fileName) {
        String line;
        File fl = new File(fileName);
        FileReader frd = null;
        try {
            frd = new FileReader(fl);
        BufferedReader brd = new BufferedReader(frd);

        while ((line=brd.readLine())!=null)
            doSomethingWithLine(line);
        brd.close();
        frd.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        sortbykey();

        return valueLines;
    }

    public static void doSomethingWithLine(String line) {
        // Example of what to do for each line
        numRows = numRows + 1;
        //lineList.add(new ArrayList());
        fields = line.split(",");
        String t = String.valueOf(fields[0]);
        int t1 = Integer.parseInt(fields[1]);
        int t2 = Integer.parseInt(fields[2]);
        int t3 = Integer.parseInt(fields[3]);
        int t4 = Integer.parseInt(fields[4]);
        int t5 = Integer.parseInt(fields[5]);
        hmap.put(t1+t2+t3+t4+t5,t);
        System.out.println(String.valueOf(hmap.get(t1+t2+t3+t4+t5)));
    }

    public static void sortbykey() {
        TreeMap<Integer, String> sorted = new TreeMap<>(Collections.reverseOrder());

        // Copy all data from hashMap into TreeMap
        sorted.putAll(hmap);

        // Display the TreeMap which is naturally sorted
        for (Map.Entry<Integer, String> entry : sorted.entrySet())
            valueLines.add(String.valueOf(entry.getValue()));
    }



}
