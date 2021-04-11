package com.timeforwalk.timeforwalk.users;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public List<Users> getALlUsers(){
    return userRepository.findAll();
  }

  public long getUsersCount() {
    return userRepository.count();
  }

  public void addUser(Users user) {
    //TODO already exist
    userRepository.save(user);
  }
}
