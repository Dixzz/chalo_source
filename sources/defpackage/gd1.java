package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* renamed from: gd1  reason: default package */
/* compiled from: FirebaseSender */
public class gd1 implements hd1 {

    /* renamed from: a  reason: collision with root package name */
    public FirebaseAnalytics f1241a;

    public gd1(Context context) {
        this.f1241a = FirebaseAnalytics.getInstance(context);
    }

    @Override // defpackage.hd1
    public void a(String str) {
        this.f1241a.setUserProperty("user_mail", str);
    }

    @Override // defpackage.hd1
    public void b(String str) {
        this.f1241a.setUserProperty("user_name", str);
    }

    @Override // defpackage.hd1
    public void c() {
    }

    @Override // defpackage.hd1
    public void d(String str, double d) {
    }

    @Override // defpackage.hd1
    public void e(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f1241a.setUserProperty(h(entry.getKey()), entry.getValue());
        }
    }

    @Override // defpackage.hd1
    public void f(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f1241a.setUserProperty(h(entry.getKey()), entry.getValue());
        }
    }

    @Override // defpackage.hd1
    public void g(ed1 ed1) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Object> entry : ed1.b.entrySet()) {
            String h = h(entry.getKey());
            if (entry.getValue() instanceof String) {
                bundle.putString(h, String.valueOf(entry.getValue()));
            } else if (entry.getValue() instanceof Long) {
                bundle.putLong(h, ((Long) entry.getValue()).longValue());
            } else if (entry.getValue() instanceof Integer) {
                bundle.putInt(h, ((Integer) entry.getValue()).intValue());
            }
        }
        this.f1241a.logEvent(h(ed1.f961a), bundle);
    }

    public final String h(String str) {
        return str.replace(" ", "_");
    }
}
