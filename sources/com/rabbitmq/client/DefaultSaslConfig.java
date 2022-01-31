package com.rabbitmq.client;

import com.rabbitmq.client.impl.ExternalMechanism;
import com.rabbitmq.client.impl.PlainMechanism;
import java.util.Arrays;
import java.util.HashSet;

public class DefaultSaslConfig implements SaslConfig {
    public static final DefaultSaslConfig EXTERNAL = new DefaultSaslConfig("EXTERNAL");
    public static final DefaultSaslConfig PLAIN = new DefaultSaslConfig("PLAIN");
    private final String mechanism;

    private DefaultSaslConfig(String str) {
        this.mechanism = str;
    }

    @Override // com.rabbitmq.client.SaslConfig
    public SaslMechanism getSaslMechanism(String[] strArr) {
        if (!new HashSet(Arrays.asList(strArr)).contains(this.mechanism)) {
            return null;
        }
        if (this.mechanism.equals("PLAIN")) {
            return new PlainMechanism();
        }
        if (this.mechanism.equals("EXTERNAL")) {
            return new ExternalMechanism();
        }
        return null;
    }
}
