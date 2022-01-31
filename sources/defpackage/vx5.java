package defpackage;

import java.util.Set;

/* renamed from: vx5  reason: default package */
/* compiled from: RemoteData */
public class vx5 implements Runnable {
    public final /* synthetic */ Set f;
    public final /* synthetic */ wx5 g;

    public vx5(wx5 wx5, Set set) {
        this.g = wx5;
        this.f = set;
    }

    public void run() {
        this.g.o.b(this.f);
    }
}
