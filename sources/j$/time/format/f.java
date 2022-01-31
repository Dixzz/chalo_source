package j$.time.format;

import a.I0;
import a.K0;
import a.M0;
import a.U;
import j$.util.Comparator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator f1614a = new a();
    public static final /* synthetic */ int b = 0;

    class a implements Comparator<Map.Entry<String, Long>>, j$.util.Comparator {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            return entry2.getKey().length() - entry.getKey().length();
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<Map.Entry<String, Long>> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<Map.Entry<String, Long>> thenComparing(java.util.Comparator<? super Map.Entry<String, Long>> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // java.util.Comparator
        public /* synthetic */ java.util.Comparator<Map.Entry<String, Long>> thenComparing(java.util.function.Function function) {
            return Comparator.CC.$default$thenComparing(this, U.c(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.function.ToDoubleFunction] */
        @Override // java.util.Comparator
        public /* synthetic */ java.util.Comparator<Map.Entry<String, Long>> thenComparingDouble(java.util.function.ToDoubleFunction<? super Map.Entry<String, Long>> toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, I0.a(toDoubleFunction));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.function.ToIntFunction] */
        @Override // java.util.Comparator
        public /* synthetic */ java.util.Comparator<Map.Entry<String, Long>> thenComparingInt(java.util.function.ToIntFunction<? super Map.Entry<String, Long>> toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, K0.a(toIntFunction));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.function.ToLongFunction] */
        @Override // java.util.Comparator
        public /* synthetic */ java.util.Comparator<Map.Entry<String, Long>> thenComparingLong(java.util.function.ToLongFunction<? super Map.Entry<String, Long>> toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, M0.a(toLongFunction));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // java.util.Comparator
        public /* synthetic */ java.util.Comparator<Map.Entry<String, Long>> thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, U.c(function), comparator);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Map f1615a;

        b(Map map) {
            this.f1615a = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    int i = f.b;
                    hashMap2.put((String) entry2.getValue(), new AbstractMap.SimpleImmutableEntry((String) entry2.getValue(), (Long) entry2.getKey()));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort(arrayList2, f.f1614a);
                hashMap.put((j) entry.getKey(), arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put(null, arrayList);
            }
            Collections.sort(arrayList, f.f1614a);
        }

        /* access modifiers changed from: package-private */
        public String a(long j, j jVar) {
            Map map = (Map) this.f1615a.get(jVar);
            if (map != null) {
                return (String) map.get(Long.valueOf(j));
            }
            return null;
        }
    }

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    f() {
    }
}
