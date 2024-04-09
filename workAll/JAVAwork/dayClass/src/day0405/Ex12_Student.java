package day0405;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex12_Student {
    static Scanner sc = new Scanner(System.in);
    String name;
    int java, html, spring;

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
    String user_name = "admin"; //  접속자 id
    String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw

    public Ex12_Student() {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertStudent() {
        System.out.println("추가할 이름");
        name = sc.nextLine();
        System.out.println("자바 점수");
        java = Integer.parseInt(sc.nextLine());
        System.out.println("html 점수");
        html = Integer.parseInt(sc.nextLine());
        System.out.println("spring 점수");
        spring = Integer.parseInt(sc.nextLine());

        String sql = "insert into bitcamp.student (name, java, html, spring) values (?, ?, ?, ?)";

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, java);
            preparedStatement.setInt(3, html);
            preparedStatement.setInt(4, spring);

            preparedStatement.execute();
            System.out.println(name + "정보 추가 완료");

        } catch (SQLException | NullPointerException e) {
            System.err.println("연결 오류" + e.getMessage());
        } finally {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        // 접속 종료
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
        }


        System.out.println(name + "의 성적 등록 완료");
    }

    public void deleteStudent() {
        System.out.println("추가할 이름");
        name = sc.nextLine();

        String sql = "delete from bitcamp.student where name = ?";

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1,name);

            preparedStatement.execute();

            System.out.println(name + " 정보 삭제 완료");

        } catch (SQLException | NullPointerException e) {
            System.err.println("연결 오류" + e.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        // 접속 종료
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
        }
    }

    public void writeStudent() {
        String sql = """
                SELECT name 이름, java, html, spring,\s
                (java + html + spring) "총점", ROUND((java + html + spring)/3,1) "평균",\s
                DATE_FORMAT(textday, '%Y-%m-%d %H:%i') "textday"
                FROM bitcamp.student s;
                """;

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int java = resultSet.getInt(2);
                int html = resultSet.getInt(3);
                int spring = resultSet.getInt(4);
                int add = resultSet.getInt(5);
                double avg = resultSet.getDouble(6);
                String textday = resultSet.getString(7);


                System.out.println(name + "\t" + java + "\t" + html + "\t" + spring + "\t" + add + "\t" + avg + "\t" + textday);
            }


        } catch (SQLException | NullPointerException e) {
            System.err.println("연결 오류" + e.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        // 접속 종료
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
        }
    }

    public void databasePrint() {


        // 접속

    }

    public static void main(String[] args) {
        Ex12_Student ex = new Ex12_Student();
        int menu = 0;
        while (true) {
            System.out.println("1.학생정보추가 2.이르므로 삭제 3.전체출력 4.종료");
            menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                ex.insertStudent();
            } else if (menu == 2) {
                ex.deleteStudent();
            } else if (menu == 3) {
                ex.writeStudent();
            } else if (menu == 4) {
                break;
            }
            System.out.println("=".repeat(30));


        }

    }
}
