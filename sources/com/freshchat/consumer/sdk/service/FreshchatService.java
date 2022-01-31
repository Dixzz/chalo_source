package com.freshchat.consumer.sdk.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.b.b;
import com.freshchat.consumer.sdk.service.b.c;
import com.freshchat.consumer.sdk.service.e.i;
import com.freshchat.consumer.sdk.service.e.j;
import java.util.LinkedList;
import java.util.Queue;

public class FreshchatService extends IntentService {
    private static Queue<c> fn = new LinkedList();
    private static Queue<c> fo = new LinkedList();
    private int fp = 0;
    public b fq = new b();

    public FreshchatService() {
        super("FreshchatService");
    }

    public static void a(Context context, j jVar, a aVar) {
        fn.add(new c(jVar, aVar));
        r(context);
    }

    private static void a(Queue<c> queue, c cVar) {
        if (queue.contains(cVar)) {
            queue.remove(cVar);
        }
    }

    public static void bk(Context context) {
        try {
            fn.clear();
            fo.clear();
        } catch (Exception e) {
            q.a(e);
        }
    }

    private static void r(Context context) {
        try {
            context.startService(new Intent(context, FreshchatService.class));
        } catch (Exception e) {
            ai.w("FRESHCHAT", e.getMessage());
        }
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        StringBuilder i0 = hj1.i0("Service processed ");
        i0.append(this.fp);
        i0.append(" messages");
        ai.d("FRESHCHAT", i0.toString());
    }

    public void onHandleIntent(Intent intent) {
        Queue<c> queue;
        while (true) {
            try {
                if (fn.peek() != null || fo.peek() != null) {
                    c peek = fn.peek();
                    if (peek == null) {
                        peek = fo.peek();
                        if (peek != null) {
                            this.fq.b(getApplicationContext(), peek.dv(), peek.du());
                            this.fp++;
                            queue = fo;
                        }
                    } else if (peek.dv() instanceof i) {
                        fo.add(fn.remove());
                    } else {
                        ai.d("Service", "Processing message " + peek.dv().getClass());
                        this.fq.b(getApplicationContext(), peek.dv(), peek.du());
                        this.fp = this.fp + 1;
                        queue = fn;
                    }
                    a(queue, peek);
                } else {
                    return;
                }
            } catch (Exception e) {
                q.a(e);
                return;
            }
        }
    }
}
