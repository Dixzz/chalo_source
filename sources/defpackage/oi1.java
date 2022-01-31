package defpackage;

import android.net.Uri;
import defpackage.ut;

/* renamed from: oi1  reason: default package */
/* compiled from: UberOAuthProvider */
public class oi1 extends hi1 {
    @Override // defpackage.hi1
    public String a() {
        return "android-app://app.zophop/zophop/";
    }

    @Override // defpackage.hi1
    public String b(String str) {
        StringBuilder sb = new StringBuilder(Uri.parse(ut.t).buildUpon().appendPath("uber").appendPath("refreshToken").toString());
        if (str != null) {
            sb.append("?refreshToken=");
            sb.append(str);
        }
        return Uri.parse(sb.toString()).toString();
    }

    @Override // defpackage.hi1
    public String c() {
        Uri parse = Uri.parse(Uri.parse(ut.t).buildUpon().appendPath("uber").appendPath("oauth").toString());
        StringBuilder k0 = hj1.k0("https://login.uber.com/oauth/v2/authorize", "?response_type=code&scope=request&client_id=");
        ut.a aVar = ut.f3552a;
        k0.append("gF01SvsVYF86MZWIrMJbcktgijgjNiH-");
        k0.append("&redirect_uri=");
        k0.append(parse);
        return Uri.parse(k0.toString()).toString();
    }
}
