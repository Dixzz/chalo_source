package defpackage;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

@y66(c = "app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass$checkAndActivateInCoroutine$1", f = "SoundFragmentSuperPass.kt", l = {}, m = "invokeSuspend")
/* renamed from: w31  reason: default package */
/* compiled from: SoundFragmentSuperPass.kt */
public final class w31 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public /* synthetic */ Object f;
    public final /* synthetic */ SoundFragmentSuperPass g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w31(SoundFragmentSuperPass soundFragmentSuperPass, k66<? super w31> k66) {
        super(2, k66);
        this.g = soundFragmentSuperPass;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        w31 w31 = new w31(this.g, k66);
        w31.f = obj;
        return w31;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        w31 w31 = new w31(this.g, k66);
        w31.f = mb6;
        s56 s56 = s56.f3190a;
        w31.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        if (hd3.C1((mb6) this.f)) {
            SoundFragmentSuperPass soundFragmentSuperPass = this.g;
            x91 x91 = soundFragmentSuperPass.h;
            if (x91 == null) {
                n86.l("localViewModel");
                throw null;
            } else if (!x91.e) {
                soundFragmentSuperPass.i();
            } else if (soundFragmentSuperPass.j().i) {
                this.g.i();
            } else {
                xt.f3961a.g0().a();
                SoundFragmentSuperPass soundFragmentSuperPass2 = this.g;
                vh1 vh1 = vh1.f3649a;
                n86.f(soundFragmentSuperPass2, "$this$findNavController");
                NavController d = NavHostFragment.d(soundFragmentSuperPass2);
                n86.b(d, "NavHostFragment.findNavController(this)");
                d41 d41 = new d41(null);
                d41.f783a.put("arg_source", "sound fragment");
                n86.d(d41, "actionSoundFragmentSuper…CE_NAME\n                )");
                vh1.a(d, d41);
            }
        }
        return s56.f3190a;
    }
}
