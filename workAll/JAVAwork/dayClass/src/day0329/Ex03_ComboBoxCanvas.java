package day0329;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class Ex03_ComboBoxCanvas extends JFrame {
    JComboBox<String> comboBox;
    int selectCombo = 4;
    static final String PATH = "/Users/minseok/Documents/GitHub/naver0314devops11/img_food/";
    Random random = new Random();
    String[] comboLabel = {"선", "원", "사각형", "문자열", "이미지"};


    Draw draw = new Draw();


    public Ex03_ComboBoxCanvas(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(0xffffff));


        this.initDesign(); //컴포넌트 생성
        this.setVisible(true);
    }

    public void initDesign() {
        JPanel p = new JPanel();
        comboBox = new JComboBox<String>(comboLabel);
        p.add(new JLabel("메뉴 선택"));
        p.add(comboBox);

        comboBox.setSelectedIndex(selectCombo);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                selectCombo = comboBox.getSelectedIndex();
                draw.repaint();
            }
        });

        this.add("North", p);

        this.add("Center", draw);


    }

    public Color getRandomColor() {
        Color color;

        int c = ((int) (Math.random() * 16777215));
        color = new Color(c);

        return color;
    }

    class Draw extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            if (selectCombo == 0) {
                for (int i = 0; i < 50; i++) {
                    int x = random.nextInt(500);
                    int y = random.nextInt(500);
                    int x1 = random.nextInt(500);
                    int y1 = random.nextInt(500);
                    Color color = getRandomColor();
                    g.setColor(color);
                    g.drawLine(x, y, x1, y1);
                }


            } else if (selectCombo == 1) {
                for (int i = 0; i < 50; i++) {
                    int x = random.nextInt(500);
                    int y = random.nextInt(500);
                    int w = random.nextInt(40)+20;

                    Color color = getRandomColor();
                    g.setColor(color);
                    g.fillOval(x,y,w,w);
                }

            } else if (selectCombo == 2) {
                for (int i = 0; i < 50; i++) {
                    int x = random.nextInt(500);
                    int y = random.nextInt(500);
                    int w = random.nextInt(40)+20;

                    Color color = getRandomColor();
                    g.setColor(color);
                    g.fillRect(x,y,w,w);
                }

            } else if (selectCombo == 3) {
                String msg = "HI";
                g.setFont(new Font("Comic Sans MS",Font.BOLD,30));

                for (int i = 0; i < 50; i++) {
                    int x = random.nextInt(350);
                    int y = random.nextInt(500);
                    Color color = getRandomColor();
                    g.setColor(color);
                    g.drawString(msg,x,y);
                }


            } else if (selectCombo == 4) {
                int r = random.nextInt(12) + 1;
                String link = PATH + r + ".jpg";
                Image img = new ImageIcon(link).getImage();
                g.drawImage(img, 50, 10, 400, 400, this);
            }
        }
    }


    public static void main(String[] args) {
        Ex03_ComboBoxCanvas ex = new Ex03_ComboBoxCanvas("콤보박스");
    }
}
