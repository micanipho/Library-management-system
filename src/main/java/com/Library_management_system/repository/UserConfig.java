package com.Library_management_system.repository;

import com.Library_management_system.model.ApplicationUser;
import com.Library_management_system.security.ApplicationUserRole;
import com.Library_management_system.service.ApplicationUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

import static com.Library_management_system.security.ApplicationUserRole.ADMIN;

@Configuration
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationUserDao applicationUserDao) {
        return args -> {
            ApplicationUser user = new ApplicationUser(
                    "Nhlakanipho",
                    "Masilela",
                    "admin@gmail.com",
                    passwordEncoder.encode("admin"),
                    ADMIN
            );
            applicationUserDao.save(user);
        };
    }
}
