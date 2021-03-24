package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    private static int yearColumnIndex;
    private static List<String> valueLines;
    private static String[] fields;
    private static int numRows = -1;
    private static HashMap<Integer, String> hmap = new HashMap<Integer, String>();

    public List<String> getCompetitorsNamesFromFile(String fileName) throws IOException {
        String line;
        File fl = new File(fileName);
        FileReader frd = new FileReader(fl);
        BufferedReader brd = new BufferedReader(frd);

        while ((line=brd.readLine())!=null)
            doSomethingWithLine(line);
        brd.close();
        frd.close();

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
    }

    public static void sortbykey() {
        // TreeMap to store values of HashMap
        TreeMap<Integer, String> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(hmap);

        for (HashMap.Entry<Integer, String> entry : sorted.entrySet())
            valueLines.add(entry.getValue());
    }



}
