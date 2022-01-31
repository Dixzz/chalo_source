package com.rabbitmq.client;

public class AuthenticationFailureException extends PossibleAuthenticationFailureException {
    public AuthenticationFailureException(String str) {
        super(str);
    }
}
