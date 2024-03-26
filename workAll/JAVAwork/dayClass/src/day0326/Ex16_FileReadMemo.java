package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex16_FileReadMemo {
    static final String FILENAME2 = "/Users/minseok/Documents/GitHub/naver0314devops11/meno2.txt";

    static public void readMeno2() {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(FILENAME2);
            br = new BufferedReader(fr);
            System.out.println("memo2 file reading...");

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("not found memo2 file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //나중에 열린 자원을 먼저 닫는다.
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        readMeno2();
    }
}
