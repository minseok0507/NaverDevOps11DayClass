package day0327;

import day0325.Phone;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
 * 1.학생정보추가 > 이름 나이 점수입력
 * 2.학생정보삭제 > 이름으로 찾아서 삭제
 * 3.전체출력    > 번호 이름 과목 총점 평균 등급
 * 4.평균으로 검색 > 평균값 이상 학생 출력
 * 5.이름으로 검색 > 이름을 포함(contains)
 * 6.저장&종료
 * */
public class Ex09_VectorPractice {
    static final String FILENAME = "/Users/minseok/Documents/GitHub/naver0314devops11/student.txt";
    List<StudentDto> list = new Vector<>();
    Scanner sc = new Scanner(System.in);

    public Ex09_VectorPractice() {
        ReadStudentFile();
    }

    public void addStudent() {
        System.out.println("이름을 입력하시오.");
        String name = sc.nextLine();
        System.out.println("나이 입력");
        try {
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("자바 점수 입력");
            int java = Integer.parseInt(sc.nextLine());
            System.out.println("스프링 점수 입력");
            int spring = Integer.parseInt(sc.nextLine());
            System.out.println("html 점수 입력");
            int html = Integer.parseInt(sc.nextLine());

            StudentDto sdt = new StudentDto(name, age, java, spring, html);
            list.add(sdt);
            System.out.println(list.size() + "번째 학생 입력 완료");
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하시오." + e);
        }
    }

    public void delStudent() {
        String inputName = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(inputName)) {
                System.out.println(list.get(i).getName() + "의 정보를 삭제합니다.");
                System.out.printf("""
                                                            
                                번호 : %d
                                이름 : %s
                                나이 : %d
                                자바 : %d\t스프링 : %d\tHTML : %d
                                총점 : %d
                                평균 : %2.2f
                                등급 : %s
                                                            
                                """,
                        i, list.get(i).getName(), list.get(i).getAge(), list.get(i).getJava(), list.get(i).getSpring(), list.get(i).getHtml(),
                        list.get(i).getTotal(), list.get(i).getAvg(), list.get(i).getGrade());
                list.remove(i);
                System.out.println("삭제완료");
            }
        }
    }

    public void printStudent() {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("""
                                                        
                            번호 : %d
                            이름 : %s
                            나이 : %d
                            자바 : %d\t스프링 : %d\tHTML : %d
                            총점 : %d
                            평균 : %2.2f
                            등급 : %s
                                                        
                            """,
                    i, list.get(i).getName(), list.get(i).getAge(), list.get(i).getJava(), list.get(i).getSpring(), list.get(i).getHtml(),
                    list.get(i).getTotal(), list.get(i).getAvg(), list.get(i).getGrade());
            System.out.println("=".repeat(30));
        }
    }

    public void avgSearch() {
        System.out.println("평균을 입력하시오.");
        double num = sc.nextDouble();
        boolean who = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAvg() > num) {
                System.out.printf("""
                                                            
                                번호 : %d
                                이름 : %s
                                나이 : %d
                                자바 : %d\t스프링 : %d\tHTML : %d
                                총점 : %d
                                평균 : %2.2f
                                등급 : %s
                                                            
                                """,
                        i, list.get(i).getName(), list.get(i).getAge(), list.get(i).getJava(), list.get(i).getSpring(), list.get(i).getHtml(),
                        list.get(i).getTotal(), list.get(i).getAvg(), list.get(i).getGrade());
                System.out.println("=".repeat(30));
                who = false;
            }
        }
        if (who) {
            System.out.printf("평균 %2.1f 이상인 학생이 없습니다.", num);
        }
    }

    public void nameSearch() {
        System.out.println("이름을 검색합니다.");
        String s = sc.nextLine();
        boolean who = true;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(s)) {
                System.out.printf("""
                                                            
                                번호 : %d
                                이름 : %s
                                나이 : %d
                                자바 : %d\t스프링 : %d\tHTML : %d
                                총점 : %d
                                평균 : %2.2f
                                등급 : %s
                                                            
                                """,
                        i, list.get(i).getName(), list.get(i).getAge(), list.get(i).getJava(), list.get(i).getSpring(), list.get(i).getHtml(),
                        list.get(i).getTotal(), list.get(i).getAvg(), list.get(i).getGrade());
                System.out.println("=".repeat(30));
                who = false;
            }
        }

        if (who) {
            System.out.printf("이름에 %s가 포함된 학생이 없습니다.\n", s);
        }
    }


    public int getMenu() {
        int menu = 0;
        System.out.println("=".repeat(30));
        System.out.println("1.학생정보추가");
        System.out.println("2.학생정보삭제");
        System.out.println("3.전체출력");
        System.out.println("4.평균으로 검색");
        System.out.println("5.이름으로 검색");
        System.out.println("6.저장&종료");
        System.out.println("=".repeat(30));

        try {
            menu = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력하세요.");
        } finally {
            return menu;

        }

    }

    public void ReadStudentFile() {
        FileReader flrd = null;
        BufferedReader bfrd = null;

        try {
            flrd = new FileReader(FILENAME);
            bfrd = new BufferedReader(flrd);

            while (true) {
                String s = bfrd.readLine();
                if (s == null) {
                    break;
                } else {
                    String[] data = s.split(",");
                    StudentDto sdto = new StudentDto();
                    sdto.setName(data[0]);
                    sdto.setAge(Integer.parseInt(data[1]));
                    sdto.setJava(Integer.parseInt(data[2]));
                    sdto.setSpring(Integer.parseInt(data[3]));
                    sdto.setHtml(Integer.parseInt(data[4]));
                    list.add(sdto);
                }
            }
            System.out.println(list.size() + "명의 정보를 읽어왔습니다.");
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

    public void saveAndExit() {
        FileWriter flwt = null;

        try {
            flwt = new FileWriter(FILENAME);

            for (int i = 0; i < list.size(); i++) {
                StudentDto sdt = list.get(i);
                String s = sdt.getName() + "," + sdt.getAge() + "," + sdt.getJava() + "," + sdt.getSpring() + "," + sdt.getHtml() + "\n";
                flwt.write(s);
            }
            System.out.println(list.size() + "명을 파일에 저장했습니다.");

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
        Ex09_VectorPractice ex = new Ex09_VectorPractice();

        Exit:
        while (true) {
            int menu = ex.getMenu();
            switch (menu) {
                case 1:
                    ex.addStudent();
                    break;
                case 2:
                    ex.delStudent();
                    break;
                case 3:
                    ex.printStudent();
                    break;
                case 4:
                    ex.avgSearch();
                    break;
                case 5:
                    ex.nameSearch();
                    break;
                case 6:
                    ex.saveAndExit();
                    break Exit;
            }
        }

    }
}
