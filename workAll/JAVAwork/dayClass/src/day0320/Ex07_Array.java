package day0320;

public class Ex07_Array {
    public static void main(String[] args) {
        int[] date = {23, 123, 3, 1, 4, -123, -312, -12, 23, 3};

        System.out.println(date.length);

        int max, min;
        max = min = date[0];
        for (int i = 1; i < date.length; i++) {
            if (max < date[i]) {
                max = date[i];
            }
        }
        System.out.println(max);

        for (int i = 1; i < date.length; i++) {
            if (min > date[i]) {
                min = date[i];
            }
        }
        System.out.println(min);

        System.out.println();

        int pcnt = 0, mcnt = 0;
        for (int i = 0; i < date.length; i++) {
            if (date[i] > 0){
                pcnt++;
            }else if (date[i] < 0){
                mcnt++;
            }
        }
        System.out.printf("양수 : %d개\n음수 : %d개",pcnt,mcnt);

    }
}
