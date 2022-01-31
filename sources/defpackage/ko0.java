package defpackage;

import android.view.View;
import app.zophop.products.PassSelectionActivity;

/* renamed from: ko0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ko0 implements View.OnClickListener {
    public final /* synthetic */ lt0 f;

    public /* synthetic */ ko0(lt0 lt0) {
        this.f = lt0;
    }

    public final void onClick(View view) {
        lt0 lt0 = this.f;
        int i = lt0.i;
        n86.e(lt0, "this$0");
        ve activity = lt0.c();
        if (activity != null) {
            ed1 ed1 = new ed1("Pass Selection BottomSheet proceed clicked", Long.MIN_VALUE);
            hj1.J0(ed1, "isSuperPass", Boolean.TRUE, ed1);
            ((PassSelectionActivity) activity).z0();
            lt0.dismiss();
        }
    }
}
