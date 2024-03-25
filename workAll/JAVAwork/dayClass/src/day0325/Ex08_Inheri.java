package day0325;

class Phone2{
    private String model, color;

    public Phone2(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class SmartPhone2 extends Phone2{
    private String wifi;

    public SmartPhone2(String model, String color, String wifi){
        super(model,color);
        this.wifi = wifi;
    }

    public void info(){
        System.out.println("모델명 : " + this.getModel());
        System.out.println("색 상 : " + this.getColor());
        System.out.println("통신사 : " + wifi);
        System.out.println();
    }

}

public class Ex08_Inheri {
    public static void main(String[] args) {
        SmartPhone2 sp1 = new SmartPhone2("겔럭시", "은색", "KT");
        sp1.info();

        SmartPhone2 sp2 = new SmartPhone2("아이폰14", "화이트", "SK");
        sp2.info();
    }
}
