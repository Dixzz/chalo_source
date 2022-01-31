package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.Gender;
import defpackage.mm0;

/* renamed from: dm0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class dm0 implements View.OnClickListener {
    public final /* synthetic */ mm0 f;
    public final /* synthetic */ Gender g;

    public /* synthetic */ dm0(mm0 mm0, Gender gender) {
        this.f = mm0;
        this.g = gender;
    }

    public final void onClick(View view) {
        mm0 mm0 = this.f;
        Gender gender = this.g;
        int i = mm0.l;
        n86.e(mm0, "this$0");
        n86.e(gender, "$iGender");
        mm0.a aVar = mm0.i;
        if (aVar != null) {
            aVar.a(gender);
        }
        mm0.dismiss();
    }
}
