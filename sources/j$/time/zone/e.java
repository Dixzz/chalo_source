package j$.time.zone;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final CopyOnWriteArrayList f1642a;
    private static final ConcurrentMap b = new ConcurrentHashMap(512, 0.75f, 2);

    class a implements PrivilegedAction<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f1643a;

        a(List list) {
            this.f1643a = list;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
            if (property != null) {
                try {
                    e eVar = (e) e.class.cast(Class.forName(property, true, e.class.getClassLoader()).newInstance());
                    e.d(eVar);
                    this.f1643a.add(eVar);
                    return null;
                } catch (Exception e) {
                    throw new Error(e);
                }
            } else {
                e.d(new b());
                return null;
            }
        }
    }

    private static final class b extends e {
        private final Set c;

        b() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : TimeZone.getAvailableIDs()) {
                linkedHashSet.add(str);
            }
            this.c = Collections.unmodifiableSet(linkedHashSet);
        }

        /* access modifiers changed from: protected */
        @Override // j$.time.zone.e
        public c b(String str, boolean z) {
            if (this.c.contains(str)) {
                return new c(TimeZone.getTimeZone(str));
            }
            throw new d("Not a built-in time zone: " + str);
        }

        /* access modifiers changed from: protected */
        @Override // j$.time.zone.e
        public Set c() {
            return this.c;
        }
    }

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f1642a = copyOnWriteArrayList;
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new a(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    protected e() {
    }

    public static c a(String str, boolean z) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentMap concurrentMap = b;
        e eVar = (e) concurrentMap.get(str);
        if (eVar != null) {
            return eVar.b(str, z);
        }
        if (concurrentMap.isEmpty()) {
            throw new d("No time-zone data files registered");
        }
        throw new d("Unknown time-zone ID: " + str);
    }

    public static void d(e eVar) {
        Objects.requireNonNull(eVar, "provider");
        for (String str : eVar.c()) {
            Objects.requireNonNull(str, "zoneId");
            if (((e) b.putIfAbsent(str, eVar)) != null) {
                throw new d("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + eVar);
            }
        }
        f1642a.add(eVar);
    }

    /* access modifiers changed from: protected */
    public abstract c b(String str, boolean z);

    /* access modifiers changed from: protected */
    public abstract Set c();
}
