package defpackage;

import defpackage.f86;
import defpackage.r96;
import java.util.Objects;

/* renamed from: s86  reason: default package */
/* compiled from: PropertyReference2 */
public abstract class s86 extends u86 implements r96 {
    public s86(Class cls, String str, String str2, int i) {
        super(f86.a.f, cls, str, str2, i);
    }

    @Override // defpackage.r96
    public r96.a b() {
        m96 c = c();
        if (c != this) {
            return ((r96) ((s96) c)).b();
        }
        throw new g76();
    }

    @Override // defpackage.f86
    public m96 d() {
        Objects.requireNonNull(z86.f4146a);
        return this;
    }

    @Override // defpackage.w76
    public Object invoke(Object obj, Object obj2) {
        return ((t86) this).b().a(obj, obj2);
    }
}
