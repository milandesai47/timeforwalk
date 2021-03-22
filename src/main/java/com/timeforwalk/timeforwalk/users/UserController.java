package com.timeforwalk.timeforwalk.users;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

  @GetMapping
  public List<User> getAllUsers() {
    List<User> users = Arrays.asList(
        new User(1L, "Milan", "Milan@gmail.com", 40),
        new User(2L, "Ankita", "Ankita@gmail.com", 30)
    );
    return users;
  }

}
