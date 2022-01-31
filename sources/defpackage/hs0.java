package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import defpackage.nw0;

/* renamed from: hs0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hs0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context f;
    public final /* synthetic */ nw0 g;

    public /* synthetic */ hs0(Context context, nw0 nw0) {
        this.f = context;
        this.g = nw0;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context = this.f;
        nw0 nw0 = this.g;
        nw0.a aVar = nw0.j;
        n86.e(context, "$it");
        n86.e(nw0, "this$0");
        n86.e("sound permission through settings selected", "lName");
        n86.e("sound info rationale fragment", "lSource");
        ed1 ed1 = new ed1("sound permission through settings selected", Long.MIN_VALUE);
        ed1.a("source", "sound info rationale fragment");
        ui1.m0(ed1);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        nw0.h.a(intent, null);
    }
}
