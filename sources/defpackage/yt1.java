package defpackage;

import java.util.Objects;

/* renamed from: yt1  reason: default package */
/* compiled from: AutoValue_Event */
public final class yt1<T> extends au1<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f4084a;
    public final bu1 b;

    public yt1(Integer num, T t, bu1 bu1) {
        Objects.requireNonNull(t, "Null payload");
        this.f4084a = t;
        Objects.requireNonNull(bu1, "Null priority");
        this.b = bu1;
    }

    @Override // defpackage.au1
    public Integer a() {
        return null;
    }

    @Override // defpackage.au1
    public T b() {
        return this.f4084a;
    }

    @Override // defpackage.au1
    public bu1 c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof au1)) {
            return false;
        }
        au1 au1 = (au1) obj;
        if (au1.a() != null || !this.f4084a.equals(au1.b()) || !this.b.equals(au1.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.b.hashCode() ^ ((-721379959 ^ this.f4084a.hashCode()) * 1000003);
    }

    public String toString() {
        return "Event{code=" + ((Object) null) + ", payload=" + ((Object) this.f4084a) + ", priority=" + this.b + "}";
    }
}
