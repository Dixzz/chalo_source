package com.rabbitmq.client.test.ssl;

import com.rabbitmq.client.ConnectionFactory;
import junit.framework.TestCase;
import org.junit.Assert;

public class ConnectionFactoryDefaultTlsVersion extends TestCase {
    private ConnectionFactory connectionFactory = new ConnectionFactory();

    public void testDefaultTlsVersionJdk16ShouldTakeFallback() {
        Assert.assertEquals("TLSv1", ConnectionFactory.computeDefaultTlsProcotol(new String[]{"SSLv2Hello", "SSLv3", "TLSv1"}));
    }

    public void testDefaultTlsVersionJdk17ShouldTakePrefered() {
        Assert.assertEquals("TLSv1.2", ConnectionFactory.computeDefaultTlsProcotol(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
    }

    public void testDefaultTlsVersionJdk18ShouldTakePrefered() {
        Assert.assertEquals("TLSv1.2", ConnectionFactory.computeDefaultTlsProcotol(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
    }
}
