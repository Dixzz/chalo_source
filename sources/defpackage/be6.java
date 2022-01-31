package defpackage;

/* renamed from: be6  reason: default package */
/* compiled from: Channel.kt */
public final class be6<T> {
    public static final b b = new b(null);
    public static final c c = new c();

    /* renamed from: a  reason: collision with root package name */
    public final Object f419a;

    /* renamed from: be6$a */
    /* compiled from: Channel.kt */
    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f420a;

        public a(Throwable th) {
            this.f420a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && n86.a(this.f420a, ((a) obj).f420a);
        }

        public int hashCode() {
            Throwable th = this.f420a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // defpackage.be6.c
        public String toString() {
            StringBuilder i0 = hj1.i0("Closed(");
            i0.append(this.f420a);
            i0.append(')');
            return i0.toString();
        }
    }

    /* renamed from: be6$b */
    /* compiled from: Channel.kt */
    public static final class b {
        public b(j86 j86) {
        }
    }

    /* renamed from: be6$c */
    /* compiled from: Channel.kt */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ be6(Object obj) {
        this.f419a = obj;
    }

    public boolean equals(Object obj) {
        Object obj2 = this.f419a;
        if ((obj instanceof be6) && n86.a(obj2, ((be6) obj).f419a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f419a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        Object obj = this.f419a;
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }
}
