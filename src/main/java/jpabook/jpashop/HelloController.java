package jpabook.jpashop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
//   Model에 데이터를 실어서 넘기는 요소
    public String Hello(Model model){
//       스프링 부트가 타임리프로 매핑 시켜준다.
//       resources:teplates/{ViewName}+.html
        model.addAttribute("data","Hello!");
        return "hello";
    }
}
