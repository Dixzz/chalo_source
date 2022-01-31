package defpackage;

import app.zophop.pubsub.eventbus.events.CheckedinEvent;
import app.zophop.service.LocationTrackingService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import server.zophop.models.StreamStatus;

/* renamed from: x80  reason: default package */
/* compiled from: LocationTrackingService */
public class x80 implements ValueEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationTrackingService f3900a;

    public x80(LocationTrackingService locationTrackingService) {
        this.f3900a = locationTrackingService;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onCancelled(DatabaseError databaseError) {
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void onDataChange(DataSnapshot dataSnapshot) {
        String str = (String) dataSnapshot.getValue();
        if (str != null && StreamStatus.valueOf(str).equals(StreamStatus.CLOSED)) {
            long b = LocationTrackingService.p.b();
            this.f3900a.f(CheckedinEvent.STOP_SOURCE.SERVER);
            this.f3900a.c("checkin closed", "server", "error", b);
        }
    }
}
