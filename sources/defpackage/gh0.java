package defpackage;

import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.UniversalPickerActivity;

/* renamed from: gh0  reason: default package */
/* compiled from: UniversalPickerActivity */
public class gh0 implements ci1<Favourite> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniversalPickerActivity f1260a;

    public gh0(UniversalPickerActivity universalPickerActivity) {
        this.f1260a = universalPickerActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ci1
    public void a(Favourite favourite) {
        BusFavourite busFavourite = (BusFavourite) favourite;
        UniversalPickerActivity.k0(busFavourite.getAgency(), busFavourite.getRouteName(), busFavourite.getStartStopName(), null, vn.K0(this.f1260a), true, false);
        RouteDetailsActivity.w0(this.f1260a, busFavourite.getRouteId(), null, null, TransitMode.bus, "favoriteScreen");
    }
}
