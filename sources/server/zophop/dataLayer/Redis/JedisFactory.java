package server.zophop.dataLayer.Redis;

import j$.time.Duration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisFactory {
    private static volatile JedisFactory _instance;
    private static JedisPool _jedisPool;
    public final JedisPoolConfig _poolConfig;

    public JedisFactory() {
        JedisPoolConfig buildPoolConfig = buildPoolConfig();
        this._poolConfig = buildPoolConfig;
        _jedisPool = new JedisPool(buildPoolConfig, RedisDBConfig.HOST, (int) RedisDBConfig.PORT, 10000, RedisDBConfig.PASSWORD);
    }

    private JedisPoolConfig buildPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(50);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        jedisPoolConfig.setNumTestsPerEvictionRun(3);
        jedisPoolConfig.setBlockWhenExhausted(true);
        return jedisPoolConfig;
    }

    public static synchronized JedisFactory get_instance() {
        JedisFactory jedisFactory;
        synchronized (JedisFactory.class) {
            if (_instance == null) {
                _instance = new JedisFactory();
            }
            jedisFactory = _instance;
        }
        return jedisFactory;
    }

    public JedisPool getJedisPool() {
        return _jedisPool;
    }
}
