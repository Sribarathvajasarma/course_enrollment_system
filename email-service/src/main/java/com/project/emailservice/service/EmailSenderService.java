package com.project.emailservice.service;

import com.project.emailservice.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(EmailRequest emailRequest){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(emailRequest.getFrom());
        message.setTo(emailRequest.getTo());
        message.setText(emailRequest.getMessage());
        message.setSubject(emailRequest.getSubject());

        mailSender.send(message);
        System.out.println("Mail Send...");
    }
}
