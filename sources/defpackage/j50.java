package defpackage;

import android.content.Context;
import app.zophop.ZophopApplication;
import app.zophop.models.City;
import app.zophop.models.mTicketing.TrillSoundConfiguration;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.rabbitmq.client.AMQP;
import com.razorpay.AnalyticsConstants;
import com.trillbit.datasdk.core.CWrapper;
import defpackage.kb;
import defpackage.kg5;
import defpackage.ut;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: j50  reason: default package */
/* compiled from: TrillSoundFeature.kt */
public final class j50 implements b30 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1879a;
    public final j56 b = hd3.a2(new b(this));
    public Context c;
    public String d;
    public String e;
    public rf1 f;
    public long g;
    public long h;
    public final TrillSoundConfiguration i;
    public boolean j;

    /* renamed from: j50$a */
    /* compiled from: TrillSoundFeature.kt */
    public interface a {
        void a(int i);

        void d(int i);
    }

    /* renamed from: j50$b */
    /* compiled from: TrillSoundFeature.kt */
    public static final class b extends o86 implements h76<eg5> {
        public final /* synthetic */ j50 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(j50 j50) {
            super(0);
            this.f = j50;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public eg5 invoke() {
            return new eg5(this.f.f1879a, "368128054af01c60", "a785da4a-def1-49d9-bf53-2efd0f8f5a8f");
        }
    }

    public j50(Context context) {
        int i2;
        String name;
        n86.e(context, AnalyticsConstants.CONTEXT);
        this.f1879a = context;
        TrillSoundConfiguration trillSoundConfiguration = new TrillSoundConfiguration(null, false, 3, null);
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        if (!(d2 == null || (name = d2.getName()) == null)) {
            String lowerCase = name.toLowerCase();
            n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            ut.a aVar = ut.f3552a;
            String f2 = t1Var.t().f("cityWiseTrillbitConfigurationProd");
            n86.d(f2, "{\n            getFireBas…IGURATION_PROD)\n        }");
            if (!(f2.length() == 0)) {
                try {
                    JSONObject jSONObject = new JSONObject(f2);
                    if (jSONObject.has("all")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("all");
                        String optString = jSONObject2.optString(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "3.6");
                        boolean optBoolean = jSONObject2.optBoolean("isTwoWay", false);
                        n86.d(optString, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
                        trillSoundConfiguration = new TrillSoundConfiguration(optString, optBoolean);
                    }
                    if (jSONObject.has(lowerCase)) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject(lowerCase);
                        String optString2 = jSONObject3.optString(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "3.6");
                        boolean optBoolean2 = jSONObject3.optBoolean("isTwoWay", false);
                        n86.d(optString2, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
                        trillSoundConfiguration = new TrillSoundConfiguration(optString2, optBoolean2);
                    }
                } catch (Exception e2) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e2);
                }
            }
        }
        this.i = trillSoundConfiguration;
        HashMap hashMap = new HashMap();
        String sdkVersion = trillSoundConfiguration.getSdkVersion();
        eg5 h2 = h();
        k50 k50 = new k50(hashMap, this, sdkVersion, false, 19);
        h2.d = k50;
        int i3 = h2.h;
        if (i3 == -1) {
            h2.h = 0;
            h2.e = false;
            float f3 = 3.6f;
            kg5 kg5 = h2.g;
            kg5.d(AnalyticsConstants.INIT);
            if (kg5.i == 0) {
                kg5.j = k50;
                kg5.i = 1;
                kg5.m = false;
                kg5.k = new gg5(kg5);
                kg5.h = new hg5(kg5);
                if (sdkVersion.equals("3.6")) {
                    i2 = 44100;
                } else {
                    f3 = 3.7f;
                    i2 = 48000;
                }
                kg5.e = new qg5(kg5.k, i2);
                kg5.f = new CWrapper(0, kg5.d, false, f3);
                kg5.g = new lg5(kg5.c, kg5.f, kg5.h, kg5.d, i2);
                kg5.b = new ng5(kg5.f);
                kg5.e.c = kg5.d;
                kg5.j.d(AMQP.REPLY_SUCCESS);
            }
            k50.d(AMQP.REPLY_SUCCESS);
            k50.b(304, "SDK Initialized");
        } else if (i3 == -2) {
            k50.a(AMQP.PRECONDITION_FAILED, "Unsupported Payload Length");
        } else {
            k50.a(400, "SDK Already Running");
        }
    }

    public static final void f(j50 j50, Map map, String str, boolean z) {
        Objects.requireNonNull(j50);
        map.put("sound sdk version code", str);
        map.put("sound validation algo used", 102);
        if (z) {
            map.put("sound validation type", "two way");
        } else {
            map.put("sound validation type", "one way");
        }
    }

    public static final void g(j50 j50, String str, Map map) {
        Objects.requireNonNull(j50);
        ui1.m0(new ed1(str, Long.MIN_VALUE, map));
    }

    @Override // defpackage.b30
    public void a() {
        int i2;
        eg5 h2 = h();
        int i3 = h2.i;
        if (i3 == -1) {
            h2.d.a(AMQP.FRAME_ERROR, "Unable to authenticate sdk");
        } else if (i3 == 2) {
            h2.d.a(AMQP.NOT_FOUND, "SDK Expired");
        } else if (i3 == 1 && (i2 = h2.h) != -1) {
            if (i2 == 0) {
                kg5 kg5 = h2.g;
                kg5.d("stop");
                if (kg5.i != 1) {
                    kg5.e();
                    kg5.q.b();
                    kg5.d.b();
                    return;
                }
                kg5.c(AnalyticsConstants.START);
                kg5.j.a(400, "SDK Already Running");
                return;
            }
            h2.d.a(513, "Authentication not running");
        }
    }

    @Override // defpackage.b30
    public boolean b() {
        return h().a();
    }

    @Override // defpackage.b30
    public void c(String str, Context context, String str2) {
        this.e = str2;
        this.d = str;
        this.c = context;
        this.f = new rf1(this.f1879a, "OTP_STORAGE");
    }

    @Override // defpackage.b30
    public void d(String str, Context context, String str2) {
        this.e = str2;
        this.d = str;
        this.j = true;
        this.c = context;
    }

    @Override // defpackage.b30
    public void e(byte[] bArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (bArr != null) {
            int i7 = 0;
            i4 = 0;
            while (true) {
                int i8 = i7 + 1;
                i4 = (i4 * 2) + (Math.abs((int) bArr[i7]) % 2);
                if (i8 > 2) {
                    break;
                }
                i7 = i8;
            }
            int i9 = 3;
            i3 = 0;
            while (true) {
                int i10 = i9 + 1;
                i3 = (i3 * 2) + (Math.abs((int) bArr[i9]) % 2);
                if (i10 > 5) {
                    break;
                }
                i9 = i10;
            }
            int i11 = 6;
            i2 = 0;
            while (true) {
                int i12 = i11 + 1;
                i2 = (i2 * 2) + (Math.abs((int) bArr[i11]) % 2);
                if (i12 > 8) {
                    break;
                }
                i11 = i12;
            }
        } else {
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        int i13 = (i2 * 100) + (i3 * 10) + i4;
        if (this.j) {
            xt.t1 t1Var = xt.f3961a;
            tz value = xt.w0.getValue();
            sz szVar = sz.f3280a;
            kb.a<Integer> aVar = sz.b;
            Integer valueOf = Integer.valueOf(i13);
            Objects.requireNonNull(value);
            n86.e(aVar, "lDataStorePreferenceKey");
            hd3.Y1((ZophopApplication) value.b.getValue(), null, null, new uz(value, aVar, valueOf, null), 3, null);
        } else {
            rf1 rf1 = this.f;
            if (rf1 != null) {
                rf1.h(this.d, i13);
            }
        }
        eg5 h2 = h();
        int i14 = h2.i;
        if (i14 == -1) {
            h2.d.a(AMQP.FRAME_ERROR, "Unable to authenticate sdk");
        } else if (i14 == 2) {
            h2.d.a(AMQP.NOT_FOUND, "SDK Expired");
        } else if (i14 == 1 && (i6 = h2.h) != -1 && i6 == 0) {
            kg5 kg5 = h2.g;
            if (kg5.m) {
                if (i13 > 999) {
                    kg5.l = i13 / 10;
                } else {
                    kg5.l = i13;
                }
                bg5 bg5 = kg5.d;
                bg5.a("Sender", "Set Expected Code Called, Expecting : " + i13);
                CWrapper.setExpectedString(new byte[]{(byte) (i13 / 100), (byte) (i13 % 100)}, kg5.f.b);
            } else {
                kg5.j.a(407, "Method not supported in oneway");
            }
        }
        eg5 h3 = h();
        int i15 = h3.i;
        if (i15 == -1) {
            h3.d.a(AMQP.FRAME_ERROR, "Unable to authenticate sdk");
        } else if (i15 == 2) {
            h3.d.a(AMQP.NOT_FOUND, "SDK Expired");
        } else if (i15 == 1 && (i5 = h3.h) != -1) {
            if (i5 == 0) {
                if (h3.a()) {
                    h3.d.a(514, "Wired or Wireless handset is connected");
                }
                if (!h3.e) {
                    kg5 kg52 = h3.g;
                    if (!kg52.m) {
                        kg52.n = (int) 1400.0f;
                    }
                }
                kg5 kg53 = h3.g;
                kg53.d("play");
                if (kg53.i == 1) {
                    Objects.requireNonNull(kg53.d);
                    kg53.p = new kg5.a(bArr);
                    kg5.b bVar = new kg5.b(null);
                    kg53.q = bVar;
                    bVar.c = new ArrayList<>();
                    bVar.f2057a = Long.valueOf(System.currentTimeMillis() + 1000);
                    bVar.b = 0;
                    kg53.o = 102;
                    kg53.i = 2;
                    kg53.j.f(AMQP.REPLY_SUCCESS);
                    kg53.b(false);
                    return;
                }
                kg53.c(AnalyticsConstants.START);
                kg53.j.a(400, "SDK Already Running");
            } else if (i5 == 1) {
                h3.d.a(AMQP.ACCESS_REFUSED, "SDK Type Receiver doesn't supports called method, check documents");
            }
        }
    }

    public final eg5 h() {
        return (eg5) this.b.getValue();
    }
}
