package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component
public class KoreanTire implements Tire {
    @Override
    public String getTireName() {
        return "KoreanTire";
    }
}
