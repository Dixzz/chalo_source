package defpackage;

import android.content.Context;
import android.os.SystemClock;
import app.zophop.features.GeoFenceReceiver;
import app.zophop.models.Stop;
import app.zophop.models.StopGeofence;
import app.zophop.models.TransitMode;
import com.google.android.gms.internal.location.zzbh;
import com.google.firebase.appindexing.Indexable;
import org.json.JSONException;

/* renamed from: u10  reason: default package */
/* compiled from: GeoFenceFeature */
public class u10 implements n20 {

    /* renamed from: a  reason: collision with root package name */
    public final je1 f3441a;
    public final sv b = new sv();
    public final rf1 c;

    public u10(Context context, je1 je1) {
        this.f3441a = je1;
        this.c = new rf1(context, "geofenceStore");
    }

    @Override // defpackage.n20
    public long a() {
        return this.c.b.getLong("previousAutoRefreshTimeInMillis", 0);
    }

    @Override // defpackage.n20
    public void b(Stop stop, boolean z) {
        long j;
        if (stop != null) {
            StopGeofence stopGeofence = null;
            try {
                String string = this.c.b.getString(stop.getId(), null);
                if (string != null) {
                    stopGeofence = this.b.b(string);
                }
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
            if (stopGeofence != null) {
                if (!stopGeofence.isNeverExpire()) {
                    this.f3441a.i("stop:" + stop.getId());
                    String id = stop.getId();
                    if (this.c.b.contains(id)) {
                        rf1 rf1 = this.c;
                        rf1.f3075a.remove(id);
                        rf1.f3075a.commit();
                    }
                } else {
                    return;
                }
            }
            float f = stop.getMode().equals(TransitMode.bus) ? 100.0f : 300.0f;
            double d = stop.getLatLong().latitude;
            double d2 = stop.getLatLong().longitude;
            int parseInt = Integer.parseInt(xt.f3961a.t().f("geofenceDwellTimeInMin")) * 60 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
            String S = hj1.S("stop:", stop.getId());
            long j2 = z ? -1 : 2592000000L;
            if (j2 < 0) {
                j = -1;
            } else {
                j = SystemClock.elapsedRealtime() + j2;
            }
            je1 je1 = this.f3441a;
            if (S == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (parseInt < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (j != Long.MIN_VALUE) {
                je1.g(new zzbh(S, 4, 1, d, d2, f, j, 0, parseInt), GeoFenceReceiver.class);
                StopGeofence stopGeofence2 = new StopGeofence();
                stopGeofence2.setStop(stop);
                stopGeofence2.setCreationTimeInMillis(System.currentTimeMillis());
                stopGeofence2.setExpiryDuration(z ? -1 : 2592000000L);
                stopGeofence2.setNeverExpire(z);
                try {
                    this.c.j(stopGeofence2.getStop().getId(), this.b.a(stopGeofence2).toString());
                } catch (JSONException e2) {
                    b00 b002 = b00.f358a;
                    b00.a().b(e2);
                }
            } else {
                throw new IllegalArgumentException("Expiration not set.");
            }
        }
    }

    @Override // defpackage.n20
    public void c(long j) {
        rf1 rf1 = this.c;
        rf1.f3075a.putLong("previousAutoRefreshTimeInMillis", j);
        rf1.f3075a.commit();
    }
}
