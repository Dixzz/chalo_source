package defpackage;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.mTicketing.MagicPassesProperties;
import app.zophop.ui.fragments.ProductHistoryFragment;
import defpackage.xt;
import java.util.HashMap;

/* renamed from: rr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class rr0 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductHistoryFragment f3120a;

    public /* synthetic */ rr0(ProductHistoryFragment productHistoryFragment) {
        this.f3120a = productHistoryFragment;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ProductHistoryFragment productHistoryFragment = this.f3120a;
        int i = ProductHistoryFragment.g;
        n86.e(productHistoryFragment, "this$0");
        if (menuItem.getItemId() == R.id.report_problem_menu) {
            xt.t1 t1Var = xt.f3961a;
            d20 c = t1Var.c();
            City d = t1Var.k().d();
            n86.c(d);
            MagicPassesProperties a0 = c.a0(d.getName());
            boolean z = false;
            boolean z2 = a0 != null && a0.hasPassesOnMultipleDevices();
            y20 R = t1Var.R();
            Context requireContext = productHistoryFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            HashMap hashMap = new HashMap();
            if (t1Var.L().m()) {
                hashMap.put("userPropertyIsUserLoggedId", "true");
                d20 c2 = t1Var.c();
                City d2 = t1Var.k().d();
                n86.c(d2);
                MagicPassesProperties a02 = c2.a0(d2.getName());
                if (a02 != null && a02.hasPassesOnMultipleDevices()) {
                    z = true;
                }
                hashMap.put("userPropertyPassesOnMultipleDevices", String.valueOf(z));
                String q = t1Var.L().q();
                String t = t1Var.L().t();
                if (q != null) {
                    if (t != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append((Object) q);
                        sb.append(' ');
                        sb.append((Object) t);
                        q = sb.toString();
                    }
                    n86.d(q, "lFirstName");
                    hashMap.put("userPropertyUserName", q);
                } else if (t != null) {
                    hashMap.put("userPropertyUserName", t);
                }
                if (t1Var.L().getUserId() != null) {
                    String userId = t1Var.L().getUserId();
                    n86.d(userId, "profileFeature.userId");
                    hashMap.put("userPropertyUserID", userId);
                }
            } else {
                hashMap.put("userPropertyIsUserLoggedId", "false");
            }
            R.b(requireContext, "historyScreen", "activatePassScreen", hashMap, z2);
            ed1 l = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "otherTicketingProblemsV2");
            l.a("problemSource", "activatePassScreen");
            ui1.m0(l);
        }
        return true;
    }
}
