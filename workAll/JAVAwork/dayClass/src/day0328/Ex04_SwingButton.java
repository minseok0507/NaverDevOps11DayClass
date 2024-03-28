package day0328;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ex04_SwingButton extends JFrame {

    JButton btn1, btn2, btn3;
    JButton[] btnArray = new JButton[6];
    String[] btnLable = {"초록", "빨강", "분홍", "주황", "노랑", "랜덤"};

    public Ex04_SwingButton(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(5459614));

        this.setVisible(true);

        this.initDesign(); //컴포넌트 생성

    }


    public void initDesign() {
        this.setLayout(null);//기본 레이아웃 삭제
        btn1 = new JButton("버튼1");
        btn1.setBounds(150, 10, 100, 40);

        btn2 = new JButton("버튼2");
        btn2.setBounds(150, 60, 100, 40);

        btn3 = new JButton("버튼3");
        btn3.setBounds(150, 110, 100, 40);

        this.add(btn1);
        this.add(btn2);
        this.add(btn3);

        int yPos = 30;
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i] = new JButton(btnLable[i]);
            btnArray[i].setBounds(10, yPos, 100, 30);
            this.add(btnArray[i]);
            yPos += 35;

            btnArray[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton ob = (JButton) e.getSource();
                    System.out.println(ob.getText());
                    //System.out.println(ob.getLabel());

                    switch (ob.getText()) {
                        case "초록":
                            Ex04_SwingButton.this.getContentPane().setBackground(Color.green);
                            break;
                        case "빨강":
                            Ex04_SwingButton.this.getContentPane().setBackground(Color.red);
                            break;
                        case "분홍":
                            Ex04_SwingButton.this.getContentPane().setBackground(Color.pink);
                            break;
                        case "주황":
                            Ex04_SwingButton.this.getContentPane().setBackground(Color.orange);
                            break;
                        case "노랑":
                            Ex04_SwingButton.this.getContentPane().setBackground(Color.yellow);
                            break;
                        case "랜덤":{
                            int n = 16777215;
                            n = (int) (Math.random()*16777215);
                            Ex04_SwingButton.this.getContentPane().setBackground(new Color(n));
                            break;
                        }
                    }

                }
            });
        }


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Ex04_SwingButton.this, "버튼1 누름");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Ex04_SwingButton.this, "버튼2 누름");

            }
        });

        btn3.addActionListener(new Button2Event());

    }

    class Button2Event implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    public static void main(String[] args) {
        Ex04_SwingButton a = new Ex04_SwingButton("스윙버튼");

    }
}
