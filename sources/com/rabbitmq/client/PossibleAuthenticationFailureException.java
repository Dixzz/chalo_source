package com.rabbitmq.client;

import java.io.IOException;

public class PossibleAuthenticationFailureException extends IOException {
    private static final long serialVersionUID = 1;

    public PossibleAuthenticationFailureException(Throwable th) {
        super("Possibly caused by authentication failure");
        super.initCause(th);
    }

    public PossibleAuthenticationFailureException(String str) {
        super(str);
    }
}
