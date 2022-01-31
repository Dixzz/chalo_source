package defpackage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;
import java.util.Objects;

@y66(c = "app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment$setUpActivationExpiredDialog$1$1", f = "ActiveSuperPassFragment.kt", l = {}, m = "invokeSuspend")
/* renamed from: y21  reason: default package */
/* compiled from: ActiveSuperPassFragment.kt */
public final class y21 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ SuperPass f;
    public final /* synthetic */ ActiveSuperPassFragment g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y21(SuperPass superPass, ActiveSuperPassFragment activeSuperPassFragment, k66<? super y21> k66) {
        super(2, k66);
        this.f = superPass;
        this.g = activeSuperPassFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new y21(this.f, this.g, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        y21 y21 = new y21(this.f, this.g, k66);
        s56 s56 = s56.f3190a;
        y21.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        if (!this.f.isSuperPassActivationValid()) {
            ActiveSuperPassFragment activeSuperPassFragment = this.g;
            SuperPass superPass = this.f;
            ActiveSuperPassFragment.a aVar = ActiveSuperPassFragment.i;
            Objects.requireNonNull(activeSuperPassFragment);
            gi1.h(gi1.f1265a, "mpass activation duration expired dialog shown", superPass, "Active Super Pass Fragment", 0, 8);
            FragmentManager childFragmentManager = activeSuperPassFragment.getChildFragmentManager();
            String string = activeSuperPassFragment.getResources().getString(R.string.activation_expired_pass_title);
            String string2 = activeSuperPassFragment.getResources().getString(R.string.activation_expired_pass_copy);
            String string3 = activeSuperPassFragment.getResources().getString(R.string.got_it);
            String string4 = activeSuperPassFragment.getResources().getString(R.string.see_details);
            n86.e("active duration expired", "tag");
            hm0 hm0 = null;
            if (childFragmentManager != null) {
                Fragment I = childFragmentManager.I("active duration expired");
                boolean z = true;
                if (I == null || !I.isVisible()) {
                    z = false;
                }
                if (!z) {
                    hm0 hm02 = new hm0(null);
                    Bundle bundle = new Bundle();
                    if (string != null) {
                        bundle.putString("extra:title_copy", string);
                    }
                    bundle.putString("extra:message_copy", string2);
                    bundle.putString("extra:postive_action_copy", string3);
                    if (string4 != null) {
                        bundle.putString("extra:negative_action_copy", string4);
                    }
                    hm02.setArguments(bundle);
                    hm02.show(childFragmentManager, "active duration expired");
                    hm0 = hm02;
                }
            }
            if (hm0 != null) {
                hm0.setCancelable(false);
                hm0.m = new v01(hm0, superPass, hm0);
                hm0.n = new a11(hm0, superPass, hm0);
            }
        }
        return s56.f3190a;
    }
}
