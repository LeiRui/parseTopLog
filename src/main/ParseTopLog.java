package main;

import java.io.*;

public class ParseTopLog {
    public static void main(String[] args) {
        String fileIn = "D:\\我的坚果云\\1\\top5min.log";
        String fileOut = "D:\\我的坚果云\\1\\top5min_out.csv";
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            bf = new BufferedReader(new FileReader(fileIn));
            pw = new PrintWriter(new FileOutputStream(fileOut));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        pw.println("Time(s),Mem total,Mem free,Mem used,Mem buff/cache");

        try {
            int timeConsume = 0;
            String target = "GiB Mem";
            String line = null;
            while ((line = bf.readLine()) != null) {
                if (line.contains(target)) {
                    String[] split = line.split("\\s+");
                    pw.println(timeConsume+","+split[3] + "," + split[5] + "," + split[7] + "," + split[9]);
                    timeConsume += 3;
                }
            }

            pw.close();
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
