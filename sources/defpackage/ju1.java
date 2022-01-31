package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsConstants;
import defpackage.gv1;
import defpackage.pu1;
import defpackage.uu1;
import defpackage.wv1;
import defpackage.yu1;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: ju1  reason: default package */
/* compiled from: CctTransportBackend */
public final class ju1 implements cw1 {

    /* renamed from: a  reason: collision with root package name */
    public final DataEncoder f1980a = new JsonDataEncoderBuilder().configureWith(lu1.f2272a).ignoreNullValues(true).build();
    public final ConnectivityManager b;
    public final Context c;
    public final URL d;
    public final jy1 e;
    public final jy1 f;
    public final int g;

    /* renamed from: ju1$a */
    /* compiled from: CctTransportBackend */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final URL f1981a;
        public final tu1 b;
        public final String c;

        public a(URL url, tu1 tu1, String str) {
            this.f1981a = url;
            this.b = tu1;
            this.c = str;
        }
    }

    /* renamed from: ju1$b */
    /* compiled from: CctTransportBackend */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f1982a;
        public final URL b;
        public final long c;

        public b(int i, URL url, long j) {
            this.f1982a = i;
            this.b = url;
            this.c = j;
        }
    }

    public ju1(Context context, jy1 jy1, jy1 jy12) {
        this.c = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = c(iu1.c);
        this.e = jy12;
        this.f = jy1;
        this.g = 40000;
    }

    public static URL c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(hj1.S("Invalid url: ", str), e2);
        }
    }

    @Override // defpackage.cw1
    public wv1 a(vv1 vv1) {
        String str;
        Integer num;
        String str2;
        qv1 qv1;
        pu1.b bVar;
        long j;
        String str3;
        HashMap hashMap = new HashMap();
        qv1 qv12 = (qv1) vv1;
        for (gv1 gv1 : qv12.f2994a) {
            String g2 = gv1.g();
            if (!hashMap.containsKey(g2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(gv1);
                hashMap.put(g2, arrayList);
            } else {
                ((List) hashMap.get(g2)).add(gv1);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            String str4 = null;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                gv1 gv12 = (gv1) ((List) entry.getValue()).get(0);
                zu1 zu1 = zu1.DEFAULT;
                Long valueOf = Long.valueOf(this.f.a());
                Long valueOf2 = Long.valueOf(this.e.a());
                ou1 ou1 = new ou1(uu1.a.ANDROID_FIREBASE, new mu1(Integer.valueOf(gv12.f("sdk-version")), gv12.a("model"), gv12.a("hardware"), gv12.a(AnalyticsConstants.DEVICE), gv12.a("product"), gv12.a("os-uild"), gv12.a("manufacturer"), gv12.a("fingerprint"), gv12.a(AnalyticsConstants.LOCALE), gv12.a("country"), gv12.a("mcc_mnc"), gv12.a("application_build"), null), null);
                try {
                    str = null;
                    num = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                } catch (NumberFormatException unused) {
                    num = null;
                    str = (String) entry.getKey();
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    gv1 gv13 = (gv1) it2.next();
                    fv1 d2 = gv13.d();
                    zt1 zt1 = d2.f1174a;
                    if (zt1.equals(new zt1("proto"))) {
                        byte[] bArr = d2.b;
                        bVar = new pu1.b();
                        bVar.d = bArr;
                    } else if (zt1.equals(new zt1("json"))) {
                        String str5 = new String(d2.b, Charset.forName(StringRpcServer.STRING_ENCODING));
                        bVar = new pu1.b();
                        bVar.e = str5;
                    } else {
                        qv1 = qv12;
                        gj1.L("CctTransportBackend");
                        String.format("Received event of unsupported encoding %s. Skipping...", zt1);
                        it2 = it2;
                        it = it;
                        qv12 = qv1;
                    }
                    bVar.f2853a = Long.valueOf(gv13.e());
                    bVar.c = Long.valueOf(gv13.h());
                    String str6 = gv13.b().get("tz-offset");
                    if (str6 == null) {
                        j = 0;
                    } else {
                        j = Long.valueOf(str6).longValue();
                    }
                    bVar.f = Long.valueOf(j);
                    qv1 = qv12;
                    bVar.g = new su1(yu1.b.forNumber(gv13.f("net-type")), yu1.a.forNumber(gv13.f("mobile-subtype")), null);
                    if (gv13.c() != null) {
                        bVar.b = gv13.c();
                    }
                    if (bVar.f2853a == null) {
                        str3 = " eventTimeMs";
                    } else {
                        str3 = "";
                    }
                    if (bVar.c == null) {
                        str3 = hj1.S(str3, " eventUptimeMs");
                    }
                    if (bVar.f == null) {
                        str3 = hj1.S(str3, " timezoneOffsetSeconds");
                    }
                    if (str3.isEmpty()) {
                        arrayList3.add(new pu1(bVar.f2853a.longValue(), bVar.b, bVar.c.longValue(), bVar.d, bVar.e, bVar.f.longValue(), bVar.g, null));
                        it2 = it2;
                        it = it;
                        qv12 = qv1;
                    } else {
                        throw new IllegalStateException(hj1.S("Missing required properties:", str3));
                    }
                }
                if (valueOf == null) {
                    str2 = " requestTimeMs";
                } else {
                    str2 = "";
                }
                if (valueOf2 == null) {
                    str2 = hj1.S(str2, " requestUptimeMs");
                }
                if (str2.isEmpty()) {
                    arrayList2.add(new qu1(valueOf.longValue(), valueOf2.longValue(), ou1, num, str, arrayList3, zu1, null));
                    it = it;
                    qv12 = qv12;
                } else {
                    throw new IllegalStateException(hj1.S("Missing required properties:", str2));
                }
            } else {
                nu1 nu1 = new nu1(arrayList2);
                URL url = this.d;
                if (qv12.b != null) {
                    try {
                        iu1 a2 = iu1.a(((qv1) vv1).b);
                        String str7 = a2.b;
                        if (str7 != null) {
                            str4 = str7;
                        }
                        String str8 = a2.f1573a;
                        if (str8 != null) {
                            url = c(str8);
                        }
                    } catch (IllegalArgumentException unused2) {
                        return wv1.a();
                    }
                }
                try {
                    b bVar2 = (b) gj1.k0(5, new a(url, nu1, str4), new hu1(this), gu1.f1304a);
                    int i = bVar2.f1982a;
                    if (i == 200) {
                        return new rv1(wv1.a.OK, bVar2.c);
                    }
                    if (i < 500) {
                        if (i != 404) {
                            return wv1.a();
                        }
                    }
                    return new rv1(wv1.a.TRANSIENT_ERROR, -1);
                } catch (IOException unused3) {
                    gj1.L("CctTransportBackend");
                    return new rv1(wv1.a.TRANSIENT_ERROR, -1);
                }
            }
        }
    }

    @Override // defpackage.cw1
    public gv1 b(gv1 gv1) {
        int i;
        int i2;
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        gv1.a i3 = gv1.i();
        i3.c().put("sdk-version", String.valueOf(Build.VERSION.SDK_INT));
        i3.c().put("model", Build.MODEL);
        i3.c().put("hardware", Build.HARDWARE);
        i3.c().put(AnalyticsConstants.DEVICE, Build.DEVICE);
        i3.c().put("product", Build.PRODUCT);
        i3.c().put("os-uild", Build.ID);
        i3.c().put("manufacturer", Build.MANUFACTURER);
        i3.c().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        i3.c().put("tz-offset", String.valueOf((long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
        if (activeNetworkInfo == null) {
            i = yu1.b.NONE.getValue();
        } else {
            i = activeNetworkInfo.getType();
        }
        i3.c().put("net-type", String.valueOf(i));
        int i4 = -1;
        if (activeNetworkInfo == null) {
            i2 = yu1.a.UNKNOWN_MOBILE_SUBTYPE.getValue();
        } else {
            i2 = activeNetworkInfo.getSubtype();
            if (i2 == -1) {
                i2 = yu1.a.COMBINED.getValue();
            } else if (yu1.a.forNumber(i2) == null) {
                i2 = 0;
            }
        }
        i3.c().put("mobile-subtype", String.valueOf(i2));
        i3.c().put("country", Locale.getDefault().getCountry());
        i3.c().put(AnalyticsConstants.LOCALE, Locale.getDefault().getLanguage());
        i3.c().put("mcc_mnc", ((TelephonyManager) this.c.getSystemService("phone")).getSimOperator());
        Context context = this.c;
        try {
            i4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            gj1.L("CctTransportBackend");
        }
        i3.c().put("application_build", Integer.toString(i4));
        return i3.b();
    }
}
