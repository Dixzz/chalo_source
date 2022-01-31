package defpackage;

import android.os.Handler;
import app.zophop.models.SeatInfo;
import app.zophop.models.VehicleInfo;
import java.util.List;
import java.util.Map;

/* renamed from: z20  reason: default package */
/* compiled from: ISeatOccupancyFeature */
public interface z20 {
    Runnable a();

    void b();

    void c(List<SeatInfo> list, String str);

    Map<String, Integer> d(List<SeatInfo> list, Map<String, Integer> map);

    void e(Handler handler);

    void f();

    void g(Map<String, VehicleInfo> map);

    void h();
}
