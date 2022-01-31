package defpackage;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* renamed from: te5  reason: default package */
/* compiled from: Dispatcher */
public class te5 {

    /* renamed from: a  reason: collision with root package name */
    public final b f3341a;
    public final Context b;
    public final ExecutorService c;
    public final ue5 d;
    public final Map<String, ne5> e = new LinkedHashMap();
    public final Map<Object, le5> f = new WeakHashMap();
    public final Map<Object, le5> g = new WeakHashMap();
    public final Set<Object> h = new LinkedHashSet();
    public final Handler i;
    public final Handler j;
    public final oe5 k;
    public final nf5 l;
    public final List<ne5> m;
    public final c n;
    public final boolean o;
    public boolean p;

    /* renamed from: te5$a */
    /* compiled from: Dispatcher */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final te5 f3342a;

        /* renamed from: te5$a$a  reason: collision with other inner class name */
        /* compiled from: Dispatcher */
        public class RunnableC0054a implements Runnable {
            public final /* synthetic */ Message f;

            public RunnableC0054a(a aVar, Message message) {
                this.f = message;
            }

            public void run() {
                StringBuilder i0 = hj1.i0("Unknown handler message received: ");
                i0.append(this.f.what);
                throw new AssertionError(i0.toString());
            }
        }

        public a(Looper looper, te5 te5) {
            super(looper);
            this.f3342a = te5;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:176:0x0034 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:178:0x0034 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v62, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v39, types: [android.os.Handler] */
        /* JADX WARN: Type inference failed for: r3v63 */
        /* JADX WARN: Type inference failed for: r3v64, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v67 */
        /* JADX WARN: Type inference failed for: r3v68 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r17) {
            /*
            // Method dump skipped, instructions count: 1040
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.te5.a.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: te5$b */
    /* compiled from: Dispatcher */
    public static class b extends HandlerThread {
        public b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* renamed from: te5$c */
    /* compiled from: Dispatcher */
    public static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final te5 f3343a;

        public c(te5 te5) {
            this.f3343a = te5;
        }

        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra(RemoteConfigConstants.ResponseFieldKey.STATE)) {
                        te5 te5 = this.f3343a;
                        boolean booleanExtra = intent.getBooleanExtra(RemoteConfigConstants.ResponseFieldKey.STATE, false);
                        Handler handler = te5.i;
                        handler.sendMessage(handler.obtainMessage(10, booleanExtra ? 1 : 0, 0));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    StringBuilder sb = rf5.f3076a;
                    te5 te52 = this.f3343a;
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    Handler handler2 = te52.i;
                    handler2.sendMessage(handler2.obtainMessage(9, activeNetworkInfo));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public te5(android.content.Context r6, java.util.concurrent.ExecutorService r7, android.os.Handler r8, defpackage.ue5 r9, defpackage.oe5 r10, defpackage.nf5 r11) {
        /*
        // Method dump skipped, instructions count: 159
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.te5.<init>(android.content.Context, java.util.concurrent.ExecutorService, android.os.Handler, ue5, oe5, nf5):void");
    }

    public final void a(ne5 ne5) {
        Future<?> future = ne5.s;
        if (!(future != null && future.isCancelled())) {
            Bitmap bitmap = ne5.r;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.m.add(ne5);
            if (!this.i.hasMessages(7)) {
                this.i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    public void b(ne5 ne5) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, ne5));
    }

    public void c(ne5 ne5) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, ne5));
    }

    public void d(ne5 ne5, boolean z) {
        if (ne5.g.n) {
            String c2 = rf5.c(ne5);
            StringBuilder i0 = hj1.i0("for error");
            i0.append(z ? " (will replay)" : "");
            rf5.f("Dispatcher", "batched", c2, i0.toString());
        }
        this.e.remove(ne5.k);
        a(ne5);
    }

    public void e(le5 le5, boolean z) {
        if (this.h.contains(le5.j)) {
            this.g.put(le5.d(), le5);
            if (le5.f2204a.n) {
                String b2 = le5.b.b();
                StringBuilder i0 = hj1.i0("because tag '");
                i0.append(le5.j);
                i0.append("' is paused");
                rf5.f("Dispatcher", "paused", b2, i0.toString());
                return;
            }
            return;
        }
        ne5 ne5 = this.e.get(le5.i);
        if (ne5 != null) {
            boolean z2 = ne5.g.n;
            jf5 jf5 = le5.b;
            if (ne5.p == null) {
                ne5.p = le5;
                if (z2) {
                    List<le5> list = ne5.q;
                    if (list == null || list.isEmpty()) {
                        rf5.f("Hunter", "joined", jf5.b(), "to empty hunter");
                    } else {
                        rf5.f("Hunter", "joined", jf5.b(), rf5.d(ne5, "to "));
                    }
                }
            } else {
                if (ne5.q == null) {
                    ne5.q = new ArrayList(3);
                }
                ne5.q.add(le5);
                if (z2) {
                    rf5.f("Hunter", "joined", jf5.b(), rf5.d(ne5, "to "));
                }
                Picasso.e eVar = le5.b.r;
                if (eVar.ordinal() > ne5.x.ordinal()) {
                    ne5.x = eVar;
                }
            }
        } else if (!this.c.isShutdown()) {
            ne5 e2 = ne5.e(le5.f2204a, this, this.k, this.l, le5);
            e2.s = this.c.submit(e2);
            this.e.put(le5.i, e2);
            if (z) {
                this.f.remove(le5.d());
            }
            if (le5.f2204a.n) {
                rf5.f("Dispatcher", "enqueued", le5.b.b(), "");
            }
        } else if (le5.f2204a.n) {
            rf5.f("Dispatcher", "ignored", le5.b.b(), "because shut down");
        }
    }
}
