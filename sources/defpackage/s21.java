package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: s21  reason: default package */
/* compiled from: ActivateSuperPassFragmentDirections */
public class s21 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3170a = new HashMap();

    public s21() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_activateSuperPassFragment_to_activeSuperPassVisualValidationFragment;
    }

    public String b() {
        return (String) this.f3170a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s21.class != obj.getClass()) {
            return false;
        }
        s21 s21 = (s21) obj;
        if (this.f3170a.containsKey("arg_source") != s21.f3170a.containsKey("arg_source")) {
            return false;
        }
        return b() == null ? s21.b() == null : b().equals(s21.b());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f3170a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f3170a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        return bundle;
    }

    public int hashCode() {
        return hj1.b(b() != null ? b().hashCode() : 0, 31, 31, R.id.action_activateSuperPassFragment_to_activeSuperPassVisualValidationFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionActivateSuperPassFragmentToActiveSuperPassVisualValidationFragment(actionId=", R.id.action_activateSuperPassFragment_to_activeSuperPassVisualValidationFragment, "){argSource=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public s21(q21 q21) {
    }
}
