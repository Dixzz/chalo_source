package defpackage;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* renamed from: is3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class is3<T> {
    public static final Object g = new Object();
    @Nullable
    public static volatile qs3 h;
    public static rs3 i = new rs3(ks3.f2115a);
    public static final AtomicInteger j = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final ns3 f1568a;
    public final String b;
    public final T c;
    public volatile int d = -1;
    public volatile T e;
    public final boolean f;

    static {
        new AtomicReference();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public is3(ns3 ns3, String str, Object obj, boolean z, js3 js3) {
        if (ns3.f2599a != null) {
            this.f1568a = ns3;
            this.b = str;
            this.c = obj;
            this.f = z;
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
        Objects.requireNonNull(this.f1568a);
        return b("");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T d() {
        /*
        // Method dump skipped, instructions count: 325
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.is3.d():java.lang.Object");
    }
}
