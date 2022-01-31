package defpackage;

import android.view.View;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: rm0  reason: default package */
/* compiled from: NpsSurveyDialog */
public class rm0 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ TextView g;
    public final /* synthetic */ qm0 h;

    public rm0(qm0 qm0, int i, TextView textView) {
        this.h = qm0;
        this.f = i;
        this.g = textView;
    }

    public void onClick(View view) {
        qm0 qm0 = this.h;
        qm0.m = this.f;
        hj1.v0(qm0.g, R.color.chalo_primary, qm0.s);
        qm0.s.setAlpha(1.0f);
        qm0.s.setClickable(true);
        qm0 qm02 = this.h;
        qm02.w.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.w);
        qm02.x.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.x);
        qm02.y.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.y);
        qm02.z.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.z);
        qm02.A.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.A);
        qm02.B.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.B);
        qm02.C.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.C);
        qm02.D.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.D);
        qm02.E.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.E);
        qm02.F.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.F);
        qm02.G.setBackgroundResource(R.drawable.rectangular_button_grey);
        hj1.v0(qm02.g, R.color.black_87, qm02.G);
        this.g.setBackgroundResource(R.drawable.rectangular_button_orange);
        this.g.setTextColor(this.h.g.getResources().getColor(R.color.white));
        q30.g("NPS rating clicked", "NPS rating clicked score " + this.f);
    }
}
