package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import server.zophop.logging.LoggingConstants;

/* renamed from: nc1  reason: default package */
/* compiled from: EtaListCard */
public class nc1 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ String i;
    public final /* synthetic */ oc1 j;

    public nc1(oc1 oc1, String str, String str2, boolean z, String str3) {
        this.j = oc1;
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = str3;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f)) {
            oc1.a(this.j, this.g, this.h, true);
            if (this.f.equalsIgnoreCase("dialog")) {
                this.j.i.a(Boolean.TRUE);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f));
            intent.putExtra(LoggingConstants.ROUTE_ID, this.i);
            intent.putExtra("mode", "bus");
            this.j.f.startActivity(intent);
        }
    }
}
