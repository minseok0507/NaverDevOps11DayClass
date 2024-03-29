package day0329;

import day0325.Phone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Vector;

public class Ex07_SwingFilePractice extends JFrame {
    static final String FILE = "/Users/minseok/Documents/GitHub/naver0314devops11/sawon.txt";

    JButton buttonAdd, buttonDelete;
    TextField textFieldName;

    JComboBox<String> comboBoxBlood;
    String[] comboLabelBlood = {"A", "B", "AB", "O"};
    JComboBox<String> comboBoxAddr;
    String[] comboLabelAddr = {"경기도", "서울", "인천", "강원도", "충청도", "전라도", "제주도"};
    JComboBox<String> comboBoxRank;
    String[] comboLabelRank = {"인턴", "사원", "대리", "팀장", "부장", "사장"};
    JTable table;
    DefaultTableModel tableModel;
    String[] title = {"이름", "혈액형", "주소", "직급"};

    public Ex07_SwingFilePractice(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 400);
        this.getContentPane().setBackground(new Color(12098141));

        this.initDesign(); //컴포넌트 생성

        this.setVisible(true);

        windowOpenEvent();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                windowClosingEvent();
                System.exit(0);

            }
        });
    }

    public void initDesign() {
//이름,혈액형,지역,직급
        buttonAdd = new JButton("사원 정보 저장");
        buttonDelete = new JButton("시원 정보 삭제");

        textFieldName = new TextField(5);
        comboBoxBlood = new JComboBox<String>(comboLabelBlood);
        comboBoxAddr = new JComboBox<String>(comboLabelAddr);
        comboBoxRank = new JComboBox<String>(comboLabelRank);

        JPanel pTop = new JPanel();
        JPanel pbot = new JPanel();

        pTop.add(buttonAdd);
        pTop.add(buttonDelete);

        pbot.add(new JLabel("이름"));
        pbot.add(textFieldName);
        pbot.add(new JLabel("   혈액형"));
        pbot.add(comboBoxBlood);
        pbot.add(new JLabel("   주소"));
        pbot.add(comboBoxAddr);
        pbot.add(new JLabel("   직급"));
        pbot.add(comboBoxRank);

        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);


        this.add("North", pTop);
        this.add("South", pbot);
        this.add("Center", new JScrollPane(table));


        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAddEvent();
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonDeleteEvent();
            }
        });
    }

    public void buttonAddEvent() {
        String name = textFieldName.getText();
        String blood = comboLabelBlood[comboBoxBlood.getSelectedIndex()];
        String addr = comboLabelAddr[comboBoxAddr.getSelectedIndex()];
        String rank = comboLabelRank[comboBoxRank.getSelectedIndex()];

        if (name.equals("")) {
            JOptionPane.showMessageDialog(Ex07_SwingFilePractice.this, "이름을 입력하세요.");
        } else {
            Vector<String> date = new Vector<>();
            date.add(name);
            date.add(blood);
            date.add(addr);
            date.add(rank);

            tableModel.addRow(date);
            textFieldName.setText("");
            comboBoxBlood.setSelectedIndex(0);
            comboBoxAddr.setSelectedIndex(0);
            comboBoxRank.setSelectedIndex(0);
        }
    }

    public void buttonDeleteEvent() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(Ex07_SwingFilePractice.this, "행을 선택하세요.");
        } else {
            JOptionPane.showMessageDialog(Ex07_SwingFilePractice.this, "선택한 행을 삭제합니다.");
            tableModel.removeRow(row);
        }
    }

    public void windowOpenEvent() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);

            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null)
                    break;

                String[] fileData = readLine.split(",");
                tableModel.addRow(fileData);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void windowClosingEvent() {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(FILE);

            for (int i = 0; i < table.getRowCount(); i++) {
                String name = table.getValueAt(i, 0).toString();
                String blood = table.getValueAt(i, 1).toString();
                String addr = table.getValueAt(i, 2).toString();
                String rank = table.getValueAt(i, 3).toString();

                String writeDate = name + "," + blood + "," + addr + "," + rank + "\n";

                fileWriter.write(writeDate);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        JOptionPane.showMessageDialog(Ex07_SwingFilePractice.this,"저장완료");
    }

    public static void main(String[] args) {
        Ex07_SwingFilePractice ex = new Ex07_SwingFilePractice("사원 정보");
    }
}
