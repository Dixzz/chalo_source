package defpackage;

import android.widget.AbsListView;
import app.zophop.pubsub.eventbus.events.RouteListScrollEvent;

/* renamed from: st0  reason: default package */
/* compiled from: BusRouteFragment */
public class st0 implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public RouteListScrollEvent.TYPE f3252a;

    public st0(mt0 mt0) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        RouteListScrollEvent.TYPE type;
        if (i == 0) {
            type = RouteListScrollEvent.TYPE.TOP;
        } else if (i + i2 == i3 - 1) {
            type = RouteListScrollEvent.TYPE.BOTTOM;
        } else {
            type = RouteListScrollEvent.TYPE.INTERMEDIATE;
        }
        RouteListScrollEvent.TYPE type2 = this.f3252a;
        if (type2 == null || !type2.equals(type)) {
            this.f3252a = type;
            jz5.b().g(new RouteListScrollEvent(this.f3252a));
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
