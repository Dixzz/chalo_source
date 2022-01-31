package com.google.firebase;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class FirebaseException extends Exception {
    @Deprecated
    public FirebaseException() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebaseException(@RecentlyNonNull String str) {
        super(str);
        gj1.i(str, "Detail message must not be empty");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebaseException(@RecentlyNonNull String str, @RecentlyNonNull Throwable th) {
        super(str, th);
        gj1.i(str, "Detail message must not be empty");
    }
}
