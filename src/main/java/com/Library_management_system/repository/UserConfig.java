package com.Library_management_system.repository;

import com.Library_management_system.model.ApplicationUser;
import com.Library_management_system.security.ApplicationUserRole;
import com.Library_management_system.service.ApplicationUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(ApplicationUserDao applicationUserDao) {
        return args -> {
            ApplicationUser user = new ApplicationUser(
                    "Nhlakanipho",
                    "Masilela",
                    "admin@gmail.com",
                    "admin",
                    ApplicationUserRole.ADMIN
            );
            applicationUserDao.save(user);
        };
    }
}
