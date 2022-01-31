package server.zophop.dataLayer.databaseLayer;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import server.zophop.dataLayer.Redis.JedisFactory;

public class RedisJavaTest {
    public final byte[] ba = {10};
    public final byte[] bb = {11};
    public final byte[] bbar = {5, 6, 7, 8};
    public final byte[] bfoo = {1, 2, 3, 4};

    @Test
    public void testGetConnection() {
        Jedis resource = JedisFactory.get_instance().getJedisPool().getResource();
        resource.flushAll();
        Transaction multi = resource.multi();
        multi.sadd("foo", new String[]{"a"});
        multi.sadd("foo", new String[]{"b"});
        multi.scard("foo");
        List exec = multi.exec();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1L);
        arrayList.add(1L);
        arrayList.add(2L);
        TestCase.assertEquals(arrayList, exec);
        Transaction multi2 = resource.multi();
        multi2.sadd(this.bfoo, new byte[][]{this.ba});
        multi2.sadd(this.bfoo, new byte[][]{this.bb});
        multi2.scard(this.bfoo);
        List exec2 = multi2.exec();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(1L);
        arrayList2.add(1L);
        arrayList2.add(2L);
        TestCase.assertEquals(arrayList2, exec2);
    }
}
