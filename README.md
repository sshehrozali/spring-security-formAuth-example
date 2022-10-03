## Overview
The application is designed to demonstrate the most common use of **Spring Security** using the **BasicAuth** pattern to allow authentication to different users in the system. Checkout the `ApplicationSecurityConfig` class to better understand the behaviour of BasicAuth pattern.

### BasicAuth
The BasicAuth is the most common approach to easily introduce authentication into your system by securing your endpoints (except those who you whitelist explicitly using `.antMatchers()` and `.permitAll()`). It works by sending _username_ and _password_ in request headers using **Base64** which then server reads to match with stored username and password.

* #### `InMemoryUserDetailsManager`
The application currently uses this method to store multiple `UserDetails` objects and stores it in-memory. This means that when the system starts it is stored **in-memory** i.e. no persistence maintained over entire life-time.

* #### `BCryptPasswordEncoder`
The application uses this method to encode plain raw password and then store the `UserDetails` in-memory as forced by Spring Security. Checkout `PasswordConfig` class to understand the usage. The `PasswordEncoder` is injected into `ApplicationSecurityConfig` class via constructor-based approach annotated with `@Autowired`. The `UserDetails.builder().password()` is passed `passwordEncoder.encode(_your-password_)` which encrypts the password and then stores it in-memory.