package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofUploadFragment;

/* renamed from: n51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class n51 implements View.OnClickListener {
    public final /* synthetic */ SuperPassUserProofUploadFragment f;
    public final /* synthetic */ String g;

    public /* synthetic */ n51(SuperPassUserProofUploadFragment superPassUserProofUploadFragment, String str) {
        this.f = superPassUserProofUploadFragment;
        this.g = str;
    }

    public final void onClick(View view) {
        SuperPassUserProofUploadFragment superPassUserProofUploadFragment = this.f;
        String str = this.g;
        int i = SuperPassUserProofUploadFragment.m;
        n86.e(superPassUserProofUploadFragment, "this$0");
        ed1 ed1 = new ed1("sample proof image zoomed", Long.MIN_VALUE);
        ed1.a("url", str);
        superPassUserProofUploadFragment.i(ed1);
        ui1.m0(ed1);
        ZoomedImageViewActivity.i0(superPassUserProofUploadFragment.c(), (ImageView) view, str, null, true);
    }
}
