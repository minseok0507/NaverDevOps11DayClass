package day0326;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class MyFrame extends JFrame{
    public MyFrame(){
        super("화이팅");
        this.setLocation(300,100);
        this.setSize(300,300);
        this.setVisible(true);

        this.addWindowListener(new WindowExit());
    }

    //내부 클레스
    class WindowExit implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("윈도우 종료");
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}



public class Ex06_WindowFrame {
    public static void main(String[] args) {
        MyFrame a = new MyFrame();

    }
}
