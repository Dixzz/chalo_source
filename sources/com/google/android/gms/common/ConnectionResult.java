package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ConnectionResult extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new qb2();
    public static final int SUCCESS = 0;
    @RecentlyNonNull
    public static final ConnectionResult j = new ConnectionResult(0);
    public final int f;
    public final int g;
    public final PendingIntent h;
    public final String i;

    public ConnectionResult(int i2) {
        this.f = 1;
        this.g = i2;
        this.h = null;
        this.i = null;
    }

    public ConnectionResult(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f = i2;
        this.g = i3;
        this.h = pendingIntent;
        this.i = str;
    }

    public static String n1(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.g == connectionResult.g && gj1.G(this.h, connectionResult.h) && gj1.G(this.i, connectionResult.i);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), this.h, this.i});
    }

    public boolean l1() {
        return (this.g == 0 || this.h == null) ? false : true;
    }

    public boolean m1() {
        return this.g == 0;
    }

    @RecentlyNonNull
    public String toString() {
        g82 g82 = new g82(this);
        g82.a("statusCode", n1(this.g));
        g82.a("resolution", this.h);
        g82.a("message", this.i);
        return g82.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int o1 = gj1.o1(parcel, 20293);
        int i3 = this.f;
        parcel.writeInt(262145);
        parcel.writeInt(i3);
        int i4 = this.g;
        parcel.writeInt(262146);
        parcel.writeInt(i4);
        gj1.A0(parcel, 3, this.h, i2, false);
        gj1.B0(parcel, 4, this.i, false);
        gj1.H1(parcel, o1);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent) {
        this.f = 1;
        this.g = i2;
        this.h = pendingIntent;
        this.i = null;
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent, String str) {
        this.f = 1;
        this.g = i2;
        this.h = null;
        this.i = str;
    }
}
