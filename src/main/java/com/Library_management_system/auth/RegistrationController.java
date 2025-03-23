package com.Library_management_system.auth;

import com.Library_management_system.model.ApplicationUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "lms/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {


    private RegistrationService registrationService;

    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
