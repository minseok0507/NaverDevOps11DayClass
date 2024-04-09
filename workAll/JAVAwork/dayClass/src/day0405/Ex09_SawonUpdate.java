package day0405;

import day0404db.Ex01_MysqlSawon;

import java.sql.*;
import java.util.Scanner;

public class Ex09_SawonUpdate {
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;

    String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
    String user_name = "admin"; //  접속자 id
    String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw

    public Ex09_SawonUpdate() {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateSawon() {
        Scanner sc = new Scanner(System.in);
        String updateName, updateBuseo;
        int updateScore;

        System.out.println("수정할 이름");
        updateName = sc.nextLine();

        System.out.println("수정할 점수");
        updateScore = Integer.parseInt(sc.nextLine());
        System.out.println("수정할 부서명");
        updateBuseo = sc.nextLine();

        String sql = "UPDATE bitcamp.sawon SET score = " + updateScore + ", buseo = '" + updateBuseo + "' WHERE name = '" + updateName + "'";




        // 접속
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);

            statement =con.createStatement();
            int n = statement.executeUpdate(sql);
            if (n == 0){
                System.out.println(updateName + " 존재하지 않음");
            } else {
                System.out.println(updateName + "의 정보 수정됨");
            }


        } catch (SQLException | NullPointerException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
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
        Ex09_SawonUpdate ex = new Ex09_SawonUpdate();
        ex.updateSawon();
    }
}
