package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.superPass.CashPaymentPendingTransactionDetails;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;

/* compiled from: SuperPassCashPaymentWebViewActivity.kt */
public final class SuperPassCashPaymentWebViewActivity extends WebViewActivity {
    public SuperPassApplication r;
    public String s;

    public static final void l0(String str, SuperPassApplication superPassApplication, BookableSuperPassConfiguration bookableSuperPassConfiguration, Context context) {
        n86.e(str, "lSource");
        n86.e(superPassApplication, "lSuperPassApplication");
        n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
        n86.e(context, "lContext");
        Intent intent = new Intent(context, SuperPassCashPaymentWebViewActivity.class);
        intent.putExtra("arg_pendingSuperPassString", superPassApplication);
        intent.putExtra("arg_source", str);
        String string = context.getResources().getString(R.string.cash_center);
        n86.d(string, "lContext.resources.getString(R.string.cash_center)");
        StringBuilder sb = new StringBuilder();
        sb.append(ut.D);
        sb.append("?referenceId=");
        CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails = superPassApplication.getCashPaymentPendingTransactionDetails();
        n86.c(cashPaymentPendingTransactionDetails);
        sb.append(cashPaymentPendingTransactionDetails.getReferenceId());
        sb.append("&mobile_number=");
        sb.append(superPassApplication.getSuperPassUserDetails().getMobileNumber());
        sb.append("&amount=");
        sb.append(superPassApplication.getCashPaymentPendingTransactionDetails().getPendingFare());
        sb.append("&city=");
        sb.append(bookableSuperPassConfiguration.getSuperPassProductConfigurationProperties().getProductCity());
        sb.append("&agency=");
        sb.append(bookableSuperPassConfiguration.getSuperPassProductConfigurationProperties().getProductAgency());
        intent.putExtra("extra:url", sb.toString());
        intent.putExtra("extra:name", string);
        intent.putExtra("extra:image_mode", false);
        intent.putExtra("extra:action_bar", false);
        intent.putExtra("extra:source", str);
        context.startActivity(intent);
    }

    @Override // app.zophop.ui.activities.WebViewActivity, defpackage.tf1
    public void e(Bundle bundle) {
        super.e(bundle);
        if (bundle != null) {
            SuperPassApplication superPassApplication = (SuperPassApplication) bundle.getParcelable("arg_pendingSuperPassString");
            if (superPassApplication != null) {
                this.r = superPassApplication;
            }
            String string = bundle.getString("arg_source");
            if (string != null) {
                this.s = string;
            }
        } else {
            Parcelable parcelableExtra = getIntent().getParcelableExtra("arg_pendingSuperPassString");
            n86.c(parcelableExtra);
            n86.d(parcelableExtra, "intent.getParcelableExtr…SUPER_PASS_APPLICATION)!!");
            this.r = (SuperPassApplication) parcelableExtra;
            String stringExtra = getIntent().getStringExtra("arg_source");
            n86.c(stringExtra);
            n86.d(stringExtra, "intent.getStringExtra(ARG_SOURCE)!!");
            this.s = stringExtra;
        }
        jz5.b().g(new ed1("Cash Activity loaded", Long.MIN_VALUE));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        if (getIntent() == null || getIntent().getStringExtra("extra:source") == null || !ea6.f(getIntent().getStringExtra("extra:source"), "passHistory", true)) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            return;
        }
        super.onBackPressed();
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        n86.e(menu, "menu");
        getMenuInflater().inflate(R.menu.change_payment_mode, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    @Override // defpackage.wt
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onOptionsItemSelected(android.view.MenuItem r23) {
        /*
        // Method dump skipped, instructions count: 558
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.SuperPassCashPaymentWebViewActivity.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public void onRestoreInstanceState(Bundle bundle) {
        n86.e(bundle, "savedInstanceState");
        SuperPassApplication superPassApplication = (SuperPassApplication) bundle.getParcelable("arg_pendingSuperPassString");
        if (superPassApplication != null) {
            this.r = superPassApplication;
        }
        String string = bundle.getString("arg_source");
        if (string != null) {
            this.s = string;
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        n86.e(bundle, "outState");
        SuperPassApplication superPassApplication = this.r;
        if (superPassApplication != null) {
            bundle.putParcelable("arg_pendingSuperPassString", superPassApplication);
            String str = this.s;
            if (str != null) {
                bundle.putString("arg_source", str);
                super.onSaveInstanceState(bundle);
                return;
            }
            n86.l("source");
            throw null;
        }
        n86.l("superPassApplication");
        throw null;
    }
}
