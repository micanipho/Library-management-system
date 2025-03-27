package com.Library_management_system.auth;

import com.Library_management_system.model.ApplicationUser;
import com.Library_management_system.security.ApplicationUserRole;
import com.Library_management_system.service.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final ApplicationUserService applicationUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Invalid email");
        }

        return applicationUserService.signUpUser(
                new ApplicationUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        ApplicationUserRole.STUDENT
                )
        );
    }
}
