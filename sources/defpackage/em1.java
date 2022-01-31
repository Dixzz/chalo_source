package defpackage;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Objects;

/* renamed from: em1  reason: default package */
/* compiled from: Option */
public final class em1<T> {
    public static final b<Object> e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final T f992a;
    public final b<T> b;
    public final String c;
    public volatile byte[] d;

    /* renamed from: em1$a */
    /* compiled from: Option */
    public static class a implements b<Object> {
        @Override // defpackage.em1.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* renamed from: em1$b */
    /* compiled from: Option */
    public interface b<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public em1(String str, T t, b<T> bVar) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            this.f992a = t;
            Objects.requireNonNull(bVar, "Argument must not be null");
            this.b = bVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T> em1<T> a(String str, T t) {
        return new em1<>(str, t, e);
    }

    public boolean equals(Object obj) {
        if (obj instanceof em1) {
            return this.c.equals(((em1) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Option{key='");
        i0.append(this.c);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
