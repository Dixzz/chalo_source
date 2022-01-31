package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.a32;
import defpackage.x22;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zze extends z72<zzr> {
    public static final x22<x22.d.c> API;
    private static final x22.g<zze> CLIENT_KEY;
    private static final x22.a<zze, x22.d.c> zzev;

    static {
        x22.g<zze> gVar = new x22.g<>();
        CLIENT_KEY = gVar;
        zzd zzd = new zzd();
        zzev = zzd;
        API = new x22<>("AppIndexing.API", zzd, gVar);
    }

    public zze(Context context, Looper looper, x72 x72, a32.b bVar, a32.c cVar) {
        super(context, looper, 113, x72, bVar, cVar);
    }

    @Override // defpackage.w72
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.appindexing.internal.IAppIndexingService");
        if (queryLocalInterface instanceof zzr) {
            return (zzr) queryLocalInterface;
        }
        return new zzu(iBinder);
    }

    @Override // defpackage.w72, defpackage.x22.f
    public final int getMinApkVersion() {
        return 12600000;
    }

    @Override // defpackage.w72
    public final String getServiceDescriptor() {
        return "com.google.firebase.appindexing.internal.IAppIndexingService";
    }

    @Override // defpackage.w72
    public final String getStartServiceAction() {
        return "com.google.android.gms.icing.APP_INDEXING_SERVICE";
    }
}
