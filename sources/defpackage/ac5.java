package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import defpackage.kc5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ac5  reason: default package */
/* compiled from: AnalyticsMessages */
public class ac5 {
    public static final Map<Context, ac5> d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final h f147a = new h();
    public final Context b;
    public final jc5 c;

    /* renamed from: ac5$b */
    /* compiled from: AnalyticsMessages */
    public static class b extends d {
        public String toString() {
            return this.b.toString();
        }
    }

    /* renamed from: ac5$c */
    /* compiled from: AnalyticsMessages */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f148a;

        public c(String str) {
            this.f148a = str;
        }
    }

    /* renamed from: ac5$d */
    /* compiled from: AnalyticsMessages */
    public static class d extends c {
        public final JSONObject b;

        public d(String str, JSONObject jSONObject) {
            super(str);
            if (jSONObject != null && jSONObject.length() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.get(next).toString();
                    } catch (AssertionError unused) {
                        jSONObject.remove(next);
                    } catch (JSONException unused2) {
                    }
                }
            }
            this.b = jSONObject;
        }
    }

    /* renamed from: ac5$e */
    /* compiled from: AnalyticsMessages */
    public static class e extends d {
        public e(JSONObject jSONObject, String str) {
            super(str, jSONObject);
        }

        public String toString() {
            return this.b.toString();
        }
    }

    /* renamed from: ac5$f */
    /* compiled from: AnalyticsMessages */
    public static class f extends c {
        public final String b;

        public f(String str, String str2) {
            super(str2);
            this.b = str;
        }

        public String toString() {
            return this.b;
        }
    }

    /* renamed from: ac5$g */
    /* compiled from: AnalyticsMessages */
    public static class g extends c {
    }

    /* renamed from: ac5$h */
    /* compiled from: AnalyticsMessages */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public final Object f149a = new Object();
        public Handler b;
        public long c = 0;
        public long d = 0;
        public long e = -1;
        public ed5 f;

        /* renamed from: ac5$h$a */
        /* compiled from: AnalyticsMessages */
        public class a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public kc5 f150a = null;
            public final dc5 b;
            public final long c;
            public long d;
            public long e;
            public int f;

            public a(Looper looper) {
                super(looper);
                h.this.f = ed5.a(ac5.this.b);
                ac5 ac5 = ac5.this;
                this.b = new dc5(ac5.b, ac5.c);
                this.c = (long) ac5.this.c.b;
            }

            /* JADX WARNING: Removed duplicated region for block: B:108:0x0213  */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x022a  */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x022d  */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x024e  */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x01e1  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final org.json.JSONObject a(defpackage.ac5.a r10) throws org.json.JSONException {
                /*
                // Method dump skipped, instructions count: 670
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.ac5.h.a.a(ac5$a):org.json.JSONObject");
            }

            public final void b(kc5 kc5, String str) {
                boolean z;
                Objects.requireNonNull(ac5.this);
                ac5 ac5 = ac5.this;
                Context context = ac5.b;
                synchronized (ac5.c) {
                }
                if (od5.f2679a) {
                    z = false;
                } else {
                    z = true;
                    try {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            z = activeNetworkInfo.isConnectedOrConnecting();
                        }
                    } catch (SecurityException unused) {
                    }
                }
                if (!z) {
                    ac5.a(ac5.this, "Not flushing data to Mixpanel because the device is not connected to the internet.");
                    return;
                }
                c(kc5, str, kc5.b.EVENTS, ac5.this.c.m);
                c(kc5, str, kc5.b.PEOPLE, ac5.this.c.n);
                c(kc5, str, kc5.b.GROUPS, ac5.this.c.o);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:47:0x0172, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x0174, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0176, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x0178, code lost:
                defpackage.ac5.b(r25.g.g, "Cannot post message to " + r29 + ".", r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0192, code lost:
                defpackage.ac5.b(r25.g.g, "Cannot post message to " + r29 + ".", r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ac, code lost:
                defpackage.ac5.b(r25.g.g, "Cannot post message to " + r29 + ".", r0);
                r25.e = (long) (r0.f * com.google.firebase.appindexing.Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0223 */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x0172 A[ExcHandler: IOException (r0v30 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:32:0x00f1] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0174 A[ExcHandler: SocketTimeoutException (r0v29 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:32:0x00f1] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x0176 A[ExcHandler: a (r0v26 'e' ud5$a A[CUSTOM_DECLARE]), Splitter:B:32:0x00f1] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x01d1  */
            /* JADX WARNING: Removed duplicated region for block: B:79:0x0255 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void c(defpackage.kc5 r26, java.lang.String r27, defpackage.kc5.b r28, java.lang.String r29) {
                /*
                // Method dump skipped, instructions count: 681
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.ac5.h.a.c(kc5, java.lang.String, kc5$b, java.lang.String):void");
            }

            /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x025c  */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x0280 A[SYNTHETIC, Splitter:B:93:0x0280] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void handleMessage(android.os.Message r11) {
                /*
                // Method dump skipped, instructions count: 759
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.ac5.h.a.handleMessage(android.os.Message):void");
            }
        }

        public h() {
            HandlerThread handlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 10);
            handlerThread.start();
            this.b = new a(handlerThread.getLooper());
        }

        public static void a(h hVar) {
            Objects.requireNonNull(hVar);
            long currentTimeMillis = System.currentTimeMillis();
            long j = hVar.c;
            long j2 = 1 + j;
            long j3 = hVar.e;
            if (j3 > 0) {
                long j4 = ((hVar.d * j) + (currentTimeMillis - j3)) / j2;
                hVar.d = j4;
                ac5 ac5 = ac5.this;
                ac5.a(ac5, "Average send frequency approximately " + (j4 / 1000) + " seconds.");
            }
            hVar.e = currentTimeMillis;
            hVar.c = j2;
        }

        public void b(Message message) {
            synchronized (this.f149a) {
                Handler handler = this.b;
                if (handler == null) {
                    ac5 ac5 = ac5.this;
                    ac5.a(ac5, "Dead mixpanel worker dropping a message: " + message.what);
                } else {
                    handler.sendMessage(message);
                }
            }
        }
    }

    public ac5(Context context) {
        this.b = context;
        this.c = jc5.b(context);
        new Thread(new nd5(new od5())).start();
    }

    public static void a(ac5 ac5, String str) {
        Objects.requireNonNull(ac5);
        Thread.currentThread().getId();
    }

    public static void b(ac5 ac5, String str, Throwable th) {
        Objects.requireNonNull(ac5);
        Thread.currentThread().getId();
    }

    /* renamed from: ac5$a */
    /* compiled from: AnalyticsMessages */
    public static class a extends d {
        public final String c;
        public final JSONObject d;
        public final boolean e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, JSONObject jSONObject, String str2) {
            super(str2, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            this.c = str;
            this.e = false;
            this.d = jSONObject2;
        }

        public a(String str, JSONObject jSONObject, String str2, boolean z, JSONObject jSONObject2) {
            super(str2, jSONObject);
            this.c = str;
            this.e = z;
            this.d = jSONObject2;
        }
    }
}
