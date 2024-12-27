package backend.com.example.demo.dto.v1;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email; // Only email in V1
    private String password; // Only password in V1
}