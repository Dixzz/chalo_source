package defpackage;

import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.service.LocationTrackingService;
import defpackage.k90;

/* renamed from: ee0  reason: default package */
/* compiled from: LanguagePickerActivity */
public abstract class ee0 extends vf1 {
    @Override // defpackage.tf1
    public void d0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        intentFilter.addAction("android.location.PROVIDER_CHANGED_ACTION");
        this.g = new fh1();
        he1 he1 = new he1();
        this.h = he1;
        registerReceiver(he1, intentFilter);
        registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.tf1
    public void g0() {
        if (!LocationTrackingService.l) {
            unregisterReceiver(this.g);
            unregisterReceiver(this.h);
        }
    }

    @Override // defpackage.vf1
    public void m0() {
        ui1.g(this, xt.f3961a.z().b());
    }

    public void p0() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.loader_view, (ViewGroup) null);
        hj1.x0(inflate, R.id.alert_icon, 8, R.id.loading_spinner, 8);
        hj1.x0(inflate, R.id.connection_error_textview, 8, R.id.empty_view_text, 8);
        hj1.x0(inflate, R.id.retry, 8, R.id.empty_view_text, 8);
        inflate.setVisibility(8);
        ((LinearLayout) findViewById(R.id.location_list_container)).addView(inflate);
        this.k.setEmptyView(inflate);
    }

    public void q0(k90.a aVar) {
        View emptyView = this.k.getEmptyView();
        TextView textView = (TextView) emptyView.findViewById(R.id.miscellaneous_text);
        String obj = this.l.getText().toString();
        if (obj == null || obj.length() == 0) {
            textView.setText((CharSequence) null);
        } else if (aVar.equals(k90.a.NO_MATCH_FOUND)) {
            textView.setText(getString(R.string.no_entries_found));
            textView.setVisibility(0);
        } else if (aVar.equals(k90.a.NETWORK_ERROR)) {
            emptyView.setVisibility(8);
            textView.setText((CharSequence) null);
            f0(this.k);
        }
    }
}
