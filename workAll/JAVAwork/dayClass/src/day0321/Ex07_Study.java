package day0321;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07_Study {
    public static void main(String[] args) {
        String[] members = {
                "강하윤", "공병현", "김도훈", "김우형", "김정호",
                "김창인", "민경진", "박민지", "박보민", "박주용",
                "박한경", "배동우", "서정현", "손가원", "시바타유니",
                "신완철", "우태형", "유상곤", "이가현", "이병현",
                "이장우", "이현성", "정민석", "정상혁", "정진욱",
                "정환용", "최시현", "허승필", "황재웅", "꽝"
        };

        String[][] sArr2d = new String[6][5];

        int[] arr = new int[members.length];

        Loop:
        for (int i = 0; i < arr.length; i++) {
            int n = (int) (Math.random() * 30);
            arr[i] = n;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    continue Loop;
                }
            }
        }
        int iNum = 0;
        for (int i = 0; i < sArr2d.length; i++) {
            for (int j = 0; j < sArr2d[i].length; j++) {
                sArr2d[i][j] = members[arr[iNum]];
                iNum++;
            }
        }

        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일"); //HH 24시간
        System.out.println(sdf1.format(date));

        System.out.println("701 스터디\n");
        for (int i = 0; i < sArr2d.length; i++) {
            System.out.print(i+1 + "조 팀 : ");
            for (int j = 0; j < sArr2d[i].length; j++) {
                System.out.printf(sArr2d[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
