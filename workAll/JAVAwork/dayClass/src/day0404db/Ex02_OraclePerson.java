package day0404db;

public class Ex02_OraclePerson {

    static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";

    public Ex02_OraclePerson(){
        try {
            Class.forName(ORACLE_DRIVER);
            System.out.println("oracle 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("오류 "+ e.getMessage());
        }
    }

    public static void main(String[] args) {
        Ex02_OraclePerson ex = new Ex02_OraclePerson();
    }
}
