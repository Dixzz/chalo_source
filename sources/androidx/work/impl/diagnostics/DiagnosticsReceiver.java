package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import defpackage.vp;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f268a = tp.e("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            tp.c().a(f268a, "Requesting diagnostics", new Throwable[0]);
            try {
                pq a2 = pq.a(context);
                Objects.requireNonNull(a2);
                List singletonList = Collections.singletonList((vp) new vp.a(DiagnosticsWorker.class).a());
                if (!singletonList.isEmpty()) {
                    new kq(a2, null, op.KEEP, singletonList, null).a();
                    return;
                }
                throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
            } catch (IllegalStateException e) {
                tp.c().b(f268a, "WorkManager is not initialized", e);
            }
        }
    }
}
