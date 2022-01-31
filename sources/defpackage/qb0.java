package defpackage;

import android.view.View;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.activities.ActivatePassScreen;

/* renamed from: qb0  reason: default package */
/* compiled from: ActivatePassScreen */
public class qb0 implements View.OnClickListener {
    public final /* synthetic */ ActivatePassScreen f;

    /* renamed from: qb0$a */
    /* compiled from: ActivatePassScreen */
    public class a implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public a(qb0 qb0, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public qb0(ActivatePassScreen activatePassScreen) {
        this.f = activatePassScreen;
    }

    public void onClick(View view) {
        if (!vn.L0(this.f)) {
            lm0 a2 = lm0.a(this.f.getFragmentManager(), this.f.getString(R.string.dialog_ride_internet_header), this.f.getString(R.string.dialog_ride_internet_desc), this.f.getResources().getString(R.string.ok), null);
            a aVar = new a(this, a2);
            TextView textView = a2.i;
            if (textView != null) {
                textView.setOnClickListener(aVar);
            } else {
                a2.q = aVar;
            }
        }
    }
}
