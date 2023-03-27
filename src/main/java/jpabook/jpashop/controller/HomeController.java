package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {


    @RequestMapping("/")
    public String home(){

//      로그를 확인해보고 이후에 뷰에서 문제가 발생했구나 판단.
        log.info("home controller");
//       자동적으로  tymeleaf> home.html로 가진다.
        return "home";
    }
}
