package defpackage;

import android.view.View;
import app.zophop.scanPay.ScanPayBaseActivity;

/* renamed from: q80  reason: default package */
/* compiled from: ScanPayBaseActivity */
public class q80 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;
    public final /* synthetic */ ScanPayBaseActivity g;

    public q80(ScanPayBaseActivity scanPayBaseActivity, lm0 lm0) {
        this.g = scanPayBaseActivity;
        this.f = lm0;
    }

    public void onClick(View view) {
        this.f.dismiss();
        this.g.o0();
    }
}
