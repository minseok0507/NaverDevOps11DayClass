package anno.study.ex6;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
    private String name;
    private int count;
    private int price;

}
