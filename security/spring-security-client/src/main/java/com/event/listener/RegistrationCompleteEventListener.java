package com.event.listener;

import com.entity.User;
import com.event.RegistrationCompleteEvent;
import com.services.Userservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private Userservice userservice;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userservice.saveVerificationTokenForUser(token, user);
        String url = event.getApplicationUrl()+"verifyRegistration?token="+token;
        log.info("Click to verify your account: {}", url);
    }
}
