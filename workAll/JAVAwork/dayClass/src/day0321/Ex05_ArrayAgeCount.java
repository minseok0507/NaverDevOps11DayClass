package day0321;

public class Ex05_ArrayAgeCount {
    public static void main(String[] args) {
        int[] iArrMenberAge = {12, 13, 13, 41, 12, 32, 41, 21, 44, 2, 31, 21, 14, 41, 23, 26, 27, 21, 28, 47, 4};
        System.out.println("총 인원수 : " + (iArrMenberAge.length + 1));
        int[] ageCount = new int[6];
        for (int i = 0; i < iArrMenberAge.length; i++) {
            ageCount[iArrMenberAge[i] / 10]++;
        }

        for (int i = 0; i < ageCount.length; i++) {
            System.out.printf("%d0대 : %d명\n", i, ageCount[i]);
        }
    }
}
