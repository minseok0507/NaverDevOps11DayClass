package day0326;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class NewFrame extends JFrame{
    public NewFrame(){
        super("Hello");
        this.setLocation(300,100);
        this.setSize(300,300);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("윈도우를 종료합니다.");
                System.exit(0);
            }
        });
    }
}

public class Ex11_AnonyWindow {
    public static void main(String[] args) {
        NewFrame f = new NewFrame();
    }
}
