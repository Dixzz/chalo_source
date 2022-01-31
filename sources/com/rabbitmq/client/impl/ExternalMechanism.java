package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import com.rabbitmq.client.SaslMechanism;

public class ExternalMechanism implements SaslMechanism {
    @Override // com.rabbitmq.client.SaslMechanism
    public String getName() {
        return "EXTERNAL";
    }

    @Override // com.rabbitmq.client.SaslMechanism
    public LongString handleChallenge(LongString longString, String str, String str2) {
        return LongStringHelper.asLongString("");
    }
}
