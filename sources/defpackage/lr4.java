package defpackage;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: lr4  reason: default package */
public final class lr4 extends ov4 {
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;
    public final /* synthetic */ ay4 i;
    public final /* synthetic */ int j;
    public final /* synthetic */ ur4 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public lr4(ur4 ur4, ay4 ay4, int i2, String str, ay4 ay42, int i3) {
        super(ay4);
        this.k = ur4;
        this.g = i2;
        this.h = str;
        this.i = ay42;
        this.j = i3;
    }

    @Override // defpackage.ov4
    public final void a() {
        try {
            ur4 ur4 = this.k;
            String str = ur4.f3547a;
            int i2 = this.g;
            String str2 = this.h;
            Bundle bundle = new Bundle();
            bundle.putInt("session_id", i2);
            bundle.putString("module_name", str2);
            ((yw4) ur4.c.k).V(str, bundle, ur4.g(), new tr4(this.k, this.i, this.g, this.h, this.j));
        } catch (RemoteException e) {
            ur4.f.a(e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
