package day0405;

import day0404db.Ex01_MysqlSawon;

import java.sql.*;

public class Ex01_MysqlSawonGrop {
    public Ex01_MysqlSawonGrop(){
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
        String user_name = "admin"; //  접속자 id
        String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw
//        String server = "192.168.0.59"; // 서버 주소
//        String user_name = "root"; //  접속자 id
//        String password = "1234"; // 접속자 pw


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

            System.out.println("\t**부서별 현황**\n");
            System.out.println("부서명\t인원수\t최고점ㅅ\t평균점수");
            System.out.println("=".repeat(30));

            while (resultSet.next()){
                String buseo = resultSet.getString("buseo");
                int inwon = resultSet.getInt("inwon");
                int max = resultSet.getInt("maxscore");
                int avg = resultSet.getInt("avgscore");

                System.out.println(buseo + "\t" + inwon + "\t" + max + "\t" + avg + "\t");
            }




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
        Ex01_MysqlSawonGrop ex = new Ex01_MysqlSawonGrop();


    }
}
