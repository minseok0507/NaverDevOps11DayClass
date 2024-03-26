package day0326;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex15_FileException {

    static final String FILENAME = "/Users/minseok/Documents/GitHub/naver0314devops11/meno1.txt";
    static final String FILENAME2 = "/Users/minseok/Documents/GitHub/naver0314devops11/meno2.txt";

    static public void fileSave() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME);
            fw.write("이름 : 짱짱맨\n");
            fw.write("나이 : 24\n");
            fw.write("주소 : 중산\n");
            System.out.println("파일을 확인하세오");
            System.out.println(FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void fileSave2() throws IOException {
        Scanner sc = new Scanner(System.in);
        String name, hp, addr;
        while (true) {
            FileWriter fw = null;
            fw = new FileWriter(FILENAME2, true);// 추가 모드

            System.out.println("이름을 입력하시오/x 종료");
            name = sc.nextLine();
            if (name.equals("x")) {
                System.out.println("종료합니다");
                System.exit(0);
            }
            System.out.println("폰 번호 입력");
            hp = sc.nextLine();
            System.out.println("주소 입력");
            addr = sc.nextLine();

            System.out.println("입력한 정보 저장");
            System.out.println("이름 : " + name);
            System.out.println("나이 : " + hp);
            System.out.println("주소 : " + addr);

            fw.write("\n이름 : " + name);
            fw.write("\n나이 : " + hp);
            fw.write("\n주소 : " + addr);
            fw.close();

        }
    }


    public static void main(String[] args) {
        try {
            fileSave2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
