package defpackage;

import android.content.Context;
import android.text.TextUtils;
import defpackage.pm;

/* renamed from: lq  reason: default package */
/* compiled from: WorkDatabase */
public class lq implements pm.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f2256a;

    public lq(Context context) {
        this.f2256a = context;
    }

    @Override // defpackage.pm.c
    public pm a(pm.b bVar) {
        Context context = this.f2256a;
        String str = bVar.b;
        pm.a aVar = bVar.c;
        if (aVar == null) {
            throw new IllegalArgumentException("Must set a callback to create the configuration.");
        } else if (context == null) {
            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        } else if (!TextUtils.isEmpty(str)) {
            pm.b bVar2 = new pm.b(context, str, aVar, true);
            return new um(bVar2.f2829a, bVar2.b, bVar2.c, bVar2.d);
        } else {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
        }
    }
}
