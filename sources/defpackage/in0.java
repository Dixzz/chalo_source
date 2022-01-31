package defpackage;

import android.view.View;
import app.zophop.scanPay.ScanPayBaseActivity;

/* renamed from: in0  reason: default package */
/* compiled from: ScanPayGuidelinesDialog */
public class in0 implements View.OnClickListener {
    public final /* synthetic */ jn0 f;

    public in0(jn0 jn0) {
        this.f = jn0;
    }

    public void onClick(View view) {
        this.f.dismiss();
        if (this.f.c() instanceof ScanPayBaseActivity) {
            ((ScanPayBaseActivity) this.f.c()).o0();
        }
    }
}
