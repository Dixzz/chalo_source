package defpackage;

import android.content.Context;
import java.io.File;

/* renamed from: bb  reason: default package */
/* compiled from: PreferenceDataStoreDelegate.kt */
public final class bb extends o86 implements h76<File> {
    public final /* synthetic */ Context f;
    public final /* synthetic */ cb g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bb(Context context, cb cbVar) {
        super(0);
        this.f = context;
        this.g = cbVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public File invoke() {
        Context context = this.f;
        n86.d(context, "applicationContext");
        String str = this.g.f541a;
        n86.e(context, "<this>");
        n86.e(str, "name");
        String j = n86.j(str, ".preferences_pb");
        n86.e(context, "<this>");
        n86.e(j, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), n86.j("datastore/", j));
    }
}
