package day0408;

import db.common.DBconnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Vector;

public class Ex02_DBSawon extends JFrame {
    DBconnect db = new DBconnect();

    JTable table;
    DefaultTableModel tableModel;
    JTextField textFieldName, textFieldScore;
    JButton buttonAdd, buttonDel;
    JComboBox<String> comboBoxDep, comboBoxSearchDep;
    JComboBox<String> comboBoxSex;
    JRadioButton radioButtonAll, radioButtonM, radioButtonF;
    ButtonGroup buttonGroupSex;

    String[] title = {"스퀀스", "이름", "점수", "성별", "부서",};
    String[] comboLabelDep = {"홍보부", "교육부", "인사부"};
    String[] comboLabelSearchDep = {"전체", "홍보부", "교육부", "인사부"};
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public Ex02_DBSawon(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(5459614));

        this.initDesign(); //컴포넌트 생성
        this.setVisible(true);
    }

    private String getSql() {
        String sql = "SELECT * FROM bitcamp.sawon";
        if (radioButtonAll.isSelected()) {
            if (comboBoxSearchDep.getSelectedIndex() == 0) {
                sql = "SELECT * FROM bitcamp.sawon";
            } else {
                sql = "SELECT * FROM bitcamp.sawon WHERE buseo = '" + comboLabelSearchDep[comboBoxSearchDep.getSelectedIndex()] + "'";
            }
        } else if (radioButtonM.isSelected()) {
            if (comboBoxSearchDep.getSelectedIndex() == 0) {
                sql = "SELECT * FROM bitcamp.sawon WHERE gender = '남자'";
            } else {
                sql = "SELECT * FROM bitcamp.sawon WHERE gender = '남자' AND buseo = '" + comboLabelSearchDep[comboBoxSearchDep.getSelectedIndex()] + "'";
            }
        } else if (radioButtonF.isSelected()) {
            if (comboBoxSearchDep.getSelectedIndex() == 0) {
                sql = "SELECT * FROM bitcamp.sawon WHERE gender = '여자'";
            } else {
                sql = "SELECT * FROM bitcamp.sawon WHERE gender = '여자' AND buseo = '" + comboLabelSearchDep[comboBoxSearchDep.getSelectedIndex()] + "'";
            }
        }

        return sql;
    }

    public void initDesign() {
        radioButtonAll = new JRadioButton("전체");
        radioButtonM = new JRadioButton("남자");
        radioButtonF = new JRadioButton("여자");
        buttonGroupSex = new ButtonGroup();
        buttonGroupSex.add(radioButtonAll);
        buttonGroupSex.add(radioButtonM);
        buttonGroupSex.add(radioButtonF);

        JPanel p1 = new JPanel();

        p1.add(new JLabel("이름:"));
        textFieldName = new JTextField(5);
        p1.add(textFieldName);

        p1.add(new JLabel("\t점수:"));
        textFieldScore = new JTextField(5);
        p1.add(textFieldScore);

        comboBoxDep = new JComboBox<>(comboLabelDep);
        p1.add(new JLabel("부서"));
        p1.add(comboBoxDep);

        String[] sex = {"남자", "여자"};
        comboBoxSex = new JComboBox<>(sex);
        p1.add(new JLabel("성별"));
        p1.add(comboBoxSex);

        this.add("North", p1);


        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));


        JPanel p2 = new JPanel();

        buttonAdd = new JButton("추가");
        buttonDel = new JButton("삭제");
        p2.add(buttonAdd);
        p2.add(buttonDel);

        p2.add(new JLabel("       "));


        comboBoxSearchDep = new JComboBox<>(comboLabelSearchDep);
        p2.add(new JLabel("부서별"));
        p2.add(comboBoxSearchDep);


        p2.add(new JLabel("\t성별"));
        p2.add(radioButtonAll);
        radioButtonAll.setSelected(true);
        p2.add(radioButtonM);
        p2.add(radioButtonF);

        this.add("South", p2);


        comboBoxSearchDep.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                writeStudent();
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sex = "";

                if (radioButtonM.isSelected()) {
                    sex = radioButtonM.getText();
                } else if (radioButtonF.isSelected()) {
                    sex = radioButtonF.getText();
                } else {
                    sex = radioButtonAll.getText();
                }

                if (textFieldName.getText().isEmpty() || textFieldScore.getText().isEmpty())
                    return;

                connection = db.getConnect();
                String spl = "insert into bitcamp.sawon values (null,?,?,?,?)";
                try {
                    preparedStatement = connection.prepareStatement(spl);

                    preparedStatement.setString(1, textFieldName.getText());
                    preparedStatement.setInt(2, Integer.parseInt(textFieldScore.getText()));
                    preparedStatement.setString(3, sex);
                    preparedStatement.setString(4, comboLabelDep[comboBoxDep.getSelectedIndex()]);


                    preparedStatement.execute();

                    textFieldName.setText("");
                    textFieldScore.setText("");
                    radioButtonAll.isSelected();
                    comboBoxDep.setSelectedIndex(0);


                    writeStudent();
                    JOptionPane.showMessageDialog(Ex02_DBSawon.this, "데이터 추가 성공");

                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Ex02_DBSawon.this, "입력 값을 확인하시오");
                    throw new RuntimeException(ex);
                }
            }
        });


        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (row == -1) {
                    JOptionPane.showMessageDialog(Ex02_DBSawon.this, "행을 선택하시오.");
                } else {
                    JOptionPane.showMessageDialog(Ex02_DBSawon.this, "선택한 행을 삭제합니다.");
                    try {
                        connection = db.getConnect();
                        String sql = "delete from bitcamp.sawon where num = ?";
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1, Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
                        preparedStatement.execute();
                        writeStudent();
                        JOptionPane.showMessageDialog(Ex02_DBSawon.this, "삭제완료");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });

        radioButtonAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeStudent();
            }
        });

        radioButtonM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeStudent();
            }
        });

        radioButtonF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeStudent();
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

                tableModel.addRow(data);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Ex02_DBSawon ex = new Ex02_DBSawon("사원관리");
    }

}
