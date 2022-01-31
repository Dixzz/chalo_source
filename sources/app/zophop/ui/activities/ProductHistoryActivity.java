package app.zophop.ui.activities;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import app.zophop.R;

/* compiled from: ProductHistoryActivity.kt */
public final class ProductHistoryActivity extends ol0<qy> {
    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.ol0
    public qy g0() {
        View inflate = getLayoutInflater().inflate(R.layout.product_history_activity, (ViewGroup) null, false);
        FragmentContainerView fragmentContainerView = (FragmentContainerView) inflate.findViewById(R.id.nav_host_fragment);
        if (fragmentContainerView != null) {
            qy qyVar = new qy((ConstraintLayout) inflate, fragmentContainerView);
            n86.d(qyVar, "inflate(layoutInflater)");
            return qyVar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.nav_host_fragment)));
    }

    @Override // defpackage.ol0
    public void h0(Bundle bundle) {
    }

    @Override // defpackage.ol0
    public void i0() {
    }

    @Override // defpackage.ol0
    public void j0() {
        registerReceiver(e0(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.ol0
    public void m0() {
    }

    @Override // defpackage.ol0
    public void n0() {
        unregisterReceiver(e0());
    }
}
