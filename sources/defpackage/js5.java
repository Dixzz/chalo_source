package defpackage;

import android.os.Handler;
import android.os.SystemClock;
import defpackage.is5;

/* renamed from: js5  reason: default package */
/* compiled from: Timer */
public abstract class js5 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1977a;
    public long b;
    public long c;
    public long d;
    public final Handler e = new Handler();
    public final Runnable f = new a();

    /* renamed from: js5$a */
    /* compiled from: Timer */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            js5 js5 = js5.this;
            if (js5.f1977a) {
                js5.c();
                is5.a aVar = (is5.a) js5.this;
                is5.this.d(true);
                is5 is5 = is5.this;
                is5.d dVar = is5.n;
                if (dVar != null) {
                    fs5 fs5 = (fs5) dVar;
                    fs5.f1169a.i.a(new xr5("timed_out"), is5.getTimer().a());
                    fs5.f1169a.i(is5.getContext());
                }
            }
        }
    }

    public js5(long j) {
        this.c = j;
    }

    public long a() {
        if (!this.f1977a) {
            return this.d;
        }
        return (SystemClock.elapsedRealtime() + this.d) - this.b;
    }

    public void b() {
        if (!this.f1977a) {
            this.f1977a = true;
            this.b = SystemClock.elapsedRealtime();
            long j = this.c;
            if (j > 0) {
                this.e.postDelayed(this.f, j);
            } else {
                this.e.post(this.f);
            }
        }
    }

    public void c() {
        if (this.f1977a) {
            this.d = SystemClock.elapsedRealtime() - this.b;
            this.f1977a = false;
            this.e.removeCallbacks(this.f);
            this.c = Math.max(0L, this.c - (SystemClock.elapsedRealtime() - this.b));
        }
    }
}
