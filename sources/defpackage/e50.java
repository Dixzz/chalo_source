package defpackage;

import android.content.Context;
import android.os.Handler;
import app.zophop.models.SeatInfo;
import app.zophop.models.VehicleInfo;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: e50  reason: default package */
/* compiled from: SeatOccupancyFeature */
public class e50 implements z20 {

    /* renamed from: a  reason: collision with root package name */
    public Handler f927a;
    public Runnable b;
    public List<VehicleInfo> c;

    /* renamed from: e50$a */
    /* compiled from: SeatOccupancyFeature */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e50 e50 = e50.this;
            if (e50.f927a != null) {
                e50.f();
                e50 e502 = e50.this;
                e502.f927a.postDelayed(e502.b, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD);
            }
        }
    }

    public e50(Context context) {
    }

    @Override // defpackage.z20
    public Runnable a() {
        if (this.f927a == null) {
            return null;
        }
        this.c.size();
        a aVar = new a();
        this.b = aVar;
        return aVar;
    }

    @Override // defpackage.z20
    public void b() {
        Handler handler = this.f927a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f927a = null;
    }

    @Override // defpackage.z20
    public void c(List<SeatInfo> list, String str) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                ed1 ed1 = new ed1("seat status", Long.MIN_VALUE);
                SeatInfo seatInfo = list.get(i);
                ed1.a("vehicle no", seatInfo.getVehicleNo());
                ed1.a("seat status", Integer.valueOf(seatInfo.getSeatStatus()));
                ed1.a("time", Long.valueOf(System.currentTimeMillis()));
                ed1.a("event happened on screen:", str);
                jz5.b().g(ed1);
            }
        }
    }

    @Override // defpackage.z20
    public Map<String, Integer> d(List<SeatInfo> list, Map<String, Integer> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        for (SeatInfo seatInfo : list) {
            map.put(seatInfo.getVehicleNo(), Integer.valueOf(seatInfo.getSeatStatus()));
        }
        return map;
    }

    @Override // defpackage.z20
    public void e(Handler handler) {
        this.f927a = handler;
    }

    @Override // defpackage.z20
    public void f() {
        if (this.c != null) {
            xt.f3961a.c().X(this.c);
        }
    }

    @Override // defpackage.z20
    public void g(Map<String, VehicleInfo> map) {
        this.c = new ArrayList();
        for (Map.Entry<String, VehicleInfo> entry : map.entrySet()) {
            this.c.add(entry.getValue());
        }
    }

    @Override // defpackage.z20
    public void h() {
        Handler handler = this.f927a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
