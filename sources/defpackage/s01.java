package defpackage;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;

/* renamed from: s01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class s01 implements View.OnClickListener {
    public final /* synthetic */ ActivateSuperPassFragment f;
    public final /* synthetic */ SuperPass g;

    public /* synthetic */ s01(ActivateSuperPassFragment activateSuperPassFragment, SuperPass superPass) {
        this.f = activateSuperPassFragment;
        this.g = superPass;
    }

    public final void onClick(View view) {
        ActivateSuperPassFragment activateSuperPassFragment = this.f;
        SuperPass superPass = this.g;
        ActivateSuperPassFragment.a aVar = ActivateSuperPassFragment.h;
        n86.e(activateSuperPassFragment, "this$0");
        n86.e(superPass, "$lSuperPass");
        ve activity = activateSuperPassFragment.c();
        if (activity != null) {
            ed1 ed1 = new ed1("view trip receipt button clicked", Long.MIN_VALUE);
            ed1.a("passId", superPass.getSuperPassProperties().getPassId());
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.B().h() != null) {
                LatLng h = t1Var.B().h();
                ed1.a("long", hj1.U(hj1.f0(ed1, "lat", hj1.U(new StringBuilder(), h.latitude, "")), h.longitude, ""));
            }
            ed1.a("source", "Activate Super pass Screen");
            gi1.f1265a.d(ed1, superPass);
            ui1.m0(ed1);
            String passId = superPass.getSuperPassProperties().getPassId();
            SuperPassSubType productSubType = superPass.getSuperPassProperties().getProductSubType();
            n86.e(passId, "lSuperPassId");
            n86.e(productSubType, "lSuperPassSubType");
            n86.e("sourceActivateSuperPassScreen", "lSource");
            n86.e(activity, "lContext");
            Intent intent = new Intent(activity, SuperPassBookingSummaryActivity.class);
            intent.putExtra("arg_source", "sourceActivateSuperPassScreen");
            intent.putExtra("arg_startDestination", "startDestinationSuperPassTripReceiptHistoryScreen");
            intent.putExtra("arg_superPassId", passId);
            intent.putExtra("arg_superPassSubType", (Parcelable) productSubType);
            activity.startActivity(intent);
        }
    }
}
