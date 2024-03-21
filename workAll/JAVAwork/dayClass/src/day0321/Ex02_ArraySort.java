package day0321;

public class Ex02_ArraySort {
    public static void main(String[] args) {
//        int a = 10, b = 20, temp;
//        System.out.println("a = " + a + ", b = " + b);
//        temp = a;
//        a = b;
//        b = temp;
//        System.out.println("a = " + a + ", b = " + b);

        int[] arr = {5, 1, 6, 3, 1, 10};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] < arr[j]) { 오름차순
                if (arr[i] < arr[j]) { //내림차순
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }
}
