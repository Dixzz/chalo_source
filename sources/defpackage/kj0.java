package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* renamed from: kj0  reason: default package */
/* compiled from: HomeDrawerAdapter */
public class kj0 implements View.OnClickListener {
    public final /* synthetic */ pj0 f;

    public kj0(pj0 pj0) {
        this.f = pj0;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("app update clicked", Long.MAX_VALUE));
        String packageName = this.f.h.getPackageName();
        try {
            Context context = this.f.h;
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            Context context2 = this.f.h;
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }
}
