package defpackage;

import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: dp5  reason: default package */
/* compiled from: AudienceManager */
public class dp5 implements yp5 {

    /* renamed from: a  reason: collision with root package name */
    public final hk5 f878a;
    public final cp5 b;
    public final kp5 c;
    public final ep5 d;
    public final hy5 e;
    public final up5 f;
    public final fp5 g;
    public a h;

    /* renamed from: dp5$a */
    /* compiled from: AudienceManager */
    public interface a {
    }

    public dp5(kq5 kq5, kp5 kp5, up5 up5, hk5 hk5) {
        ep5 ep5 = new ep5(kq5);
        hy5 hy5 = hy5.f1445a;
        fp5 fp5 = new fp5(hk5, hy5);
        cp5 cp5 = new cp5(kp5, up5, hy5);
        this.d = ep5;
        this.c = kp5;
        this.f = up5;
        this.g = fp5;
        this.b = cp5;
        this.f878a = hk5;
        this.e = hy5;
        kp5 kp52 = cp5.b;
        kp52.m.f1413a.add(new yo5(cp5));
        kp5 kp53 = cp5.b;
        kp53.n.d.add(new zo5(cp5));
        up5 up52 = cp5.c;
        up52.l.f1413a.add(new ap5(cp5));
        up5 up53 = cp5.c;
        up53.m.d.add(new bp5(cp5));
        up5.n.add(this);
    }

    @Override // defpackage.yp5
    public void a(String str) {
        fp5 fp5 = this.g;
        fp5.f1157a.l("com.urbanairship.iam.tags.TAG_CACHE_RESPONSE");
        fp5.f1157a.l("com.urbanairship.iam.tags.TAG_CACHE_CREATE_DATE");
        fp5.f1157a.l("com.urbanairship.iam.tags.TAG_CACHE_REQUESTED_TAGS");
    }

