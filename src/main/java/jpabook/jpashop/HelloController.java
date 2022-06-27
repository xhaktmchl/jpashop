package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!"); // (데이터 속성 이름, 데이터 값)
        return "hello";// 반환 템플릿 페이지 이름 ex) hello.html 자동으로 요청
    }
}
