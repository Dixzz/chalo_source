package defpackage;

import app.zophop.features.GeoFenceService;
import app.zophop.models.http_response.SummaryResponse;
import defpackage.yj1;

/* renamed from: x10  reason: default package */
/* compiled from: GeoFenceService */
public class x10 implements yj1.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SummaryResponse f3869a;
    public final /* synthetic */ GeoFenceService b;

    public x10(GeoFenceService geoFenceService, SummaryResponse summaryResponse) {
        this.b = geoFenceService;
        this.f3869a = summaryResponse;
    }

    @Override // defpackage.yj1.a
    public void a(dk1 dk1) {
        GeoFenceService geoFenceService = this.b;
        String id = this.f3869a.getStop().getId();
        int i = GeoFenceService.p;
        geoFenceService.g(id, "crtsError");
    }
}
