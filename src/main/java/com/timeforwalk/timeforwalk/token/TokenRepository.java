package com.timeforwalk.timeforwalk.token;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TokenRepository extends JpaRepository<Token, Long> {

  Optional<Token> findByToken(String token);

  @Transactional
  @Modifying
  @Query("UPDATE Token c " +
      "SET c.confirmedAt = :#{#confirmedAt} " +
      "WHERE c.token = :#{#token}")
  int updateConfirmedAt(String token,
      LocalDateTime confirmedAt);
}
