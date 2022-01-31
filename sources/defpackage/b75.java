package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b75  reason: default package */
/* compiled from: ExpandedRow */
public final class b75 {

    /* renamed from: a  reason: collision with root package name */
    public final List<a75> f391a;
    public final int b;
    public final boolean c;

    public b75(List<a75> list, int i, boolean z) {
        this.f391a = new ArrayList(list);
        this.b = i;
        this.c = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b75)) {
            return false;
        }
        b75 b75 = (b75) obj;
        if (!this.f391a.equals(b75.f391a) || this.c != b75.c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f391a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return "{ " + this.f391a + " }";
    }
}
