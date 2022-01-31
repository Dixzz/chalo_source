package com.rabbitmq.client;

import com.rabbitmq.client.impl.LongStringHelper;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

public class JDKSaslConfig implements SaslConfig {
    private static final String[] DEFAULT_PREFERRED_MECHANISMS = {"PLAIN"};
    private final CallbackHandler callbackHandler;
    private final ConnectionFactory factory;
    private final List<String> mechanisms;

    public class JDKSaslMechanism implements SaslMechanism {
        private final SaslClient client;

        public JDKSaslMechanism(SaslClient saslClient) {
            this.client = saslClient;
        }

        @Override // com.rabbitmq.client.SaslMechanism
        public String getName() {
            return this.client.getMechanismName();
        }

        @Override // com.rabbitmq.client.SaslMechanism
        public LongString handleChallenge(LongString longString, String str, String str2) {
            try {
                return LongStringHelper.asLongString(this.client.evaluateChallenge(longString.getBytes()));
            } catch (SaslException e) {
                throw new RuntimeException((Throwable) e);
            }
        }
    }

    public class UsernamePasswordCallbackHandler implements CallbackHandler {
        private final ConnectionFactory factory;

        public UsernamePasswordCallbackHandler(ConnectionFactory connectionFactory) {
            this.factory = connectionFactory;
        }

        @Override // javax.security.auth.callback.CallbackHandler
        public void handle(Callback[] callbackArr) throws IOException, UnsupportedCallbackException {
            for (Callback callback : callbackArr) {
                if (callback instanceof NameCallback) {
                    ((NameCallback) callback).setName(this.factory.getUsername());
                } else if (callback instanceof PasswordCallback) {
                    ((PasswordCallback) callback).setPassword(this.factory.getPassword().toCharArray());
                } else {
                    throw new UnsupportedCallbackException(callback, "Unrecognized Callback");
                }
            }
        }
    }

    public JDKSaslConfig(ConnectionFactory connectionFactory) {
        this(connectionFactory, DEFAULT_PREFERRED_MECHANISMS);
    }

    @Override // com.rabbitmq.client.SaslConfig
    public SaslMechanism getSaslMechanism(String[] strArr) {
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        for (String str : this.mechanisms) {
            if (hashSet.contains(str)) {
                try {
                    SaslClient createSaslClient = Sasl.createSaslClient(new String[]{str}, (String) null, "AMQP", this.factory.getHost(), (Map) null, this.callbackHandler);
                    if (createSaslClient != null) {
                        return new JDKSaslMechanism(createSaslClient);
                    }
                } catch (SaslException e) {
                    throw new RuntimeException((Throwable) e);
                }
            }
        }
        return null;
    }

    public JDKSaslConfig(ConnectionFactory connectionFactory, String[] strArr) {
        this.factory = connectionFactory;
        this.callbackHandler = new UsernamePasswordCallbackHandler(connectionFactory);
        this.mechanisms = Arrays.asList(strArr);
    }
}
