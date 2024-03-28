package day0328;

import javax.swing.*;
import java.awt.*;

public class Ex05_SwingCanvars extends JFrame {
    MyDraw draw = new MyDraw();

    String FOODIMG1 = "/Users/minseok/Documents/GitHub/naver0314devops11/img_food/1.jpg";
    String FOODIMG2 = "/Users/minseok/Documents/GitHub/naver0314devops11/img_food/2.jpg";

    public Ex05_SwingCanvars(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료

        this.setVisible(true);

        this.initDesign(); //컴포넌트 생성
    }

    class MyDraw extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.setColor(Color.magenta);


            g.drawOval(30, 30, 100, 100);
            g.fillOval(150, 30, 100, 100);


            g.setColor(new Color(000000));
            g.drawRect(30, 150, 100, 100);

            g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g.drawString("Good Day", 50, 400);

            g.setFont(new Font("Gungseo", Font.BOLD, 30));
            g.drawString("안녕하세요", 300, 400);

            Image img1 = new ImageIcon(FOODIMG1).getImage();
            g.drawImage(img1, 300, 50, 100, 100, this);

            Image img2 = Toolkit.getDefaultToolkit().getImage(FOODIMG2);
            g.drawImage(img2, 300, 160, 100, 100, this);
        }
    }


    public void initDesign() {
        this.add("Center", draw);
    }


    public static void main(String[] args) {
        Ex05_SwingCanvars a = new Ex05_SwingCanvars("캔버스");
    }
}
