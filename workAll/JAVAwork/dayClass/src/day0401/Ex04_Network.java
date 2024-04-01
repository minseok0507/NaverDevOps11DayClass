package day0401;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex04_Network {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();

        System.out.println("PC NAME : " + local.getHostName());
        System.out.println("IP : " + local.getHostAddress());
        System.out.println("=".repeat(40));

        InetAddress[] naverInet = InetAddress.getAllByName("naver.com");
        for (InetAddress inet : naverInet) {
            System.out.println("NAVER IP : " + inet.getHostAddress());
        }

        System.out.println("=".repeat(40));


        InetAddress[] googleInet = InetAddress.getAllByName("google.com");
        for (InetAddress inet : googleInet) {
            System.out.println("google IP : " + inet.getHostAddress());
        }
    }
}
