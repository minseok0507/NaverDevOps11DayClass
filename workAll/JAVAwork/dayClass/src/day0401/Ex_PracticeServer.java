package day0401;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Ex_PracticeServer extends JFrame implements Runnable {
    JTextArea textAreaServerLog;
    ServerSocket serverSocket;

    Vector<ClientMemberIn> list = new Vector<>();


    class ClientMemberIn extends Thread {
        Socket mySocket;
        String nickName;
        BufferedReader bufferedReader;
        PrintWriter printWriter;

        public ClientMemberIn(Socket socket) {
            mySocket = socket;

            try {
                bufferedReader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                printWriter = new PrintWriter(mySocket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String msg = bufferedReader.readLine();

                    textAreaServerLog.append(msg + "\n");

                    String[] readCheck = msg.split("\\|");

                    switch (readCheck[0]) {
                        case "name":{
                            String sendMessage = readCheck[1] + "님이 입장했습니다.\n";
                            nickName = readCheck[1];

                            for (ClientMemberIn clientMemberIn : list){
                                clientMemberIn.printWriter.write(sendMessage+"\n");
                                clientMemberIn.printWriter.flush();
                            }

                            break;
                        }

                        case "message":{
                            String sendMessage = nickName + ">>" + readCheck[1] + "\n";

                            for (ClientMemberIn clientMemberIn : list){
                                clientMemberIn.printWriter.write(sendMessage+"\n");
                                clientMemberIn.printWriter.flush();
                            }

                            break;
                        }
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(6000);
            textAreaServerLog.append("서버 소켓 생성 성공\n");

            while (true) {
                Socket socket = serverSocket.accept();
                textAreaServerLog.append(socket.getInetAddress().getHostAddress() + "\n");


                ClientMemberIn clientMemberIn = new ClientMemberIn(socket);

                list.add(clientMemberIn);


                clientMemberIn.start();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Ex_PracticeServer(String title) {
        super(title);
        this.setLocation(100, 100);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 프레임 종료
        this.getContentPane().setBackground(new Color(0x9B8D6E));

        this.initDesign(); //컴포넌트 생성

        this.setVisible(true);

    }

    public void initDesign() {
        textAreaServerLog = new JTextArea();
        this.add(new JScrollPane(textAreaServerLog));

    }


    public static void main(String[] args) {
        Ex_PracticeServer ex = new Ex_PracticeServer("서버");

        ex.run();
    }
}
