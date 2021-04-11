package com.timeforwalk.timeforwalk.users;

import com.timeforwalk.timeforwalk.exception.BadRequestException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
    if(userExist) {
      throw new BadRequestException("Email already registered");
    }
    userRepository.save(user);
  }

  @Transactional
  public void deleteUser(String email) {
    email = email.replaceAll("^\"+|\"+$", "");
    boolean userExist = userRepository.findByEmail(email).isPresent();
    if(!userExist) {
      throw new BadRequestException("Data removal failed, No associated email found");
    }
    userRepository.deleteByEmail(email);
  }
}
