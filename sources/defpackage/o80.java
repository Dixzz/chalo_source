package defpackage;

import app.zophop.scanPay.ScanPayBaseActivity;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

/* renamed from: o80  reason: default package */
/* compiled from: ScanPayBaseActivity */
public class o80 implements Runnable {
    public final /* synthetic */ e35 f;
    public final /* synthetic */ ScanPayBaseActivity.a g;

    public o80(ScanPayBaseActivity.a aVar, e35 e35) {
        this.g = aVar;
        this.f = e35;
    }

    public void run() {
        ScanPayBaseActivity scanPayBaseActivity = ScanPayBaseActivity.this;
        String str = this.f.f921a;
        int i = ScanPayBaseActivity.p;
        Objects.requireNonNull(scanPayBaseActivity);
        scanPayBaseActivity.n = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        while (stringTokenizer.hasMoreTokens()) {
            scanPayBaseActivity.n.add(stringTokenizer.nextToken());
        }
        scanPayBaseActivity.runOnUiThread(new p80(scanPayBaseActivity, str));
    }
}
