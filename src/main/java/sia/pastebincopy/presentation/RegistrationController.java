package sia.pastebincopy.presentation;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.pastebincopy.db.repository.UserRepository;
import sia.pastebincopy.domain.entity.RegistrationForm;

@Slf4j
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String register(@Valid RegistrationForm form, Errors errors){

        if(errors.hasFieldErrors() || !form.getPassword().equals(form.getConfirmPassword())){
            return "registration";
        }

        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}