package defpackage;

import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* renamed from: g30  reason: default package */
/* compiled from: IntentURIParser */
public class g30 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f1208a = new HashMap();
    public String b;
    public String c;
    public final Uri d;

    public g30(Intent intent) {
        Uri data = intent.getData();
        this.d = data;
        if (a()) {
            for (String str : data.getQueryParameterNames()) {
                this.f1208a.put(str, this.d.getQueryParameter(str));
            }
            this.b = this.d.getLastPathSegment();
            this.c = this.d.getHost();
        }
    }

    public boolean a() {
        Uri uri = this.d;
        return uri != null && uri.isHierarchical();
    }
}
