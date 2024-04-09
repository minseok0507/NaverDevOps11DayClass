package day0405;

import java.sql.*;
import java.util.Scanner;

public class Ex03_SawinSearchName {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
    String user_name = "admin"; //  접속자 id
    String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw




    public Ex03_SawinSearchName() {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void searchSawon(String searchName) {
        // 접속
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            System.out.println("연결 완료!");
            boolean find = true;

            String sql = "SELECT * FROM bitcamp.sawon s WHERE NAME LIKE CONCAT('%','" + searchName + "','%')";
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            System.out.println(searchName + " 검색결과");
            System.out.println("=".repeat(40));
            System.out.println("번호\t이름\t성별\t부서\t점수");
            System.out.println("=".repeat(40));

            while (resultSet.next()){
                int num = resultSet.getInt("num");
                int score = resultSet.getInt("score");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String buseo = resultSet.getString("buseo");
                System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + score);
                find = false;

            }

            if (find){
                System.out.println(searchName + " 없음");
            }




        } catch (SQLException | NullPointerException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                con.close();
            } catch (SQLException | NullPointerException e) {
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
        Ex03_SawinSearchName ex = new Ex03_SawinSearchName();

        Scanner sc = new Scanner(System.in);
        String searchName = "";

        while (true){
            System.out.println("검색할 이름입력 / x입력시 종료");
            searchName =sc.nextLine();
            if (searchName.equalsIgnoreCase("x")){
                System.out.println("이름 검색 종료");
                break;
            }
            ex.searchSawon(searchName);
            System.out.println();

        }
    }
}
