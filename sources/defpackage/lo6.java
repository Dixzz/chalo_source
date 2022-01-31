package defpackage;

import com.firebase.client.DataSnapshot;
import java.util.concurrent.Callable;
import server.zophop.cron.GeofireCron;

/* renamed from: lo6  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class lo6 implements Callable {
    public final /* synthetic */ GeofireCron f;
    public final /* synthetic */ DataSnapshot g;

    public /* synthetic */ lo6(GeofireCron geofireCron, DataSnapshot dataSnapshot) {
        this.f = geofireCron;
        this.g = dataSnapshot;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.f.a(this.g);
        return null;
    }
}
