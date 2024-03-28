package day0328;

import javax.swing.*;
import java.awt.*;

public class SwingStandard extends JFrame {
    public SwingStandard(String title){
        super(title);
        this.setLocation(100,100);
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(5459614));

        this.setVisible(true);

        this.initDesign(); //컴포넌트 생성

    }

    public void initDesign(){

    }

    public static void main(String[] args) {
        SwingStandard a = new SwingStandard("기본창");



    }
}
