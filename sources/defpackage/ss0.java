package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import app.zophop.ui.fragments.UserProofUploadFragment;

/* renamed from: ss0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ss0 implements View.OnClickListener {
    public final /* synthetic */ UserProofUploadFragment f;
    public final /* synthetic */ String g;

    public /* synthetic */ ss0(UserProofUploadFragment userProofUploadFragment, String str) {
        this.f = userProofUploadFragment;
        this.g = str;
    }

    public final void onClick(View view) {
        UserProofUploadFragment userProofUploadFragment = this.f;
        String str = this.g;
        int i = UserProofUploadFragment.m;
        n86.e(userProofUploadFragment, "this$0");
        n86.e(str, "$lVideoUrl");
        ed1 ed1 = new ed1("watch tutorial video clicked", Long.MIN_VALUE);
        ed1.a("url", str);
        userProofUploadFragment.i(ed1);
        ui1.m0(ed1);
        try {
            ve activity = userProofUploadFragment.c();
            if (activity != null) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        } catch (Exception e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
