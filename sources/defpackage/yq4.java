package defpackage;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: yq4  reason: default package */
public final class yq4 extends ov4 {
    public final /* synthetic */ ay4 g;
    public final /* synthetic */ String h;
    public final /* synthetic */ cr4 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yq4(cr4 cr4, ay4 ay4, ay4 ay42, String str) {
        super(ay4);
        this.i = cr4;
        this.g = ay42;
        this.h = str;
    }

    @Override // defpackage.ov4
    public final void a() {
        try {
            cr4 cr4 = this.i;
            String str = cr4.b;
            Bundle bundle = new Bundle();
            bundle.putAll(av4.a("app_update"));
            bundle.putInt("playcore.version.code", 10901);
            ((tw4) cr4.f747a.k).b0(str, bundle, new ar4(this.i, this.g));
        } catch (RemoteException e) {
            cr4.e.a(e, "completeUpdate(%s)", this.h);
            this.g.a(new RuntimeException(e));
        }
    }
}
