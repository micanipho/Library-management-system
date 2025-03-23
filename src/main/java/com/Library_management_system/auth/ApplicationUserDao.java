package com.Library_management_system.auth;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> findByUsername(String username);
}
