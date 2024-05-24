package anno.study.ex5;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Emp {
    @NonNull
    private Sawon sawon;
    @Value("google")
    private String empName;
    @Value("2024-12-01")
    private String innerDay;

    public void sawonInfo(){
        System.out.println("** 사원 정보 **");
        System.out.println("입사일 : " + innerDay);
        System.out.println("회사명 : " + empName);
        System.out.println("사원명 : " + sawon.getName());
        System.out.println("주 소 : " + sawon.getAddr());
        System.out.println("나 이 : " + sawon.getAge());
    }
}
