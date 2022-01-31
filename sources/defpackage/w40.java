package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.pubsub.eventbus.events.BusSummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.MetroSummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.MonorailSummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import app.zophop.pubsub.eventbus.events.TrainSummaryResponseEvent;
import com.google.android.gms.maps.model.LatLng;
import defpackage.n00;
import defpackage.yj1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: w40  reason: default package */
/* compiled from: ScheduleFeature */
public class w40 {

    /* renamed from: a  reason: collision with root package name */
    public final xj1 f3717a;
    public final e80 b = xt.f3961a.k();
    public final Context c;

    /* renamed from: w40$a */
    /* compiled from: ScheduleFeature */
    public class a implements yj1.b<JSONArray> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f3718a;

        public a(long j) {
            this.f3718a = j;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONArray jSONArray) {
            JSONArray jSONArray2 = jSONArray;
            try {
                jSONArray2.length();
                jSONArray2.get(0).toString();
                jz5.b().i(new uv().b(jSONArray2));
                Context context = w40.this.c;
                String str = ut.b;
            } catch (JSONException unused) {
                Context context2 = w40.this.c;
                String str2 = ut.b;
                jz5.b().i(new ArrayList());
            }
        }
    }

    /* renamed from: w40$b */
    /* compiled from: ScheduleFeature */
    public class b implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f3719a;

        public b(long j) {
            this.f3719a = j;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            Context context = w40.this.c;
            dk1.toString();
            ArrayList arrayList = new ArrayList();
            dk1.toString();
            jz5.b().i(arrayList);
        }
    }

    /* renamed from: w40$c */
    /* compiled from: ScheduleFeature */
    public class c implements yj1.b<JSONArray> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri.Builder f3720a;
        public final /* synthetic */ long b;

        public c(Uri.Builder builder, long j) {
            this.f3720a = builder;
            this.b = j;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONArray jSONArray) {
            JSONArray jSONArray2 = jSONArray;
            try {
                jSONArray2.length();
                jSONArray2.get(0).toString();
                jz5.b().i(new uv().b(jSONArray2));
                Context context = w40.this.c;
                this.f3720a.toString();
            } catch (JSONException unused) {
                Context context2 = w40.this.c;
                this.f3720a.toString();
                jz5.b().i(new ArrayList());
            }
        }
    }

    /* renamed from: w40$d */
    /* compiled from: ScheduleFeature */
    public class d implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f3721a;
        public final /* synthetic */ TransitMode b;
        public final /* synthetic */ String c;

        public d(long j, TransitMode transitMode, String str) {
            this.f3721a = j;
            this.b = transitMode;
            this.c = str;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            Context context = w40.this.c;
            dk1.toString();
            dk1.toString();
            vn.e("fetch summary", vn.K0(w40.this.c));
            w40 w40 = w40.this;
            TransitMode transitMode = this.b;
            w40.a(w40, transitMode, new SummaryResponseEvent(this.c, transitMode, SummaryResponseEvent.ResponseType.QUERY_FAILED, null));
        }
    }

    /* renamed from: w40$e */
    /* compiled from: ScheduleFeature */
    public class e implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3722a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ TransitMode d;

        public e(String str, long j, String str2, TransitMode transitMode) {
            this.f3722a = str;
            this.b = j;
            this.c = str2;
            this.d = transitMode;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            Context context = w40.this.c;
            SummaryResponseEvent a2 = new uv().a(this.c, jSONObject2);
            hj1.S0("Nearby summary response ", jSONObject2);
            w40.a(w40.this, this.d, a2);
        }
    }

    /* renamed from: w40$f */
    /* compiled from: ScheduleFeature */
    public class f implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f3723a;
        public final /* synthetic */ String b;

        public f(long j, String str) {
            this.f3723a = j;
            this.b = str;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            Context context = w40.this.c;
            dk1.toString();
            dk1.toString();
            jz5.b().i(new SummaryResponseEvent(this.b, null, SummaryResponseEvent.ResponseType.QUERY_FAILED, null));
        }
    }

    /* renamed from: w40$g */
    /* compiled from: ScheduleFeature */
    public class g implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3724a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public g(String str, String str2, long j) {
            this.f3724a = str;
            this.b = str2;
            this.c = j;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            SummaryResponseEvent a2 = new uv().a(this.f3724a, jSONObject2);
            String str = "summary response " + jSONObject2;
            if (a2.getResponseType().equals(SummaryResponseEvent.ResponseType.SUCCESS)) {
                w40.a(w40.this, a2.getSummaryResponseList().get(0).getStop().getMode(), a2);
                Context context = w40.this.c;
                return;
            }
            Context context2 = w40.this.c;
            jz5.b().i(a2);
        }
    }

    /* renamed from: w40$h */
    /* compiled from: ScheduleFeature */
    public class h implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f3725a;

        public h(long j) {
            this.f3725a = j;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            Context context = w40.this.c;
            dk1.toString();
            ArrayList arrayList = new ArrayList();
            dk1.toString();
            jz5.b().i(arrayList);
        }
    }

    static {
        String str = ut.d;
    }

    public w40(xj1 xj1, Context context) {
        this.f3717a = xj1;
        this.c = context;
    }

    public static void a(w40 w40, TransitMode transitMode, SummaryResponseEvent summaryResponseEvent) {
        Object obj;
        Objects.requireNonNull(w40);
        String requestId = summaryResponseEvent.getRequestId();
        SummaryResponseEvent.ResponseType responseType = summaryResponseEvent.getResponseType();
        List<SummaryResponse> summaryResponseList = summaryResponseEvent.getSummaryResponseList();
        int ordinal = transitMode.ordinal();
        if (ordinal == 0) {
            obj = new TrainSummaryResponseEvent(requestId, responseType, summaryResponseList);
        } else if (ordinal == 1) {
            obj = new BusSummaryResponseEvent(requestId, responseType, summaryResponseList);
        } else if (ordinal == 2) {
            obj = new MetroSummaryResponseEvent(requestId, responseType, summaryResponseList);
        } else if (ordinal != 3) {
            obj = new SummaryResponseEvent(requestId, transitMode, responseType, summaryResponseList);
        } else {
            obj = new MonorailSummaryResponseEvent(requestId, responseType, summaryResponseList);
        }
        jz5.b().i(obj);
    }

    public void b(Context context, String str, TransitMode transitMode, String str2) {
        String name = this.b.d().getName();
        if (!str2.equalsIgnoreCase(name)) {
            c(str, str2);
        } else if (vn.K0(context) || !xt.f3961a.A().j()) {
            c(str, name);
        } else {
            HandlerThread handlerThread = new HandlerThread("depFetcher");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new x40(this, str, transitMode, handler));
        }
    }

    public final void c(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        h hVar = new h(currentTimeMillis);
        a aVar = new a(currentTimeMillis);
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder appendPath = builder.encodedPath(ut.d).appendPath(str2).appendPath("stopdetails");
        appendPath.appendQueryParameter("stop_id", str + "").appendQueryParameter("time", "0").appendQueryParameter("day", vn.I()).appendQueryParameter("meta", ui1.K0().toString());
        builder.build().toString();
        c70 c70 = new c70(builder.build().toString(), aVar, hVar);
        c70.n = true;
        this.f3717a.a(c70);
    }

    public void d(String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.d).appendPath(str3).appendPath("tripsbetweenstops");
        builder.appendQueryParameter("from_stop_id", str).appendQueryParameter("to_stop_id", str2).appendQueryParameter("day", vn.I());
        builder.appendQueryParameter("meta", ui1.K0().toString());
        b bVar = new b(currentTimeMillis);
        c70 c70 = new c70(builder.build().toString(), new c(builder, currentTimeMillis), bVar);
        c70.n = true;
        this.f3717a.a(c70);
    }

    public String e(LatLng latLng, TransitMode transitMode, int i, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        LatLng h2 = xt.f3961a.B().h();
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.d).appendPath(this.b.d().getName()).appendPath("summary").appendQueryParameter("lat", hj1.U(new StringBuilder(), latLng.latitude, "")).appendQueryParameter("lon", hj1.U(new StringBuilder(), latLng.longitude, "")).appendQueryParameter("time", String.valueOf(ui1.N())).appendQueryParameter("day", vn.I()).appendQueryParameter("radius", str).appendQueryParameter("cards", String.valueOf(i)).appendQueryParameter("meta", ui1.K0().toString());
        if (h2 != null) {
            builder.appendQueryParameter("currentLat", String.valueOf(h2.latitude));
            builder.appendQueryParameter("currentLon", String.valueOf(h2.longitude));
        }
        if (transitMode != null) {
            builder.appendQueryParameter("station_type", transitMode.toString());
        }
        builder.toString();
        String uri = builder.build().toString();
        d70 d70 = new d70(uri, null, new e(uri, currentTimeMillis, uuid, transitMode), new d(currentTimeMillis, transitMode, uuid));
        d70.n = true;
        this.f3717a.a(d70);
        return uuid;
    }

    public String f(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        f fVar = new f(currentTimeMillis, uuid);
        g gVar = new g(uuid, str, currentTimeMillis);
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.d).appendPath(this.b.d().getName()).appendEncodedPath("summary/stop").appendQueryParameter("stop_ids", str).appendQueryParameter("time", String.valueOf(ui1.N())).appendQueryParameter("day", vn.I()).appendQueryParameter("meta", ui1.K0().toString());
        builder.build().toString();
        this.f3717a.a(new d70(builder.build().toString(), null, gVar, fVar));
        return uuid;
    }
}
