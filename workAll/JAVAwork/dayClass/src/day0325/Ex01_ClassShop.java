package day0325;

public class Ex01_ClassShop {


    public static void main(String[] args) {
//        Shop[] myShop = new Shop[4];
//        myShop[0] = new Shop();
//        myShop[1] = new Shop("딸기");
//        myShop[2] = new Shop(3, 2000);
//        myShop[3] = new Shop("사과", 5, 3000);
        Shop[] myShop = {
                new Shop(),
                new Shop("딸기"),
                new Shop(3, 2000),
                new Shop("사과", 5, 3000)
        };

        showTitle();//제목 출력하는 method
        writeShop(myShop);

        System.out.println();
        System.out.println("0번의 상품명, 수량, 단가 변경");
        myShop[0].setGoods("포도");
        myShop[0].setValue(3);
        myShop[0].setPrice(2000);

        System.out.println("1번의 상품명, 수량, 단가 변경");
        myShop[0].setSangpum("오렌지", 5, 1200);

        System.out.println("변경된 값으로 다시 출력");
        showTitle();
        writeShop(myShop);

    }

    private static void writeShop(Shop[] myShop) {
        for (int i = 0; i < myShop.length; i++) {
            System.out.printf("%d번\t%4s\t%4d\t%4d\t%4d\n", i, myShop[i].getGoods(), myShop[i].getValue(), myShop[i].getPrice(), myShop[i].getValue() * myShop[i].getPrice());
        }
    }


    private static void showTitle() {
        System.out.printf("번호\t\t상품\t\t수량\t\t단가\t\t총금액\n");
    }
}
