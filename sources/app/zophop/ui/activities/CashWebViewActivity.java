package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import app.zophop.R;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductActiveStatus;
import app.zophop.models.mTicketing.ProductConfiguration;

public class CashWebViewActivity extends WebViewActivity {
    public static MPass r;

    public static Intent l0(Context context, String str, String str2, MPass mPass, boolean z, boolean z2, String str3) {
        Intent N0 = hj1.N0(context, CashWebViewActivity.class, "extra:url", str);
        N0.putExtra("extra:name", str2);
        N0.putExtra("extra:image_mode", z);
        N0.putExtra("extra:action_bar", z2);
        N0.putExtra("extra:source", str3);
        r = mPass;
        return N0;
    }

    @Override // app.zophop.ui.activities.WebViewActivity, defpackage.tf1
    public void e(Bundle bundle) {
        super.e(bundle);
        jz5.b().g(new ed1("Cash Activity loaded", Long.MIN_VALUE));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        if (getIntent() == null || getIntent().getStringExtra("extra:source") == null || !getIntent().getStringExtra("extra:source").equalsIgnoreCase("passHistory")) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            return;
        }
        super.onBackPressed();
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.change_payment_mode, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (getIntent() == null || getIntent().getStringExtra("extra:source") == null || !getIntent().getStringExtra("extra:source").equalsIgnoreCase("passHistory")) {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(268468224);
                startActivity(intent);
                return true;
            }
            super.onBackPressed();
        } else if (menuItem.getItemId() == R.id.change_mode) {
            ProductConfiguration m0 = vn.m0(r.getConfigId());
            if (m0 == null) {
                String string = getResources().getString(R.string.recent_products_not_available_dialog_copy);
                if (string == null) {
                    string = getString(R.string.recent_products_disabled_dialog_copy);
                }
                String string2 = getString(R.string.recent_products_disabled_dialog_title);
                if (string.equals(getString(R.string.recent_products_not_available_dialog_copy))) {
                    string2 = getString(R.string.recent_products_not_available_dialog_title);
                }
                xm0.a(getFragmentManager(), this, new pd0(this, string), CashWebViewActivity.class.getSimpleName(), string, string2, false);
                return true;
            }
            ProductActiveStatus h = vn.h(r, m0);
            if (!h.getIsActive()) {
                String inactiveReason = h.getInactiveReason();
                if (inactiveReason == null) {
                    inactiveReason = getResources().getString(R.string.recent_products_disabled_dialog_copy);
                }
                if (inactiveReason == null) {
                    inactiveReason = getString(R.string.recent_products_disabled_dialog_copy);
                }
                String string3 = getString(R.string.recent_products_disabled_dialog_title);
                if (inactiveReason.equals(getString(R.string.recent_products_not_available_dialog_copy))) {
                    string3 = getString(R.string.recent_products_not_available_dialog_title);
                }
                xm0.a(getFragmentManager(), this, new pd0(this, inactiveReason), CashWebViewActivity.class.getSimpleName(), inactiveReason, string3, false);
                return true;
            }
            MPass mPass = r;
            n86.e(this, "lContext");
            n86.e("sourceVerificationPendingStatusCard", "lSource");
            n86.e("flowPaymentPostVerification", "lPurchaseFlowType");
            n86.e(mPass, "lMPass");
            Intent intent2 = new Intent(this, MPassPurchaseActivity.class);
            intent2.putExtra("arg_source", "sourceVerificationPendingStatusCard");
            intent2.putExtra("arg_purchase_flow_type", "flowPaymentPostVerification");
            intent2.putExtra("arg_mPass", ov.f(mPass));
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
