package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.TransitMode;
import defpackage.xt;

/* renamed from: j90  reason: default package */
/* compiled from: NavigationHelper */
public class j90 {
    public void a(Context context, String str, String str2, String str3, String str4, TransitMode transitMode) {
        String str5;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(268435456);
        intent.setType("text/plain");
        if (transitMode.equals(TransitMode.train)) {
            str5 = String.format(context.getString(R.string.check_out_details_train), transitMode.name(), str3, str4);
        } else if (transitMode.equals(TransitMode.metro) || transitMode.equals(TransitMode.monorail)) {
            str5 = String.format(context.getString(R.string.check_out_details_metro_monorail), transitMode.name(), str2);
        } else {
            str5 = String.format(context.getString(R.string.check_out_details_others), transitMode.name(), str2);
        }
        xt.t1 t1Var = xt.f3961a;
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedPath = builder.encodedPath(ut.o);
        City d = t1Var.k().d();
        encodedPath.appendPath(d == null ? null : d.getName()).appendPath("route").appendPath(str);
        String uri = builder.build().toString();
        n86.d(uri, "lBuilder.build().toString()");
        intent.putExtra("android.intent.extra.TEXT", str5 + uri);
        intent.putExtra("android.intent.extra.SUBJECT", String.format(context.getString(R.string.route_share_subject), transitMode.name()));
        context.startActivity(intent);
    }
}
