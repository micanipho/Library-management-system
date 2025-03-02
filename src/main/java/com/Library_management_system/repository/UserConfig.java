package com.Library_management_system.repository;

import com.Library_management_system.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
         User nipho = new User(
              "Nipho",
              "0636639970",
              "student"
          );

         User khosi = new User(
                 "khosi",
                 "0795755795",
                 "student"
         );
         userRepository.saveAll(List.of(nipho, khosi));
        };
    }
}
