package day0405;

import java.sql.*;

public class Ex02_ShopCartJoin {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
    String user_name = "admin"; //  접속자 id
    String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw


    String sql = """
            SELECT cartnum ,username ,sangpum, price, color, DATE_FORMAT(guipday,'%Y-%m-%d %H:%i') guipday\s
            FROM bitcamp.shop s ,bitcamp.cart c\s
            WHERE s.shopnum = c.shopnum;
            """;

    public Ex02_ShopCartJoin() {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void writeCartJoin() {
        // 접속
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            System.out.println("연결 완료!");
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            System.out.println("\t나의 장바구니");
            System.out.println("시권스\t 이름\t 상품명\t 가격\t 색상\t 구입일");
            System.out.println("=".repeat(50));

            while (resultSet.next()) {
                int cartnum = resultSet.getInt("cartnum");
                String sangpum = resultSet.getString("sangpum");
                String username = resultSet.getString("username");
                int price = resultSet.getInt("price");
                String color = resultSet.getString("color");
                String guipday = resultSet.getString("guipday");

                System.out.println(cartnum + "\t" + sangpum + "\t" + username + "\t" + price + "\t" + color + "\t" + guipday);
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
        Ex02_ShopCartJoin ex = new Ex02_ShopCartJoin();
        ex.writeCartJoin();
    }
}
