package day0326;

interface StudyInter{
    public void javaStudy();
    public void springStudy();
}
interface PlayInter{
    public void run();
    public void game();

}

class MyStudy implements StudyInter{
    @Override
    public void javaStudy() {
        System.out.println("JAVA STUDY");
    }

    @Override
    public void springStudy() {
        System.out.println("SPRING STUDY");
    }
}

class MyPlay implements PlayInter{
    @Override
    public void run() {
        System.out.println("RUN");
    }

    @Override
    public void game() {
        System.out.println("PLAY GAME");
    }
}
public class Ex07_Interface {
    static public void study(StudyInter sdyIn){
        sdyIn.springStudy();
        sdyIn.javaStudy();
    }
    static public void play(PlayInter plyIn){
        plyIn.run();
        plyIn.game();
    }
    public static void main(String[] args) {
        study(new MyStudy());
        play(new MyPlay());
    }
}
