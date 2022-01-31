package defpackage;

import android.view.View;
import android.widget.CheckBox;
import app.zophop.R;
import defpackage.gn0;
import defpackage.qm0;

/* renamed from: ob1  reason: default package */
/* compiled from: RatingTagView */
public class ob1 implements View.OnClickListener {
    public final /* synthetic */ pb1 f;

    public ob1(pb1 pb1) {
        this.f = pb1;
    }

    public void onClick(View view) {
        if (this.f.a()) {
            ((CheckBox) this.f.findViewById(R.id.tag)).setTextColor(this.f.f.getResources().getColor(R.color.white));
        } else {
            ((CheckBox) this.f.findViewById(R.id.tag)).setTextColor(this.f.f.getResources().getColor(R.color.black_87));
        }
        gn0.b bVar = this.f.i;
        if (bVar != null) {
            ((fn0) bVar).f1145a.a();
        }
        qm0.f fVar = this.f.j;
        if (fVar != null) {
            fVar.a();
        }
    }
}
