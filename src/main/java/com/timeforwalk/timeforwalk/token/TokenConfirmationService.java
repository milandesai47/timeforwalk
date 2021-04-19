package com.timeforwalk.timeforwalk.token;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenConfirmationService {

  private final TokenRepository tokenRepository;

  public void saveToken(Token token) {
    tokenRepository.save(token);
  }

  public Optional<Token> getToken(String token) {
    return tokenRepository.findByToken(token);
  }

  public int setConfirmedAt(String token) {
    return tokenRepository.updateConfirmedAt(token, LocalDateTime.now());
  }

}
