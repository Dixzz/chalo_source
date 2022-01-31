package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import com.rabbitmq.client.SaslConfig;
import com.rabbitmq.client.SaslMechanism;
import java.util.Arrays;

public class CRDemoMechanism implements SaslMechanism {
    private static final String NAME = "RABBIT-CR-DEMO";
    private int round = 0;

    public static class CRDemoSaslConfig implements SaslConfig {
        @Override // com.rabbitmq.client.SaslConfig
        public SaslMechanism getSaslMechanism(String[] strArr) {
            if (Arrays.asList(strArr).contains(CRDemoMechanism.NAME)) {
                return new CRDemoMechanism();
            }
            return null;
        }
    }

    @Override // com.rabbitmq.client.SaslMechanism
    public String getName() {
        return NAME;
    }

    @Override // com.rabbitmq.client.SaslMechanism
    public LongString handleChallenge(LongString longString, String str, String str2) {
        int i = this.round + 1;
        this.round = i;
        if (i == 1) {
            return LongStringHelper.asLongString(str);
        }
        return LongStringHelper.asLongString("My password is " + str2);
    }
}
