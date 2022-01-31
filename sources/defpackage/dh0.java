package defpackage;

import app.zophop.ui.activities.TripsSchedulesDirectionActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/* renamed from: dh0  reason: default package */
/* compiled from: TripsSchedulesDirectionActivity */
public class dh0 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TripsSchedulesDirectionActivity f835a;

    public dh0(TripsSchedulesDirectionActivity tripsSchedulesDirectionActivity) {
        this.f835a = tripsSchedulesDirectionActivity;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        this.f835a.D = dataSnapshot;
    }
}
