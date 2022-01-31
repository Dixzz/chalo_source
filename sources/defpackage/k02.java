package defpackage;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: k02  reason: default package */
public final class k02 extends ki<Void> implements a42 {

    /* renamed from: a  reason: collision with root package name */
    public Semaphore f2006a = new Semaphore(0);
    public Set<a32> b;

    public k02(Context context, Set<a32> set) {
        super(context);
        this.b = set;
    }

    @Override // defpackage.a42
    public final void a() {
        this.f2006a.release();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ki
    public final Void loadInBackground() {
        int i = 0;
        for (a32 a32 : this.b) {
            if (a32.o(this)) {
                i++;
            }
        }
        try {
            this.f2006a.tryAcquire(i, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // defpackage.li
    public final void onStartLoading() {
        this.f2006a.drainPermits();
        forceLoad();
    }
}
