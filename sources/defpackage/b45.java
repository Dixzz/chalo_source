package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;

/* renamed from: b45  reason: default package */
/* compiled from: InactivityTimer */
public final class b45 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f377a;
    public final BroadcastReceiver b;
    public boolean c = false;
    public Handler d;
    public Runnable e;
    public boolean f;

    /* renamed from: b45$b */
    /* compiled from: InactivityTimer */
    public final class b extends BroadcastReceiver {

        /* renamed from: b45$b$a */
        /* compiled from: InactivityTimer */
        public class a implements Runnable {
            public final /* synthetic */ boolean f;

            public a(boolean z) {
                this.f = z;
            }

            public void run() {
                b45 b45 = b45.this;
                b45.f = this.f;
                if (b45.c) {
                    b45.d.removeCallbacksAndMessages(null);
                    if (b45.f) {
                        b45.d.postDelayed(b45.e, DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL);
                    }
                }
            }
        }

        public b(a aVar) {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                b45.this.d.post(new a(intent.getIntExtra("plugged", -1) <= 0));
            }
        }
    }

    public b45(Context context, Runnable runnable) {
        this.f377a = context;
        this.e = runnable;
        this.b = new b(null);
        this.d = new Handler();
    }

    public void a() {
        this.d.removeCallbacksAndMessages(null);
        if (this.c) {
            this.f377a.unregisterReceiver(this.b);
            this.c = false;
        }
    }
}
