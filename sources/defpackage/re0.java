package defpackage;

import app.zophop.ui.activities.NearbyStopsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/* renamed from: re0  reason: default package */
/* compiled from: NearbyStopsActivity */
public class re0 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NearbyStopsActivity f3071a;

    public re0(NearbyStopsActivity nearbyStopsActivity) {
        this.f3071a = nearbyStopsActivity;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        this.f3071a.Q = dataSnapshot;
    }
}
