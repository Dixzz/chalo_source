package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import app.zophop.R;
import app.zophop.ZophopApplication;
import app.zophop.service.LocationTrackingService;
import app.zophop.ui.activities.SplashScreen;
import java.util.List;

/* renamed from: au  reason: default package */
/* compiled from: GAActivity */
public abstract class au extends tf1 {
    public a j;

    /* renamed from: au$a */
    /* compiled from: GAActivity */
    public enum a {
        CREATED,
        STARTED,
        RESUMED,
        PAUSED,
        STOPPED,
        DESTROYED
    }

    @Override // defpackage.f0, defpackage.tf1
    public void attachBaseContext(Context context) {
        super.attachBaseContext(j26.c.a(context));
    }

    @Override // defpackage.tf1
    public void d0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        intentFilter.addAction("android.location.PROVIDER_CHANGED_ACTION");
        this.g = new fh1();
        he1 he1 = new he1();
        this.h = he1;
        registerReceiver(he1, intentFilter);
        registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.tf1
    public void g0() {
        if (!LocationTrackingService.l) {
            unregisterReceiver(this.g);
            unregisterReceiver(this.h);
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActionBar() != null) {
            getActionBar().setDisplayShowHomeEnabled(false);
        }
        if (!((ZophopApplication) getApplication()).f) {
            Intent intent = new Intent(this, SplashScreen.class);
            intent.putExtra("source", au.class.getName());
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        } else {
            ui1.g(getBaseContext(), xt.f3961a.z().b());
            overridePendingTransition(17432576, 17432577);
            e(bundle);
        }
        this.j = a.CREATED;
    }

    @Override // defpackage.f0, defpackage.ve
    public void onDestroy() {
        super.onDestroy();
        this.j = a.DESTROYED;
    }

    @Override // defpackage.ve, defpackage.tf1
    public void onPause() {
        super.onPause();
        this.j = a.PAUSED;
    }

    @Override // defpackage.ve, defpackage.tf1
    public void onResume() {
        super.onResume();
        this.j = a.RESUMED;
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStart() {
        super.onStart();
        List<Runnable> list = vy1.j;
        vy1 f = ac3.b(this).f();
        synchronized (f) {
            zy1 zy1 = new zy1(f.d, null);
            he3 he3 = (he3) new fe3(f.d).Z(R.xml.analytics);
            if (he3 != null) {
                zy1.o0(he3);
            }
            zy1.Z();
        }
        vy1 f2 = ac3.b(this).f();
        if (!f2.h) {
            f2.b(this);
        }
        xt.f3961a.P().b();
        this.j = a.STARTED;
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStop() {
        super.onStop();
        List<Runnable> list = vy1.j;
        vy1 f = ac3.b(this).f();
        if (!f.h) {
            f.c(this);
        }
        this.j = a.STOPPED;
    }
}
