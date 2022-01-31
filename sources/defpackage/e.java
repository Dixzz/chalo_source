package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.truecaller.android.sdk.R;

/* renamed from: e  reason: default package */
/* compiled from: java-style lambda group */
public final class e implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ Object g;

    public e(int i, Object obj) {
        this.f = i;
        this.g = obj;
    }

    public final void onClick(View view) {
        int i = this.f;
        if (i == 0) {
            hd3.E0((Activity) this.g);
        } else if (i == 1) {
            ((Activity) this.g).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((Activity) this.g).getString(R.string.sdk_disclaimer_url))));
        } else {
            throw null;
        }
    }
}
