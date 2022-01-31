package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Objects;

/* renamed from: lj0  reason: default package */
/* compiled from: HomeDrawerAdapter */
public class lj0 implements View.OnClickListener {
    public final /* synthetic */ pj0 f;

    public lj0(pj0 pj0) {
        this.f = pj0;
    }

    public void onClick(View view) {
        pj0 pj0 = this.f;
        Context context = pj0.h;
        Objects.requireNonNull(pj0);
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(context.getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode >= 3002850 ? "fb://facewebmodal/f?href=https://www.facebook.com/chaloapp/" : "fb://page/zophopapp"));
            intent.addFlags(268435456);
            pj0.h.startActivity(intent);
        } catch (Exception unused) {
            pj0.h.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/chaloapp/")));
        }
        pj0.a(this.f, "facebook");
    }
}
