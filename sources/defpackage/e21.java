package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import app.zophop.ui.fragments.superPassValidation.SoundInfoRationaleFragmentSuperPass;

/* renamed from: e21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class e21 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context f;
    public final /* synthetic */ SoundInfoRationaleFragmentSuperPass g;

    public /* synthetic */ e21(Context context, SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass) {
        this.f = context;
        this.g = soundInfoRationaleFragmentSuperPass;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context = this.f;
        SoundInfoRationaleFragmentSuperPass soundInfoRationaleFragmentSuperPass = this.g;
        SoundInfoRationaleFragmentSuperPass.a aVar = SoundInfoRationaleFragmentSuperPass.j;
        n86.e(context, "$it");
        n86.e(soundInfoRationaleFragmentSuperPass, "this$0");
        n86.e("sound permission through settings selected", "lName");
        n86.e("sound info rationale fragment super pass", "lSource");
        ed1 ed1 = new ed1("sound permission through settings selected", Long.MIN_VALUE);
        ed1.a("source", "sound info rationale fragment super pass");
        ui1.m0(ed1);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        soundInfoRationaleFragmentSuperPass.h.a(intent, null);
    }
}
