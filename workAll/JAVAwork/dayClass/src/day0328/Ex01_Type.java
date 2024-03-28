package day0328;

//<T>는 T가 타입 파라미터를 뜻하는 기호, 타입이 필요한 지라에 T 사용
class GenericType<T> {
    T[] v;

    public void setV(T[] v) {
        this.v = v;
    }

    public void print() {
        for (T s : v) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

public class Ex01_Type {
    public static void main(String[] args) {
        String[] s = {"장미꽃", "안개꽃", "국화꽃", "후리지아"};
        Integer[] n = {100, 98, 51, 78};
        Double[] d = {35.5, 24.6, 12.61};

        GenericType<String> gt1 = new GenericType<>();
        gt1.setV(s);
        gt1 .print();

        GenericType<Integer> gt2 = new GenericType<>();
        gt2.setV(n);
        gt2.print();

        GenericType<Double> gt3 = new GenericType<>();
        gt3.setV(d);
        gt3.print();
    }
}
