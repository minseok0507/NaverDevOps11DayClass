package day0405;

import java.sql.*;
import java.util.Scanner;

public class Ex05_SawonInsert {
    Connection con = null;

    PreparedStatement preparedStatement = null;

    String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
    String user_name = "admin"; //  접속자 id
    String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw



    public Ex05_SawonInsert() {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertSawon() {
        Scanner sc = new Scanner(System.in);
        String name, gender, buseo;
        int score, gnum, bnum;
        String sql = "";

        System.out.println("이름 입력");
        name = sc.nextLine();
        System.out.println("점수는");
        score = Integer.parseInt(sc.nextLine());
        System.out.println("성별은? 1.남자 2.여자");
        gnum = Integer.parseInt(sc.nextLine());
        gender = gnum==1?"남자":"여자";
        System.out.println("부서는? 1.홍보부 2.인사부 3.교육부");
        bnum = Integer.parseInt(sc.nextLine());
        buseo = bnum==1?"홍보부":bnum==2?"인사부":"교육부";

        sql = "insert into bitcamp.sawon (name,score,gender,buseo) values (?,?,?,?)";

        // 접속
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            System.out.println("연결 완료!");
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2,score);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, buseo);

            preparedStatement.execute();

            System.out.println("데이터 추가 성공");

        } catch (SQLException | NullPointerException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
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
    }

    public static void main(String[] args) {
        Ex05_SawonInsert ex = new Ex05_SawonInsert();
        ex.insertSawon();

    }

}
