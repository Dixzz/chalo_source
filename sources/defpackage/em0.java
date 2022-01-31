package defpackage;

import android.view.View;
import defpackage.on0;

/* renamed from: em0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class em0 implements View.OnClickListener {
    public final /* synthetic */ on0 f;

    public /* synthetic */ em0(on0 on0) {
        this.f = on0;
    }

    public final void onClick(View view) {
        on0.a aVar;
        on0 on0 = this.f;
        on0 on02 = on0.g;
        n86.e(on0, "this$0");
        on0.dismiss();
        if (on0.c() != null && (aVar = on0.f) != null) {
            aVar.b();
        }
    }
}
