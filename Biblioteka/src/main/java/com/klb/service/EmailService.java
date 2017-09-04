package com.klb.service;

/**
 * Created by Michał Makaruk on 08.07.2017.
 */
public interface EmailService {
    void sendEmail(String fromAdress, String toAddress, String subject, String body);
}
