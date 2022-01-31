package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: sr  reason: default package */
/* compiled from: BroadcastReceiverConstraintTracker */
public abstract class sr<T> extends tr<T> {
    public static final String h = tp.e("BrdcstRcvrCnstrntTrckr");
    public final BroadcastReceiver g = new a();

    /* renamed from: sr$a */
    /* compiled from: BroadcastReceiverConstraintTracker */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                sr.this.g(context, intent);
            }
        }
    }

    public sr(Context context, pt ptVar) {
        super(context, ptVar);
    }

    @Override // defpackage.tr
    public void d() {
        tp.c().a(h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.registerReceiver(this.g, f());
    }

    @Override // defpackage.tr
    public void e() {
        tp.c().a(h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.unregisterReceiver(this.g);
    }

    public abstract IntentFilter f();

    public abstract void g(Context context, Intent intent);
}
