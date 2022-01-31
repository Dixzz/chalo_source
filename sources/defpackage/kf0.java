package defpackage;

import app.zophop.ui.activities.RouteDetailsActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

/* renamed from: kf0  reason: default package */
/* compiled from: RouteDetailsActivity */
public class kf0 implements ChildEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RouteDetailsActivity f2050a;

    public kf0(RouteDetailsActivity routeDetailsActivity) {
        this.f2050a = routeDetailsActivity;
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onCancelled(DatabaseError databaseError) {
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onChildAdded(DataSnapshot dataSnapshot, String str) {
        if (dataSnapshot != null && dataSnapshot.getKey() != null) {
            this.f2050a.U.put(dataSnapshot.getKey(), dataSnapshot);
            RouteDetailsActivity.k0(this.f2050a);
        }
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onChildChanged(DataSnapshot dataSnapshot, String str) {
        if (dataSnapshot != null && dataSnapshot.getKey() != null) {
            this.f2050a.U.put(dataSnapshot.getKey(), dataSnapshot);
            RouteDetailsActivity.k0(this.f2050a);
        }
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onChildMoved(DataSnapshot dataSnapshot, String str) {
    }

    @Override // com.google.firebase.database.ChildEventListener
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        if (dataSnapshot != null && dataSnapshot.getKey() != null && this.f2050a.U.containsKey(dataSnapshot.getKey())) {
            this.f2050a.U.remove(dataSnapshot.getKey());
            RouteDetailsActivity.k0(this.f2050a);
        }
    }
}
