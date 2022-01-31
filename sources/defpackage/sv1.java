package defpackage;

import android.content.Context;
import java.util.Objects;

/* renamed from: sv1  reason: default package */
/* compiled from: AutoValue_CreationContext */
public final class sv1 extends xv1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3261a;
    public final jy1 b;
    public final jy1 c;
    public final String d;

    public sv1(Context context, jy1 jy1, jy1 jy12, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.f3261a = context;
        Objects.requireNonNull(jy1, "Null wallClock");
        this.b = jy1;
        Objects.requireNonNull(jy12, "Null monotonicClock");
        this.c = jy12;
        Objects.requireNonNull(str, "Null backendName");
        this.d = str;
    }

    @Override // defpackage.xv1
    public Context a() {
        return this.f3261a;
    }

    @Override // defpackage.xv1
    public String b() {
        return this.d;
    }

    @Override // defpackage.xv1
    public jy1 c() {
        return this.c;
    }

    @Override // defpackage.xv1
    public jy1 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xv1)) {
            return false;
        }
        xv1 xv1 = (xv1) obj;
        if (!this.f3261a.equals(xv1.a()) || !this.b.equals(xv1.d()) || !this.c.equals(xv1.c()) || !this.d.equals(xv1.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.f3261a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CreationContext{applicationContext=");
        i0.append(this.f3261a);
        i0.append(", wallClock=");
        i0.append(this.b);
        i0.append(", monotonicClock=");
        i0.append(this.c);
        i0.append(", backendName=");
        return hj1.a0(i0, this.d, "}");
    }
}
