package server.zophop.test;

import com.rabbitmq.client.ConnectionFactory;
import java.lang.reflect.Array;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;
import server.zophop.dataLayer.Redis.RedisDBConfig;

public class RedisConnectionTest {
    private Connection client;

    @Test
    public void checkCloseable() {
        this.client.setHost(ConnectionFactory.DEFAULT_HOST);
        this.client.setPort((int) RedisDBConfig.PORT);
        this.client.connect();
        this.client.close();
    }

    @Test(expected = JedisConnectionException.class)
    public void checkUnkownHost() {
        this.client.setHost("someunknownhost");
        this.client.connect();
    }

    @Test(expected = JedisConnectionException.class)
    public void checkWrongPort() {
        this.client.setHost(ConnectionFactory.DEFAULT_HOST);
        this.client.setPort(55665);
        this.client.connect();
    }

    @Test
    public void connectIfNotConnectedWhenSettingTimeoutInfinite() {
        this.client.setHost(ConnectionFactory.DEFAULT_HOST);
        this.client.setPort((int) RedisDBConfig.PORT);
        this.client.setTimeoutInfinite();
    }

    @Test
    public void getErrorAfterConnectionReset() throws Exception {
        AnonymousClass1TestConnection r0 = new Connection() {
            /* class server.zophop.test.RedisConnectionTest.AnonymousClass1TestConnection */

            public void sendCommand(Protocol.Command command, byte[]... bArr) {
                RedisConnectionTest.super.sendCommand(command, bArr);
            }
        };
        try {
            Protocol.Command command = Protocol.Command.HMSET;
            int[] iArr = new int[2];
            iArr[1] = 0;
            iArr[0] = 1048577;
            r0.sendCommand(command, (byte[][]) Array.newInstance(byte.class, iArr));
        } catch (JedisConnectionException unused) {
        }
    }

    @Before
    public void setUp() throws Exception {
        this.client = new Connection();
    }

    @After
    public void tearDown() throws Exception {
        this.client.disconnect();
    }
}
