package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: yf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public abstract class yf3<T> {
    public static final Object f = new Object();
    @SuppressLint({"StaticFieldLeak"})
    public static Context g;
    public static gg3<eg3<uf3>> h;
    public static final AtomicInteger i = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final cg3 f4042a;
    public final String b;
    public final T c;
    public volatile int d = -1;
    public volatile T e;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public yf3(cg3 cg3, String str, Object obj, ag3 ag3) {
        if (cg3.f562a != null) {
            this.f4042a = cg3;
            this.b = str;
            this.c = obj;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public abstract T a(Object obj);

    public final String b(String str) {
        if (str != null && str.isEmpty()) {
            return this.b;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.b);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String c() {
        Objects.requireNonNull(this.f4042a);
        return b("");
    }
}
