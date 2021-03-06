package com.google.firebase.appindexing.internal;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;

@TargetApi(19)
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzz extends zzaa {
    private final Context zzcs;
    private final ContentResolver zzfu;

    public zzz(Context context) {
        this.zzcs = context;
        this.zzfu = context.getContentResolver();
    }

    @Override // com.google.firebase.appindexing.internal.zzaa
    public final void grantSlicePermission(String str, Uri uri) {
        ContentProviderClient acquireUnstableContentProviderClient = this.zzfu.acquireUnstableContentProviderClient(uri);
        try {
            Bundle bundle = new Bundle();
            bundle.putParcelable("slice_uri", uri);
            bundle.putString("provider_pkg", this.zzcs.getPackageName());
            bundle.putString("pkg", str);
            acquireUnstableContentProviderClient.call("grant_perms", null, bundle);
        } catch (RemoteException unused) {
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }
}
