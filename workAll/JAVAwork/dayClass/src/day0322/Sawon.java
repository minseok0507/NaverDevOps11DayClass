package day0322;

public class Sawon {
    private String name;
    private int standard;
    private int money;

    //getter method
    public String getName() {
        return name;
    }

    public int getStandard() {
        return standard;
    }

    public int getMoney() {
        return money;
    }

    public void setSawon(String name, int standard, int money){
        setName(name);
        setStandard(standard);
        setMoney(money);

    }


    public int getNetPay(){
        int pay = 0;
        pay = standard - (int)(standard * 0.03) + money;

        return pay;
    }

    //setter method
    public void setName(String name) {
        this.name = name;
    }

    public void setStandard(int iStandard) {
        this.standard = iStandard;
    }

    public void setMoney(int iMoney) {
        this.money = iMoney;
    }
}
