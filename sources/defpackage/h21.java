package defpackage;

import android.content.Context;
import androidx.appcompat.app.AlertController;
import app.zophop.R;
import app.zophop.ui.fragments.superPassValidation.SoundInfoRationaleFragmentSuperPass;
import defpackage.e0;

/* renamed from: h21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class h21 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SoundInfoRationaleFragmentSuperPass f1332a;

    public /* synthetic */ h21(SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass) {
        this.f1332a = soundInfoRationaleFragmentSuperPass;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass = this.f1332a;
        Boolean bool = (Boolean) obj;
        SoundInfoRationaleFragmentSuperPass.a aVar = SoundInfoRationaleFragmentSuperPass.j;
        n86.e(soundInfoRationaleFragmentSuperPass, "this$0");
        n86.d(bool, "isGranted");
        if (bool.booleanValue()) {
            hj1.R0("sound permission granted", "lName", "sound info rationale fragment super pass", "lSource", "sound permission granted", Long.MIN_VALUE, "source", "sound info rationale fragment super pass");
            soundInfoRationaleFragmentSuperPass.f();
            return;
        }
        Context context = soundInfoRationaleFragmentSuperPass.getContext();
        if (context != null) {
            e0.a aVar2 = new e0.a(context);
            String string = soundInfoRationaleFragmentSuperPass.getString(R.string.sound_permission_prompt);
            AlertController.b bVar = aVar2.f908a;
            bVar.f = string;
            bVar.k = true;
            aVar2.c(soundInfoRationaleFragmentSuperPass.getString(R.string.settings), new e21(context, soundInfoRationaleFragmentSuperPass));
            j21 j21 = new j21(soundInfoRationaleFragmentSuperPass);
            AlertController.b bVar2 = aVar2.f908a;
            bVar2.i = "Cancel";
            bVar2.j = j21;
            e0 a2 = aVar2.a();
            n86.d(a2, "lBuilder.create()");
            a2.show();
        }
        hj1.R0("sound permission denied", "lName", "sound info rationale fragment super pass", "lSource", "sound permission denied", Long.MIN_VALUE, "source", "sound info rationale fragment super pass");
    }
}
