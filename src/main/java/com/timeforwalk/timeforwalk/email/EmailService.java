package com.timeforwalk.timeforwalk.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{

  private final JavaMailSender javaMailSender;

  @Override
  @Async
  public void send(String to, String email) throws IllegalAccessException {
    try {
      MimeMessage mimeMessage = javaMailSender.createMimeMessage();
      MimeMessageHelper helper= new MimeMessageHelper(mimeMessage, "utf-8");
      helper.setText(email, true);
      helper.setTo(to);
      helper.setSubject("Please confirm registration");
      helper.setFrom("noreply@timeforwalk.com");
      javaMailSender.send(mimeMessage);
    } catch (MessagingException me) {
      throw new IllegalAccessException("");
    }
  }
}
