package com.google.firebase.appindexing.internal;

import android.content.Context;
import com.google.firebase.appindexing.FirebaseAppIndex;
import defpackage.x22;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzi extends FirebaseAppIndex {
    private static String[] zzez = {"com.google.android.googlequicksearchbox", "com.google.android.gms"};
    private final Context zzcs;
    private final z22<?> zzfa;
    private final zzk zzfb;

    public zzi(Context context) {
        this(context, new zzh(context));
    }

    private final yi4<Void> zza(zzy zzy) {
        return this.zzfb.zzb(zzy);
    }

    @Override // com.google.firebase.appindexing.FirebaseAppIndex
    public final yi4<Void> remove(String... strArr) {
        return zza(new zzy(3, null, strArr, null, null, null, null));
    }

    @Override // com.google.firebase.appindexing.FirebaseAppIndex
    public final yi4<Void> removeAll() {
        return zza(new zzy(4, null, null, null, null, null, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075 A[Catch:{ ArrayStoreException -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008e A[Catch:{ ArrayStoreException -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a4 A[Catch:{ ArrayStoreException -> 0x00cc }] */
    @Override // com.google.firebase.appindexing.FirebaseAppIndex
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.yi4<java.lang.Void> update(com.google.firebase.appindexing.Indexable... r13) {
        /*
        // Method dump skipped, instructions count: 216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.appindexing.internal.zzi.update(com.google.firebase.appindexing.Indexable[]):yi4");
    }

    private zzi(Context context, z22<x22.d.c> z22) {
        this.zzfa = z22;
        this.zzcs = context;
        this.zzfb = new zzk(z22);
    }
}
