package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/* renamed from: ri1  reason: default package */
/* compiled from: Utils */
public class ri1 implements View.OnClickListener {
    public final /* synthetic */ Context f;

    public ri1(Context context) {
        this.f = context;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("location settings opened", Long.MIN_VALUE));
        this.f.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
}
