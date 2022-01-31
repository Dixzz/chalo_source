package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import defpackage.ar;
import java.util.HashMap;
import java.util.WeakHashMap;

public class SystemAlarmService extends ih implements ar.c {
    public static final String i = tp.e("SystemAlarmService");
    public ar g;
    public boolean h;

    public final void a() {
        ar arVar = new ar(this);
        this.g = arVar;
        if (arVar.o != null) {
            tp.c().b(ar.p, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            arVar.o = this;
        }
    }

    public void b() {
        this.h = true;
        tp.c().a(i, "All commands completed in dispatcher", new Throwable[0]);
        String str = it.f1571a;
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = it.b;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                tp.c().f(it.f1571a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
        stopSelf();
    }

    @Override // defpackage.ih
    public void onCreate() {
        super.onCreate();
        a();
        this.h = false;
    }

    @Override // defpackage.ih
    public void onDestroy() {
        super.onDestroy();
        this.h = true;
        this.g.c();
    }

    @Override // defpackage.ih
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.h) {
            tp.c().d(i, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.g.c();
            a();
            this.h = false;
        }
        if (intent == null) {
            return 3;
        }
        this.g.a(intent, i3);
        return 3;
    }
}
