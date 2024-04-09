package day0404db;

public class Ex01_MysqlSawon {
    static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL="jdbc:mysql://database-1.c3gcoee6wzjj.ap-southeast-2.rds.amazonaws.com";
    static final String USERNAME="admin";

    public Ex01_MysqlSawon(){
        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("mysql8 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("오류 "+ e.getMessage());
        }
    }

    public static void main(String[] args) {
        Ex01_MysqlSawon ex1 = new Ex01_MysqlSawon();
    }
}
