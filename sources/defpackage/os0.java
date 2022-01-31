package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.fragments.UserProofUploadFragment;

/* renamed from: os0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class os0 implements View.OnClickListener {
    public final /* synthetic */ UserProofUploadFragment f;
    public final /* synthetic */ String g;

    public /* synthetic */ os0(UserProofUploadFragment userProofUploadFragment, String str) {
        this.f = userProofUploadFragment;
        this.g = str;
    }

    public final void onClick(View view) {
        UserProofUploadFragment userProofUploadFragment = this.f;
        String str = this.g;
        int i = UserProofUploadFragment.m;
        n86.e(userProofUploadFragment, "this$0");
        ed1 ed1 = new ed1("sample proof image zoomed", Long.MIN_VALUE);
        ed1.a("url", str);
        userProofUploadFragment.i(ed1);
        ui1.m0(ed1);
        ZoomedImageViewActivity.i0(userProofUploadFragment.c(), (ImageView) view, str, null, true);
    }
}
