package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: cv0  reason: default package */
/* compiled from: LanguageSelectSplashScreenDirections */
public class cv0 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f755a = new HashMap();

    public cv0() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_languageSelectSplashScreen_to_citySelectionFragment;
    }

    public boolean b() {
        return ((Boolean) this.f755a.get("isFromSplash")).booleanValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || cv0.class != obj.getClass()) {
            return false;
        }
        cv0 cv0 = (cv0) obj;
        return this.f755a.containsKey("isFromSplash") == cv0.f755a.containsKey("isFromSplash") && b() == cv0.b();
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f755a.containsKey("isFromSplash")) {
            bundle.putBoolean("isFromSplash", ((Boolean) this.f755a.get("isFromSplash")).booleanValue());
        } else {
            bundle.putBoolean("isFromSplash", false);
        }
        return bundle;
    }

    public int hashCode() {
        return (((b() ? 1 : 0) + 31) * 31) + R.id.action_languageSelectSplashScreen_to_citySelectionFragment;
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionLanguageSelectSplashScreenToCitySelectionFragment(actionId=", R.id.action_languageSelectSplashScreen_to_citySelectionFragment, "){isFromSplash=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public cv0(bv0 bv0) {
    }
}
