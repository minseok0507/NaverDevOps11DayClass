package day0401;

import javax.swing.*;
import java.awt.*;

public class EX03_ThreadSwingCanvas extends JFrame implements Runnable {
    JButton buttonStart, buttonStop;
    MyDraw draw = new MyDraw();


    @Override
    public void run() {
        System.out.println("Draw Circle");

        if (draw == null) {
            return;
        }
        while (true) {

        }
    }

    public EX03_ThreadSwingCanvas(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료

        this.initDesign(); //컴포넌트 생성


        this.setVisible(true);
    }

    public void initDesign() {
        buttonStart = new JButton("START");
        buttonStop = new JButton("STOP");

        JPanel pTop = new JPanel();

        pTop.add(buttonStart);
        pTop.add(buttonStop);


        this.add("Center", draw);
        this.add("North", pTop);

    }

    class MyDraw extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);


            int color = (int) (Math.random() * 16777215);

            g.setColor(new Color(color));

            int xPos = (int) (Math.random() * 400) + 50;
            int yPos = (int) (Math.random() * 400) + 50;

            g.fillOval(xPos, yPos, 70, 70);
        }
    }
    public void drawPaint(){

    }
    public static void main(String[] args) {
        EX03_ThreadSwingCanvas ex = new EX03_ThreadSwingCanvas("Thread");

//        ex.run();

        Thread thread = new Thread(ex);
        thread.run();

    }
}
