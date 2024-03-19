package day0319;

public class Ex03_PracticeXYYX {
    public static void main(String[] args) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                int iNum;
                iNum = (x * 10) + y + (y * 10) + x;
                if (iNum == 121) {
                    System.out.printf("""
                            %d%d + %d%d = 121\tx = %d,y = %d
                            """,x,y,y,x,x,y);
                }
                iNum = 0;
            }
        }
    }
}
