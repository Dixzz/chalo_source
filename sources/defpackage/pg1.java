package defpackage;

import android.content.DialogInterface;
import defpackage.qg1;
import java.util.Objects;

/* renamed from: pg1  reason: default package */
/* compiled from: LocationPromptDialogFragment */
public class pg1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ qg1 f;

    public pg1(qg1 qg1) {
        this.f = qg1;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        qg1 qg1 = this.f;
        qg1.a.EnumC0048a aVar = qg1.a.EnumC0048a.NEGATIVE;
        Objects.requireNonNull(qg1);
        jz5.b().g(new qg1.a(aVar));
    }
}
