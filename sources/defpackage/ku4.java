package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: ku4  reason: default package */
public final class ku4 {
    public static final nv4 e = new nv4("AssetPackManager");

    /* renamed from: a  reason: collision with root package name */
    public final bs4 f2122a;
    public final kw4<vu4> b;
    public final yr4 c;
    public final kw4<Executor> d;

    public ku4(bs4 bs4, kw4<vu4> kw4, yr4 yr4, mx4 mx4, dt4 dt4, ss4 ss4, js4 js4, kw4<Executor> kw42, bv4 bv4) {
        new Handler(Looper.getMainLooper());
        this.f2122a = bs4;
        this.b = kw4;
        this.c = yr4;
        this.d = kw42;
    }

    public final void a(boolean z) {
        boolean z2;
        yr4 yr4 = this.c;
        synchronized (yr4) {
            z2 = yr4.e != null;
        }
        yr4 yr42 = this.c;
        synchronized (yr42) {
            yr42.f = z;
            yr42.b();
        }
        if (z && !z2) {
            this.d.a().execute(new hu4(this));
        }
    }
}
