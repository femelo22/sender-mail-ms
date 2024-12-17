package br.com.lfmelo.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.lfmelo.entities.Email;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailSender {

  private final JavaMailSender mailSender;

  public EmailSender(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void sendEmail(Email email) {
    var message = new SimpleMailMessage();

    message.setFrom("noreply@email.com");
    message.setTo(email.to());
    message.setSubject(email.subject());
    message.setText(email.body());

    try {
      mailSender.send(message);
      log.info("Email enviado para {} - {}", email.to(), email.subject());
    } catch (Exception e) {
      throw new RuntimeException("Erro ao enviar email", e);
    }
    
  }
}
