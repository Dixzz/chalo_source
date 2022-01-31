package app.zophop.ui.activities.cardRecharge;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.ui.activities.HomeActivity;
import defpackage.xt;
import java.util.HashMap;

/* compiled from: OnlineCardRechargePaymentSuccessActivity.kt */
public final class OnlineCardRechargePaymentSuccessActivity extends tl0<cw> {
    public static final /* synthetic */ int n = 0;
    public String k;
    public String l;
    public String m;

    @Override // defpackage.ol0
    public qo g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_online_card_recharege_payment_success, (ViewGroup) null, false);
        int i = R.id.btn_okay;
        TextView textView = (TextView) inflate.findViewById(R.id.btn_okay);
        if (textView != null) {
            i = R.id.btn_recharge_details;
            TextView textView2 = (TextView) inflate.findViewById(R.id.btn_recharge_details);
            if (textView2 != null) {
                i = R.id.recharge_delay;
                TextView textView3 = (TextView) inflate.findViewById(R.id.recharge_delay);
                if (textView3 != null) {
                    i = R.id.step_one;
                    TextView textView4 = (TextView) inflate.findViewById(R.id.step_one);
                    if (textView4 != null) {
                        i = R.id.step_one_copy;
                        TextView textView5 = (TextView) inflate.findViewById(R.id.step_one_copy);
                        if (textView5 != null) {
                            i = R.id.step_two;
                            TextView textView6 = (TextView) inflate.findViewById(R.id.step_two);
                            if (textView6 != null) {
                                i = R.id.step_two_copy;
                                TextView textView7 = (TextView) inflate.findViewById(R.id.step_two_copy);
                                if (textView7 != null) {
                                    i = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
                                    if (toolbar != null) {
                                        cw cwVar = new cw((LinearLayout) inflate, textView, textView2, textView3, textView4, textView5, textView6, textView7, toolbar);
                                        n86.d(cwVar, "inflate(layoutInflater)");
                                        return cwVar;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.ol0
    public void i0() {
    }

    @Override // defpackage.ol0
    public void m0() {
    }

    @Override // defpackage.tl0
    public void o0() {
        String stringExtra = getIntent().getStringExtra("arg_source");
        n86.c(stringExtra);
        n86.d(stringExtra, "intent.getStringExtra(ARG_SOURCE)!!");
        this.k = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("arg_transactionId");
        n86.c(stringExtra2);
        n86.d(stringExtra2, "intent.getStringExtra(ARG_TRANSACTION_ID)!!");
        this.l = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("arg_rechargeDelayCopy");
        n86.c(stringExtra3);
        n86.d(stringExtra3, "intent.getStringExtra(ARG_RECHARGE_DELAY_COPY)!!");
        this.m = stringExtra3;
        ed1 ed1 = new ed1("ocr payment success activity open", Long.MIN_VALUE);
        String str = this.k;
        if (str != null) {
            ed1.a("source", str);
            String str2 = this.l;
            if (str2 != null) {
                ed1.a("cardTransactionId", str2);
                String str3 = this.m;
                if (str3 != null) {
                    ed1.a("ocr recharge delay copy", str3);
                    ui1.m0(ed1);
                    return;
                }
                n86.l(CardRechargeJsonKeys.RECHARGE_DELAY_COPY);
                throw null;
            }
            n86.l("transactionId");
            throw null;
        }
        n86.l("source");
        throw null;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ed1 ed1 = new ed1("ocr payment success back clicked", Long.MIN_VALUE);
        String str = this.l;
        if (str != null) {
            ed1.a("cardTransactionId", str);
            ui1.m0(ed1);
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            return;
        }
        n86.l("transactionId");
        throw null;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.report_problem_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "item");
        if (menuItem.getItemId() != R.id.report_problem_menu) {
            return false;
        }
        xt.t1 t1Var = xt.f3961a;
        y20 R = t1Var.R();
        HashMap hashMap = new HashMap();
        City d = t1Var.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "DependencyFactory.cityProvider.currentCity!!.name");
        hashMap.put("userPropertyCity", name);
        UserProfile e = t1Var.L().e();
        if (e != null) {
            String fullName = e.getFullName();
            n86.d(fullName, "it.fullName");
            hashMap.put("userPropertyUserName", fullName);
            String phone = e.getPhone();
            n86.d(phone, "it.phone");
            hashMap.put("userPropertyPhoneNo", phone);
            String userId = e.getUserId();
            n86.d(userId, "it.userId");
            hashMap.put("userPropertyUserID", userId);
        }
        R.b(this, "cardRelatedProblems", "cardRechargeHistoryActivity", hashMap, false);
        ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "cardRelatedProblems");
        l2.a("problemSource", "cardRechargeSuccessActivity");
        String str = this.l;
        if (str != null) {
            l2.a("cardTransactionId", str);
            ui1.m0(l2);
            return true;
        }
        n86.l("transactionId");
        throw null;
    }

    @Override // defpackage.tl0
    public void p0() {
        ((cw) f0()).c.setOnClickListener(new bi0(this));
        ((cw) f0()).b.setOnClickListener(new ci0(this));
    }

    @Override // defpackage.tl0
    public void q0() {
    }

    @Override // defpackage.tl0
    public void r0() {
        TextView textView = ((cw) f0()).d;
        String str = this.m;
        if (str != null) {
            textView.setText(str);
        } else {
            n86.l(CardRechargeJsonKeys.RECHARGE_DELAY_COPY);
            throw null;
        }
    }
}
