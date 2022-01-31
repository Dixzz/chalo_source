package defpackage;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class fe4 implements Runnable {
    public final ge4 f;
    public final int g;
    public final Exception h;
    public final byte[] i;
    public final Map j;

    public fe4(ge4 ge4, int i2, Exception exc, byte[] bArr, Map map) {
        this.f = ge4;
        this.g = i2;
        this.h = exc;
        this.i = bArr;
        this.j = map;
    }

    public final void run() {
        List<ResolveInfo> queryIntentActivities;
        ge4 ge4 = this.f;
        int i2 = this.g;
        Exception exc = this.h;
        byte[] bArr = this.i;
        vb4 vb4 = ge4.g.f4028a;
        boolean z = true;
        if (!((i2 == 200 || i2 == 204 || i2 == 304) && exc == null)) {
            vb4.g().i.c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), exc);
            return;
        }
        vb4.n().x.a(true);
        if (bArr.length == 0) {
            vb4.g().m.a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            if (TextUtils.isEmpty(optString)) {
                vb4.g().m.a("Deferred Deep Link is empty.");
                return;
            }
            ug4 t = vb4.t();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = t.f3331a.f3627a.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                vb4.g().i.c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            vb4.p.G("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
            ug4 t2 = vb4.t();
            if (!TextUtils.isEmpty(optString) && t2.X(optString, optDouble)) {
                t2.f3331a.f3627a.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            vb4.g().f.b("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
