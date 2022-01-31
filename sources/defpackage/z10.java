package defpackage;

import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* renamed from: z10  reason: default package */
/* compiled from: GeoSpatialFeatureWithPollingImpl */
public class z10 implements o20 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4108a;
    public final xj1 b;
    public final Map<String, b20> c = new HashMap();

    public z10(Context context, xj1 xj1) {
        this.f4108a = context;
        this.b = xj1;
        y10.g();
    }

    @Override // defpackage.o20
    public void a(String str) {
        Map<String, b20> map = this.c;
        if (map != null && map.containsKey(str)) {
            b20 b20 = this.c.get(str);
            b20.i = false;
            b20.g.c(b20.f());
            b20.f.removeCallbacks(b20.b);
            b20.f367a.quit();
            this.c.remove(str);
        }
    }

    @Override // defpackage.o20
    public boolean b(String str, LatLng latLng) {
        boolean z;
        Map<String, b20> map = this.c;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        b20 b20 = this.c.get(str);
        Objects.requireNonNull(b20);
        synchronized (b20.w) {
            b20.g.c(b20.f());
            b20.f.removeCallbacks(b20.b);
            b20.d = latLng;
            b20.r = false;
            b20.s = false;
            b20.k = b20.l;
            b20.h(false, false);
            z = b20.i;
        }
        return z;
    }

    @Override // defpackage.o20
    public void c(int i) {
    }

    @Override // defpackage.o20
    public String d(LatLng latLng, double d, int i) {
        String uuid = UUID.randomUUID().toString();
        this.c.put(uuid, new b20(this.f4108a, this.b, uuid, latLng, d, i));
        return uuid;
    }
}
