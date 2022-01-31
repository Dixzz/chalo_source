package defpackage;

import android.view.View;

/* renamed from: fm4  reason: default package */
/* compiled from: MaterialDatePicker */
public class fm4 implements View.OnClickListener {
    public final /* synthetic */ em4 f;

    public fm4(em4 em4) {
        this.f = em4;
    }

    public void onClick(View view) {
        em4 em4 = this.f;
        em4.v.setEnabled(em4.k.F0());
        this.f.t.toggle();
        em4 em42 = this.f;
        em42.j(em42.t);
        this.f.h();
    }
}
