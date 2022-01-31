package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: kp  reason: default package */
/* compiled from: Configuration */
public final class kp {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2095a = a();
    public final Executor b = a();
    public final dq c;
    public final sp d;
    public final eq e;
    public final int f;
    public final int g;
    public final int h;

    /* renamed from: kp$a */
    /* compiled from: Configuration */
    public static final class a {
    }

    /* renamed from: kp$b */
    /* compiled from: Configuration */
    public interface b {
        kp a();
    }

    public kp(a aVar) {
        String str = dq.f879a;
        this.c = new cq();
        this.d = new rp();
        this.e = new eq();
        this.f = 4;
        this.g = Integer.MAX_VALUE;
        this.h = 20;
    }

    public final Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