    public final Map<String, Set<String>> b(Map<String, Set<String>> map, gp5 gp5, long j) {
        HashMap hashMap = new HashMap(gp5.f);
        for (jq5 jq5 : d(j - this.f878a.e("com.urbanairship.iam.tags.TAG_PREFER_LOCAL_DATA_TIME", 600000))) {
            Map<String, Set<String>> map2 = jq5.f;
            if (map2 != null) {
                for (Map.Entry<String, Set<String>> entry : map2.entrySet()) {
                    Set set = (Set) hashMap.get(entry.getKey());
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(entry.getKey(), set);
                    }
                    set.addAll(entry.getValue());
                }
            }
            Map<String, Set<String>> map3 = jq5.g;
            if (map3 != null) {
                for (Map.Entry<String, Set<String>> entry2 : map3.entrySet()) {
                    Set set2 = (Set) hashMap.get(entry2.getKey());
                    if (set2 != null) {
                        set2.removeAll(entry2.getValue());
                    }
                }
            }
            Map<String, Set<String>> map4 = jq5.h;
            if (map4 != null) {
                for (Map.Entry<String, Set<String>> entry3 : map4.entrySet()) {
                    hashMap.put(entry3.getKey(), entry3.getValue());
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, Set<String>> entry4 : map.entrySet()) {
            String key = entry4.getKey();
            Set set3 = (Set) hashMap.get(key);
            if (set3 != null) {
                HashSet hashSet = new HashSet(set3);
                hashSet.retainAll(entry4.getValue());
                hashMap2.put(key, hashSet);
            }
        }
        return hashMap2;
    }

    public List<qp5> c() {
        List a2;
        ArrayList arrayList = new ArrayList();
        cp5 cp5 = this.b;
        Objects.requireNonNull(this.e);
        long currentTimeMillis = System.currentTimeMillis() - 600000;
        synchronized (cp5.e) {
            a2 = cp5.a(cp5.e, currentTimeMillis);
        }
        arrayList.addAll(a2);
        arrayList.addAll(this.f.m.b());
        arrayList.addAll(this.c.n.b());
        return qp5.a(arrayList);
    }

    public final List<jq5> d(long j) {
        List a2;
        ArrayList arrayList = new ArrayList();
        cp5 cp5 = this.b;
        synchronized (cp5.d) {
            a2 = cp5.a(cp5.d, j);
        }
        arrayList.addAll(a2);
        arrayList.addAll(this.f.l.d.b());
        arrayList.addAll(this.c.m.d.b());
        kp5 kp5 = this.c;
        if (kp5.p) {
            Set<String> o = kp5.o();
            HashMap hashMap = new HashMap();
            hashMap.put(AnalyticsConstants.DEVICE, new HashSet(o));
            arrayList.add(new jq5(null, null, hashMap));
        }
        return jq5.a(arrayList);
    }

    public final void e(Map<String, Set<String>> map, gp5 gp5) throws Exception {
        String str;
        ip5 ip5;
        a aVar = this.h;
        if (aVar != null) {
            HashMap hashMap = new HashMap();
            dn5 dn5 = dn5.this;
            dn5.l();
            mm5 mm5 = dn5.h;
            Objects.requireNonNull(mm5);
            ck5 ck5 = new ck5();
            mm5.i.post(new km5(mm5, ck5));
            Collection<ln5> collection = (Collection) ck5.get();
            if (collection != null) {
                for (ln5 ln5 : collection) {
                    fm5 fm5 = ln5.l;
                    if (!(fm5 == null || (ip5 = fm5.k) == null || !ip5.c())) {
                        hd3.i(hashMap, fm5.k.e());
                    }
                }
            }
            HashMap hashMap2 = new HashMap();
            hd3.i(hashMap2, map);
            hd3.i(hashMap2, hashMap);
            map = hashMap2;
        }
        gp5 gp52 = null;
        if (gp5 != null && !map.equals(hd3.t2(this.g.f1157a.d("com.urbanairship.iam.tags.TAG_CACHE_REQUESTED_TAGS")))) {
            gp5 = null;
        }
        ep5 ep5 = this.d;
        String l = this.c.l();
        oq5 a2 = ep5.f1016a.b().a();
        Uri.Builder builder = a2.f2724a;
        if (builder != null) {
            builder.appendEncodedPath("api/channel-tags-lookup");
        }
        Uri b2 = a2.b();
        if (b2 == null) {
            yj5.a("Tag Group URL is null, unable to fetch tag groups.", new Object[0]);
        } else {
            String str2 = ep5.f1016a.a() == 1 ? "amazon" : "android";
            zt5.b s = zt5.s();
            s.f("channel_id", l);
            s.f("device_type", str2);
            s.i("tag_groups", map);
            s.f("if_modified_since", gp5 != null ? gp5.g : null);
            String zt5 = s.a().toString();
            yj5.a("Looking up tags with payload: %s", zt5);
            try {
                qq5 qq5 = new qq5();
                qq5.d = FirebasePerformance.HttpMethod.POST;
                qq5.f2981a = b2;
                AirshipConfigOptions airshipConfigOptions = ep5.f1016a.b;
                String str3 = airshipConfigOptions.f711a;
                String str4 = airshipConfigOptions.b;
                qq5.b = str3;
                qq5.c = str4;
                qq5.e = zt5;
                qq5.f = "application/json";
                qq5.d();
                qq5.e(ep5.f1016a);
                try {
                    gp52 = gp5.a(qq5.a());
                    if (gp52.h == 200 && gp5 != null && (str = gp52.g) != null && hd3.R0(str, gp5.g)) {
                        gp52 = gp5;
                    }
                } catch (xt5 e2) {
                    yj5.e(e2, "Failed to parse tag group response.", new Object[0]);
                }
            } catch (rq5 e3) {
                yj5.e(e3, "Failed to refresh the cache.", new Object[0]);
            }
        }
        if (gp52 == null) {
            yj5.c("Failed to refresh the cache.", new Object[0]);
        } else if (gp52.h != 200) {
            yj5.c("Failed to refresh the cache. Status: %s", gp52);
        } else {
            yj5.h("Refreshed tag group with response: %s", gp52);
            fp5 fp5 = this.g;
            fp5.f1157a.i("com.urbanairship.iam.tags.TAG_CACHE_RESPONSE", gp52);
            fp5.f1157a.f("com.urbanairship.iam.tags.TAG_CACHE_CREATE_DATE").b(String.valueOf(System.currentTimeMillis()));
            fp5.f1157a.j("com.urbanairship.iam.tags.TAG_CACHE_REQUESTED_TAGS", JsonValue.x(map));
        }
    }
}
