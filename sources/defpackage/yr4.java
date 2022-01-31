package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: yr4  reason: default package */
public final class yr4 extends gx4<AssetPackState> {
    public final dt4 g;
    public final ps4 h;
    public final kw4<vu4> i;
    public final js4 j;
    public final ss4 k;
    public final kw4<Executor> l;
    public final kw4<Executor> m;
    public final Handler n = new Handler(Looper.getMainLooper());

    public yr4(Context context, dt4 dt4, ps4 ps4, kw4<vu4> kw4, ss4 ss4, js4 js4, kw4<Executor> kw42, kw4<Executor> kw43) {
        super(new nv4("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.g = dt4;
        this.h = ps4;
        this.i = kw4;
        this.k = ss4;
        this.j = js4;
        this.l = kw42;
        this.m = kw43;
    }

    @Override // defpackage.gx4
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f1313a.b(6, "Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            AssetPackState d = AssetPackState.d(bundleExtra, stringArrayList.get(0), this.k, as4.c);
            this.f1313a.b(3, "ListenerRegistryBroadcastReceiver.onReceive: %s", new Object[]{d});
            if (((PendingIntent) bundleExtra.getParcelable("confirmation_intent")) != null) {
                Objects.requireNonNull(this.j);
            }
            this.m.a().execute(new wr4(this, bundleExtra, d));
            this.l.a().execute(new xr4(this, bundleExtra));
            return;
        }
        this.f1313a.b(6, "Empty bundle received from broadcast.", new Object[0]);
    }
}
