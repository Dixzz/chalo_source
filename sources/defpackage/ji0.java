package defpackage;

import android.view.View;
import defpackage.wi0;

/* renamed from: ji0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ji0 implements View.OnClickListener {
    public final /* synthetic */ wi0.d f;
    public final /* synthetic */ wi0 g;

    public /* synthetic */ ji0(wi0.d dVar, wi0 wi0) {
        this.f = dVar;
        this.g = wi0;
    }

    public final void onClick(View view) {
        wi0.d dVar = this.f;
        wi0 wi0 = this.g;
        n86.e(dVar, "this$0");
        n86.e(wi0, "this$1");
        if (dVar.getBindingAdapterPosition() != -1) {
            wi0.f.a(Integer.valueOf(dVar.getBindingAdapterPosition()));
        }
    }
}
