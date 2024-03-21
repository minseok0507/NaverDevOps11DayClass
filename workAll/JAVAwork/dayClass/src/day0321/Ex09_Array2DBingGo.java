package day0321;

import java.util.Scanner;

public class Ex09_Array2DBingGo {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int iBingGo;

        Scanner sc = new Scanner(System.in);

        while (true) {
            String sAns = sc.nextLine();

            iBingGo = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) (Math.random() * 3 + 1);
                }
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.printf("%4d", arr[i][j]);
                }
                System.out.println();
            }

            boolean diagonalBingo = (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) ||
                    (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]);

            for (int i = 0; i < arr.length; i++) {
                boolean rowBingo = arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2];
                boolean columnBingo = arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i];

                if (rowBingo) iBingGo++;
                if (columnBingo) iBingGo++;
            }

            if (diagonalBingo) iBingGo++;

            System.out.println("빙고 개수: " + iBingGo);

            if (sAns.equals("x")) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}
