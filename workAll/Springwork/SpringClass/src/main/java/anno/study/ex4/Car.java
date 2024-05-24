package anno.study.ex4;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//public class Car {
//    private String carName;
//    private Tire tire;
//
//    public Car(Tire tire) {
//        this.tire = tire;
//    }
//
//    public void setCarName(String carName) {
//        this.carName = carName;
//    }
//
//    public void carInfo() {
//        System.out.println("자동차명 : " + carName);
//        System.out.println("타이어명 : " + tire.getTireName());
//    }
//}

//@Component
//public class Car {
//    @Value("아우디")
//    private String carName;
//    @Autowired
//    private KoreanTire tire;
//
//    public void carInfo() {
//        System.out.println("자동차명 : " + carName);
//        System.out.println("타이어명 : " + tire.getTireName());
//    }
//}

@Component
@RequiredArgsConstructor
public class Car {
    @Value("볼브")
    private String carName;
    @NonNull
    private CanadaTire tire;

    public void carInfo() {
        System.out.println("자동차명 : " + carName);
        System.out.println("타이어명 : " + tire.getTireName());
    }
}