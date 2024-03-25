package day0325;

public class Phone {
    public String model, color;

    public void bell(){
        System.out.println("벨이 울립니다.");
    }

    public void sendVoice(String msg){
        System.out.println("본 인 : " + msg);
    }

    public void receiveVoice(String msg){
        System.out.println("상대방 : " + msg);
    }

    public void hangUp(){
        System.out.println("전화를 끊습니다.");
    }


}
