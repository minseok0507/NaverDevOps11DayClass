package anno.study.ex5;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Sawon {
    @Value("minseok")
    private String name;
    @Value("중산동")
    private String addr;
    @Value("24")
    private int age;
}
