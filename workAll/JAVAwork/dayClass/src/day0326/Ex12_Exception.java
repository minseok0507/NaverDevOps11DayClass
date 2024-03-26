package day0326;

public class Ex12_Exception {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6};
        for (int i = 0; i <= arr.length; i++) {
            try {
                System.out.println(i + " : " + arr[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("배열 인덱스 오류 : " + e.getMessage());
            }
        }
        System.out.println("종료");
    }
}
