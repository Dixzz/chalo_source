package defpackage;

import android.content.Context;
import java.util.Objects;

/* renamed from: d06  reason: default package */
/* compiled from: AbstractValueCache */
public abstract class d06<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d06<T> f775a;

    public d06(d06<T> d06) {
        this.f775a = d06;
    }

    public final synchronized T a(Context context, f06<T> f06) throws Exception {
        T t;
        t = ((e06) this).b;
        if (t == null) {
            d06<T> d06 = this.f775a;
            t = d06 != null ? d06.a(context, f06) : f06.load(context);
            Objects.requireNonNull(t);
            ((e06) this).b = t;
        }
        return t;
    }
}
