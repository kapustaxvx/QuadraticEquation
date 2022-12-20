package com.quadraticequation;

import com.quadraticequation.model.entity.Role;
import com.quadraticequation.model.entity.User;
import com.quadraticequation.service.RoleService;
import com.quadraticequation.service.UserService;
import org.mapstruct.BeanMapping;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class QuadraticEquationApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuadraticEquationApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService){
        return args -> {
            roleService.saveRole(new Role(null, "ROLE_USER"));
            roleService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null,
                    "Ilia Moskalenko",
                    "imoskxvx",
                    "12345",
                    new HashSet<>()));
            userService.saveUser(new User(null,
                    "Gendos Rubtcov",
                    "marshak",
                    "12345",
                    new HashSet<>()));
            userService.saveUser(new User(null,
                    "Oleg Povaev",
                    "phowhy",
                    "12345",
                    new HashSet<>()));

            userService.addRoleToUser("imoskxvx", "ROLE_USER");
            userService.addRoleToUser("imoskxvx", "ROLE_ADMIN");
            userService.addRoleToUser("marshak", "ROLE_USER");
            userService.addRoleToUser("phowhy", "ROLE_USER");
        };
    }

}
