package defpackage;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.firebase.appindexing.Indexable;
import defpackage.e44;
import java.util.List;

/* renamed from: ch1  reason: default package */
/* compiled from: MapUtils */
public class ch1 implements e44.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f565a;
    public final /* synthetic */ e44 b;
    public final /* synthetic */ int c;

    public ch1(List list, e44 e44, int i) {
        this.f565a = list;
        this.b = e44;
        this.c = i;
    }

    @Override // defpackage.e44.g
    public void a() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : this.f565a) {
            builder.include(latLng);
        }
        this.b.c(hd3.j2(builder.build(), this.c), Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, null);
    }
}
