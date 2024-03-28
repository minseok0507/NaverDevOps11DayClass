package day0328;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex06_SwingCanvasRadio extends JFrame {
    final static String[] PHOTO = {"/Users/minseok/Documents/GitHub/naver0314devops11/img_people/17.jpg"
            , "/Users/minseok/Documents/GitHub/naver0314devops11/img_people/18.jpg"
            , "/Users/minseok/Documents/GitHub/naver0314devops11/img_people/19.jpg"
            , "/Users/minseok/Documents/GitHub/naver0314devops11/img_people/20.jpg"
    };

    Color boxColor = Color.CYAN;
    JRadioButton[] rdbtn = new JRadioButton[4];

    String[] btnLable = {"1", "2", "3", "4"};
    JRadioButton rbPhoto1, rbPhoto2, rbPhoto3, rbPhoto4;
    int photoIndex = 0;

    MyDraw draw = new MyDraw();

    public Ex06_SwingCanvasRadio(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료

        this.setVisible(true);

        this.initDesign(); //컴포넌트 생성
    }

    class MyDraw extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.setColor(boxColor);
            g.fillRect(50, 30, 400, 400);
            Image img = null;
            switch (photoIndex) {
                case 0:
                    img = new ImageIcon(PHOTO[0]).getImage();
                    break;
                case 1:
                    img = new ImageIcon(PHOTO[1]).getImage();
                    break;
                case 2:
                    img = new ImageIcon(PHOTO[2]).getImage();
                    break;
                case 3:
                    img = new ImageIcon(PHOTO[3]).getImage();
                    break;
            }
            g.drawImage(img, 75, 50, 350, 350, this);
        }
    }

    public void initDesign() {
        this.add("Center", draw);

        JPanel pTop = new JPanel();
        ButtonGroup bg1 = new ButtonGroup();

        String[] s = {"남자1", "남자2", "남자3", "남자4"};
        for (int i = 0; i < rdbtn.length; i++) {
            rdbtn[i] = new JRadioButton(s[i], i == photoIndex ? true : false);
            bg1.add(rdbtn[i]);
            pTop.add(rdbtn[i]);

            int finalI = i;
            rdbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    draw.repaint();
                    photoIndex = finalI;
                }
            });
        }


        this.add("North", pTop);


        JPanel pBottom = new JPanel();
        this.add("South", pBottom);

        ButtonGroup bg2 = new ButtonGroup();

    }

    public static void main(String[] args) {
        Ex06_SwingCanvasRadio ex = new Ex06_SwingCanvasRadio("사진");

    }
}
