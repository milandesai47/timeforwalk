package com.timeforwalk.timeforwalk.email;

public interface EmailSender {
  void send(String to, String email) throws IllegalAccessException;
}
