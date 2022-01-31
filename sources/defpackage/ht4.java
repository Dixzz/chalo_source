package defpackage;

import android.content.Context;
import java.util.Objects;

/* renamed from: ht4  reason: default package */
public final class ht4 implements nw4<gt4> {

    /* renamed from: a  reason: collision with root package name */
    public final nw4 f1424a;
    public final nw4 b;
    public final nw4 c;
    public final /* synthetic */ int d = 0;

    public ht4(nw4<dt4> nw4, nw4<bs4> nw42, nw4<hs4> nw43) {
        this.f1424a = nw4;
        this.b = nw42;
        this.c = nw43;
    }

    public ht4(nw4<Context> nw4, nw4<ur4> nw42, nw4<lt4> nw43, byte[] bArr) {
        this.c = nw4;
        this.b = nw42;
        this.f1424a = nw43;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.nw4
    public final gt4 a() {
        if (this.d != 0) {
            vu4 vu4 = (vu4) (nu4.a(((ru4) this.c).a()) == null ? mw4.b(this.b).a() : mw4.b(this.f1424a).a());
            Objects.requireNonNull(vu4, "Cannot return null from a non-@Nullable @Provides method");
            return vu4;
        }
        return new gt4((dt4) this.f1424a.a(), (bs4) this.b.a(), (hs4) this.c.a());
    }
}
