package defpackage;

import app.zophop.models.Route;
import app.zophop.ui.activities.RouteDetailsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/* renamed from: lf0  reason: default package */
/* compiled from: RouteDetailsActivity */
public class lf0 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RouteDetailsActivity f2207a;

    public lf0(RouteDetailsActivity routeDetailsActivity) {
        this.f2207a = routeDetailsActivity;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
        Route route = this.f2207a.o;
        if (route != null) {
            route.getRouteId();
            RouteDetailsActivity routeDetailsActivity = this.f2207a;
            if (routeDetailsActivity.S == null) {
                jf0 jf0 = new jf0(routeDetailsActivity);
                routeDetailsActivity.S = jf0;
                routeDetailsActivity.P.post(jf0);
            }
        }
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        RouteDetailsActivity routeDetailsActivity = this.f2207a;
        if (routeDetailsActivity.S == null) {
            jf0 jf0 = new jf0(routeDetailsActivity);
            routeDetailsActivity.S = jf0;
            routeDetailsActivity.P.post(jf0);
        }
    }
}
