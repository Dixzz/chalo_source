package defpackage;

import java.util.Objects;

/* renamed from: zt1  reason: default package */
/* compiled from: Encoding */
public final class zt1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f4209a;

    public zt1(String str) {
        Objects.requireNonNull(str, "name is null");
        this.f4209a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zt1)) {
            return false;
        }
        return this.f4209a.equals(((zt1) obj).f4209a);
    }

    public int hashCode() {
        return this.f4209a.hashCode() ^ 1000003;
    }

    public String toString() {
        return hj1.a0(hj1.i0("Encoding{name=\""), this.f4209a, "\"}");
    }
}
