package defpackage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;
import java.util.Objects;

@y66(c = "app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment$setUpActivationExpiredDialog$1$1", f = "ActiveSuperPassVisualValidationFragment.kt", l = {}, m = "invokeSuspend")
/* renamed from: m31  reason: default package */
/* compiled from: ActiveSuperPassVisualValidationFragment.kt */
public final class m31 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ SuperPass f;
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m31(SuperPass superPass, ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment, k66<? super m31> k66) {
        super(2, k66);
        this.f = superPass;
        this.g = activeSuperPassVisualValidationFragment;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new m31(this.f, this.g, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        m31 m31 = new m31(this.f, this.g, k66);
        s56 s56 = s56.f3190a;
        m31.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        if (!this.f.isSuperPassActivationValid()) {
            ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment = this.g;
            SuperPass superPass = this.f;
            ActiveSuperPassVisualValidationFragment.a aVar = ActiveSuperPassVisualValidationFragment.i;
            Objects.requireNonNull(activeSuperPassVisualValidationFragment);
            gi1.h(gi1.f1265a, "mpass activation duration expired dialog shown", superPass, "Active Super Pass Visual validation Fragment", 0, 8);
            FragmentManager childFragmentManager = activeSuperPassVisualValidationFragment.getChildFragmentManager();
            String string = activeSuperPassVisualValidationFragment.getResources().getString(R.string.activation_expired_pass_title);
            String string2 = activeSuperPassVisualValidationFragment.getResources().getString(R.string.activation_expired_pass_copy);
            String string3 = activeSuperPassVisualValidationFragment.getResources().getString(R.string.got_it);
            String string4 = activeSuperPassVisualValidationFragment.getResources().getString(R.string.see_details);
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
                hm0.m = new i11(hm0, superPass, hm0);
                hm0.n = new j11(hm0, superPass, hm0);
            }
        }
        return s56.f3190a;
    }
}
