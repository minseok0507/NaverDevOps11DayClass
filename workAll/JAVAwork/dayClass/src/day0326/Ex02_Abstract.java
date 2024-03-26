package day0326;

abstract class AbsEx1{
    abstract public void play();
}

abstract class AbsEx2 extends AbsEx1{
    @Override
    public void play() {
        System.out.println("PLAY GAME");
    }
    abstract public void study();
}

class AbsEx3 extends AbsEx2{
    @Override
    public void study() {
        System.out.println("STUDYING");
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Abst3 PLAY GAME");
    }
}

public class Ex02_Abstract {
    public static void main(String[] args) {
        AbsEx2 a = new AbsEx3();
        a.play();
        a.study();
    }
}
