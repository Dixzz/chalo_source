package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;

/* renamed from: rq4  reason: default package */
public final class rq4 implements oq4 {

    /* renamed from: a  reason: collision with root package name */
    public final cr4 f3119a;
    public final qq4 b;
    public final Context c;

    public rq4(cr4 cr4, qq4 qq4, Context context) {
        new Handler(Looper.getMainLooper());
        this.f3119a = cr4;
        this.b = qq4;
        this.c = context;
    }

    @Override // defpackage.oq4
    public final ey4<Void> a() {
        cr4 cr4 = this.f3119a;
        String packageName = this.c.getPackageName();
        if (cr4.f747a == null) {
            return cr4.b();
        }
        cr4.e.b(4, "completeUpdate(%s)", new Object[]{packageName});
        ay4 ay4 = new ay4();
        cr4.f747a.a(new yq4(cr4, ay4, ay4, packageName));
        return ay4.f348a;
    }

    @Override // defpackage.oq4
    public final ey4<nq4> b() {
        cr4 cr4 = this.f3119a;
        String packageName = this.c.getPackageName();
        if (cr4.f747a == null) {
            return cr4.b();
        }
        cr4.e.b(4, "requestUpdateInfo(%s)", new Object[]{packageName});
        ay4 ay4 = new ay4();
        cr4.f747a.a(new xq4(cr4, ay4, packageName, ay4));
        return ay4.f348a;
    }

    @Override // defpackage.oq4
    public final synchronized void c(fv4 fv4) {
        qq4 qq4 = this.b;
        synchronized (qq4) {
            qq4.f1313a.b(4, "registerListener", new Object[0]);
            hd3.c0(fv4, "Registered Play Core listener should not be null.");
            qq4.d.add(fv4);
            qq4.b();
        }
    }

    @Override // defpackage.oq4
    public final boolean d(nq4 nq4, int i, Activity activity, int i2) throws IntentSender.SendIntentException {
        pq4 c2 = pq4.c(i);
        if (!(nq4.j(c2) != null)) {
            return false;
        }
        activity.startIntentSenderForResult(nq4.j(c2).getIntentSender(), i2, null, 0, 0, 0, null);
        return true;
    }

    @Override // defpackage.oq4
    public final synchronized void e(fv4 fv4) {
        qq4 qq4 = this.b;
        synchronized (qq4) {
            qq4.f1313a.b(4, "unregisterListener", new Object[0]);
            hd3.c0(fv4, "Unregistered Play Core listener should not be null.");
            qq4.d.remove(fv4);
            qq4.b();
        }
    }
}
