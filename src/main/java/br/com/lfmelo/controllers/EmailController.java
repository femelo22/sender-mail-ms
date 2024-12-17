package br.com.lfmelo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lfmelo.entities.Email;
import br.com.lfmelo.services.EmailSender;

@RestController
@RequestMapping("/send-notification")
public class EmailController {
  
  @Autowired
  private EmailSender emailSender;

  @PostMapping
  public ResponseEntity<String> sendMailNotification(@RequestBody Email email) {
    emailSender.sendEmail(email);
    return ResponseEntity.ok("Email enviado com sucesso!");
  }
}
