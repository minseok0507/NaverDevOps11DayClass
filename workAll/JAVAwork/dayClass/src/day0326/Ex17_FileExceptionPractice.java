package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex17_FileExceptionPractice {
    /*
     * 총개수 총점 평균 출력
     * 문자 잇을경우 제외
     * */
    static final String FILENAME = "/Users/minseok/Documents/GitHub/naver0314devops11/score.txt";

    static public void readScore() {
        BufferedReader bfrd = null;
        FileReader flrd = null;

        try {
            flrd = new FileReader(FILENAME);
            bfrd = new BufferedReader(flrd);
            System.out.println("score file reading");
            int count = 0, sum = 0;
            double avg = 0;

            while (true) {
                String bfLine = bfrd.readLine();
                if (bfLine == null) {
                    break;
                }
                try {
                    sum += Integer.parseInt(bfLine);
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage() + " 제외");
                }
            }
            avg = sum / (double) count;
            System.out.println("총 개수 : " + count);
            System.out.println("총 합 : " + sum);
            System.out.printf("평균 : %1.2f",avg);

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bfrd.close();
                flrd.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        readScore();
    }
}
