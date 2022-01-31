package defpackage;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/* renamed from: n30  reason: default package */
/* compiled from: NearbyStopTripRequestHandler */
public class n30 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m30 f2510a;

    public n30(m30 m30) {
        this.f2510a = m30;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
        this.f2510a.c();
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        this.f2510a.k = dataSnapshot;
    }
}
