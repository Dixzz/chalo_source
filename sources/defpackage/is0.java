package defpackage;

import android.content.Context;
import androidx.appcompat.app.AlertController;
import app.zophop.R;
import defpackage.e0;
import defpackage.nw0;

/* renamed from: is0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class is0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ nw0 f1566a;

    public /* synthetic */ is0(nw0 nw0) {
        this.f1566a = nw0;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        nw0 nw0 = this.f1566a;
        Boolean bool = (Boolean) obj;
        nw0.a aVar = nw0.j;
        n86.e(nw0, "this$0");
        n86.d(bool, "isGranted");
        if (bool.booleanValue()) {
            hj1.R0("sound permission granted", "lName", "sound info rationale fragment", "lSource", "sound permission granted", Long.MIN_VALUE, "source", "sound info rationale fragment");
            nw0.g();
            return;
        }
        Context context = nw0.getContext();
        if (context != null) {
            e0.a aVar2 = new e0.a(context);
            String string = nw0.getString(R.string.sound_permission_prompt);
            AlertController.b bVar = aVar2.f908a;
            bVar.f = string;
            bVar.k = true;
            aVar2.c(nw0.getString(R.string.settings), new hs0(context, nw0));
            ds0 ds0 = new ds0(nw0);
            AlertController.b bVar2 = aVar2.f908a;
            bVar2.i = "Cancel";
            bVar2.j = ds0;
            e0 a2 = aVar2.a();
            n86.d(a2, "lBuilder.create()");
            a2.show();
        }
        hj1.R0("sound permission denied", "lName", "sound info rationale fragment", "lSource", "sound permission denied", Long.MIN_VALUE, "source", "sound info rationale fragment");
    }
}
