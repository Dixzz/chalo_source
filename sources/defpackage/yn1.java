package defpackage;

import defpackage.ho1;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: yn1  reason: default package */
/* compiled from: BaseKeyPool */
public abstract class yn1<T extends ho1> {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<T> f4070a = new ArrayDeque(20);

    public yn1() {
        char[] cArr = rt1.f3126a;
    }

    public abstract T a();

    public T b() {
        T poll = this.f4070a.poll();
        return poll == null ? a() : poll;
    }

    public void c(T t) {
        if (this.f4070a.size() < 20) {
            this.f4070a.offer(t);
        }
    }
}
