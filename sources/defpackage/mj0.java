package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Objects;

/* renamed from: mj0  reason: default package */
/* compiled from: HomeDrawerAdapter */
public class mj0 implements View.OnClickListener {
    public final /* synthetic */ pj0 f;

    public mj0(pj0 pj0) {
        this.f = pj0;
    }

    public void onClick(View view) {
        pj0 pj0 = this.f;
        Objects.requireNonNull(pj0);
        try {
            pj0.h.getPackageManager().getPackageInfo("com.twitter.android", 0);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("twitter://user?screen_name=chaloapp"));
            intent.addFlags(268435456);
            pj0.h.startActivity(intent);
        } catch (Exception unused) {
            pj0.h.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/chaloapp")));
        }
        pj0.a(this.f, "twitter");
    }
}
