package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: e31  reason: default package */
/* compiled from: ActiveSuperPassFragmentDirections */
public class e31 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f918a = new HashMap();

    public e31() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_activeSuperPassFragment_to_activeSuperPassQrZoomedFragment;
    }

    public String b() {
        return (String) this.f918a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e31.class != obj.getClass()) {
            return false;
        }
        e31 e31 = (e31) obj;
        if (this.f918a.containsKey("arg_source") != e31.f918a.containsKey("arg_source")) {
            return false;
        }
        return b() == null ? e31.b() == null : b().equals(e31.b());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f918a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f918a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        return bundle;
    }

    public int hashCode() {
        return hj1.b(b() != null ? b().hashCode() : 0, 31, 31, R.id.action_activeSuperPassFragment_to_activeSuperPassQrZoomedFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionActiveSuperPassFragmentToActiveSuperPassQrZoomedFragment(actionId=", R.id.action_activeSuperPassFragment_to_activeSuperPassQrZoomedFragment, "){argSource=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public e31(d31 d31) {
    }
}
