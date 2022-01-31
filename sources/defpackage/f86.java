package defpackage;

import java.io.Serializable;
import java.util.Objects;

/* renamed from: f86  reason: default package */
/* compiled from: CallableReference */
public abstract class f86 implements m96, Serializable {
    public transient m96 f;
    public final Object g;
    public final Class h;
    public final String i;
    public final String j;
    public final boolean k;

    /* renamed from: f86$a */
    /* compiled from: CallableReference */
    public static class a implements Serializable {
        public static final a f = new a();
    }

    public f86() {
        this.g = a.f;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = false;
    }

    public m96 c() {
        m96 m96 = this.f;
        if (m96 != null) {
            return m96;
        }
        m96 d = d();
        this.f = d;
        return d;
    }

    public abstract m96 d();

    public o96 f() {
        Class cls = this.h;
        if (cls == null) {
            return null;
        }
        if (!this.k) {
            return z86.a(cls);
        }
        Objects.requireNonNull(z86.f4146a);
        return new p86(cls, "");
    }

    public f86(Object obj, Class cls, String str, String str2, boolean z) {
        this.g = obj;
        this.h = cls;
        this.i = str;
        this.j = str2;
        this.k = z;
    }
}
