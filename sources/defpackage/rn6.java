package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: rn6  reason: default package */
/* compiled from: Timeout.kt */
public class rn6 {
    public static final rn6 d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f3105a;
    public long b;
    public long c;

    /* renamed from: rn6$a */
    /* compiled from: Timeout.kt */
    public static final class a extends rn6 {
        @Override // defpackage.rn6
        public rn6 d(long j) {
            return this;
        }

        @Override // defpackage.rn6
        public void f() {
        }

        @Override // defpackage.rn6
        public rn6 g(long j, TimeUnit timeUnit) {
            n86.f(timeUnit, "unit");
            return this;
        }
    }

    public rn6 a() {
        this.f3105a = false;
        return this;
    }

    public rn6 b() {
        this.c = 0;
        return this;
    }

    public long c() {
        if (this.f3105a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public rn6 d(long j) {
        this.f3105a = true;
        this.b = j;
        return this;
    }

    public boolean e() {
        return this.f3105a;
    }

    public void f() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f3105a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public rn6 g(long j, TimeUnit timeUnit) {
        n86.f(timeUnit, "unit");
        if (j >= 0) {
            this.c = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException(hj1.M("timeout < 0: ", j).toString());
    }

    public long h() {
        return this.c;
    }
}
