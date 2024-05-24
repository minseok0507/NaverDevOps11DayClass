package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Data
public class ShopDto {
    private int id;
    private String name;
    private String photo;
    private int price;
    private int count;
}
