package defpackage;

import android.content.Context;
import android.net.Uri;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import app.zophop.pubsub.eventbus.events.DatabaseConnectionEvent;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import app.zophop.service.LocationTrackingService;
import app.zophop.ui.activities.LocationIntentReceiverActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import defpackage.sd1;
import defpackage.ut;
import defpackage.xt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: z30  reason: default package */
/* compiled from: RealTimeFeature */
public class z30 implements h20 {

    /* renamed from: a  reason: collision with root package name */
    public DatabaseReference f4113a;
    public DatabaseReference b;
    public DatabaseReference c;
    public DatabaseReference d;
    public final yd1 e;
    public final e80 f;
    public final Context g;
    public nf1 h = null;

    /* renamed from: z30$a */
    /* compiled from: RealTimeFeature */
    public class a implements sd1.b {
        public a() {
        }

        @Override // defpackage.sd1.b
        public void a() {
            if (!LocationTrackingService.l && xt.f3961a.A().k()) {
                z30.this.b(false);
            }
        }

        @Override // defpackage.sd1.b
        public void b() {
            xt.t1 t1Var = xt.f3961a;
            t1Var.A();
            String optString = t1Var.l().h.optString("syn_status", null);
            boolean z = false;
            if (optString != null && (optString.equals(DatabaseSyncEvent.STATUS.STARTED.toString()) || optString.equals(DatabaseSyncEvent.STATUS.STOPS_DONE.toString()))) {
                z = true;
            }
            if (!z) {
                z30.this.b(true);
            }
        }
    }

    /* renamed from: z30$b */
    /* compiled from: RealTimeFeature */
    public class b implements ValueEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean[] f4115a;

        public b(z30 z30, boolean[] zArr) {
            this.f4115a = zArr;
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            String str = LocationIntentReceiverActivity.k;
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            this.f4115a[0] = ((Boolean) dataSnapshot.getValue(Boolean.class)).booleanValue();
            DatabaseConnectionEvent databaseConnectionEvent = new DatabaseConnectionEvent();
            databaseConnectionEvent.setConnected(this.f4115a[0]);
            jz5.b().g(databaseConnectionEvent);
        }
    }

    /* renamed from: z30$c */
    /* compiled from: RealTimeFeature */
    public class c implements ValueEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f4116a;
        public final /* synthetic */ Stop b;
        public final /* synthetic */ ji1 c;

        public c(z30 z30, List list, Stop stop, ji1 ji1) {
            this.f4116a = list;
            this.b = stop;
            this.c = ji1;
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            this.c.a(databaseError.getDetails());
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            j10 f = ii1.f(dataSnapshot, this.f4116a, this.b.getLatLong());
            if (f.b().size() != 0) {
                this.c.onSuccess(f);
            } else if (f.a() == Integer.MAX_VALUE) {
                this.c.a("no_etas");
            } else if (f.a() >= 7200) {
                this.c.a("all_max_etas");
            } else {
                this.c.onSuccess(f);
            }
        }
    }

    public z30(Context context, String str) {
        new HashMap();
        new HashMap();
        ut.a aVar = ut.f3552a;
        this.e = new ce1(context, str, "amqp://appuser:MDI2ZTBmYTUxNzVmMjM0ZjM2ZjEyNDYx@rmq.chalo.com/chaloApp", ut.B);
        xt.t1 t1Var = xt.f3961a;
        this.f = t1Var.k();
        i();
        g();
        this.g = context;
        sd1 v = t1Var.v();
        v.i.add(new a());
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public final void a(String str, Map map) {
        ((ce1) this.e).c(new zd1(str, map));
    }

    public void b(boolean z) {
        if (z) {
            xt.t1 t1Var = xt.f3961a;
            if (!xt.p || !ui1.W()) {
                FirebaseDatabase.getInstance().goOnline();
                DatabaseReference.goOnline();
                return;
            }
            return;
        }
        FirebaseDatabase.getInstance().goOffline();
        DatabaseReference.goOffline();
    }

    public void c(Stop stop, String str, List<StreamInfo> list, ji1<j10, String> ji1) {
        if (!vn.K0(this.g)) {
            ji1.a("NO Internet");
            return;
        }
        this.d.child(this.f.d().getName().toUpperCase()).child(stop.getId()).child(str).addListenerForSingleValueEvent(new c(this, list, stop, ji1));
    }

    public DatabaseReference d(String str) {
        return this.d.child(xt.f3961a.k().d().getName().toUpperCase()).child(str);
    }

    public void e(Stop stop, String str, ji1<j10, String> ji1) {
        if (!vn.K0(this.g)) {
            ji1.a("NO Internet");
            return;
        }
        String upperCase = this.f.d().getName().toUpperCase();
        xt.t1 t1Var = xt.f3961a;
        if (xt.p) {
            String id = stop.getId();
            Uri.Builder builder = new Uri.Builder();
            builder.encodedPath(ut.q).appendEncodedPath("eta").appendEncodedPath(upperCase).appendEncodedPath(str).appendEncodedPath(id);
            JSONObject K0 = ui1.K0();
            if (K0 != null) {
                try {
                    K0.put("src", "appCrts");
                } catch (JSONException e2) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e2);
                }
                builder.appendQueryParameter("meta", K0.toString());
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("src", "appCrts");
                    builder.appendQueryParameter("meta", jSONObject.toString());
                } catch (JSONException e3) {
                    b00 b002 = b00.f358a;
                    b00.a().b(e3);
                }
            }
            String uri = builder.build().toString();
            xt.f3961a.S().a(new e70(0, uri, new d40(this, ji1), new e40(this, ji1), new JSONObject().toString()));
            return;
        }
        this.d.child(upperCase).child(stop.getId()).child(str).addListenerForSingleValueEvent(new c40(this, ji1));
    }

    public DatabaseReference f(String str) {
        return this.c.child(this.f.d().getName().toUpperCase()).child(str);
    }

    public final void g() {
        this.b = this.f4113a.child("streams");
        this.c = this.f4113a.child(ProductDiscountsObject.KEY_ROUTES);
        this.d = this.f4113a.child("eta");
    }

    public void h() {
        FirebaseDatabase.getInstance().getReference(".info/connected").addValueEventListener(new b(this, new boolean[]{true}));
    }

    public final void i() {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.k().d() != null) {
            String liveDataUrl = t1Var.k().d().getLiveDataUrl();
            this.f4113a = FirebaseDatabase.getInstance(liveDataUrl).getReference().child(ut.g.name());
            return;
        }
        this.f4113a = FirebaseDatabase.getInstance().getReference().child(ut.g.name());
    }

    public void j(String str, String str2, boolean z) {
        if (str != null && str2 != null) {
            xt.t1 t1Var = xt.f3961a;
            if (!xt.p) {
                d(str).child(str2).keepSynced(z);
            }
        }
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        i();
        g();
    }

    public void onEvent(UserProfileEvent userProfileEvent) {
        xt.f3961a.m0();
    }
}
