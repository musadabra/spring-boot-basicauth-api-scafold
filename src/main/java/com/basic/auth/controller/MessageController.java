package com.basic.auth.controller;


import com.basic.auth.model.AppResponse;
import com.basic.auth.model.UserMessage;
import com.basic.auth.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author mdabra
 */

@RestController
@ControllerAdvice
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private UserMessageService userMessageService;

    @PostMapping("/inbound/sms")
    public ResponseEntity<AppResponse> inbound(@Validated @RequestBody UserMessage message){
        long userId = 1;
        AppResponse response = userMessageService.processInbound(message, userId);
        if(response.getError() != "")
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/outbound/sms")
    public ResponseEntity<AppResponse> outbound(@Validated @RequestBody UserMessage message) {
        long userId = 1;
        AppResponse response = userMessageService.processOutbound(message, userId);
        if(response.getError() != "")
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(response);
    }
}
