package day0404db;

import day0404db.Ex01_MysqlSawon;

import java.sql.*;

public class SQLtest {
    public SQLtest(){
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
        String user_name = "admin"; //  접속자 id
        String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw


        String sql = """
                
                """;
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }




        // 접속
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            System.out.println("연결 완료!");

            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);



        } catch (SQLException e) {
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

    public void writeSawonGrop(){

    }

    public static void main(String[] args) {
        SQLtest ex = new SQLtest();


    }
}
