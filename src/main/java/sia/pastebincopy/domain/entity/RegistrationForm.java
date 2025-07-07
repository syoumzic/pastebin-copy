package sia.pastebincopy.domain.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.pastebincopy.db.model.User;

@Data
public class RegistrationForm {
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String fullName;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullName);
    }
}
