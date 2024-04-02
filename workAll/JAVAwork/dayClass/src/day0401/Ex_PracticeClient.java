package day0401;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Ex_PracticeClient extends JFrame implements Runnable, ActionListener {
    JButton buttonConnect;
    JButton buttonSend;
    JTextArea textAreaChatLog;
    JTextField textFieldChat;
    JLabel labelEvent;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    String nickName;
    Socket socket;

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();

        if (object == textFieldChat || object == buttonConnect) {
            printWriter.write("message|" + textFieldChat.getText() + "\n");
            printWriter.flush();

            textFieldChat.setText("");
            textFieldChat.requestFocus();
        }
    }

    public Ex_PracticeClient(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(500, 510);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(0x9B8D6E));

        this.initDesign(); //컴포넌트 생성

        this.setVisible(true);

    }

    public void initDesign() {
        this.setLayout(null);

        buttonConnect = new JButton("서버 접속하기");
        buttonConnect.setBounds(10, 10, 250, 50);
        this.add(buttonConnect);

        labelEvent = new JLabel("접속 안됨");
        labelEvent.setBounds(270, 25, 150, 20);
        this.add(labelEvent);

        textAreaChatLog = new JTextArea();
        textAreaChatLog.setBounds(15, 70, 470, 350);
        this.add(textAreaChatLog);

        textFieldChat = new JTextField(50);
        textFieldChat.setBounds(10, 430, 300, 40);
        this.add(textFieldChat);

        buttonSend = new JButton("전송");
        buttonSend.setBounds(350, 430, 100, 40);
        this.add(buttonSend);

        textFieldChat.addActionListener(this);
        buttonSend.addActionListener(this);

        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serverIP = JOptionPane.showInputDialog("접속할 주소를 입력하세요", "192.168.0.22");
                nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.", "민석잉");

                try {
                    socket = new Socket(serverIP, 6000);

                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    printWriter = new PrintWriter(socket.getOutputStream());

                    labelEvent.setText("닉네임 : " + nickName);

                    Thread thread = new Thread(Ex_PracticeClient.this);
                    thread.start();

                    printWriter.write("name|" + nickName + "\n");
                    printWriter.flush();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Ex_PracticeClient.this, "주소를 확인하세요.");
                } finally {
                    socket = null;
                }
            }
        });
    }

    @Override
    public void run() {
        System.out.println("서버 접속 성공");

        while (true) {
            try {
                String msg = bufferedReader.readLine();
                textAreaChatLog.append(msg + "\n");
            } catch (IOException e) {
            }
        }
    }

    public void autoScroll() {
        int n = textFieldChat.getDocument().getLength();
        textFieldChat.setCaretPosition(n);
    }

    public static void main(String[] args) {
        Ex_PracticeClient ex = new Ex_PracticeClient("채팅창");
    }
}
