package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ss4  reason: default package */
public final class ss4 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Double> f3250a = new HashMap();

    public final synchronized void a(String str) {
        this.f3250a.put(str, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }
}
