package defpackage;

import android.graphics.Bitmap;
import app.zophop.ui.fragments.ProfileFragment;

/* renamed from: pv0  reason: default package */
/* compiled from: ProfileFragment */
public class pv0 extends at1<Bitmap> {
    public final /* synthetic */ int i;
    public final /* synthetic */ ProfileFragment j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public pv0(ProfileFragment profileFragment, int i2, int i3, int i4) {
        super(i2, i3);
        this.j = profileFragment;
        this.i = i4;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        ProfileFragment.a(this.j, (Bitmap) obj, this.i);
    }
}
