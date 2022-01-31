package defpackage;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.activities.SuperPassValidationActivity;

/* renamed from: oa0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class oa0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ SuperPass g;
    public final /* synthetic */ SuperPassValidationActivity h;

    public /* synthetic */ oa0(du0 du0, SuperPass superPass, SuperPassValidationActivity superPassValidationActivity) {
        this.f = du0;
        this.g = superPass;
        this.h = superPassValidationActivity;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        SuperPass superPass = this.g;
        SuperPassValidationActivity superPassValidationActivity = this.h;
        int i = SuperPassValidationActivity.l;
        n86.e(du0, "$lBottomSheet");
        n86.e(superPass, "$lSuperPass");
        n86.e(superPassValidationActivity, "this$0");
        du0.dismiss();
        String passId = superPass.getSuperPassProperties().getPassId();
        SuperPassSubType productSubType = superPass.getSuperPassProperties().getProductSubType();
        long lastActivationTimeStamp = superPass.getLastActivationTimeStamp();
        n86.e(passId, "lSuperPassId");
        n86.e(productSubType, "lSuperPassSubType");
        n86.e("sourceSuperPassValidationScreen", "lSource");
        n86.e(superPassValidationActivity, "lContext");
        Intent intent = new Intent(superPassValidationActivity, SuperPassBookingSummaryActivity.class);
        intent.putExtra("arg_source", "sourceSuperPassValidationScreen");
        intent.putExtra("arg_startDestination", "startDestinationSuperPassTripReceiptScreen");
        intent.putExtra("arg_superPassId", passId);
        intent.putExtra("arg_superPassSubType", (Parcelable) productSubType);
        intent.putExtra("arg_activationTimeStamp", lastActivationTimeStamp);
        superPassValidationActivity.startActivity(intent);
        superPassValidationActivity.finish();
    }
}
