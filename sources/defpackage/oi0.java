package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Favourites.TripFavourite;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.activities.SchedulerActivity;
import app.zophop.ui.activities.TripPlanningActivity;
import app.zophop.ui.activities.TripPlanningStopBasedActivity;
import defpackage.bk0;

/* renamed from: oi0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class oi0 implements View.OnClickListener {
    public final /* synthetic */ bk0.c f;
    public final /* synthetic */ bk0 g;

    public /* synthetic */ oi0(bk0.c cVar, bk0 bk0) {
        this.f = cVar;
        this.g = bk0;
    }

    public final void onClick(View view) {
        bk0.c cVar = this.f;
        bk0 bk0 = this.g;
        n86.e(cVar, "this$0");
        n86.e(bk0, "this$1");
        if (cVar.getBindingAdapterPosition() != -1) {
            int bindingAdapterPosition = cVar.getBindingAdapterPosition();
            ed1 ed1 = new ed1("home screen recent card clicked", Long.MIN_VALUE);
            ed1.a("card position", Integer.valueOf(bindingAdapterPosition));
            ui1.m0(ed1);
            T t = bk0.f2701a.f.get(cVar.getBindingAdapterPosition());
            if (t instanceof TripFavourite) {
                xt.f3961a.i0().b(t);
                Context context = bk0.c;
                if (context instanceof Activity) {
                    T t2 = t;
                    TripPlanningActivity.m0((Activity) context, t2.isFromMyLocation() ? null : t2.getFrom(), t2.getTo(), true);
                }
            } else if (t instanceof StopBasedTripFavourite) {
                xt.f3961a.i0().b(t);
                Context context2 = bk0.c;
                if (context2 instanceof Activity) {
                    T t3 = t;
                    TripPlanningStopBasedActivity.r0((Activity) context2, t3.getOriginStop(), t3.getDestinationStop(), "home screen recent search card");
                }
            } else if (t instanceof BusFavourite) {
                xt.f3961a.r().e(t);
                RouteDetailsActivity.w0(bk0.c, t.getRouteId(), null, null, TransitMode.bus, "home screen recent search card");
            } else if (t instanceof RailFavourite) {
                SchedulerActivity.j0(bk0.c, t, "home screen recent search card");
            }
        }
    }
}
