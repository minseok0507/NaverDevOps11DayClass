package day0327;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex08_MemberList {
    static final String FILENAME = "/Users/minseok/Documents/GitHub/naver0314devops11/member.txt";
    List<MemberDto> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public Ex08_MemberList() {
        memberReadFile();
    }

    public void memberReadFile() {
        FileReader flrd = null;
        BufferedReader bfrd = null;

        try {
            flrd = new FileReader(FILENAME);
            bfrd = new BufferedReader(flrd);

            while (true) {
                String s = bfrd.readLine();
                if (s == null) {
                    break;
                }
                String[] data = s.split(",");
                MemberDto dto = new MemberDto();
                dto.setName(data[0]);
                dto.setHp(data[1]);
                dto.setAddr(data[2]);
                dto.setBlood(data[3]);
                list.add(dto);
            }
            System.out.println(list.size() + "명 정보 가져옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void memberFileSave() {
        FileWriter flwt = null;
        try {
            flwt = new FileWriter(FILENAME);

            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getAddr() + "," + list.get(i).getBlood() + "\n";
                flwt.write(s);
            }
            System.out.println(list.size() + "명 파일에 저장");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                flwt.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getMenu() {
        int menu = 0;
        System.out.println("=".repeat(60));
        System.out.println("1.멤버추가  2.멤버삭제  3.멤버출력  4.이름검색  5.번호검색  6.저장&종료");
        System.out.println("=".repeat(60));
        try {
            menu = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못 입력");
        }

        return menu;
    }

    public void addMember() {
        System.out.println("이름 입력");
        String name = sc.nextLine();
        System.out.println("핸드폰 입력");
        String hp = sc.nextLine();
        System.out.println("주소 입력");
        String addr = sc.nextLine();
        System.out.println("혈액형 입력");
        String blood = sc.nextLine();

        MemberDto dto = new MemberDto(name, hp, addr, blood);
        list.add(dto);
        System.out.println(list.size() + "번째 멤버 정보 추가 완료");
    }

    public void deleteMember() {
        System.out.println("입력한 이름의 정보 삭제");
        String dlMem = sc.nextLine();
        boolean remove = true;
        for (int i = 0; i < list.size(); i++) {
            if (dlMem.equals(list.get(i).getName())) {
                System.out.println(list.get(i).getName() + "의 정보를 삭제합니다.");
                list.remove(i);
                remove = false;
            }
        }
        if (remove) {
            System.out.println("입력한 이름이 없습니다.");
        }
    }

    public void printMember() {
        System.out.println("=".repeat(50));
        System.out.println("번호\t\t이름\t\t\t핸드폰\t\t\t주소\t\t혈액형");
        System.out.println("=".repeat(50));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + "\t\t" + list.get(i).getName() + "\t\t" + list.get(i).getHp() + "\t\t" + list.get(i).getAddr() + "\t\t" + list.get(i).getBlood());
            System.out.println();
        }
    }

    public void searchName() {
        System.out.println("찾을 이름의 성 입력하시오.");
        String searchName = sc.nextLine();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().startsWith(searchName)) {
                System.out.print("\n이름 : " + list.get(i).getName() + "\n번호 : " + list.get(i).getHp() + "\n주소 : " + list.get(i).getAddr() + "\n혈액형 : " + list.get(i).getBlood() + "\n");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("찾는 이름이 없음");
        }
    }

    public void searchPhone() {
        System.out.println("찾을 끝 번호를 입력하시오.");
        String searchNum = sc.nextLine();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getHp().endsWith(searchNum)) {
                System.out.print("\n이름 : " + list.get(i).getName() + "\n번호 : " + list.get(i).getHp() + "\n주소 : " + list.get(i).getAddr() + "\n혈액형 : " + list.get(i).getBlood() + "\n");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("찾는 번호가 없음");
        }
    }


    public static void main(String[] args) {
        Ex08_MemberList ex = new Ex08_MemberList();

        Exit:
        while (true) {
            int menu = ex.getMenu();
            switch (menu) {
                case 1:
                    ex.addMember();
                    break;
                case 2:
                    ex.deleteMember();
                    break;
                case 3:
                    ex.printMember();
                    break;
                case 4:
                    ex.searchName();
                    break;
                case 5:
                    ex.searchPhone();
                    break;
                case 6:
                    ex.memberFileSave();
                    System.out.println("저장&종료");
                    break Exit;
                default:
                    System.out.println("다시 입력");
            }
            System.out.println();
        }


    }
}
