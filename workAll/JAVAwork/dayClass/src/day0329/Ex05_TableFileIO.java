package day0329;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class Ex05_TableFileIO extends JFrame {
    JLabel lblTitle;
    JTable table;
    JButton btn;
    DefaultTableModel tableModel;


    public Ex05_TableFileIO(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(12098141));

        this.initDesign(); //컴포넌트 생성

        this.setVisible(true);

    }

    public void initDesign() {
        lblTitle = new JLabel("학생 정보", JLabel.CENTER);
        lblTitle.setFont(new Font("", Font.BOLD, 30));
        this.add("North", lblTitle);

        String[] title = {"이름", "나이", "Java", "Spring", "HTML", "총점", "평균"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));
        this.addStudentFile();
        process();

        btn = new JButton("선택 행 삭제");
        this.add("South", btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (row == -1){
                    JOptionPane.showMessageDialog(Ex05_TableFileIO.this,"행을 선택하시오.");
                }
                else {
                    JOptionPane.showMessageDialog(Ex05_TableFileIO.this,"선택 행을 삭제합니다.");
                    tableModel.removeRow(row);
                }
            }
        });
    }

    public void process(){
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int java = Integer.parseInt(table.getValueAt(i,2).toString());
            int spring = Integer.parseInt(table.getValueAt(i,3).toString());
            int html = Integer.parseInt(table.getValueAt(i,4).toString());

            int total = java + spring + html;
            double avg = total / 3.0;
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            numberFormat.setMaximumFractionDigits(2);
            table.setValueAt(total,i,5);
            table.setValueAt(numberFormat.format(avg),i,6);

            table.setGridColor(Color.black);
            table.setBackground(Color.pink);
        }
    }

    public void addStudentFile() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader("/Users/minseok/Documents/GitHub/naver0314devops11/student.txt");
            bufferedReader = new BufferedReader(fileReader);


            while (true) {
                String nextLine = bufferedReader.readLine();
                if (nextLine == null) {
                    break;
                }
                String []data = nextLine.split(",");
                tableModel.addRow(data);

            }


        } catch (FileNotFoundException e) {
            System.out.println("Not Fount File!!" + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Ex05_TableFileIO ex = new Ex05_TableFileIO("파일 테이블");
    }
}
