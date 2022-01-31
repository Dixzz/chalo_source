package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.kb;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: hb  reason: default package */
/* compiled from: Preferences.kt */
public final class hb extends kb {

    /* renamed from: a  reason: collision with root package name */
    public final Map<kb.a<?>, Object> f1356a;
    public final AtomicBoolean b;

    /* renamed from: hb$a */
    /* compiled from: Preferences.kt */
    public static final class a extends o86 implements s76<Map.Entry<kb.a<?>, Object>, CharSequence> {
        public static final a f = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.s76
        public CharSequence invoke(Map.Entry<kb.a<?>, Object> entry) {
            Map.Entry<kb.a<?>, Object> entry2 = entry;
            n86.e(entry2, "entry");
            return "  " + entry2.getKey().f2041a + " = " + entry2.getValue();
        }
    }

    public hb() {
        this(null, false, 3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hb(Map map, boolean z, int i) {
        this((i & 1) != 0 ? new LinkedHashMap() : null, (i & 2) != 0 ? true : z);
    }

    @Override // defpackage.kb
    public Map<kb.a<?>, Object> a() {
        Map<kb.a<?>, Object> unmodifiableMap = Collections.unmodifiableMap(this.f1356a);
        n86.d(unmodifiableMap, "unmodifiableMap(preferencesMap)");
        return unmodifiableMap;
    }

    public final void b() {
        if (!(!this.b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public final <T> void c(kb.a<T> aVar, T t) {
        n86.e(aVar, AnalyticsConstants.KEY);
        d(aVar, t);
    }

    public final void d(kb.a<?> aVar, Object obj) {
        n86.e(aVar, AnalyticsConstants.KEY);
        b();
        if (obj == null) {
            n86.e(aVar, AnalyticsConstants.KEY);
            b();
            this.f1356a.remove(aVar);
        } else if (obj instanceof Set) {
            Map<kb.a<?>, Object> map = this.f1356a;
            Set unmodifiableSet = Collections.unmodifiableSet(y56.D((Iterable) obj));
            n86.d(unmodifiableSet, "unmodifiableSet(value.toSet())");
            map.put(aVar, unmodifiableSet);
        } else {
            this.f1356a.put(aVar, obj);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof hb) {
            return n86.a(this.f1356a, ((hb) obj).f1356a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1356a.hashCode();
    }

    public String toString() {
        return y56.m(this.f1356a.entrySet(), ",\n", "{\n", "\n}", 0, null, a.f, 24);
    }

    public hb(Map<kb.a<?>, Object> map, boolean z) {
        n86.e(map, "preferencesMap");
        this.f1356a = map;
        this.b = new AtomicBoolean(z);
    }
}
