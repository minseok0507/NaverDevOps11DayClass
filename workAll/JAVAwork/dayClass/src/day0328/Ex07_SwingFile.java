package day0328;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Ex07_SwingFile extends JFrame {
    final String FILE = "/Users/minseok/Documents/GitHub/naver0314devops11/swing_memo.txt";

    JButton btnOpen, btnSave;
    JTextArea memoArea;

    public Ex07_SwingFile(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(0xffffff));

        this.setVisible(true);

        this.initDesign(); //컴포넌트 생성

    }

    public void initDesign() {
        JPanel p = new JPanel();
        btnOpen = new JButton("파일 열기");
        btnSave = new JButton("파일 저장");
        p.add(btnOpen);
        p.add(btnSave);

        this.add("North", p);

        memoArea = new JTextArea();
        //this.add("Center", memoArea);
        this.add("Center", new JScrollPane(memoArea));

        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(Ex07_SwingFile.this, "파일열기",FileDialog.LOAD);
                dlg.setVisible(true);

                if (dlg.getDirectory() == null){
                    return;
                }
                String path = dlg.getDirectory() + dlg.getFile();//불러올 파일은 디렉토리명 + 파일명

                FileReader fr = null;
                BufferedReader br = null;

                try {
                    fr = new FileReader(path);
                    br = new BufferedReader(fr);

                    System.out.println(path);

                    memoArea.setText("");
                    while (true){
                        String line = br.readLine();
                        if (line == null){
                            break;
                        }

                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    try {
                        br.close();
                        fr.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(Ex07_SwingFile.this, "파일저장",FileDialog.SAVE);
                dlg.setVisible(true);

                if (dlg.getDirectory() == null){
                    return;
                }
                String path = dlg.getDirectory() + dlg.getFile();//불러올 파일은 디렉토리명 + 파일명

                FileWriter fw = null;
                try {
                    fw = new FileWriter(path);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });


    }


    public static void main(String[] args) {
        Ex07_SwingFile ex = new Ex07_SwingFile("파일");
    }
}
