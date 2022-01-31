package defpackage;

import android.net.Uri;
import android.os.Build;
import com.google.firebase.perf.FirebasePerformance;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: ay5  reason: default package */
/* compiled from: RemoteDataApiClient */
public class ay5 {
    public static final List<String> c = Collections.singletonList("huawei");

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f349a;
    public final jp5<jk5> b;

    /* renamed from: ay5$a */
    /* compiled from: RemoteDataApiClient */
    public class a implements uq5<c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f350a;
        public final /* synthetic */ b b;

        public a(ay5 ay5, Uri uri, b bVar) {
            this.f350a = uri;
            this.b = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0052 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Set] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashSet] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // defpackage.uq5
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public defpackage.ay5.c a(int r5, java.util.Map r6, java.lang.String r7) throws java.lang.Exception {
            /*
                r4 = this;
                r6 = 200(0xc8, float:2.8E-43)
                if (r5 != r6) goto L_0x005e
                com.urbanairship.json.JsonValue r5 = com.urbanairship.json.JsonValue.p(r7)
                zt5 r5 = r5.n()
                java.lang.String r6 = "payloads"
                com.urbanairship.json.JsonValue r5 = r5.u(r6)
                yt5 r5 = r5.f()
                if (r5 == 0) goto L_0x0056
                ay5$c r6 = new ay5$c
                android.net.Uri r7 = r4.f350a
                ay5$b r0 = r4.b
                zx5 r0 = (defpackage.zx5) r0
                wx5 r0 = r0.f4227a
                zt5 r0 = r0.i(r7)
                java.util.HashSet r1 = new java.util.HashSet     // Catch:{ xt5 -> 0x0043 }
                r1.<init>()     // Catch:{ xt5 -> 0x0043 }
                java.util.Iterator r2 = r5.iterator()     // Catch:{ xt5 -> 0x0043 }
            L_0x002f:
                boolean r3 = r2.hasNext()     // Catch:{ xt5 -> 0x0043 }
                if (r3 == 0) goto L_0x0052
                java.lang.Object r3 = r2.next()     // Catch:{ xt5 -> 0x0043 }
                com.urbanairship.json.JsonValue r3 = (com.urbanairship.json.JsonValue) r3     // Catch:{ xt5 -> 0x0043 }
                by5 r3 = defpackage.by5.a(r3, r0)     // Catch:{ xt5 -> 0x0043 }
                r1.add(r3)     // Catch:{ xt5 -> 0x0043 }
                goto L_0x002f
            L_0x0043:
                r0 = 1
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r1 = 0
                r0[r1] = r5
                java.lang.String r5 = "Unable to parse remote data payloads: %s"
                defpackage.yj5.c(r5, r0)
                java.util.Set r1 = java.util.Collections.emptySet()
            L_0x0052:
                r6.<init>(r7, r1)
                goto L_0x005f
            L_0x0056:
                xt5 r5 = new xt5
                java.lang.String r6 = "Response does not contain payloads"
                r5.<init>(r6)
                throw r5
            L_0x005e:
                r6 = 0
            L_0x005f:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ay5.a.a(int, java.util.Map, java.lang.String):java.lang.Object");
        }
    }

    /* renamed from: ay5$b */
    /* compiled from: RemoteDataApiClient */
    public interface b {
    }

    /* renamed from: ay5$c */
    /* compiled from: RemoteDataApiClient */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f351a;
        public final Set<by5> b;

        public c(Uri uri, Set<by5> set) {
            this.f351a = uri;
            this.b = set;
        }
    }

    public ay5(kq5 kq5, jp5<jk5> jp5) {
        this.f349a = kq5;
        this.b = jp5;
    }

    public tq5<c> a(String str, Locale locale, b bVar) throws rq5 {
        Uri b2 = b(locale);
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.GET;
        qq5.f2981a = b2;
        qq5.e(this.f349a);
        AirshipConfigOptions airshipConfigOptions = this.f349a.b;
        String str2 = airshipConfigOptions.f711a;
        String str3 = airshipConfigOptions.b;
        qq5.b = str2;
        qq5.c = str3;
        if (str != null) {
            qq5.j.put("If-Modified-Since", str);
        }
        return qq5.b(new a(this, b2, bVar));
    }

    public Uri b(Locale locale) {
        String str;
        String str2 = this.f349a.b().d;
        Uri.Builder buildUpon = str2 != null ? Uri.parse(str2).buildUpon() : null;
        if (buildUpon != null) {
            buildUpon.appendEncodedPath("api/remote-data/app/");
        }
        String str3 = this.f349a.b.f711a;
        if (buildUpon != null) {
            buildUpon.appendPath(str3);
        }
        String str4 = this.f349a.a() == 1 ? "amazon" : "android";
        if (buildUpon != null) {
            buildUpon.appendPath(str4);
        }
        Object obj = UAirship.t;
        if (buildUpon != null) {
            buildUpon.appendQueryParameter("sdk_version", "14.6.0");
        }
        String str5 = Build.MANUFACTURER;
        if (str5 == null) {
            str = "";
        } else {
            str = str5.toLowerCase(Locale.US);
        }
        if (c.contains(str.toLowerCase()) && buildUpon != null) {
            buildUpon.appendQueryParameter("manufacturer", str);
        }
        HashSet hashSet = new HashSet();
        for (PushProvider pushProvider : Collections.unmodifiableList(this.b.get().b)) {
            hashSet.add(pushProvider.getDeliveryType());
        }
        String V1 = hashSet.isEmpty() ? null : hd3.V1(hashSet, ",");
        if (!(V1 == null || buildUpon == null)) {
            buildUpon.appendQueryParameter("push_providers", V1);
        }
        if (!hd3.G1(locale.getLanguage())) {
            String language = locale.getLanguage();
            if (buildUpon != null) {
                buildUpon.appendQueryParameter("language", language);
            }
        }
        if (!hd3.G1(locale.getCountry())) {
            String country = locale.getCountry();
            if (buildUpon != null) {
                buildUpon.appendQueryParameter("country", country);
            }
        }
        if (buildUpon == null) {
            return null;
        }
        return buildUpon.build();
    }
}
