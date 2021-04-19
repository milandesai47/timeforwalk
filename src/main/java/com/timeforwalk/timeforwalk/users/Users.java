package com.timeforwalk.timeforwalk.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Users {
  @Id
  @SequenceGenerator(
      name = "user_sequence",
      sequenceName = "user_sequence"
  )
  @GeneratedValue(
      generator = "user_sequence",
      strategy = GenerationType.SEQUENCE
  )
  private Long id;
  private String name;
  private String email;
  private int probability;
  private boolean enabled = false;

  public Users(String name, String email, int probability) {
    this.name = name;
    this.email = email;
    this.probability = probability;
  }
}
