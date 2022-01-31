package defpackage;

import java.util.Objects;

/* renamed from: c8  reason: default package */
/* compiled from: DisplayCutoutCompat */
public final class c8 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f531a;

    public c8(Object obj) {
        this.f531a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c8.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f531a, ((c8) obj).f531a);
    }

    public int hashCode() {
        Object obj = this.f531a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("DisplayCutoutCompat{");
        i0.append(this.f531a);
        i0.append("}");
        return i0.toString();
    }
}
