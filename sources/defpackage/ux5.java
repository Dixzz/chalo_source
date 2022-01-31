package defpackage;

import android.content.Context;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import defpackage.ik5;
import defpackage.zt5;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import server.zophop.Constants;

/* renamed from: ux5  reason: default package */
/* compiled from: RemoteConfigManager */
public class ux5 extends oj5 {
    public static final Comparator<by5> n = new a();
    public final Collection<tx5> e = new CopyOnWriteArraySet();
    public final wx5 f;
    public final qx5 g;
    public final ix5 h;
    public final ik5 i;
    public final kq5 j;
    public nx5 k;
    public sx5 l;
    public final ik5.a m = new b();

    /* renamed from: ux5$a */
    /* compiled from: RemoteConfigManager */
    public static class a implements Comparator<by5>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(by5 by5, by5 by52) {
            by5 by53 = by5;
            if (by53.f491a.equals(by52.f491a)) {
                return 0;
            }
            return by53.f491a.equals("app_config") ? -1 : 1;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<by5> reversed() {
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
        public /* synthetic */ java.util.Comparator<by5> thenComparing(java.util.Comparator<? super by5> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: ux5$b */
    /* compiled from: RemoteConfigManager */
    public class b implements ik5.a {
        public b() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            ux5.this.j();
        }
    }

    /* renamed from: ux5$c */
    /* compiled from: RemoteConfigManager */
    public class c extends mx5<zt5> {
        public c() {
        }

        @Override // defpackage.hx5
        public void b(Object obj) {
            try {
                ux5.i(ux5.this, (zt5) obj);
            } catch (Exception e) {
                yj5.e(e, "Failed to process remote data", new Object[0]);
            }
        }
    }

    /* renamed from: ux5$d */
    /* compiled from: RemoteConfigManager */
    public class d implements qw5<Collection<by5>, zt5> {
        public d(ux5 ux5) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.qw5
        public zt5 apply(Collection<by5> collection) {
            ArrayList arrayList = new ArrayList(collection);
            Collections.sort(arrayList, ux5.n);
            zt5.b s = zt5.s();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                s.h(((by5) it.next()).c);
            }
            return s.a();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ux5(Context context, hk5 hk5, kq5 kq5, ik5 ik5, wx5 wx5) {
        super(context, hk5);
        qx5 qx5 = new qx5();
        jx5 jx5 = new jx5(qj5.a());
        this.j = kq5;
        this.i = ik5;
        this.f = wx5;
        this.g = qx5;
        this.h = jx5;
    }

    public static void i(ux5 ux5, zt5 zt5) {
        boolean z;
        Objects.requireNonNull(ux5);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        JsonValue jsonValue = JsonValue.g;
        for (String str : zt5.f.keySet()) {
            JsonValue u = zt5.u(str);
            if ("airship_config".equals(str)) {
                jsonValue = u;
            } else if ("disable_features".equals(str)) {
                Iterator<JsonValue> it = u.m().iterator();
                while (it.hasNext()) {
                    try {
                        arrayList.add(px5.a(it.next()));
                    } catch (xt5 e2) {
                        yj5.e(e2, "Failed to parse remote config: %s", zt5);
                    }
                }
            } else {
                hashMap.put(str, u);
            }
        }
        ux5.l = sx5.a(jsonValue);
        for (tx5 tx5 : ux5.e) {
            tx5.a(ux5.l);
        }
        Object obj = UAirship.t;
        cu5 b0 = hd3.b0(UAirship.c());
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            px5 px5 = (px5) it2.next();
            Set<String> set = px5.h;
            if (set != null) {
                Iterator<String> it3 = set.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (vy5.c(it3.next()).apply("14.6.0")) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                }
            }
            bu5 bu5 = px5.i;
            if (bu5 == null || bu5.apply(b0)) {
                arrayList2.add(px5);
            }
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet(rx5.f3147a);
        Iterator it4 = arrayList2.iterator();
        long j2 = Constants.THRESHOLD_TIMESTAMP;
        while (it4.hasNext()) {
            px5 px52 = (px5) it4.next();
            hashSet.addAll(px52.f);
            hashSet2.removeAll(px52.f);
            j2 = Math.max(j2, px52.g);
        }
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            ux5.g.d((String) it5.next(), false);
        }
        Iterator it6 = hashSet2.iterator();
        while (it6.hasNext()) {
            ux5.g.d((String) it6.next(), true);
        }
        ux5.f.f.f("com.urbanairship.remotedata.FOREGROUND_REFRESH_INTERVAL").b(String.valueOf(j2));
        HashSet hashSet3 = new HashSet(rx5.f3147a);
        hashSet3.addAll(hashMap.keySet());
        Iterator it7 = hashSet3.iterator();
        while (it7.hasNext()) {
            String str2 = (String) it7.next();
            JsonValue jsonValue2 = (JsonValue) hashMap.get(str2);
            if (jsonValue2 == null) {
                ux5.g.c(str2, null);
            } else {
                ux5.g.c(str2, jsonValue2.n());
            }
        }
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        j();
        ik5 ik5 = this.i;
        ik5.b.add(this.m);
    }

    public final void j() {
        if (this.i.c()) {
            nx5 nx5 = this.k;
            if (nx5 == null || nx5.b()) {
                String str = this.j.a() == 1 ? "app_config:amazon" : "app_config:android";
                wx5 wx5 = this.f;
                Objects.requireNonNull(wx5);
                sw5<Collection<by5>> l2 = wx5.l(Arrays.asList("app_config", str));
                this.k = l2.d(new dx5(l2, new d(this))).h(this.h).f(this.h).g(new c());
                return;
            }
            return;
        }
        nx5 nx52 = this.k;
        if (nx52 != null) {
            nx52.a();
        }
    }
}
