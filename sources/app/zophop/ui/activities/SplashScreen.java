package app.zophop.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import app.zophop.R;
import defpackage.xt;

/* compiled from: SplashScreen.kt */
public final class SplashScreen extends f0 {
    public static boolean f;

    /* compiled from: SplashScreen.kt */
    public static final class a {
        public static final void a(String str) {
            long j;
            ed1 ed1;
            if (!SplashScreen.f) {
                zz zzVar = new zz("app open", null, 2);
                ed1 ed12 = new ed1("app open", Long.MIN_VALUE);
                if (str != null) {
                    ed12.a("src", str);
                    zzVar.a("source", str);
                }
                ui1.m0(ed12);
                ui1.l0(zzVar);
                SplashScreen.f = true;
                xt.t1 t1Var = xt.f3961a;
                if (t1Var.l().h.has("appSessionCount")) {
                    String optString = t1Var.l().h.optString("appSessionCount", null);
                    n86.c(optString);
                    n86.d(optString, "getPropertiesMap()[Zopho…tion.APP_SESSION_COUNT]!!");
                    j = Long.parseLong(optString);
                } else {
                    j = 0;
                }
                long j2 = j + 1;
                t1Var.l().put("appSessionCount", String.valueOf(j2));
                t1Var.e().d(j2);
                if (t1Var.j().b()) {
                    ed1 = new ed1("chaloTime available", Long.MIN_VALUE);
                    ed1.a("difference", Long.valueOf(t1Var.j().c() - System.currentTimeMillis()));
                } else {
                    ed1 = new ed1("chaloTime not available", Long.MIN_VALUE);
                }
                ui1.m0(ed1);
                String valueOf = String.valueOf(764);
                String optString2 = t1Var.l().h.optString("keyCachedAppVersionCode", null);
                t1Var.l().put("keyCachedAppVersionCode", valueOf);
                if (optString2 == null || optString2.length() == 0) {
                    hj1.P0("chalo app updated or installed", Long.MIN_VALUE, "current app version", valueOf);
                }
                if (!ea6.f(valueOf, optString2, true)) {
                    ed1 l = hj1.l("chalo app updated", Long.MIN_VALUE, "previous app version", optString2);
                    l.a("current app version", valueOf);
                    ui1.m0(l);
                }
            }
        }
    }

    @Override // defpackage.f0
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context == null ? null : j26.c.a(context));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.splash_screen, (ViewGroup) null, false);
        if (((FragmentContainerView) inflate.findViewById(R.id.nav_host_fragment)) != null) {
            setContentView((ConstraintLayout) inflate);
            return;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.nav_host_fragment)));
    }

    @Override // defpackage.ve
    public void onResume() {
        for (hd1 hd1 : xt.f3961a.a().b) {
            hd1.d("usageCount", 1.0d);
        }
        super.onResume();
    }
}
