package defpackage;

import defpackage.nc5;
import java.util.Objects;
import org.json.JSONArray;

/* renamed from: j00  reason: default package */
/* compiled from: AbTestingFeature */
public class j00 implements c20 {

    /* renamed from: a  reason: collision with root package name */
    public final nc5 f1858a;

    public j00(nc5 nc5) {
        boolean z;
        JSONArray jSONArray;
        this.f1858a = nc5;
        nc5.e eVar = nc5.e;
        h00 h00 = new h00(this);
        Objects.requireNonNull(eVar);
        nc5.this.f.g(h00);
        i00 i00 = new i00(this);
        nc5.f fVar = (nc5.f) nc5.this.h;
        fVar.f.add(i00);
        ec5 ec5 = nc5.this.j;
        synchronized (ec5) {
            z = !ec5.d.isEmpty() || ((jSONArray = ec5.h) != null && jSONArray.length() > 0);
        }
        if (z) {
            fVar.g.execute(fVar);
        }
    }
}
