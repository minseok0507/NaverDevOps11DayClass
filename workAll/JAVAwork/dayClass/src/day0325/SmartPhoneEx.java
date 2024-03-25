package day0325;

public class SmartPhoneEx {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("갤럭시", "은색");

        System.out.println("모델 : " + myPhone.model);
        System.out.println("색상 : " + myPhone.color);

        System.out.println("와이파이 상태 : " + myPhone.wifi);

        myPhone.bell();
        myPhone.sendVoice("hi");
        myPhone.receiveVoice("im hong");
        myPhone.sendVoice("oh hi");

        myPhone.hangUp();

        myPhone.setWifi(true);
        myPhone.internet();
    }
}
