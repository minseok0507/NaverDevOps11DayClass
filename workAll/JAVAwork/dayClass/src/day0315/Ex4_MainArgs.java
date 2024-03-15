package day0315;

public class Ex4_MainArgs {
    public static void main(String[] args){

        System.out.println(args[0]);
        System.out.println(args[1]);

        System.out.println(args[2]+ args[3]);

        int s1 = Integer.parseInt(args[2]);
        int s2 = Integer.parseInt(args[3]);
        System.out.println(s1 + s2);
    }
}
