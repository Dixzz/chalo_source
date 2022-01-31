package defpackage;

import android.view.View;

/* renamed from: mc1  reason: default package */
/* compiled from: EtaListCard */
public class mc1 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ oc1 g;

    public mc1(oc1 oc1, String str) {
        this.g = oc1;
        this.f = str;
    }

    public void onClick(View view) {
        oc1.a(this.g, this.f, false, false);
    }
}
