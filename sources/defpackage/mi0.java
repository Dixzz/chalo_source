package defpackage;

import android.view.View;
import defpackage.sj0;

/* renamed from: mi0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class mi0 implements View.OnClickListener {
    public final /* synthetic */ sj0 f;
    public final /* synthetic */ sj0.a g;

    public /* synthetic */ mi0(sj0 sj0, sj0.a aVar) {
        this.f = sj0;
        this.g = aVar;
    }

    public final void onClick(View view) {
        sj0 sj0 = this.f;
        sj0.a aVar = this.g;
        n86.e(sj0, "this$0");
        n86.e(aVar, "this$1");
        sj0.b = view.getTag().toString();
        sj0.notifyItemChanged(sj0.c);
        int bindingAdapterPosition = aVar.getBindingAdapterPosition();
        sj0.c = bindingAdapterPosition;
        sj0.notifyItemChanged(bindingAdapterPosition);
        sj0.d.a(view);
    }
}
