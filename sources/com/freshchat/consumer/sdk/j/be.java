package com.freshchat.consumer.sdk.j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class be {
    private static be lH;
    private final Executor lI;
    private final Executor lJ;
    private final Executor lK;

    public static class a implements Executor {
        private Handler lL;

        private a() {
            this.lL = new Handler(Looper.getMainLooper());
        }

        public void execute(Runnable runnable) {
            this.lL.post(runnable);
        }
    }

    private be() {
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(10), new a());
    }

    private be(Executor executor, Executor executor2, Executor executor3) {
        this.lI = executor;
        this.lJ = executor2;
        this.lK = executor3;
    }

    public static be eC() {
        if (lH == null) {
            synchronized (be.class) {
                if (lH == null) {
                    lH = new be();
                }
            }
        }
        return lH;
    }

    public Executor gF() {
        return this.lK;
    }

    public Executor gZ() {
        return this.lJ;
    }

    public Executor gx() {
        return this.lI;
    }
}
