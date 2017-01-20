package com.mycompany.kanban.mailservice.endpoint;

import com.mycompany.common.client.MailClient;
import com.mycompany.kanban.mailservice.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by antongusev on 13.11.16.
 */
@RestController
public class MailEndpoint implements MailClient {

    @Autowired
    private SendMailService mailService;

    @RequestMapping(value = "/send")
    public void send(@RequestParam String email, @RequestParam String messageText) {
        mailService.send(messageText, email);
    }

}
