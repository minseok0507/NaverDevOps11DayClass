package day0401;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ex05_Clinet extends JFrame implements ActionListener, Runnable {
    JButton buttonConnect;
    JButton buttonSand;
    JLabel labelMessage;
    JTextArea textArea;
    JTextField textField;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    String nickName;
    Socket socket;


    public Ex05_Clinet(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(0x9B8D6E));

        this.initDesign(); //컴포넌트 생성

        this.setVisible(true);

    }

    //서버의 메세지를 받아 출력
    @Override
    public void run() {
        System.out.println("클라이언트 run");

        //서버가 보내는 메세지 대기 > 출력
        while (true){
            try {
                String msg = bufferedReader.readLine();

                textArea.append(msg + "\n");
                autoScroll();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    //메세지 전송 텍스트필드와 전송버튼을 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == textField || o == buttonSand) {
            printWriter.write("2|" + textField.getText() + "\n");
            printWriter.flush();

            System.out.println("send!");

            textField.setText("");
            textField.requestFocus();

        }
    }


    public void initDesign() {
        this.setLayout(null);

        buttonConnect = new JButton("서버 접속하기");
        buttonConnect.setBounds(50, 10, 150, 40);
        this.add(buttonConnect);

        labelMessage = new JLabel("접속 여부 : X");
        labelMessage.setBounds(220, 15, 150, 30);
        ;
        this.add(labelMessage);

        textArea = new JTextArea();
        textArea.setBounds(20, 60, 460, 350);
        this.add(textArea);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 60, 460, 350);
        this.add(scrollPane);

        textField = new JTextField(30);
        textField.setBounds(20, 420, 350, 30);
        this.add(textField);

        buttonSand = new JButton("전송");
        buttonSand.setBounds(380, 420, 100, 30);
        this.add(buttonSand);


        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serverIp = JOptionPane.showInputDialog("접속할 서버 주소 입력", "192.168.0.22");
                nickName = JOptionPane.showInputDialog("접속할 닉네임을 입력", "민석잉");

                //서버 접속
                try {
                    socket = new Socket(serverIp, 6000);
                    JOptionPane.showMessageDialog(Ex05_Clinet.this, "서버 접속 성공");

                    //io 클래스 생성
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    printWriter = new PrintWriter(socket.getOutputStream());

                    Ex05_Clinet.this.setTitle(nickName);
                    labelMessage.setText("서버 접속 중... " + nickName);

                    //스레드 시작
                    Thread thread = new Thread(Ex05_Clinet.this);
                    thread.start();

                    //서버로 닉네임 전달
                    printWriter.write("1|" + nickName + "\n");
                    printWriter.flush();//flush 를 해줘야 전송됨


                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Ex05_Clinet.this, "서버주소를 확인하세요.");
                }
            }
        });

        textField.addActionListener(this);
        buttonSand.addActionListener(this);

    }

    public void autoScroll() {
        int n = textArea.getDocument().getLength();
        textArea.setCaretPosition(n);
    }


    public static void main(String[] args) {
        Ex05_Clinet ex = new Ex05_Clinet("클라이언트");
    }
}
