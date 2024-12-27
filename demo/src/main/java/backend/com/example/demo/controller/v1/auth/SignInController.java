package backend.com.example.demo.controller.v1.auth;

import backend.com.example.demo.dto.v1.UserDto;
import backend.com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class SignInController {

    private final UserService userService;

    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody UserDto userDto){
        userService.authenticateUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body("User signed in successfully");
    }

}
