package defpackage;

import android.os.Bundle;
import app.zophop.R;
import java.util.HashMap;

/* renamed from: k41  reason: default package */
/* compiled from: SoundInfoRationaleFragmentSuperPassDirections */
public class k41 implements fj {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2017a = new HashMap();

    public k41() {
    }

    @Override // defpackage.fj
    public int a() {
        return R.id.action_soundInfoRationaleFragmentSuperPass_to_soundFragmentSuperPass;
    }

    public boolean b() {
        return ((Boolean) this.f2017a.get("arg_can_show_sound_info")).booleanValue();
    }

    public String c() {
        return (String) this.f2017a.get("arg_source");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k41.class != obj.getClass()) {
            return false;
        }
        k41 k41 = (k41) obj;
        if (this.f2017a.containsKey("arg_source") != k41.f2017a.containsKey("arg_source")) {
            return false;
        }
        if (c() == null ? k41.c() == null : c().equals(k41.c())) {
            return this.f2017a.containsKey("arg_can_show_sound_info") == k41.f2017a.containsKey("arg_can_show_sound_info") && b() == k41.b();
        }
        return false;
    }

    @Override // defpackage.fj
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f2017a.containsKey("arg_source")) {
            bundle.putString("arg_source", (String) this.f2017a.get("arg_source"));
        } else {
            bundle.putString("arg_source", "\"\"");
        }
        if (this.f2017a.containsKey("arg_can_show_sound_info")) {
            bundle.putBoolean("arg_can_show_sound_info", ((Boolean) this.f2017a.get("arg_can_show_sound_info")).booleanValue());
        } else {
            bundle.putBoolean("arg_can_show_sound_info", true);
        }
        return bundle;
    }

    public int hashCode() {
        return (((b() ? 1 : 0) + (((c() != null ? c().hashCode() : 0) + 31) * 31)) * 31) + R.id.action_soundInfoRationaleFragmentSuperPass_to_soundFragmentSuperPass;
    }

    public String toString() {
        StringBuilder j0 = hj1.j0("ActionSoundInfoRationaleFragmentSuperPassToSoundFragmentSuperPass(actionId=", R.id.action_soundInfoRationaleFragmentSuperPass_to_soundFragmentSuperPass, "){argSource=");
        j0.append(c());
        j0.append(", argCanShowSoundInfo=");
        j0.append(b());
        j0.append("}");
        return j0.toString();
    }

    public k41(j41 j41) {
    }
}
