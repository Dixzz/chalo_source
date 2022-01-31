package defpackage;

import defpackage.xw1;
import defpackage.zw1;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.inject.Provider;

/* renamed from: lw1  reason: default package */
/* compiled from: SchedulingConfigModule_ConfigFactory */
public final class lw1 implements Object<zw1> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider<jy1> f2284a;

    public lw1(Provider<jy1> provider) {
        this.f2284a = provider;
    }

    public Object get() {
        jy1 jy1 = this.f2284a.get();
        HashMap hashMap = new HashMap();
        bu1 bu1 = bu1.DEFAULT;
        zw1.a.AbstractC0072a a2 = zw1.a.a();
        a2.b(30000);
        a2.c(86400000);
        hashMap.put(bu1, a2.a());
        bu1 bu12 = bu1.HIGHEST;
        zw1.a.AbstractC0072a a3 = zw1.a.a();
        a3.b(1000);
        a3.c(86400000);
        hashMap.put(bu12, a3.a());
        bu1 bu13 = bu1.VERY_LOW;
        zw1.a.AbstractC0072a a4 = zw1.a.a();
        a4.b(86400000);
        a4.c(86400000);
        Set<zw1.b> unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zw1.b.NETWORK_UNMETERED, zw1.b.DEVICE_IDLE)));
        xw1.b bVar = (xw1.b) a4;
        Objects.requireNonNull(unmodifiableSet, "Null flags");
        bVar.c = unmodifiableSet;
        hashMap.put(bu13, bVar.a());
        Objects.requireNonNull(jy1, "missing required property: clock");
        int size = hashMap.keySet().size();
        bu1.values();
        if (size >= 3) {
            new HashMap();
            return new ww1(jy1, hashMap);
        }
        throw new IllegalStateException("Not all priorities have been configured");
    }
}
