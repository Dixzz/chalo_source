package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.a32;

/* renamed from: m24  reason: default package */
public final class m24 extends z72<k24> {
    public m24(Context context, Looper looper, x72 x72, a32.b bVar, a32.c cVar) {
        super(context, looper, 51, x72, bVar, cVar);
    }

    @Override // defpackage.w72
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.phenotype.internal.IPhenotypeService");
        return queryLocalInterface instanceof k24 ? (k24) queryLocalInterface : new l24(iBinder);
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return 11925000;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.android.gms.phenotype.internal.IPhenotypeService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.phenotype.service.START";
    }
}
