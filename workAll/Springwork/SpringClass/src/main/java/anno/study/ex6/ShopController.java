package anno.study.ex6;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ShopController {
    ShopDao dao = new ShopDao();

    public void insert(String name, int count, int price) {
        ShopDto shop = new ShopDto(name, count, price);
        dao.insert(shop);

        dao.selectAll();
    }
    public void delete(String name) {
        dao.delete(name);

        dao.selectAll();
    }

    public void update(String name, int count, int price) {
        ShopDto dto = new ShopDto();
        dto.setName(name);
        dto.setCount(count);
        dto.setPrice(price);
        dao.update(dto);

        dao.selectAll();
    }
}
