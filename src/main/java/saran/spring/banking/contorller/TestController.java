package saran.spring.banking.contorller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping
    public String test() {
        return "Hello spring boot";
    }

    @GetMapping("/test2")
    public String test2() {
        return "Hello spring boot test2";
    }
}
