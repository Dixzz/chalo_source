package defpackage;

import android.net.Uri;
import app.zophop.models.RouteInfo;

/* renamed from: ki1  reason: default package */
/* compiled from: RouteAutoCompleteHelper */
public class ki1 extends ld1<RouteInfo> {
    public final Uri.Builder b(String str) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.d).appendPath(xt.f3961a.k().d().getName()).appendPath("autocomplete").appendPath("route");
        builder.appendQueryParameter("str", str).appendQueryParameter("station_type", "bus");
        builder.appendQueryParameter("day", vn.I());
        builder.appendQueryParameter("meta", ui1.K0().toString());
        builder.build().toString();
        return builder;
    }
}
