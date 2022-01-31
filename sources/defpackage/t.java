package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

/* renamed from: t  reason: default package */
/* compiled from: ActivityResultContract */
public abstract class t<I, O> {

    /* renamed from: t$a */
    /* compiled from: ActivityResultContract */
    public static final class a<T> {
        @SuppressLint({"UnknownNullness"})

        /* renamed from: a  reason: collision with root package name */
        public final T f3284a;

        public a(@SuppressLint({"UnknownNullness"}) T t) {
            this.f3284a = t;
        }
    }

    public abstract Intent a(Context context, @SuppressLint({"UnknownNullness"}) I i);

    public a<O> b(Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract O c(int i, Intent intent);
}
