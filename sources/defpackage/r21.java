package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: r21  reason: default package */
/* compiled from: ActivateSuperPassFragmentDirections */
public class r21 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3027a = new HashMap();

    public r21() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_activateSuperPassFragment_to_activeSuperPassFragment;
    }

    public String b() {
        return (String) this.f3027a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r21.class != obj.getClass()) {
            return false;
        }
        r21 r21 = (r21) obj;
        if (this.f3027a.containsKey("arg_source") != r21.f3027a.containsKey("arg_source")) {
            return false;
        }
        return b() == null ? r21.b() == null : b().equals(r21.b());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f3027a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f3027a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        return bundle;
    }

    public int hashCode() {
        return hj1.b(b() != null ? b().hashCode() : 0, 31, 31, R.id.action_activateSuperPassFragment_to_activeSuperPassFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionActivateSuperPassFragmentToActiveSuperPassFragment(actionId=", R.id.action_activateSuperPassFragment_to_activeSuperPassFragment, "){argSource=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public r21(q21 q21) {
    }
}
