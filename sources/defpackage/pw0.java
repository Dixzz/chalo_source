package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: pw0  reason: default package */
/* compiled from: SplashScreenFragmentDirections */
public class pw0 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2862a = new HashMap();

    public pw0() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_splashScreenFragment_to_citySelectionFragment;
    }

    public boolean b() {
        return ((Boolean) this.f2862a.get("isFromSplash")).booleanValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pw0.class != obj.getClass()) {
            return false;
        }
        pw0 pw0 = (pw0) obj;
        return this.f2862a.containsKey("isFromSplash") == pw0.f2862a.containsKey("isFromSplash") && b() == pw0.b();
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f2862a.containsKey("isFromSplash")) {
            bundle.putBoolean("isFromSplash", ((Boolean) this.f2862a.get("isFromSplash")).booleanValue());
        } else {
            bundle.putBoolean("isFromSplash", false);
        }
        return bundle;
    }

    public int hashCode() {
        return (((b() ? 1 : 0) + 31) * 31) + R.id.action_splashScreenFragment_to_citySelectionFragment;
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionSplashScreenFragmentToCitySelectionFragment(actionId=", R.id.action_splashScreenFragment_to_citySelectionFragment, "){isFromSplash=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public pw0(ow0 ow0) {
    }
}
