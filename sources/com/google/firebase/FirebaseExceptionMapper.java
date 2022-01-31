package com.google.firebase;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class FirebaseExceptionMapper implements b42 {
    @Override // defpackage.b42
    @RecentlyNonNull
    public final Exception getException(@RecentlyNonNull Status status) {
        if (status.g == 8) {
            return new FirebaseException(status.zza());
        }
        return new FirebaseApiNotAvailableException(status.zza());
    }
}
