package defpackage;

import android.os.Bundle;

/* renamed from: tr4  reason: default package */
public final class tr4 extends pr4<Void> {
    public final int h;
    public final String i;
    public final int j;
    public final /* synthetic */ ur4 k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tr4(ur4 ur4, ay4<Void> ay4, int i2, String str, int i3) {
        super(ur4, ay4);
        this.k = ur4;
        this.h = i2;
        this.i = str;
        this.j = i3;
    }

    @Override // defpackage.pr4, defpackage.ax4
    public final void J2(Bundle bundle) {
        this.k.c.b();
        int i2 = bundle.getInt("error_code");
        ur4.f.b(6, "onError(%d), retrying notifyModuleCompleted...", new Object[]{Integer.valueOf(i2)});
        int i3 = this.j;
        if (i3 > 0) {
            this.k.k(this.h, this.i, i3 - 1);
        }
    }
}
