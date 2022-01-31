package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

@y66(c = "app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass$launchValidityChecks$1", f = "SoundFragmentSuperPass.kt", l = {196}, m = "invokeSuspend")
/* renamed from: x31  reason: default package */
/* compiled from: SoundFragmentSuperPass.kt */
public final class x31 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ SoundFragmentSuperPass h;
    public final /* synthetic */ SuperPass i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x31(SoundFragmentSuperPass soundFragmentSuperPass, SuperPass superPass, k66<? super x31> k66) {
        super(2, k66);
        this.h = soundFragmentSuperPass;
        this.i = superPass;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        x31 x31 = new x31(this.h, this.i, k66);
        x31.g = obj;
        return x31;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        x31 x31 = new x31(this.h, this.i, k66);
        x31.g = mb6;
        return x31.invokeSuspend(s56.f3190a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    @Override // defpackage.u66
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x31.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
