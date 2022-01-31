package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.Picasso;

/* renamed from: nf5  reason: default package */
/* compiled from: Stats */
public class nf5 {

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f2547a;
    public final oe5 b;
    public final Handler c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public int l;
    public int m;
    public int n;

    /* renamed from: nf5$a */
    /* compiled from: Stats */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final nf5 f2548a;

        /* renamed from: nf5$a$a  reason: collision with other inner class name */
        /* compiled from: Stats */
        public class RunnableC0046a implements Runnable {
            public final /* synthetic */ Message f;

            public RunnableC0046a(a aVar, Message message) {
                this.f = message;
            }

            public void run() {
                StringBuilder i0 = hj1.i0("Unhandled stats message.");
                i0.append(this.f.what);
                throw new AssertionError(i0.toString());
            }
        }

        public a(Looper looper, nf5 nf5) {
            super(looper);
            this.f2548a = nf5;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f2548a.d++;
            } else if (i == 1) {
                this.f2548a.e++;
            } else if (i == 2) {
                nf5 nf5 = this.f2548a;
                long j = (long) message.arg1;
                int i2 = nf5.m + 1;
                nf5.m = i2;
                long j2 = nf5.g + j;
                nf5.g = j2;
                nf5.j = j2 / ((long) i2);
            } else if (i == 3) {
                nf5 nf52 = this.f2548a;
                long j3 = (long) message.arg1;
                nf52.n++;
                long j4 = nf52.h + j3;
                nf52.h = j4;
                nf52.k = j4 / ((long) nf52.m);
            } else if (i != 4) {
                Picasso.o.post(new RunnableC0046a(this, message));
            } else {
                nf5 nf53 = this.f2548a;
                nf53.l++;
                long longValue = ((Long) message.obj).longValue() + nf53.f;
                nf53.f = longValue;
                nf53.i = longValue / ((long) nf53.l);
            }
        }
    }

    public nf5(oe5 oe5) {
        this.b = oe5;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f2547a = handlerThread;
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        StringBuilder sb = rf5.f3076a;
        qf5 qf5 = new qf5(looper);
        qf5.sendMessageDelayed(qf5.obtainMessage(), 1000);
        this.c = new a(handlerThread.getLooper(), this);
    }

    public of5 a() {
        return new of5(this.b.b(), this.b.size(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }
}
