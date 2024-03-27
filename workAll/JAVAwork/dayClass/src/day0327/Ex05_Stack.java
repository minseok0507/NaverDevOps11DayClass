package day0327;

import java.util.Stack;

public class Ex05_Stack {
    public static void main(String[] args) {
        //스택 : 선입후출

        Stack<String> stack1 = new Stack<>();
        stack1.push("사과");
        stack1.push("바나나");
        stack1.push("오렌지");
        stack1.push("사과");
        stack1.push("딸기");

        System.out.println(stack1.size());

        while (!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }
    }
}
