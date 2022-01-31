package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/* renamed from: gh1  reason: default package */
/* compiled from: NetworkUtils */
public class gh1 implements View.OnClickListener {
    public final /* synthetic */ Context f;

    public gh1(Context context) {
        this.f = context;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("internet settings opened", Long.MIN_VALUE));
        this.f.startActivity(new Intent("android.settings.SETTINGS"));
    }
}
