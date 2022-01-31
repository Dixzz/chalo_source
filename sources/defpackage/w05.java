package defpackage;

/* renamed from: w05  reason: default package */
/* compiled from: LazyFieldLite */
public class w05 {

    /* renamed from: a  reason: collision with root package name */
    public volatile j15 f3703a;
    public volatile a05 b;

    static {
        i05.a();
    }

    public j15 a(j15 j15) {
        if (this.f3703a == null) {
            synchronized (this) {
                if (this.f3703a == null) {
                    try {
                        this.f3703a = j15;
                        this.b = a05.g;
                    } catch (t05 unused) {
                        this.f3703a = j15;
                        this.b = a05.g;
                    }
                }
            }
        }
        return this.f3703a;
    }

    public a05 b() {
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b != null) {
                return this.b;
            }
            if (this.f3703a == null) {
                this.b = a05.g;
            } else {
                this.b = this.f3703a.toByteString();
            }
            return this.b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w05)) {
            return false;
        }
        w05 w05 = (w05) obj;
        j15 j15 = this.f3703a;
        j15 j152 = w05.f3703a;
        if (j15 == null && j152 == null) {
            return b().equals(w05.b());
        }
        if (j15 != null && j152 != null) {
            return j15.equals(j152);
        }
        if (j15 != null) {
            return j15.equals(w05.a(j15.getDefaultInstanceForType()));
        }
        return a(j152.getDefaultInstanceForType()).equals(j152);
    }

    public int hashCode() {
        return 1;
    }
}
