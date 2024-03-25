package day0325;

public class Ex03_ClassEmployee {

    public static void main(String[] args) {
        Employee []em = {
                new Employee(),
                new Employee("강호동","사원",30),
                new Employee("유재석","과장",42),
                new Employee("이영자","차장",45),
                new Employee("손미나",23),
        };

        em[0].setName("이광수");
        em[0].setPosition("사원");
        em[0].setAge(29);
        em[0].setGibon(340);
        em[0].setSudang(23);

        em[1].setPay(450, 100);//기본급, 수당
        em[2].setSawon("유재남","계장",41);
        em[2].setPay(410, 80);
        em[3].setPay(560, 120);

        em[4].setPosition("사원");
        em[4].setPay(289, 67);


        showTitle();
        for (int i = 0; i < em.length; i++) {
            System.out.println((i+1) + "\t" + em[i].getName() + "\t" + em[i].getPosition() + "\t" + em[i].getAge() +
                    "\t" + em[i].getGibon() + "\t\t" + em[i].getSudang() + "\t" + em[i].getNetPay());
        }

    }


    private static void showTitle() {
        System.out.printf("번호\t이름\t\t직급\t나이\t기본급\t수당\t페이\n");
    }


}
