package day0321;

public class Ex03_ArrayStringSort {
    public static void main(String[] args) {
        String[] sArr = {"하석진", "강호동", "강호마", "Candy", "손석구"};
        for (int i = 0; i < sArr.length; i++) {
            for (int j = i + 1; j < sArr.length; j++) {
                if (sArr[i].compareTo(sArr[j]) > 0) { //오름차순
                    String sTemp = sArr[i];
                    sArr[i] = sArr[j];
                    sArr[j] = sTemp;
                }
            }
        }
        System.out.println("순서대로");
        for (String s : sArr) {
            System.out.println(s);
        }
    }
}
