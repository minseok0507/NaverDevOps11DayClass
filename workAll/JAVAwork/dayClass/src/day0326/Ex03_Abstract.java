package day0326;

import day0325.Phone;

import java.util.Scanner;

abstract class Command {
    abstract public void process();
}

class List extends Command {
    @Override
    public void process() {
        System.out.println("데이터 목록을 출력합니다.");
    }
}

class Delete extends Command {
    @Override
    public void process() {
        System.out.println("데이터 목록을 삭제합니다.");
    }
}

class Insert extends Command {
    @Override
    public void process() {
        System.out.println("데이터 목록을 추가합니다.");
    }
}

class Update extends Command {
    @Override
    public void process() {
        System.out.println("데이터 목록을 수정합니다.");
    }
}

public class Ex03_Abstract {
    static public void process(Command comm) {
        comm.process();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("-".repeat(30));
            System.out.println("1.추가 2.삭제 3.목록출력 4.수정 5.종료");
            System.out.println("-".repeat(30));

            int num = sc.nextInt();
            switch (num) {
                case 5:
                    System.out.println("DB 작업을 종료합니다.");
                    break label;
                case 1:
                    process(new Insert());
                    break;
                case 2:
                    process(new Delete());
                    break;
                case 3:
                    process(new List());
                    break;
                case 4:
                    process(new Update());
                    break;
                default:
                    System.out.println("잘못 입력");
            }
        }
    }
}
