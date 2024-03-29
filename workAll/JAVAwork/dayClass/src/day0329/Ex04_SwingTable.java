package day0329;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;

public class Ex04_SwingTable extends JFrame {
    JTable table;
    JLabel lblMsg;

    public Ex04_SwingTable(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(12098141));

        this.initDesign(); //컴포넌트 생성

        this.setVisible(true);

    }

    public void initDesign() {
        String[] title = {"이름", "나이", "혈액형", "주소"};
        String[][] date = {
                {"정민석", "24", "A", "일산"},
                {"조민혁", "41", "B", "강원도"},
                {"이혁준", "27", "AB", "서울"},
                {"김민수", "17", "O", "제주도"}
        };

        table = new JTable(date, title);

        this.add("North", new JLabel("701 멤버", JLabel.CENTER));
        this.add("Center", new JScrollPane(table));

        lblMsg = new JLabel("결과", JLabel.CENTER);
        this.add("South", lblMsg);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                int rowIndex = table.getSelectedRow();

                String name = table.getValueAt(rowIndex, 0).toString();
                String age = table.getValueAt(rowIndex, 1).toString();
                String addr = table.getValueAt(rowIndex, 3).toString();

                String msg = name + "은 " + age + "세며 " + addr + "에 살고 있음";
                lblMsg.setText(msg);
            }
        });

    }

    public static void main(String[] args) {
        Ex04_SwingTable ex = new Ex04_SwingTable("테이블");
    }
}
