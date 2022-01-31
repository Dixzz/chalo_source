package defpackage;

import java.io.IOException;
import java.util.Objects;

/* renamed from: tk2  reason: default package */
public final class tk2 extends ak2<tk2> implements Cloneable {
    public static volatile tk2[] h;

    public tk2() {
        this.g = null;
        this.f = -1;
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final void a(yj2 yj2) throws IOException {
        super.a(yj2);
    }

    @Override // defpackage.ak2, java.lang.Object, defpackage.ek2
    public final Object clone() throws CloneNotSupportedException {
        try {
            return (tk2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final int d() {
        super.d();
        return 0;
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final /* synthetic */ ek2 e() throws CloneNotSupportedException {
        return (tk2) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tk2)) {
            return false;
        }
        tk2 tk2 = (tk2) obj;
        Objects.requireNonNull(tk2);
        Objects.requireNonNull(tk2);
        bk2 bk2 = this.g;
        if (bk2 != null && !bk2.a()) {
            return this.g.equals(tk2.g);
        }
        bk2 bk22 = tk2.g;
        return bk22 == null || bk22.a();
    }

    /* Return type fixed from 'ak2' to match base method */
    @Override // defpackage.ak2
    public final /* synthetic */ tk2 f() throws CloneNotSupportedException {
        return (tk2) clone();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((tk2.class.getName().hashCode() + 527) * 31) + 0) * 31) + 0) * 31;
        bk2 bk2 = this.g;
        if (bk2 != null && !bk2.a()) {
            i = this.g.hashCode();
        }
        return hashCode + i;
    }
}
