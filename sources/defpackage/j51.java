package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;

/* renamed from: j51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class j51 implements View.OnClickListener {
    public final /* synthetic */ SuperPassUserProofUploadFragment f;
    public final /* synthetic */ String g;

    public /* synthetic */ j51(SuperPassUserProofUploadFragment superPassUserProofUploadFragment, String str) {
        this.f = superPassUserProofUploadFragment;
        this.g = str;
    }

    public final void onClick(View view) {
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f;
        String str = this.g;
        int i = SuperPassUserProofUploadFragment.m;
        n86.e(superPassUserProofUploadFragment, "this$0");
        n86.e(str, "$lVideoUrl");
        ed1 ed1 = new ed1("watch tutorial video clicked", Long.MIN_VALUE);
        ed1.a("url", str);
        superPassUserProofUploadFragment.i(ed1);
        ui1.m0(ed1);
        try {
            ve activity = superPassUserProofUploadFragment.c();
            if (activity != null) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        } catch (Exception e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
