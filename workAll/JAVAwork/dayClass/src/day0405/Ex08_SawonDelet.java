package day0405;

import java.sql.*;
import java.util.Scanner;

public class Ex08_SawonDelet {
    Connection con = null;
    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
    String user_name = "admin"; //  접속자 id
    String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw


    String sql = """
            SELECT cartnum ,username ,sangpum, price, color, DATE_FORMAT(guipday,'%Y-%m-%d %H:%i') guipday\s
            FROM bitcamp.shop s ,bitcamp.cart c\s
            WHERE s.shopnum = c.shopnum;
            """;

    public Ex08_SawonDelet() {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteSawon() {
        Scanner sc = new Scanner(System.in);
        String delName = "";
        System.out.println("삭제할 이름 입력");
        delName = sc.nextLine();

        String sql = "delete from bitcamp.sawon where name = ?";
        // 접속
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, delName);

            int n = preparedStatement.executeUpdate();
            if (n == 0){
                System.out.println(delName + "은 명단에 없음");
            } else {
                System.out.println("삭제 완료");
            }


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
        Ex08_SawonDelet ex = new Ex08_SawonDelet();
        ex.deleteSawon();
    }
}
