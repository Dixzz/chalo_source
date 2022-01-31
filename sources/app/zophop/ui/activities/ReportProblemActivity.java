package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.ReportProblemCollection;
import app.zophop.models.ReportProblemFeatureCategory;
import app.zophop.models.ReportProblemFeatureProblem;
import app.zophop.pubsub.AutoLinkDeviceEvent;
import app.zophop.pubsub.eventbus.events.TransactionsFetchedOnlineEvent;
import defpackage.xt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ReportProblemActivity.kt */
public final class ReportProblemActivity extends au {
    public static final a r = new a(null);
    public static ReportProblemCollection s;
    public static Map<String, String> t;
    public static List<ReportProblemFeatureCategory> u;
    public Toolbar k;
    public LinearLayout l;
    public boolean m;
    public String n;
    public DialogFragment o;
    public Handler p;
    public boolean q;

    /* compiled from: ReportProblemActivity.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final void a(Context context, ReportProblemCollection reportProblemCollection, String str, Map<String, String> map, List<ReportProblemFeatureCategory> list) {
            n86.e(str, "source");
            n86.e(map, "userPropertiesMap");
            n86.e(list, "additionalProblemCategoryList");
            if (reportProblemCollection != null && context != null) {
                ReportProblemActivity.s = reportProblemCollection;
                ReportProblemActivity.t = map;
                ReportProblemActivity.u = list;
                Intent intent = new Intent(context, ReportProblemActivity.class);
                intent.putExtra("src", str);
                context.startActivity(intent);
            }
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.activity_report_problem);
        View findViewById = findViewById(R.id.toolbar);
        n86.d(findViewById, "findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById;
        this.k = toolbar;
        setSupportActionBar(toolbar);
        x supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            ReportProblemCollection reportProblemCollection = s;
            if (reportProblemCollection != null) {
                supportActionBar.z(reportProblemCollection.getTitle());
            } else {
                n86.l("_problemCollection");
                throw null;
            }
        }
        x supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.o(true);
        }
        View findViewById2 = findViewById(R.id.report_problem_linear_layout);
        n86.d(findViewById2, "findViewById(R.id.report_problem_linear_layout)");
        this.l = (LinearLayout) findViewById2;
        ReportProblemCollection reportProblemCollection2 = s;
        if (reportProblemCollection2 != null) {
            List<ReportProblemFeatureCategory> categoryList = reportProblemCollection2.getCategoryList();
            List<ReportProblemFeatureCategory> list = u;
            if (list != null) {
                if (!list.isEmpty()) {
                    List<ReportProblemFeatureCategory> list2 = u;
                    if (list2 != null) {
                        for (ReportProblemFeatureCategory reportProblemFeatureCategory : list2) {
                            LinearLayout linearLayout = this.l;
                            if (linearLayout != null) {
                                linearLayout.addView(new rb1(this, reportProblemFeatureCategory.getCategoryName(), true));
                                Iterator<ReportProblemFeatureProblem> it = reportProblemFeatureCategory.getProblemList().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        ReportProblemFeatureProblem next = it.next();
                                        LinearLayout linearLayout2 = this.l;
                                        if (linearLayout2 != null) {
                                            h0(linearLayout2, next);
                                        } else {
                                            n86.l("_reportProblemLinearLayout");
                                            throw null;
                                        }
                                    }
                                }
                            } else {
                                n86.l("_reportProblemLinearLayout");
                                throw null;
                            }
                        }
                    } else {
                        n86.l("_additionalProblemCategoryList");
                        throw null;
                    }
                }
                for (ReportProblemFeatureCategory reportProblemFeatureCategory2 : categoryList) {
                    LinearLayout linearLayout3 = this.l;
                    if (linearLayout3 != null) {
                        linearLayout3.addView(new rb1(this, reportProblemFeatureCategory2.getCategoryName(), true));
                        Iterator<ReportProblemFeatureProblem> it2 = reportProblemFeatureCategory2.getProblemList().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                ReportProblemFeatureProblem next2 = it2.next();
                                LinearLayout linearLayout4 = this.l;
                                if (linearLayout4 != null) {
                                    h0(linearLayout4, next2);
                                } else {
                                    n86.l("_reportProblemLinearLayout");
                                    throw null;
                                }
                            }
                        }
                    } else {
                        n86.l("_reportProblemLinearLayout");
                        throw null;
                    }
                }
                this.p = new Handler();
                fv0 fv0 = (fv0) getFragmentManager().findFragmentByTag("loader_tag");
                this.o = fv0;
                if (fv0 == null) {
                    fv0 T = vn.T(null, getString(R.string.loading), false, false);
                    this.o = T;
                    T.setRetainInstance(true);
                    return;
                }
                return;
            }
            n86.l("_additionalProblemCategoryList");
            throw null;
        }
        n86.l("_problemCollection");
        throw null;
    }

    public final void h0(View view, ReportProblemFeatureProblem reportProblemFeatureProblem) {
        rb1 rb1 = new rb1(this, reportProblemFeatureProblem.getProblemCopy(), false);
        rb1.setOnClickListener(new fa0(this, reportProblemFeatureProblem));
        ((LinearLayout) view).addView(rb1);
    }

    public final void i0(boolean z) {
        ed1 ed1 = new ed1("auto reclaim passes response", Long.MIN_VALUE);
        hj1.d(z, ed1, "isDeviceAutoLinked", ed1);
    }

    public final void j0(boolean z) {
        if (z) {
            lm0 a2 = lm0.a(getFragmentManager(), null, getString(R.string.dialog_message_reclaim_pass_successful), getResources().getString(R.string.okay), null);
            ea0 ea0 = new ea0(this, a2);
            TextView textView = a2.i;
            if (textView != null) {
                textView.setOnClickListener(ea0);
            } else {
                a2.q = ea0;
            }
        } else {
            lm0 a3 = lm0.a(getFragmentManager(), null, getString(R.string.dialog_message_reclaim_pass_not_successful), getResources().getString(R.string.continue_copy), getResources().getString(R.string.cancel_capital));
            ca0 ca0 = new ca0(this, a3);
            TextView textView2 = a3.i;
            if (textView2 != null) {
                textView2.setOnClickListener(ca0);
            } else {
                a3.q = ca0;
            }
            ba0 ba0 = new ba0(a3);
            TextView textView3 = a3.j;
            if (textView3 != null) {
                textView3.setOnClickListener(ba0);
            } else {
                a3.r = ba0;
            }
        }
    }

    public final void k0() {
        DialogFragment dialogFragment = this.o;
        Boolean valueOf = dialogFragment == null ? null : Boolean.valueOf(dialogFragment.isVisible());
        n86.c(valueOf);
        if (!valueOf.booleanValue()) {
            DialogFragment dialogFragment2 = this.o;
            n86.c(dialogFragment2);
            dialogFragment2.show(getFragmentManager(), "loader_tag");
        }
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "event");
        if (qd1.f2931a) {
            e0();
            this.m = false;
        } else if (!this.m) {
            Toolbar toolbar = this.k;
            if (toolbar != null) {
                this.m = f0(toolbar);
            } else {
                n86.l("_toolbar");
                throw null;
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        super.onBackPressed();
        return true;
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public final void onEvent(AutoLinkDeviceEvent autoLinkDeviceEvent) {
        jz5 b = jz5.b();
        n86.c(autoLinkDeviceEvent);
        b.m(autoLinkDeviceEvent);
        Handler handler = this.p;
        if (handler != null) {
            handler.postDelayed(new da0(this), 200);
        }
        if (autoLinkDeviceEvent.getResponseType() == null) {
            Toast.makeText(this, getString(R.string.toast_generic_error_message), 0).show();
        } else if (autoLinkDeviceEvent.getResponseType() != ad1.SUCCESS) {
            Toast.makeText(this, getString(R.string.toast_generic_error_message), 0).show();
        } else if (this.n != null && autoLinkDeviceEvent.getRequestId() != null && n86.a(this.n, autoLinkDeviceEvent.getRequestId())) {
            if (autoLinkDeviceEvent.isIsAutoLinked()) {
                i0(true);
                k0();
                this.q = true;
                xt.t1 t1Var = xt.f3961a;
                t1Var.c().d(t1Var.L().e().getUserId(), t1Var.L().j());
                return;
            }
            i0(false);
            j0(false);
        }
    }

    public final void onEvent(TransactionsFetchedOnlineEvent transactionsFetchedOnlineEvent) {
        n86.e(transactionsFetchedOnlineEvent, "transactionsFetchedOnlineEvent");
        Handler handler = this.p;
        if (handler != null) {
            handler.postDelayed(new da0(this), 200);
        }
        if (this.q) {
            this.q = false;
            j0(true);
            jz5.b().m(transactionsFetchedOnlineEvent);
        }
    }
}
