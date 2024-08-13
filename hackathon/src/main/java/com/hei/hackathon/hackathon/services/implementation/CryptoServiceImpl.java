package com.hei.hackathon.hackathon.services.implementation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptoServiceImpl {

    public static String encrypts(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
