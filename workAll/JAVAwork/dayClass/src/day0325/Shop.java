package day0325;

public class Shop {
    private String goods;
    private int value;
    private int price;

    Shop() {
        this("없음",0,0);
    }

    public Shop(String goods) {
        this(goods,0,0);
    }

    public Shop(int value, int price) {
        this("없음",value,price);
    }

    public Shop(String goods, int value, int price) {
        this.goods = goods;
        this.value = value;
        this.price = price;
    }

    public void setSangpum(String goods, int value, int price) {
        setGoods(goods);
        setValue(value);
        setPrice(price);
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPrice() {
        return price;
    }

    public int getValue() {
        return value;
    }

    public String getGoods() {
        return goods;
    }


}
