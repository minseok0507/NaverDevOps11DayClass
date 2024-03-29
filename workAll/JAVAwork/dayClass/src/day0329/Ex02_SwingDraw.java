package day0329;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Ex02_SwingDraw extends JFrame implements MouseMotionListener, MouseListener {
    Color color = Color.green;
    int x, y, prex, prey;

    @Override
    public void paint(Graphics g) {
        //super.paint(g);

        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g.drawLine(x, y, prex, prey);

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        prex = x;
        prey = y;
        x = e.getX();
        y = e.getY();


        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public Ex02_SwingDraw(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(5459614));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.initDesign(); //컴포넌트 생성
        this.setVisible(true);

    }

    public void initDesign() {

    }

    public static void main(String[] args) {
        Ex02_SwingDraw ex = new Ex02_SwingDraw("곡선 그리기");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Press");
        x = e.getX();
        y = e.getY();
        prex = e.getX();
        prey = e.getY();

        repaint();
        int c = ((int) (Math.random() * 16777215));
        color = new Color(c);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
