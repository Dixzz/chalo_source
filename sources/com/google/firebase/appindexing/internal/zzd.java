package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.Looper;
import defpackage.a32;
import defpackage.x22;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzd extends x22.a<zze, x22.d.c> {
    /* Return type fixed from 'x22$f' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, x72, java.lang.Object, a32$b, a32$c] */
    @Override // defpackage.x22.a
    public final /* synthetic */ zze buildClient(Context context, Looper looper, x72 x72, x22.d.c cVar, a32.b bVar, a32.c cVar2) {
        return new zze(context, looper, x72, bVar, cVar2);
    }
}
