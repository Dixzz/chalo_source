package defpackage;

import android.content.Context;
import app.zophop.models.TripOptions;
import app.zophop.models.TripRequest;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import com.crashlytics.android.answers.SearchEvent;
import com.razorpay.AnalyticsConstants;
import defpackage.hv;
import defpackage.n00;
import defpackage.wj1;
import defpackage.yj1;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import zophop.models.Itinerary;
import zophop.models.TripPlannerResponse;

/* renamed from: l50  reason: default package */
/* compiled from: TripPlanner */
public class l50 implements c30 {

    /* renamed from: a  reason: collision with root package name */
    public final xj1 f2175a;
    public final e80 b;
    public final Context c;

    /* renamed from: l50$a */
    /* compiled from: TripPlanner */
    public class a implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TripRequest f2176a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        public a(TripRequest tripRequest, String str, String str2, String str3, long j) {
            this.f2176a = tripRequest;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = j;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00b1  */
        @Override // defpackage.yj1.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(org.json.JSONObject r10) {
            /*
            // Method dump skipped, instructions count: 201
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.l50.a.a(java.lang.Object):void");
        }
    }

    /* renamed from: l50$b */
    /* compiled from: TripPlanner */
    public class b implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f2177a;
        public final /* synthetic */ TripRequest b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public b(long j, TripRequest tripRequest, String str, String str2, String str3) {
            this.f2177a = j;
            this.b = tripRequest;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            tj1 tj1 = dk1.f;
            String str = "Something Went Wrong";
            if (!(tj1 == null || tj1.b == null)) {
                try {
                    JSONObject jSONObject = new JSONObject(new dk1(new String(dk1.f.b)).getLocalizedMessage());
                    if (jSONObject.has("errorType") && !jSONObject.getString("errorType").equals("UNKNOWN")) {
                        str = jSONObject.optString("errorMessage", str);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            Context context = l50.this.c;
            dk1.toString();
            dk1.toString();
            jz5.b().i(new TripPlannerEvent(this.b, str, null, TripPlannerEvent.ResponseType.FAILED, this.c));
            l50.this.b(false, this.d, dk1.toString(), this.e);
        }
    }

    /* renamed from: l50$c */
    /* compiled from: TripPlanner */
    public class c extends d70 {
        public final /* synthetic */ TripOptions A;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, yj1.b bVar, n00.z0 z0Var, TripOptions tripOptions) {
            super(str, null, bVar, z0Var);
            this.A = tripOptions;
        }

        @Override // defpackage.wj1
        public wj1.c q() {
            TripOptions tripOptions = this.A;
            if (tripOptions != null) {
                Objects.requireNonNull(l50.this);
                if (tripOptions._tabItem.equals(l90.BUS) || tripOptions._tabItem.equals(l90.RECOMMENDED)) {
                    return wj1.c.HIGH;
                }
            }
            return wj1.c.NORMAL;
        }
    }

    public l50(Context context, xj1 xj1, e80 e80) {
        this.c = context;
        this.f2175a = xj1;
        this.b = e80;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0188  */
    @Override // defpackage.c30
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(app.zophop.models.TripRequest r22, app.zophop.models.TripOptions r23) {
        /*
        // Method dump skipped, instructions count: 498
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l50.a(app.zophop.models.TripRequest, app.zophop.models.TripOptions):java.lang.String");
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (hv.b == null) {
            hv.b = new hv();
        }
        hv.b bVar = hv.b.f1430a.get(str3);
        long j = 0;
        if (bVar != null) {
            if (bVar.b == 0) {
                bVar.b = System.currentTimeMillis();
            }
            j = bVar.b - bVar.f1431a;
        }
        ed1 l = hj1.l("trip planner response received", Long.MIN_VALUE, "responseType", z ? "success" : AnalyticsConstants.FAILURE);
        l.a("timeTaken", String.valueOf(j));
        if (!z) {
            l.a(SearchEvent.QUERY_ATTRIBUTE, str);
            l.a("failureReason", str2);
        }
        jz5.b().g(l);
    }

    public final void c(TripRequest tripRequest, TripPlannerResponse tripPlannerResponse) {
        String description = tripRequest.getDescription(tripRequest.getFrom());
        String description2 = tripRequest.getDescription(tripRequest.getTo());
        if (description == null) {
            description = "Origin";
        }
        if (description2 == null) {
            description2 = "Destination";
        }
        Iterator<Itinerary> it = tripPlannerResponse.itineraries.iterator();
        while (it.hasNext()) {
            Itinerary next = it.next();
            int size = next.legs.size();
            next.legs.get(0).start_place_name = description;
            next.legs.get(size - 1).end_place_name = description2;
        }
    }
}
