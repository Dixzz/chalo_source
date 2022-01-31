package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: qw0  reason: default package */
/* compiled from: SplashScreenFragmentDirections */
public class qw0 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2997a = new HashMap();

    public qw0() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_splashScreenFragment_to_languageSelectSplashScreen;
    }

    public boolean b() {
        return ((Boolean) this.f2997a.get("isFromSplash")).booleanValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qw0.class != obj.getClass()) {
            return false;
        }
        qw0 qw0 = (qw0) obj;
        return this.f2997a.containsKey("isFromSplash") == qw0.f2997a.containsKey("isFromSplash") && b() == qw0.b();
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f2997a.containsKey("isFromSplash")) {
            bundle.putBoolean("isFromSplash", ((Boolean) this.f2997a.get("isFromSplash")).booleanValue());
        } else {
            bundle.putBoolean("isFromSplash", false);
        }
        return bundle;
    }

    public int hashCode() {
        return (((b() ? 1 : 0) + 31) * 31) + R.id.action_splashScreenFragment_to_languageSelectSplashScreen;
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionSplashScreenFragmentToLanguageSelectSplashScreen(actionId=", R.id.action_splashScreenFragment_to_languageSelectSplashScreen, "){isFromSplash=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public qw0(ow0 ow0) {
    }
}
