package day0401;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Vector;

public class Ex05_ServerChat extends JFrame implements Runnable {
    JTextArea textArea;
    static Vector<ClinetMember> list = new Vector<>();
    ServerSocket serverSocket;


    public Ex05_ServerChat(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(5459614));
        this.initDesign(); //컴포넌트 생성

        this.setVisible(true);
    }


    //접속하는 클라이언트 허용/벡터에 저장
    @Override
    public void run() {
        System.out.println("서버 소캣 생성 후 접속 허용 run");

        try {
            serverSocket = new ServerSocket(6000);
            textArea.append("서버 소캣 생성 성공\n");

            while (true) {
                //접속한 클라이언트 허용, 소캣 생성
                Socket socket = serverSocket.accept();
                textArea.append("접속한 IP : " + socket.getInetAddress().getHostAddress() + "\n");

                autoScroll();


                //클라이언트 내부 클래스 생성

                ClinetMember clinetMember = new ClinetMember(socket);

                //백터에 저장
                list.add(clinetMember);


                clinetMember.start();
            }

        } catch (IOException e) {
            textArea.append("서버 소캣 생성 오류 : " + e.getMessage() + "\n");
        }
    }

    //클라이언트 내부 클래스
    static class ClinetMember extends Thread {
        Socket mySocket;
        String nickName;
        BufferedReader bufferedReader;
        PrintWriter printWriter;

        public ClinetMember(Socket socket) {
            mySocket = socket;

            try {
                bufferedReader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                printWriter = new PrintWriter(mySocket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        //각 클라이언트의 메세지를 읽어서 모든 클라이언트에게 send
        @Override
        public void run() {
            super.run();

            try {
                String msg = bufferedReader.readLine();


                System.out.println(msg);
                String[] m = msg.split("\\|");
                switch (m[0]) {
                    case "1": {
                        String sendMessage = m[1] + "님이 입장했습니다.\n";
                        nickName = m[1];

                        for (ClinetMember cm : list) {
                            cm.printWriter.write(sendMessage + "\n");
                            cm.printWriter.flush();
                        }
                        break;
                    }

                    case "2": {
                        String sendMessage = nickName + ">>" + m[1] + "\n";
                        for (ClinetMember cm : list) {
                            cm.printWriter.write(sendMessage + "\n");
                            cm.printWriter.flush();
                        }
                        break;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            System.out.println("클라이언트 접속 run");
        }
    }


    //채팅창(TextArea) auto scroll
    public void autoScroll() {
        int n = textArea.getDocument().getLength();
        textArea.setCaretPosition(n);
    }

    public void initDesign() {
        textArea = new JTextArea();
        this.add(new JScrollPane(textArea));
    }

    public static void main(String[] args) {
        Ex05_ServerChat ex = new Ex05_ServerChat("채팅서버");

        Thread thread = new Thread(ex);
        thread.start();


    }

}
