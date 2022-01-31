package defpackage;

import defpackage.q96;
import java.util.Objects;

/* renamed from: q86  reason: default package */
/* compiled from: PropertyReference1 */
public abstract class q86 extends u86 implements q96 {
    public q86(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // defpackage.q96
    public q96.a b() {
        m96 c = c();
        if (c != this) {
            return ((q96) ((s96) c)).b();
        }
        throw new g76();
    }

    @Override // defpackage.f86
    public m96 d() {
        Objects.requireNonNull(z86.f4146a);
        return this;
    }

    @Override // defpackage.s76
    public Object invoke(Object obj) {
        return ((r86) this).b().a(obj);
    }
}
