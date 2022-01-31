package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.ui.activities.SuperPassValidationActivity;
import com.google.gson.Gson;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: ra0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ra0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ hf1 f3063a;
    public final /* synthetic */ SuperPassValidationActivity b;

    public /* synthetic */ ra0(hf1 hf1, SuperPassValidationActivity superPassValidationActivity) {
        this.f3063a = hf1;
        this.b = superPassValidationActivity;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassTripReceipt superPassTripReceipt;
        FragmentManager childFragmentManager;
        List<Fragment> L;
        List list;
        hf1 hf1 = this.f3063a;
        SuperPassValidationActivity superPassValidationActivity = this.b;
        SuperPass superPass = (SuperPass) obj;
        long lastActivationTimeStamp = superPass.getLastActivationTimeStamp();
        n86.e(hf1, "lSuperPassPunchEvent");
        JSONObject jSONObject = new JSONObject(hf1.c);
        long optLong = jSONObject.optLong(DigitalTripReceiptJsonKeys.KEY_PUNCH_TIME, -1);
        if (optLong < lastActivationTimeStamp) {
            superPassTripReceipt = null;
        } else {
            if (jSONObject.has("specialFeatures")) {
                list = (List) new Gson().fromJson(jSONObject.getString("specialFeatures"), new w60().getType());
            } else {
                list = new ArrayList();
            }
            String string = jSONObject.getString("passId");
            n86.d(string, "getString(KEY_PASS_ID)");
            String string2 = jSONObject.getString("productType");
            n86.d(string2, "getString(KEY_PRODUCT_TYPE)");
            String string3 = jSONObject.getString("productSubType");
            n86.d(string3, "getString(KEY_PRODUCT_SUB_TYPE)");
            String optString = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, "");
            n86.d(optString, "optString(KEY_VEHICLE_NO…ppConstants.EMPTY_STRING)");
            String optString2 = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID, "");
            n86.d(optString2, "optString(KEY_CONDUCTOR_…ppConstants.EMPTY_STRING)");
            String optString3 = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_START_STOP, "");
            n86.d(optString3, "optString(KEY_START_STOP…ppConstants.EMPTY_STRING)");
            String optString4 = jSONObject.optString(DigitalTripReceiptJsonKeys.KEY_END_STOP, "");
            n86.d(optString4, "optString(KEY_END_STOP, AppConstants.EMPTY_STRING)");
            String optString5 = jSONObject.optString("routeName", "");
            n86.d(optString5, "optString(KEY_ROUTE_NAME…ppConstants.EMPTY_STRING)");
            n86.d(list, "lSpecialFeatures");
            superPassTripReceipt = new SuperPassTripReceipt(string, string2, string3, lastActivationTimeStamp, optLong, optString, optString2, optString3, optString4, optString5, list);
        }
        int i = SuperPassValidationActivity.l;
        Objects.requireNonNull(superPassValidationActivity);
        ed1 ed1 = new ed1("superPass trip punch", Long.MIN_VALUE);
        gi1.f1265a.g(ed1, superPassTripReceipt);
        if (superPassTripReceipt != null && superPassTripReceipt.isTripReceiptInfoAvailable()) {
            ed1.a("punch notification delay", Long.valueOf(ui1.Q() - superPassTripReceipt.getPunchTimeStamp()));
        }
        ui1.m0(ed1);
        if (n86.a(superPass.getSuperPassProperties().getPassId(), superPassTripReceipt == null ? null : superPassTripReceipt.getPassId()) && lastActivationTimeStamp < superPassTripReceipt.getPunchTimeStamp()) {
            xt.t1 t1Var = xt.f3961a;
            t1Var.g0().a();
            t1Var.q().updateSuperPassTripReceiptFromPunch(superPassTripReceipt);
            n86.d(superPass, "lSuperPass");
            FragmentManager supportFragmentManager = superPassValidationActivity.getSupportFragmentManager();
            n86.d(supportFragmentManager, "supportFragmentManager");
            du0 f = du0.f(supportFragmentManager, superPassValidationActivity.getString(R.string.view_receipt_bottomsheet_title), superPassValidationActivity.getString(R.string.view_receipt_bottomsheet_copy), superPassValidationActivity.getString(R.string.okay), superPassValidationActivity.getString(R.string.view_receipt_caps), 1, R.drawable.ticket_punch_success, "super pass validation activity");
            f.setCancelable(false);
            f.e(new qa0(f, superPassValidationActivity));
            f.d(new oa0(f, superPass, superPassValidationActivity));
            t1Var.c().d(t1Var.L().getUserId(), t1Var.L().j());
            FragmentManager supportFragmentManager2 = superPassValidationActivity.getSupportFragmentManager();
            n86.d(supportFragmentManager2, "supportFragmentManager");
            n86.e(supportFragmentManager2, "<this>");
            Fragment fragment = supportFragmentManager2.t;
            Fragment fragment2 = (fragment == null || (childFragmentManager = fragment.getChildFragmentManager()) == null || (L = childFragmentManager.L()) == null) ? null : (Fragment) y56.i(L);
            if (fragment2 != null) {
                hd3.C(wg.b(fragment2), null, 1);
            }
        }
    }
}
