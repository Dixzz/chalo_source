package defpackage;

import android.content.pm.PackageInfo;
import android.os.Build;
import com.freshchat.consumer.sdk.beans.User;
import com.google.firebase.appindexing.Indexable;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import defpackage.zt5;
import java.util.Calendar;
import java.util.Date;

/* renamed from: jl5  reason: default package */
/* compiled from: AppForegroundEvent */
public class jl5 extends ll5 {
    public jl5(long j) {
        super(j);
    }

    @Override // defpackage.ll5
    public final zt5 d() {
        PackageInfo e = UAirship.e();
        zt5.b s = zt5.s();
        s.f("connection_type", c());
        s.f("connection_subtype", a());
        s.f(AnalyticsConstants.CARRIER, hd3.d1());
        zt5.b g = s.d("time_zone", (long) (Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)).g("daylight_savings", Calendar.getInstance().getTimeZone().inDaylightTime(new Date()));
        g.f(User.DEVICE_META_OS_VERSION_NAME, Build.VERSION.RELEASE);
        Object obj = UAirship.t;
        g.f("lib_version", "14.6.0");
        g.i("package_version", e != null ? e.versionName : null);
        g.f("push_id", UAirship.l().f.r);
        g.f("metadata", UAirship.l().f.s);
        g.f("last_metadata", UAirship.l().i.k.g("com.urbanairship.push.LAST_RECEIVED_METADATA", null));
        return g.a();
    }

    @Override // defpackage.ll5
    public final String f() {
        return "app_foreground";
    }
}
