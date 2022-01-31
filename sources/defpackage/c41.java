package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: c41  reason: default package */
/* compiled from: SoundFragmentSuperPassDirections */
public class c41 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f516a = new HashMap();

    public c41() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_soundFragmentSuperPass_to_activeSuperPassQrZoomedFragment;
    }

    public String b() {
        return (String) this.f516a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c41.class != obj.getClass()) {
            return false;
        }
        c41 c41 = (c41) obj;
        if (this.f516a.containsKey("arg_source") != c41.f516a.containsKey("arg_source")) {
            return false;
        }
        return b() == null ? c41.b() == null : b().equals(c41.b());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f516a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f516a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        return bundle;
    }

    public int hashCode() {
        return hj1.b(b() != null ? b().hashCode() : 0, 31, 31, R.id.action_soundFragmentSuperPass_to_activeSuperPassQrZoomedFragment);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionSoundFragmentSuperPassToActiveSuperPassQrZoomedFragment(actionId=", R.id.action_soundFragmentSuperPass_to_activeSuperPassQrZoomedFragment, "){argSource=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public c41(b41 b41) {
    }
}
