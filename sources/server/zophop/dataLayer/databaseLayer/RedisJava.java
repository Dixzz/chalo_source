package server.zophop.dataLayer.databaseLayer;

import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.io.PrintStream;
import java.util.Calendar;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;
import server.zophop.dataLayer.Redis.JedisFactory;

public class RedisJava {
    public static void main(String[] strArr) {
        Jedis resource = JedisFactory.get_instance().getJedisPool().getResource();
        resource.set("1", "1");
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        pipelined(resource, 4000);
        System.out.println(Calendar.getInstance().getTimeInMillis() - timeInMillis);
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        multi(resource, 4000);
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis() - timeInMillis2;
        System.out.println(timeInMillis3);
        resource.disconnect();
        PrintStream printStream = System.out;
        printStream.println((DefaultRefreshIntervals.ACTIVE_CONV_MIN_FETCH_INTERVAL / timeInMillis3) + " ops");
        PrintStream printStream2 = System.out;
        StringBuilder i0 = hj1.i0("Server is running: ");
        i0.append(resource.ping());
        printStream2.println(i0.toString());
    }

    private static void multi(Jedis jedis, int i) {
        Transaction multi = jedis.multi();
        multi.sadd("foo", new String[]{"a"});
        multi.sadd("foo", new String[]{"b"});
        multi.scard("foo");
        multi.exec();
    }

    private static void pipelined(Jedis jedis, int i) {
        Pipeline pipelined = jedis.pipelined();
        for (int i2 = 0; i2 <= i; i2++) {
            String I = hj1.I("foo", i2);
            pipelined.set(I, hj1.I("bar", i2));
            pipelined.get(I);
        }
        pipelined.sync();
    }
}
