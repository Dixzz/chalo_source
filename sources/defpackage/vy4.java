package defpackage;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

/* renamed from: vy4  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class vy4 implements Runnable {
    public final /* synthetic */ Map.Entry f;
    public final /* synthetic */ Event g;

    public /* synthetic */ vy4(Map.Entry entry, Event event) {
        this.f = entry;
        this.g = event;
    }

    public final void run() {
        Map.Entry entry = this.f;
        ((EventHandler) entry.getKey()).handle(this.g);
    }
}
