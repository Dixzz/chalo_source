package defpackage;

import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.SchedulerInputEvent;
import app.zophop.ui.activities.RouteDetailsActivity;
import app.zophop.ui.fragments.SchedulerInputFormFragment;
import com.google.firebase.messaging.Constants;
import java.util.Objects;

/* renamed from: cw0  reason: default package */
/* compiled from: SchedulerInputFormFragment */
public class cw0 implements ci1<Favourite> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f761a;
    public final /* synthetic */ SchedulerInputFormFragment b;

    public cw0(SchedulerInputFormFragment schedulerInputFormFragment, String str) {
        this.b = schedulerInputFormFragment;
        this.f761a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ci1
    public void a(Favourite favourite) {
        Favourite favourite2 = favourite;
        SchedulerInputFormFragment schedulerInputFormFragment = this.b;
        int i = SchedulerInputFormFragment.v;
        Objects.requireNonNull(schedulerInputFormFragment);
        ed1 ed1 = new ed1("favorite clicked", Long.MAX_VALUE);
        ed1.a("mode", favourite2.getMode().name());
        ed1.a("source", "schedueler screen");
        boolean z = favourite2 instanceof RailFavourite;
        if (z) {
            RailFavourite railFavourite = (RailFavourite) favourite2;
            ed1.a(Constants.MessagePayloadKeys.FROM, railFavourite.getFromStop().getName());
            ed1.a("to", railFavourite.getToStop().getName());
        } else {
            BusFavourite busFavourite = (BusFavourite) favourite2;
            ed1.a("route", busFavourite.getRouteName());
            ed1.a(Constants.MessagePayloadKeys.FROM, busFavourite.getStartStopName());
            ed1.a("to", busFavourite.getEndStopName());
        }
        jz5.b().g(ed1);
        ((c80) this.b.o).n(favourite2);
        if (z) {
            RailFavourite railFavourite2 = (RailFavourite) favourite2;
            this.b.i = railFavourite2.getFromStop();
            this.b.j = railFavourite2.getToStop();
            SchedulerInputFormFragment schedulerInputFormFragment2 = this.b;
            schedulerInputFormFragment2.f.setText(vn.g(schedulerInputFormFragment2.i.getName()));
            SchedulerInputFormFragment schedulerInputFormFragment3 = this.b;
            schedulerInputFormFragment3.g.setText(vn.g(schedulerInputFormFragment3.j.getName()));
            jz5 b2 = jz5.b();
            TransitMode mode = favourite2.getMode();
            SchedulerInputFormFragment schedulerInputFormFragment4 = this.b;
            b2.i(new SchedulerInputEvent(mode, schedulerInputFormFragment4.i, schedulerInputFormFragment4.j));
            SchedulerInputFormFragment schedulerInputFormFragment5 = this.b;
            Objects.requireNonNull(schedulerInputFormFragment5);
            new nn0().show(schedulerInputFormFragment5.getFragmentManager(), "timePicker");
            return;
        }
        BusFavourite busFavourite2 = (BusFavourite) favourite2;
        RouteDetailsActivity.w0(this.b.getActivity(), busFavourite2.getRouteId(), null, null, TransitMode.bus, this.f761a);
        this.b.l(busFavourite2.getStartStopName(), busFavourite2.getEndStopName(), busFavourite2.getRouteId(), vn.K0(this.b.getActivity().getApplicationContext()));
    }
}
