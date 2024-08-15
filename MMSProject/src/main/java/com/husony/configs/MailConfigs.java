/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.configs;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Do Gia Huy
 */


import java.util.Properties;

@Configuration
public class MailConfigs {
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "465";
    private static final String SMTP_AUTH = "true";
    private static final String SMTP_SOCKET_FACTORY_PORT = "465";
    private static final String SMTP_SOCKET_FACTORY_CLASS = "javax.net.ssl.SSLSocketFactory";

    private static final String USERNAME = "dohuy4547@gmail.com";  // Thay đổi thành email của bạn
    private static final String PASSWORD = "fmhu gltf mnrn vwrs";   // Thay đổi thành mật khẩu ứng dụng của bạn

    @Bean
    public Session mailSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.auth", SMTP_AUTH);
        properties.put("mail.smtp.socketFactory.port", SMTP_SOCKET_FACTORY_PORT);
        properties.put("mail.smtp.socketFactory.class", SMTP_SOCKET_FACTORY_CLASS);

        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
    }
    
}

