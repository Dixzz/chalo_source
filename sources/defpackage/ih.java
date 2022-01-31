package defpackage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.zg;
import java.util.Objects;

/* renamed from: ih  reason: default package */
/* compiled from: LifecycleService */
public class ih extends Service implements fh {
    public final yh f = new yh(this);

    @Override // defpackage.fh
    public zg getLifecycle() {
        return this.f.f4045a;
    }

    public IBinder onBind(Intent intent) {
        yh yhVar = this.f;
        Objects.requireNonNull(yhVar);
        yhVar.a(zg.a.ON_START);
        return null;
    }

    public void onCreate() {
        yh yhVar = this.f;
        Objects.requireNonNull(yhVar);
        yhVar.a(zg.a.ON_CREATE);
        super.onCreate();
    }

    public void onDestroy() {
        yh yhVar = this.f;
        Objects.requireNonNull(yhVar);
        yhVar.a(zg.a.ON_STOP);
        yhVar.a(zg.a.ON_DESTROY);
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        yh yhVar = this.f;
        Objects.requireNonNull(yhVar);
        yhVar.a(zg.a.ON_START);
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
