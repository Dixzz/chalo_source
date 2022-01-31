package defpackage;

import com.google.android.gms.maps.model.LatLng;
import defpackage.yj1;

/* renamed from: pe1  reason: default package */
/* compiled from: LocationsProvider */
public class pe1 implements yj1.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LatLng f2795a;
    public final /* synthetic */ String b;
    public final /* synthetic */ le1 c;

    public pe1(le1 le1, LatLng latLng, String str) {
        this.c = le1;
        this.f2795a = latLng;
        this.b = str;
    }

    @Override // defpackage.yj1.a
    public void a(dk1 dk1) {
        this.c.k(null, this.f2795a, ad1.FAILED, false, this.b);
    }
}
