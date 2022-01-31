package defpackage;

import java.util.Objects;

/* renamed from: cf2  reason: default package */
public final /* synthetic */ class cf2 implements if2 {

    /* renamed from: a  reason: collision with root package name */
    public final af2 f561a;

    public cf2(af2 af2) {
        this.f561a = af2;
    }

    @Override // defpackage.if2
    public final Object f() {
        af2 af2 = this.f561a;
        Objects.requireNonNull(af2);
        return dl2.b(af2.h.getContentResolver(), af2.c);
    }
}
