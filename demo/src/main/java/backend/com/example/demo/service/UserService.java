package backend.com.example.demo.service;

import backend.com.example.demo.dto.v1.UserDto;
import backend.com.example.demo.model.User;
import backend.com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void registerUser(UserDto userDto){
        if (userRepository.findByEmail(userDto.getEmail()) != null){
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    public String authenticateUser(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
