package anno.study.ex6;

import org.springframework.stereotype.Component;

@Component
public class ShopDao {
    public void insert(ShopDto dto){
        System.out.println("데이터 추가");
        System.out.println(dto.toString());
    }

    public void delete(String name){
        System.out.println(name + " 상품을 삭제하였습니다.");
    }

    public void update(ShopDto dto){
        System.out.println("데이터 추가");
        System.out.println(dto.toString());
    }

    public void selectAll(){
        System.out.println("전체 상품 출력");
    }
}
