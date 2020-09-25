package com.ualbany.daneeats.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
