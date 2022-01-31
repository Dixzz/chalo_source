package defpackage;

import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: wv1  reason: default package */
/* compiled from: BackendResponse */
public abstract class wv1 {

    /* renamed from: wv1$a */
    /* compiled from: BackendResponse */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static wv1 a() {
        return new rv1(a.FATAL_ERROR, -1);
    }

    public abstract long b();

    public abstract a c();
}
