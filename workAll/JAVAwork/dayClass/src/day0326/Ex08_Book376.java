package day0326;

interface Tire{
    public void roll();
}

class HankookTire implements Tire{
    @Override
    public void roll() {
        System.out.println("한국타이어");
    }
}

class KumhoTire implements Tire{
    @Override
    public void roll() {
        System.out.println("금호타이어");
    }
}

class Car{
    Tire tire1= new HankookTire();
    Tire tire2= new HankookTire();

    public void run(){
        tire1.roll();
        tire2.roll();
    }

}


public class Ex08_Book376 {
    public static void main(String[] args) {
        Car c = new Car();

        c.run();

        c.tire1 = new KumhoTire();
        c.tire2 = new KumhoTire();

        c.run();
    }
}
