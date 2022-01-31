package defpackage;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: w11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class w11 implements View.OnClickListener {
    public final /* synthetic */ SoundFragmentSuperPass f;
    public final /* synthetic */ hm0 g;

    public /* synthetic */ w11(SoundFragmentSuperPass soundFragmentSuperPass, hm0 hm0) {
        this.f = soundFragmentSuperPass;
        this.g = hm0;
    }

    public final void onClick(View view) {
        SoundFragmentSuperPass soundFragmentSuperPass = this.f;
        hm0 hm0 = this.g;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        n86.e(soundFragmentSuperPass, "this$0");
        n86.e("sound qr show barcode ok clicked", "lName");
        n86.e("sound fragment", "lSource");
        ed1 ed1 = new ed1("sound qr show barcode ok clicked", Long.MIN_VALUE);
        ed1.a("source", "sound fragment");
        ui1.m0(ed1);
        vh1 vh1 = vh1.f3649a;
        n86.f(soundFragmentSuperPass, "$this$findNavController");
        NavController d = NavHostFragment.d(soundFragmentSuperPass);
        n86.b(d, "NavHostFragment.findNavController(this)");
        c41 c41 = new c41(null);
        c41.f516a.put("arg_source", "sound fragment");
        n86.d(c41, "actionSoundFragmentSuper…                        )");
        vh1.a(d, c41);
        hm0.dismiss();
    }
}
