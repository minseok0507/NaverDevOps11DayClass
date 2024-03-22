package day0322;

public class Ex05_CallBy {

    public static void changeNum(int n){
        n = 10;
    }

    //배열은 주소를 보내는거임
    public static void changeArray(int []a){
        a[1] = 200;
    }

    public static void changeArray(String []a){
        a[1] = "dkddkdd";
    }

    static public void changeHome(String home){
        home = "제주도";
    }

    public static void main(String[] args) {
        int n = 50;
        changeNum(n);
        System.out.println(n);

        int []arr = {3,5,7};
        changeArray(arr);
        for (int a : arr){
            System.out.println(a);
        }
        String[] sarr = {"asdf1", "asdfsa2", "asdfsaf3"};
        changeArray(sarr);
        for (String a : sarr){
            System.out.println(a);
        }

        String home = "서울";
        changeHome(home); //얘는 제외 주소말고 값이 전달;;

        System.out.println(home);

    }
}
