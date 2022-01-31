package defpackage;

import android.content.Context;
import java.util.Objects;

/* renamed from: uq4  reason: default package */
public final class uq4 implements nw4<oq4> {

    /* renamed from: a  reason: collision with root package name */
    public final nw4 f3543a;
    public final /* synthetic */ int b = 0;

    public uq4(nw4<rq4> nw4) {
        this.f3543a = nw4;
    }

    public uq4(nw4<Context> nw4, byte[] bArr) {
        this.f3543a = nw4;
    }

    public uq4(nw4<Context> nw4, char[] cArr) {
        this.f3543a = nw4;
    }

    public uq4(nw4<Context> nw4, short[] sArr) {
        this.f3543a = nw4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.nw4
    public final oq4 a() {
        int i = this.b;
        if (i == 0) {
            rq4 rq4 = (rq4) this.f3543a.a();
            Objects.requireNonNull(rq4, "Cannot return null from a non-@Nullable @Provides method");
            return rq4;
        } else if (i != 1) {
            return i != 2 ? new mx4((Context) this.f3543a.a()) : new er4(((vq4) this.f3543a).a());
        } else {
            return new qq4(((vq4) this.f3543a).a());
        }
    }
}
