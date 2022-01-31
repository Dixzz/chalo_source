package defpackage;

import android.util.Base64;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: c21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class c21 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SoundFragmentSuperPass f506a;

    public /* synthetic */ c21(SoundFragmentSuperPass soundFragmentSuperPass) {
        this.f506a = soundFragmentSuperPass;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SoundFragmentSuperPass soundFragmentSuperPass = this.f506a;
        SuperPass superPass = (SuperPass) obj;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        n86.e(soundFragmentSuperPass, "this$0");
        n86.d(superPass, "lSuperPass");
        String tone = superPass.getSuperPassProperties().getTone();
        if (tone != null) {
            xt.f3961a.g0().e(Base64.decode(tone, 0));
        }
    }
}
