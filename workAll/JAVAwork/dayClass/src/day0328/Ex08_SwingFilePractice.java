package day0328;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ex08_SwingFilePractice extends JFrame {
    String path = "/Users/minseok/Documents/GitHub/naver0314devops11/img_people/17.jpg";
    JButton btn;
    CanvasImg canvasImg = new CanvasImg();

    public Ex08_SwingFilePractice(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(5459614));

        this.setVisible(true);

        this.initDesign(); //컴포넌트 생성

    }

    public void initDesign() {
        this.add("Center", canvasImg);


        JPanel p = new JPanel();
        btn = new JButton("사진 파일 열기");
        p.add(btn);
        this.add("North", p);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(Ex08_SwingFilePractice.this, "파일열기", FileDialog.LOAD);
                dlg.setVisible(true);

                // 사용자가 취소를 눌렀거나 디렉토리만 선택한 경우
                if (dlg.getDirectory() == null || dlg.getFile() == null) {
                    return;
                }

                String selectedFilePath = dlg.getDirectory() + dlg.getFile();
                File selectedFile = new File(selectedFilePath);

                // 선택한 파일이 이미지 파일인지 확인
                if (isImageFile(selectedFile)) {
                    path = selectedFilePath; // 이미지 파일 경로 저장
                    canvasImg.repaint(); // 이미지 캔버스 다시 그리기
                } else {
                    JOptionPane.showMessageDialog(Ex08_SwingFilePractice.this, "이미지 파일이 아닙니다.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
            // 파일이 이미지 파일인지 확인하는 메서드
            boolean isImageFile(File file) {
                String name = file.getName().toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".bmp");
            }
        });




    }

    class CanvasImg extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Image img = new ImageIcon(path).getImage();
            g.drawImage(img, 10, 10, 280, 280, this);
        }
    }

    public static void main(String[] args) {
        Ex08_SwingFilePractice ex = new Ex08_SwingFilePractice("사진 올리기");
    }

}
