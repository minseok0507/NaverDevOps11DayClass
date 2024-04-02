package study;

public class stringCut {









    static class Solution {
        public int[] solution(int n, int[] slicer, int[] num_list) {
            int[] answer = {};

            switch (n) {
                case 1:
                    answer = new int[slicer[1] + 1];
                    for (int i = 0; i < answer.length; i++) {
                        answer[i] = num_list[i];
                    }
                    break;

                case 2:
                    answer = new int[num_list.length - slicer[0]];
                    for (int i = 0; i < answer.length; i++) {
                        answer[i] = num_list[slicer[0] + i];
                    }
                    break;

                case 3:
                    answer = new int[slicer[1] - slicer[0] + 1];
                    for (int i = 0; i < answer.length; i++) {
                        answer[i] = num_list[slicer[0] + i];
                    }
                    break;

                case 4:
                    answer = new int[(slicer[1] - slicer[0]) / slicer[2] + 1];
                    for (int i = 0; i < answer.length; i++) {
                        answer[i] = num_list[slicer[0] + (i * slicer[2])];
                    }
                    break;
            }


            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            int n = 4;
            int[] slicer = {2, 8, 2};
            int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

            int[] num = solution.solution(n, slicer, num_list);

            for (int s : num){
                System.out.println(s);
            }
        }
    }
}
/*
* n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
* */