package day0329;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Vector;

public class Ex06_TableShop extends JFrame {

    JTable table;
    DefaultTableModel tableModel;
    JButton buttonDelete, buttonAdd;
    JTextField textFieldGoods, textFieldCount, textFieldPrice;

    public Ex06_TableShop(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 300);
        this.getContentPane().setBackground(new Color(12098141));

        this.initDesign(); //컴포넌트 생성
        openEvent();

        this.setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                closingEvent();
                System.exit(0);

            }
        });
    }

    public void openEvent() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader("/Users/minseok/Documents/GitHub/naver0314devops11/shop.txt");
            bufferedReader = new BufferedReader(fileReader);


            while (true) {
                String nextLine = bufferedReader.readLine();
                if (nextLine == null) {
                    break;
                }
                String[] data = nextLine.split(",");
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

    public void closingEvent() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("/Users/minseok/Documents/GitHub/naver0314devops11/shop.txt");

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String goods = table.getValueAt(i, 0).toString();
                String count = table.getValueAt(i, 1).toString();
                String price = table.getValueAt(i, 2).toString();
                String total = table.getValueAt(i, 3).toString();
                fileWriter.write(goods + "," + count + "," + price + "," + total + "\n");
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


    }

    public void initDesign() {
        JPanel pTop = new JPanel();

        buttonAdd = new JButton("상품 정보 추가");
        buttonDelete = new JButton("상품 정보 삭제");
        pTop.add(buttonAdd);
        pTop.add(buttonDelete);

        this.add("North", pTop);

        String[] title = {"상품명", "수량", "단가", "총금액"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));


        textFieldGoods = new JTextField(7);
        textFieldCount = new JTextField(4);
        textFieldPrice = new JTextField(7);

        JPanel pBottom = new JPanel();
        pBottom.add(new JLabel("상품명"));
        pBottom.add(textFieldGoods);
        pBottom.add(new JLabel("수량"));
        pBottom.add(textFieldCount);
        pBottom.add(new JLabel("단가"));
        pBottom.add(textFieldPrice);

        this.add("South", pBottom);


        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String goods = textFieldGoods.getText();
                try {
                    int count = Integer.parseInt(textFieldCount.getText());
                    int price = Integer.parseInt(textFieldPrice.getText());
                    int total = count * price;

                    Vector<String> data = new Vector<>();
                    data.add(goods);
                    data.add(String.valueOf(count));
                    data.add(String.valueOf(price));
                    data.add(String.valueOf(total));

                    tableModel.addRow(data);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(Ex06_TableShop.this, "단가와 수량을 숫자로 적으시오.");
                } finally {
                    textFieldGoods.setText("");
                    textFieldCount.setText("");
                    textFieldPrice.setText("");
                }
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (row == -1) {
                    JOptionPane.showMessageDialog(Ex06_TableShop.this, "행을 선택하시오.");
                } else {
                    JOptionPane.showMessageDialog(Ex06_TableShop.this, "선택한 행을 삭제합니다.");
                    tableModel.removeRow(row);
                }
            }
        });
    }


    public static void main(String[] args) {
        Ex06_TableShop ex = new Ex06_TableShop("상품");
    }
}
