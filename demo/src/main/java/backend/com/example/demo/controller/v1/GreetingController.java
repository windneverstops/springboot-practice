package backend.com.example.demo.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greet() {
        return "Hello, World!";
    }
}
