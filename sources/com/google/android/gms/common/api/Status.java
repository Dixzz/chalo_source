package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class Status extends AbstractSafeParcelable implements f32, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new n72();
    @RecentlyNonNull
    public static final Status k = new Status(0, null);
    @RecentlyNonNull
    public static final Status l = new Status(14, null);
    @RecentlyNonNull
    public static final Status m = new Status(8, null);
    @RecentlyNonNull
    public static final Status n = new Status(15, null);
    @RecentlyNonNull
    public static final Status o = new Status(16, null);
    public final int f;
    public final int g;
    public final String h;
    public final PendingIntent i;
    public final ConnectionResult j;

    static {
        new Status(17, null);
        new Status(18, null);
    }

    public Status(int i2, int i3, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f = i2;
        this.g = i3;
        this.h = str;
        this.i = pendingIntent;
        this.j = connectionResult;
    }

    public Status(int i2, String str) {
        this.f = 1;
        this.g = i2;
        this.h = str;
        this.i = null;
        this.j = null;
    }

    @Override // defpackage.f32
    @RecentlyNonNull
    public Status M0() {
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f != status.f || this.g != status.g || !gj1.G(this.h, status.h) || !gj1.G(this.i, status.i) || !gj1.G(this.j, status.j)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.g), this.h, this.i, this.j});
    }

    public boolean l1() {
        return this.i != null;
    }

    public boolean m1() {
        return this.g <= 0;
    }

    public void n1(@RecentlyNonNull Activity activity, int i2) throws IntentSender.SendIntentException {
        if (l1()) {
            PendingIntent pendingIntent = this.i;
            Objects.requireNonNull(pendingIntent, "null reference");
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    @RecentlyNonNull
    public String toString() {
        g82 g82 = new g82(this);
        g82.a("statusCode", zza());
        g82.a("resolution", this.i);
        return g82.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.g;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        gj1.B0(parcel, 2, this.h, false);
        gj1.A0(parcel, 3, this.i, i2, false);
        gj1.A0(parcel, 4, this.j, i2, false);
        int i4 = this.f;
        parcel.writeInt(263144);
        parcel.writeInt(i4);
        gj1.H1(parcel, o1);
    }

    @RecentlyNonNull
    public final String zza() {
        String str = this.h;
        return str != null ? str : gj1.K(this.g);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this.f = 1;
        this.g = i2;
        this.h = str;
        this.i = pendingIntent;
        this.j = null;
    }
}
