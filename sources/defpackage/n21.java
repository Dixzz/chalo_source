package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.SoundVerificationFragmentSuperPass;

/* renamed from: n21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class n21 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SoundVerificationFragmentSuperPass f2507a;

    public /* synthetic */ n21(SoundVerificationFragmentSuperPass soundVerificationFragmentSuperPass) {
        this.f2507a = soundVerificationFragmentSuperPass;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SoundVerificationFragmentSuperPass soundVerificationFragmentSuperPass = this.f2507a;
        SuperPass superPass = (SuperPass) obj;
        SoundVerificationFragmentSuperPass.a aVar = SoundVerificationFragmentSuperPass.i;
        n86.e(soundVerificationFragmentSuperPass, "this$0");
        n86.d(superPass, "lSuperPass");
        T t = soundVerificationFragmentSuperPass.f;
        n86.c(t);
        ((gz) t).e.setOnMenuItemClickListener(new k21(soundVerificationFragmentSuperPass, superPass));
    }
}
