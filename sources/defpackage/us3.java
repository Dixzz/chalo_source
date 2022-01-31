package defpackage;

import java.io.Serializable;
import java.util.Objects;

/* renamed from: us3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class us3<T> implements Serializable {
    public static <T> us3<T> a(T t) {
        Objects.requireNonNull(t);
        return new vs3(t);
    }

    public abstract boolean b();

    public abstract T c();
}
