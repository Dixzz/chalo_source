package com.freshchat.consumer.sdk.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b {
    public static final String TAG = "com.freshchat.consumer.sdk.i.b";
    private static final BlockingQueue<Runnable> gV;
    public static final ThreadPoolExecutor gW;
    public static final Map<String, Integer> gX = new HashMap();

    static {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        gV = arrayBlockingQueue;
        gW = new ThreadPoolExecutor(5, 5, 30, TimeUnit.SECONDS, arrayBlockingQueue);
    }

    public static int aq(String str) {
        Integer num = gX.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}
