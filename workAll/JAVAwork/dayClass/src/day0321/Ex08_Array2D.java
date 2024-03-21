package day0321;

public class Ex08_Array2D {
    public static void main(String[] args) {
        int [][]arr;
        arr = new int[2][3];
        System.out.println("행개수 : "+ arr.length);
        System.out.println("0번행 개수 : "+ arr[0].length);

        arr[0][0] = 3;
        arr[0][2] = 10;

        arr[1][1] = 10;
        arr[1][2] = 50;

        System.out.println("2차원 배열 출력");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("arr[%d][%d} = %d, ",i,j,arr[i][j]);
            }
            System.out.println();
        }

    }

}
