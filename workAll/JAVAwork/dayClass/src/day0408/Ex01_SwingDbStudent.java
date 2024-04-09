package day0408;

import com.mysql.cj.jdbc.ConnectionImpl;
import day0329.Ex06_TableShop;
import db.common.DBconnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Vector;

public class Ex01_SwingDbStudent extends JFrame {
    DBconnect db = new DBconnect();

    JTable table;
    DefaultTableModel tableModel;
    JTextField textFieldName, textFieldJava, textFieldHTML, textFieldSpring;
    JButton buttonAdd, buttonDel;
    JComboBox<String> comboBoxResult;
    int order = 1;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    public Ex01_SwingDbStudent(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(5459614));

        this.initDesign(); //컴포넌트 생성
        this.setVisible(true);
    }

    public void initDesign() {
        JPanel p1 = new JPanel();

        p1.add(new JLabel("이름:"));
        textFieldName = new JTextField(5);
        p1.add(textFieldName);

        p1.add(new JLabel("\tJAVA:"));
        textFieldJava = new JTextField(5);
        p1.add(textFieldJava);

        p1.add(new JLabel("\tHTML:"));
        textFieldHTML = new JTextField(5);
        p1.add(textFieldHTML);

        p1.add(new JLabel("\tSpring:"));
        textFieldSpring = new JTextField(5);
        p1.add(textFieldSpring);

        this.add("North", p1);


        String[] title = {"스퀀스", "이름", "Java", "HTML", "Spring", "총 점", "평 균"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));


        JPanel p2 = new JPanel();

        buttonAdd = new JButton("추가");
        buttonDel = new JButton("삭제");
        p2.add(buttonAdd);
        p2.add(buttonDel);

        String[] combo = {"추가순", "이름순", "총점높은순", "총점낮은순"};
        comboBoxResult = new JComboBox<>(combo);
        p2.add(new JLabel("출력순서"));
        p2.add(comboBoxResult);

        this.add("South", p2);

        comboBoxResult.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                order = comboBoxResult.getSelectedIndex();
                writeStudent();
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldName.getText().isEmpty() || textFieldJava.getText().isEmpty() || textFieldHTML.getText().isEmpty() || textFieldSpring.getText().isEmpty())
                    return;

                connection = db.getConnect();
                String spl = "insert into bitcamp.student values (null,?,?,?,?,now())";

                try {
                    preparedStatement = connection.prepareStatement(spl);

                    preparedStatement.setString(1, textFieldName.getText());
                    preparedStatement.setInt(2, Integer.parseInt(textFieldJava.getText()));
                    preparedStatement.setInt(3, Integer.parseInt(textFieldHTML.getText()));
                    preparedStatement.setInt(4, Integer.parseInt(textFieldSpring.getText()));

                    preparedStatement.execute();
                    System.out.println("데이터 추가 성공");

                    textFieldName.setText("");
                    textFieldJava.setText("");
                    textFieldHTML.setText("");
                    textFieldSpring.setText("");

                    writeStudent();
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, "입력 값을 확인하시오");
                    throw new RuntimeException(ex);
                }
            }
        });


        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (row == -1) {
                    JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, "행을 선택하시오.");
                } else {
                    JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, "선택한 행을 삭제합니다.");
                    try {
                        connection = db.getConnect();
                        String sql = "delete from bitcamp.student where num = ?";
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1, Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                        preparedStatement.execute();
                        writeStudent();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });


        writeStudent();

    }

    public void writeStudent() {
        connection = db.getConnect();

        String sql = getSql();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> data = new Vector<>();
                data.add(resultSet.getString(1));
                data.add(resultSet.getString(2));
                data.add(resultSet.getString(3));
                data.add(resultSet.getString(4));
                data.add(resultSet.getString(5));
                data.add(resultSet.getString(6));

                NumberFormat numberFormat = NumberFormat.getInstance();
                numberFormat.setMaximumFractionDigits(2);
                double avg = resultSet.getInt(6) / 3.0;
                data.add(String.valueOf(numberFormat.format(avg)));

                tableModel.addRow(data);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private String getSql() {
        String sql;
        if (order == 0) {
            sql = "SELECT num, name, java,html,spring, java+html+spring tot FROM bitcamp.student order by num asc";
        } else if (order == 1) {
            sql = "SELECT num, name, java,html,spring, java+html+spring tot FROM bitcamp.student order by name asc";
        } else if (order == 2) {
            sql = "SELECT num, name, java,html,spring, java+html+spring tot FROM bitcamp.student order by tot desc";
        } else if (order == 3) {
            sql = "SELECT num, name, java,html,spring, java+html+spring tot FROM bitcamp.student order by tot asc";
        } else {
            sql = "SELECT num, name, java,html,spring, java+html+spring tot FROM bitcamp.student order by num asc";
        }
        return sql;
    }


    public static void main(String[] args) {
        Ex01_SwingDbStudent ex = new Ex01_SwingDbStudent("스윙어쩌고");
    }
}
