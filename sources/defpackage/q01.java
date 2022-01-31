package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment;
import java.util.Objects;

/* renamed from: q01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class q01 implements View.OnClickListener {
    public final /* synthetic */ hm0 f;
    public final /* synthetic */ ActivateSuperPassFragment g;
    public final /* synthetic */ RideBasedSuperPass h;
    public final /* synthetic */ SuperPass i;

    public /* synthetic */ q01(hm0 hm0, ActivateSuperPassFragment activateSuperPassFragment, RideBasedSuperPass rideBasedSuperPass, SuperPass superPass) {
        this.f = hm0;
        this.g = activateSuperPassFragment;
        this.h = rideBasedSuperPass;
        this.i = superPass;
    }

    public final void onClick(View view) {
        String str;
        String str2;
        hm0 hm0 = this.f;
        ActivateSuperPassFragment activateSuperPassFragment = this.g;
        RideBasedSuperPass rideBasedSuperPass = this.h;
        SuperPass superPass = this.i;
        ActivateSuperPassFragment.a aVar = ActivateSuperPassFragment.h;
        n86.e(activateSuperPassFragment, "this$0");
        n86.e(rideBasedSuperPass, "$lRideBasedSuperPass");
        n86.e(superPass, "$lSuperPass");
        hm0.dismiss();
        Objects.requireNonNull(activateSuperPassFragment.f());
        n86.e(rideBasedSuperPass, "lSuperPass");
        if (!rideBasedSuperPass.isRideAvailableToday()) {
            FragmentManager parentFragmentManager = activateSuperPassFragment.getParentFragmentManager();
            if (rideBasedSuperPass.getRemainingTotalTrips() <= 0) {
                str = activateSuperPassFragment.getString(R.string.dialog_all_ride_over_header);
            } else {
                str = activateSuperPassFragment.getString(R.string.dialog_ride_over_header);
            }
            if (rideBasedSuperPass.getRemainingTotalTrips() <= 0) {
                str2 = activateSuperPassFragment.getString(R.string.dialog_all_ride_over_desc);
            } else {
                str2 = activateSuperPassFragment.getString(R.string.dialog_ride_over_desc);
            }
            String string = activateSuperPassFragment.getResources().getString(R.string.okay);
            n86.e("no rides available", "tag");
            hm0 hm02 = null;
            if (parentFragmentManager != null) {
                Fragment I = parentFragmentManager.I("no rides available");
                boolean z = false;
                if (I != null && I.isVisible()) {
                    z = true;
                }
                if (!z) {
                    hm0 hm03 = new hm0(null);
                    Bundle bundle = new Bundle();
                    if (str != null) {
                        bundle.putString("extra:title_copy", str);
                    }
                    bundle.putString("extra:message_copy", str2);
                    bundle.putString("extra:postive_action_copy", string);
                    hm03.setArguments(bundle);
                    hm03.show(parentFragmentManager, "no rides available");
                    hm02 = hm03;
                }
            }
            if (hm02 != null) {
                hm02.m = new p01(hm02);
                return;
            }
            return;
        }
        activateSuperPassFragment.g(superPass);
    }
}
