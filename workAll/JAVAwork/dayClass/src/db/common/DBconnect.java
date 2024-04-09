package db.common;

import java.sql.*;

public class DBconnect {
    static final String server = "database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com"; // 서버 주소
    static final String user_name = "admin"; //  접속자 id
    static final String password = "y.TEW7tfi3#4hnZ"; // 접속자 pw

    public Connection getConnect() {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }


    public void dbClose(PreparedStatement preparedStatement, Connection connection) {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dbClose(PreparedStatement preparedStatement, Connection connection, ResultSet resultSet) {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
