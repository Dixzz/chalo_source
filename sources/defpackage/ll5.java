package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import java.util.Locale;
import java.util.UUID;

/* renamed from: ll5  reason: default package */
/* compiled from: Event */
public abstract class ll5 {
    public final String f;
    public final String g;

    public ll5(long j) {
        this.f = UUID.randomUUID().toString();
        this.g = h(j);
    }

    public static String h(long j) {
        return String.format(Locale.US, "%.3f", Double.valueOf(((double) j) / 1000.0d));
    }

    public String a() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) UAirship.d().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "";
            }
            return activeNetworkInfo.getSubtypeName();
        } catch (ClassCastException e) {
            yj5.c("Connection subtype lookup failed", e);
            return "";
        }
    }

    public String c() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) UAirship.d().getSystemService("connectivity");
        int type = (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? -1 : activeNetworkInfo.getType();
        if (type == 0) {
            return "cell";
        }
        if (type != 1) {
            return type != 6 ? "none" : "wimax";
        }
        return AnalyticsConstants.WIFI;
    }

    public abstract zt5 d();

    public int e() {
        return 1;
    }

    public abstract String f();

    public boolean g() {
        return true;
    }

    public ll5() {
        this(System.currentTimeMillis());
    }
}
