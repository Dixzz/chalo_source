package defpackage;

import com.google.android.gms.maps.model.LatLngBounds;
import defpackage.e44;

/* renamed from: dh1  reason: default package */
/* compiled from: MapUtils */
public class dh1 implements e44.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e44 f836a;
    public final /* synthetic */ LatLngBounds b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ e44.a e;

    public dh1(e44 e44, LatLngBounds latLngBounds, int i, int i2, e44.a aVar) {
        this.f836a = e44;
        this.b = latLngBounds;
        this.c = i;
        this.d = i2;
        this.e = aVar;
    }

    @Override // defpackage.e44.g
    public void a() {
        this.f836a.c(hd3.j2(this.b, this.c), this.d, this.e);
    }
}
