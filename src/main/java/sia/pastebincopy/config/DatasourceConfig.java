package sia.pastebincopy.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.pastebincopy.db.model.User;
import sia.pastebincopy.db.repository.UserRepository;

@Configuration
public class DatasourceConfig {

    @Bean
    @Profile("dev")
    public CommandLineRunner userLoader(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            userRepo.save(new User("user1", passwordEncoder.encode("password")));
            userRepo.save(new User("user2", passwordEncoder.encode("password")));
        };
    }
}
