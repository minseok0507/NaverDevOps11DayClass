package day0327;

import day0325.Phone;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex07_Vector {
    static final String FILENAME = "/Users/minseok/Documents/GitHub/naver0314devops11/name.txt";

    Scanner sc = new Scanner(System.in);
    List<String> list = new Vector<>();

    FileReader flRd;
    BufferedReader brRd;

    public void personRead() {
        try {
            flRd = new FileReader(FILENAME);
            brRd = new BufferedReader(flRd);

            while (true) {
                String readLine = brRd.readLine();
                if (readLine == null) {
                    break;
                }
                list.add(readLine);
            }

            System.out.println(list.size() + "명을 읽어옴");


        } catch (FileNotFoundException e) {
            System.out.println("파일 없음");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                brRd.close();
                flRd.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public int getMenu() {
        int menu = 0;
        System.out.println("=".repeat(30));
        System.out.println("1.이름추가  2.이름삭제  3.이름출력  4.이름검색  5.저장&종료");
        System.out.println("=".repeat(30));
        menu = Integer.parseInt(sc.nextLine());

        return menu;
    }

    public void addPerson() {
        System.out.println("추가할 이름 입력");
        String name = sc.nextLine();
        list.add(name);
        System.out.println(list.size() + "번째 멤버 추가");
    }

    public void deletPerson() {
        System.out.println("삭제할 이름 입력");
        String name = sc.nextLine();
        boolean f = list.remove(name);
        if (!f)
            System.out.println(name + "은 명단에 없음");
        else
            System.out.println(name + "을 명단에서 삭제함");
    }

    public void listPerson() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ":" + list.get(i) + "\t");
        }
    }

    public void searchPerson() {
        System.out.println("검색할 이름 입력");
        String name = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (name.equals((String) list.get(i))) {
                System.out.println(i + "번에 " + name + " 있음");
                break;
            } else {
                System.out.println(name + "은 명단에 없음");
                break;
            }
        }
    }

    public void exitPerson() {
        FileWriter flwt = null;

        try {
            flwt = new FileWriter(FILENAME);

            for (int i = 0; i < list.size(); i++) {
                flwt.write(list.get(i) + "\n");
            }
            System.out.println("저장완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                flwt.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        Ex07_Vector ex = new Ex07_Vector();
        ex.personRead();
        Exit:
        while (true) {
            int menu = ex.getMenu();
            switch (menu) {
                case 1:
                    ex.addPerson();
                    break;
                case 2:
                    ex.deletPerson();
                    break;
                case 3:
                    ex.listPerson();
                    break;
                case 4:
                    ex.searchPerson();
                    break;
                case 5:
                    ex.exitPerson();
                    System.out.println("저장&종료");
                    break Exit;
                default:
                    System.out.println("다시 입력");
            }
            System.out.println();
        }

    }

}
