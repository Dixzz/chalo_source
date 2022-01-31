package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;
import java.util.HashMap;

/* renamed from: t01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class t01 implements View.OnClickListener {
    public final /* synthetic */ SuperPass f;
    public final /* synthetic */ ActivateSuperPassFragment g;

    public /* synthetic */ t01(SuperPass superPass, ActivateSuperPassFragment activateSuperPassFragment) {
        this.f = superPass;
        this.g = activateSuperPassFragment;
    }

    public final void onClick(View view) {
        SuperPass superPass = this.f;
        ActivateSuperPassFragment activateSuperPassFragment = this.g;
        ActivateSuperPassFragment.a aVar = ActivateSuperPassFragment.h;
        n86.e(superPass, "$lSuperPass");
        n86.e(activateSuperPassFragment, "this$0");
        if (superPass.canActivate()) {
            if (superPass.getSuperPassProperties().getProductSubType() == SuperPassSubType.RIDE_BASED_SUPER_PASS) {
                RideBasedSuperPass rideBasedSuperPass = (RideBasedSuperPass) superPass;
                if (!rideBasedSuperPass.getSuperPassValidationProperties().shouldReclaim(rideBasedSuperPass.getSuperPassProperties().getCityName())) {
                    FragmentManager parentFragmentManager = activateSuperPassFragment.getParentFragmentManager();
                    String string = activateSuperPassFragment.getString(R.string.dialog_message_confirm_pass_activation_header);
                    String string2 = activateSuperPassFragment.getString(R.string.dialog_trip_info);
                    String string3 = activateSuperPassFragment.getResources().getString(R.string.yes);
                    String string4 = activateSuperPassFragment.getResources().getString(R.string.cancel);
                    n86.e("activate use within active duration", "tag");
                    hm0 hm0 = null;
                    if (parentFragmentManager != null) {
                        Fragment I = parentFragmentManager.I("activate use within active duration");
                        boolean z = false;
                        if (I != null && I.isVisible()) {
                            z = true;
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
                            hm02.show(parentFragmentManager, "activate use within active duration");
                            hm0 = hm02;
                        }
                    }
                    if (hm0 != null) {
                        hm0.m = new q01(hm0, activateSuperPassFragment, rideBasedSuperPass, superPass);
                        hm0.n = new r01(hm0);
                    }
                }
            } else {
                activateSuperPassFragment.g(superPass);
            }
        }
        zz zzVar = new zz("activation button clicked", new HashMap());
        zzVar.a("date", jh1.c(ui1.Q()));
        zzVar.a("time", jh1.g(ui1.Q()));
        ui1.l0(zzVar);
        ed1 ed1 = new ed1("activation button clicked", Long.MIN_VALUE);
        ed1.a("passId", superPass.getSuperPassProperties().getPassId());
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.B().h() != null) {
            LatLng h = t1Var.B().h();
            ed1.a("long", hj1.U(hj1.f0(ed1, "lat", hj1.U(new StringBuilder(), h.latitude, "")), h.longitude, ""));
        }
        ed1.a("source", "Activate Super pass Screen");
        gi1.f1265a.d(ed1, superPass);
        ui1.m0(ed1);
    }
}
