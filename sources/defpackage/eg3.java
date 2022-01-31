package defpackage;

import java.io.Serializable;
import java.util.Objects;

/* renamed from: eg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public abstract class eg3<T> implements Serializable {
    public static <T> eg3<T> c(T t) {
        Objects.requireNonNull(t);
        return new fg3(t);
    }

    public abstract T a();

    public abstract boolean b();
}
