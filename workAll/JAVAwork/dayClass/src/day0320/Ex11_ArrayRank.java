package day0320;

public class Ex11_ArrayRank {
    public static void main(String[] args) {
        int[] iArrScore = {100, 90, 70, 30, 30, 70, 25, 24, 24, 4, 65, 62, 34, 65, 72, 65};
        int[] iArrRank = new int[iArrScore.length];

        for (int i = 0; i < iArrRank.length; i++) {
            iArrRank[i] = 1;
        }

        for (int i = 0; i < iArrScore.length; i++) {
            for (int j = 0; j < iArrScore.length; j++) {
                if (iArrScore[i] > iArrScore[j]) {
                    iArrRank[j]++;
                }
            }
        }

        for (int i = 0; i < iArrRank.length; i++) {
            System.out.println(i + 1 + "\t" + iArrScore[i] + "\t" + iArrRank[i]);
        }


    }
}
