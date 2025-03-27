package com.Library_management_system.service;

import com.Library_management_system.model.ApplicationUser;
import com.Library_management_system.repository.ApplicationUserDao;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public String signUpUser(ApplicationUser applicationUser) {
        boolean userExists = applicationUserDao.findByEmail(applicationUser.getUsername())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("User already exists");
        }
        String hashedPassword = passwordEncoder.encode(applicationUser.getPassword());

        applicationUser.setPassword(hashedPassword);
        applicationUserDao.save(applicationUser);
        return "User registered successfully";
    }
}
