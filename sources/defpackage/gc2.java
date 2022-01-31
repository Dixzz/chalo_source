package defpackage;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* renamed from: gc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class gc2 {
    public static final gc2 d = new gc2(true, null, null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1238a;
    @Nullable
    public final String b;
    @Nullable
    public final Throwable c;

    public gc2(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.f1238a = z;
        this.b = str;
        this.c = th;
    }

    public static gc2 b(String str) {
        return new gc2(false, str, null);
    }

    public static gc2 c(String str, Throwable th) {
        return new gc2(false, str, th);
    }

    @Nullable
    public String a() {
        return this.b;
    }
}
