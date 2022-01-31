package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import app.zophop.utilities.models.InAppMessageDetails;
import java.util.Objects;

/* renamed from: dg1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class dg1 implements View.OnClickListener {
    public final /* synthetic */ jg1 f;
    public final /* synthetic */ InAppMessageDetails g;
    public final /* synthetic */ String h;

    public /* synthetic */ dg1(jg1 jg1, InAppMessageDetails inAppMessageDetails, String str) {
        this.f = jg1;
        this.g = inAppMessageDetails;
        this.h = str;
    }

    public final void onClick(View view) {
        jg1 jg1 = this.f;
        InAppMessageDetails inAppMessageDetails = this.g;
        String str = this.h;
        n86.e(jg1, "this$0");
        Objects.requireNonNull(inAppMessageDetails);
        String str2 = InAppMessageDetails.g;
        n86.d(str2, "data.notificationId");
        String str3 = InAppMessageDetails.q;
        n86.d(str3, "data.keyTitleText");
        String str4 = InAppMessageDetails.u;
        n86.d(str4, "data.keyNegativeBtnText");
        jg1.d("negative", str2, str3, str4);
        n86.d(str, "negativeCta");
        if (str.length() > 0) {
            jg1.dismiss();
            jg1.l = true;
            jg1.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
        }
        jg1.dismiss();
    }
}
