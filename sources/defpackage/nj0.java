package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.util.Objects;

/* renamed from: nj0  reason: default package */
/* compiled from: HomeDrawerAdapter */
public class nj0 implements View.OnClickListener {
    public final /* synthetic */ pj0 f;

    public nj0(pj0 pj0) {
        this.f = pj0;
    }

    public void onClick(View view) {
        pj0 pj0 = this.f;
        Objects.requireNonNull(pj0);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://instagram.com/_u/chalo.app"));
        intent.setPackage("com.instagram.android");
        try {
            pj0.h.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            pj0.h.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://instagram.com/chalo.app")));
        }
        pj0.a(this.f, "instagram");
    }
}
