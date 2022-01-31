package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment;

@y66(c = "app.zophop.ui.fragments.superPassValidation.ActiveSuperPassQrZoomedFragment$initQrCode$1$1$1", f = "ActiveSuperPassQrZoomedFragment.kt", l = {}, m = "invokeSuspend")
/* renamed from: f31  reason: default package */
/* compiled from: ActiveSuperPassQrZoomedFragment.kt */
public final class f31 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ ActiveSuperPassQrZoomedFragment f;
    public final /* synthetic */ z25 g;
    public final /* synthetic */ SuperPass h;
    public final /* synthetic */ int i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f31(ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment, z25 z25, SuperPass superPass, int i2, k66<? super f31> k66) {
        super(2, k66);
        this.f = activeSuperPassQrZoomedFragment;
        this.g = z25;
        this.h = superPass;
        this.i = i2;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new f31(this.f, this.g, this.h, this.i, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        f31 f31 = new f31(this.f, this.g, this.h, this.i, k66);
        s56 s56 = s56.f3190a;
        f31.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        ActiveSuperPassQrZoomedFragment activeSuperPassQrZoomedFragment = this.f;
        ActiveSuperPassQrZoomedFragment.a aVar = ActiveSuperPassQrZoomedFragment.h;
        T t = activeSuperPassQrZoomedFragment.f;
        n86.c(t);
        ImageView imageView = ((fx) t).b;
        y91 f2 = this.f.f();
        z25 z25 = this.g;
        SuperPass superPass = this.h;
        n86.d(superPass, "lSuperPass");
        Bitmap e = f2.e(z25, superPass);
        int i2 = this.i;
        imageView.setImageBitmap(Bitmap.createScaledBitmap(e, i2, i2, false));
        return s56.f3190a;
    }
}
