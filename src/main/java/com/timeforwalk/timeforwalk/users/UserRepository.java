package com.timeforwalk.timeforwalk.users;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
  Optional<Users> findByEmail(String email);

  void deleteByEmail(String email);

  @Transactional
  @Modifying
  @Query
      ("UPDATE Users a " +
      "SET a.enabled = TRUE WHERE a.email = ?1")
  void enableAppUser(String email);
}
