package defpackage;

import android.os.Process;
import defpackage.ik1;
import defpackage.wj1;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* renamed from: lj1  reason: default package */
/* compiled from: CacheDispatcher */
public class lj1 extends Thread {
    public static final boolean l = ek1.f981a;
    public final BlockingQueue<wj1<?>> f;
    public final BlockingQueue<wj1<?>> g;
    public final jj1 h;
    public final zj1 i;
    public volatile boolean j = false;
    public final a k;

    /* renamed from: lj1$a */
    /* compiled from: CacheDispatcher */
    public static class a implements wj1.b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<wj1<?>>> f2226a = new HashMap();
        public final lj1 b;

        public a(lj1 lj1) {
            this.b = lj1;
        }

        public static boolean a(a aVar, wj1 wj1) {
            synchronized (aVar) {
                String l = wj1.l();
                if (aVar.f2226a.containsKey(l)) {
                    List<wj1<?>> list = aVar.f2226a.get(l);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    wj1.a("waiting-for-response");
                    list.add(wj1);
                    aVar.f2226a.put(l, list);
                    if (ek1.f981a) {
                        ek1.a("Request for cacheKey=%s is in flight, putting on hold.", l);
                    }
                    return true;
                }
                aVar.f2226a.put(l, null);
                synchronized (wj1.j) {
                    wj1.t = aVar;
                }
                if (ek1.f981a) {
                    ek1.a("new request, sending to network %s", l);
                }
                return false;
            }
        }

        public synchronized void b(wj1<?> wj1) {
            String l = wj1.l();
            List<wj1<?>> remove = this.f2226a.remove(l);
            if (remove != null && !remove.isEmpty()) {
                if (ek1.f981a) {
                    ek1.b("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), l);
                }
                wj1<?> remove2 = remove.remove(0);
                this.f2226a.put(l, remove);
                synchronized (remove2.j) {
                    remove2.t = this;
                }
                try {
                    this.b.g.put(remove2);
                } catch (InterruptedException e) {
                    ek1.a("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    lj1 lj1 = this.b;
                    lj1.j = true;
                    lj1.interrupt();
                }
            }
        }
    }

    public lj1(BlockingQueue<wj1<?>> blockingQueue, BlockingQueue<wj1<?>> blockingQueue2, jj1 jj1, zj1 zj1) {
        this.f = blockingQueue;
        this.g = blockingQueue2;
        this.h = jj1;
        this.i = zj1;
        this.k = new a(this);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0138 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() throws java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 393
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj1.a():void");
    }

    public void run() {
        if (l) {
            ek1.b("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        ik1 ik1 = (ik1) this.h;
        synchronized (ik1) {
            if (ik1.c.exists()) {
                File[] listFiles = ik1.c.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        try {
                            long length = file.length();
                            ik1.b bVar = new ik1.b(new BufferedInputStream(new FileInputStream(file)), length);
                            try {
                                ik1.a a2 = ik1.a.a(bVar);
                                a2.f1528a = length;
                                ik1.f(a2.b, a2);
                            } finally {
                                bVar.close();
                            }
                        } catch (IOException unused) {
                            file.delete();
                        }
                    }
                }
            } else if (!ik1.c.mkdirs()) {
                ek1.a("Unable to create cache dir %s", ik1.c.getAbsolutePath());
            }
        }
        while (true) {
            try {
                a();
            } catch (InterruptedException unused2) {
                if (this.j) {
                    Thread.currentThread().interrupt();
                    return;
                }
                ek1.a("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
