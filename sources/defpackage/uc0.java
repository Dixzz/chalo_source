package defpackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;

/* renamed from: uc0  reason: default package */
/* compiled from: BookingSummaryMagicPassActivity */
public class uc0 implements View.OnClickListener {
    public final /* synthetic */ BookingSummaryMagicPassActivity f;

    /* renamed from: uc0$a */
    /* compiled from: BookingSummaryMagicPassActivity */
    public class a implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public a(uc0 uc0, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public uc0(BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity) {
        this.f = bookingSummaryMagicPassActivity;
    }

    public void onClick(View view) {
        String verificationOfficeTimings = ui1.C().getVerificationOfficeTimings();
        if (TextUtils.isEmpty(verificationOfficeTimings)) {
            verificationOfficeTimings = this.f.getString(R.string.verification_submission_office_timings_copy);
        }
        lm0 a2 = lm0.a(this.f.getFragmentManager(), this.f.getString(R.string.verification_dialog_title), verificationOfficeTimings, this.f.getString(R.string.ok), null);
        a2.setCancelable(false);
        a aVar = new a(this, a2);
        TextView textView = a2.i;
        if (textView != null) {
            textView.setOnClickListener(aVar);
        } else {
            a2.q = aVar;
        }
    }
}
