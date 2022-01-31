package com.google.android.play.core.review;

import android.app.PendingIntent;
import java.util.Objects;

public final class a extends ReviewInfo {
    public final PendingIntent f;

    public a(PendingIntent pendingIntent) {
        Objects.requireNonNull(pendingIntent, "Null pendingIntent");
        this.f = pendingIntent;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    public final PendingIntent a() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.f.equals(((ReviewInfo) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f);
        return hj1.b0(new StringBuilder(valueOf.length() + 26), "ReviewInfo{pendingIntent=", valueOf, "}");
    }
}
