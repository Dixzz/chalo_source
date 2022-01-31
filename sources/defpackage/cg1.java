package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import app.zophop.utilities.models.InAppMessageDetails;

/* renamed from: cg1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class cg1 implements View.OnClickListener {
    public final /* synthetic */ InAppMessageDetails f;
    public final /* synthetic */ String g;
    public final /* synthetic */ jg1 h;
    public final /* synthetic */ String i;

    public /* synthetic */ cg1(InAppMessageDetails inAppMessageDetails, String str, jg1 jg1, String str2) {
        this.f = inAppMessageDetails;
        this.g = str;
        this.h = jg1;
        this.i = str2;
    }

    public final void onClick(View view) {
        InAppMessageDetails inAppMessageDetails = this.f;
        String str = this.g;
        jg1 jg1 = this.h;
        String str2 = this.i;
        n86.e(jg1, "this$0");
        boolean z = false;
        if (inAppMessageDetails.a() == 1) {
            n86.d(str, "buttonCta");
            if (str.length() > 0) {
                String str3 = InAppMessageDetails.g;
                n86.d(str3, "data.notificationId");
                String str4 = InAppMessageDetails.q;
                n86.d(str4, "data.keyTitleText");
                String str5 = InAppMessageDetails.m;
                n86.d(str5, "data.keyButtonText");
                jg1.d("positive", str3, str4, str5);
                jg1.dismiss();
                jg1.l = true;
                jg1.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return;
            }
        }
        if ((InAppMessageDetails.o == 0 ? (char) '\b' : 1) == 1) {
            n86.d(str2, "positiveCta");
            if (str2.length() > 0) {
                z = true;
            }
            if (z) {
                String str6 = InAppMessageDetails.g;
                n86.d(str6, "data.notificationId");
                String str7 = InAppMessageDetails.q;
                n86.d(str7, "data.keyTitleText");
                String str8 = InAppMessageDetails.t;
                n86.d(str8, "data.keyPositiveBtnText");
                jg1.d("positive", str6, str7, str8);
                jg1.dismiss();
                jg1.l = true;
                jg1.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                return;
            }
        }
        if (inAppMessageDetails.a() == 1) {
            String str9 = InAppMessageDetails.g;
            n86.d(str9, "data.notificationId");
            String str10 = InAppMessageDetails.q;
            n86.d(str10, "data.keyTitleText");
            String str11 = InAppMessageDetails.m;
            n86.d(str11, "data.keyButtonText");
            jg1.d("positive", str9, str10, str11);
        } else {
            String str12 = InAppMessageDetails.g;
            n86.d(str12, "data.notificationId");
            String str13 = InAppMessageDetails.q;
            n86.d(str13, "data.keyTitleText");
            String str14 = InAppMessageDetails.t;
            n86.d(str14, "data.keyPositiveBtnText");
            jg1.d("positive", str12, str13, str14);
        }
        jg1.dismiss();
    }
}
