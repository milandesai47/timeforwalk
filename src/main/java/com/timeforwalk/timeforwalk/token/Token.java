package com.timeforwalk.timeforwalk.token;

import com.timeforwalk.timeforwalk.users.Users;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Token {

  @Id
  @SequenceGenerator(
      name = "token_sequence",
      sequenceName = "token_sequence"
  )
  @GeneratedValue(
      generator = "token_sequence",
      strategy = GenerationType.SEQUENCE
  )
  private Long id;
  @Column(nullable = false)
  private String token;
  @ManyToOne
  @JoinColumn(
      nullable = false,
      name = "users_id"
  )
  private Users user;
  private LocalDateTime createdAt;
  private LocalDateTime expiresAt;
  private LocalDateTime confirmedAt;

  public Token(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Users user) {
    this.token = token;
    this.createdAt = createdAt;
    this.expiresAt = expiresAt;
    this.user = user;
  }
}
