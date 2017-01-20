package com.mycompany.kanban.mailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by antongusev on 21.11.16.
 */
@Service
public class SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public Future send(String messageText, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Test subject");
        message.setText(messageText);
        message.setTo(email);
        javaMailSender.send(message);
        return new AsyncResult<Void>(null);
    }

}
