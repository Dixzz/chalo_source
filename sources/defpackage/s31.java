package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: s31  reason: default package */
/* compiled from: ActiveSuperPassVisualValidationFragmentDirections */
public class s31 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3178a = new HashMap();

    public s31() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_activeSuperPassVisualValidationFragment_to_activeSuperPassQrZoomedFragment;
    }

    public String b() {
        return (String) this.f3178a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s31.class != obj.getClass()) {
            return false;
        }
        s31 s31 = (s31) obj;
        if (this.f3178a.containsKey("arg_source") != s31.f3178a.containsKey("arg_source")) {
            return false;
        }
        return b() == null ? s31.b() == null : b().equals(s31.b());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f3178a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f3178a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        return bundle;
    }

    public int hashCode() {
        return hj1.b(b() != null ? b().hashCode() : 0, 31, 31, R.id.action_activeSuperPassVisualValidationFragment_to_activeSuperPassQrZoomedFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionActiveSuperPassVisualValidationFragmentToActiveSuperPassQrZoomedFragment(actionId=", R.id.action_activeSuperPassVisualValidationFragment_to_activeSuperPassQrZoomedFragment, "){argSource=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public s31(r31 r31) {
    }
}
