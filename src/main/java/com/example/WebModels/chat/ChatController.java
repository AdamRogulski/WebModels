package com.example.WebModels.chat;

import com.example.WebModels.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @MessageMapping("/send/message")
    @SendTo("/chat")
    public String onReceivedMessage(@Payload String message, @Header("Authorization") String jwtToken){

        if (jwtToken !=null && jwtTokenUtil.validateJwtToken(jwtToken.replace("Token: ", ""))) {
            String username = jwtTokenUtil.getUsernameFromToken(jwtToken.replace("Token: ", ""));
            return new SimpleDateFormat("HH:mm:ss").format(new Date()) + " " + username + ": " + message;
            }
        else
            return null;
    }

}
