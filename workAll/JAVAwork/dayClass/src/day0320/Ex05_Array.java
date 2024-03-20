package day0320;

public class Ex05_Array {
    public static void main(String[] args) {
        int []arr1;
        arr1 = new int[5];

        System.out.println("arr1 의 개수 : " + arr1.length);

        System.out.println("** arr1 초기값 출력 **");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(i + " : " + arr1[i]);
        }

        System.out.println("arr1 값 변경");
        arr1[0] = 50;
        arr1[4] = 4;
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(i + " : " + arr1[i]);
        }

        System.out.println("다른 방법");
        for (int a:arr1){
            System.out.println(a);
        }
    }
}
