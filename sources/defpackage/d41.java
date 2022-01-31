package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: d41  reason: default package */
/* compiled from: SoundFragmentSuperPassDirections */
public class d41 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f783a = new HashMap();

    public d41() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_soundFragmentSuperPass_to_soundInfoFragmentSuperPass;
    }

    public String b() {
        return (String) this.f783a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d41.class != obj.getClass()) {
            return false;
        }
        d41 d41 = (d41) obj;
        if (this.f783a.containsKey("arg_source") != d41.f783a.containsKey("arg_source")) {
            return false;
        }
        return b() == null ? d41.b() == null : b().equals(d41.b());
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f783a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f783a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        return bundle;
    }

    public int hashCode() {
        return hj1.b(b() != null ? b().hashCode() : 0, 31, 31, R.id.action_soundFragmentSuperPass_to_soundInfoFragmentSuperPass);
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionSoundFragmentSuperPassToSoundInfoFragmentSuperPass(actionId=", R.id.action_soundFragmentSuperPass_to_soundInfoFragmentSuperPass, "){argSource=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public d41(b41 b41) {
    }
}
