package day0520.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodDto {
    private String name;
    private String photo;
    private int price;
    private int count;
}
