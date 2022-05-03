package com.basic.auth.service;

import com.basic.auth.model.AppResponse;
import com.basic.auth.model.PhoneNumber;
import com.basic.auth.model.UserMessage;
import com.basic.auth.repository.PhoneNumberRepository;
import com.basic.auth.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageService {
    // Autowire: enables you to inject the object dependency implicitly
    // Autowire the Accounts repository
    @Autowired
    private UserAccountRepository userAccountRepository;

    // Autowire the Phone Number
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    // Validate the number existance.
    // Make sure the authenticated user has the to number.
    // Check the TO number, return appropraite response.
    public AppResponse processInbound(UserMessage message, long userId){
        // Find the phone number if it exist
        PhoneNumber phoneNumber = phoneNumberRepository.findByNumber(message.getTo());
        if(phoneNumber == null)
            return new AppResponse("", "To parameter not found");
//
        if(phoneNumber.getAccount().getId() != userId)
            return new AppResponse("", "To parameter not found");

        // Count the number of time saved in Redis

        // Save in tredis

        return new AppResponse("inbound sms ok", "");
    }
    
     public AppResponse processOutbound(UserMessage message, long userId){
        // Find the phone number if it exist
        PhoneNumber phoneNumber = phoneNumberRepository.findByNumber(message.getTo());
        if(phoneNumber == null)
            return new AppResponse("", "To parameter not found");
//
        if(phoneNumber.getAccount().getId() != userId)
            return new AppResponse("", "To parameter not found");

        // Count the number of time saved in Redis

        // Save in tredis

        return new AppResponse("inbound sms ok", "");
    }

}
