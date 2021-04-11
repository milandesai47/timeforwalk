package com.timeforwalk.timeforwalk.users;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<Users> getAllUsers() {
    List<Users> users = userService.getALlUsers();
    return users;
  }

  @GetMapping("/count")
  public long getUsersCount() {
    return userService.getUsersCount();
  }

  @PostMapping
  public void addUser(@RequestBody Users user) {
    userService.addUser(user);
  }

  @DeleteMapping
  public void deleteUser(@RequestBody String email) {
    userService.deleteUser(email);
  }

}
