package defpackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.service.LocationTrackingService;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.appindexing.Indexable;
import com.razorpay.AnalyticsConstants;

/* renamed from: pa1  reason: default package */
/* compiled from: CheckInCard.kt */
public final class pa1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2788a;
    public final zx b;

    public pa1(Context context, zx zxVar, View.OnClickListener onClickListener) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(zxVar, "viewBinding");
        n86.e(onClickListener, "checkInEndButtonClickListener");
        this.f2788a = context;
        this.b = zxVar;
        tw twVar = zxVar.c;
        twVar.c.setBackgroundResource(R.drawable.drawer_item_selector);
        TextView textView = twVar.d;
        n86.d(textView, "desinationEta");
        textView.setVisibility(0);
        ImageView imageView = twVar.b;
        n86.d(imageView, "audioToggle");
        imageView.setVisibility(8);
        twVar.f.setText(context.getString(R.string.tap_to_edit));
        b();
        tw twVar2 = zxVar.f;
        TextView textView2 = twVar2.d;
        n86.d(textView2, "desinationEta");
        textView2.setVisibility(8);
        twVar2.f.setText(context.getString(R.string.next_stop));
        if (LocationTrackingService.q) {
            zxVar.f.b.setImageResource(R.drawable.audio_on);
        } else {
            zxVar.f.b.setImageResource(R.drawable.audio_mute);
        }
        zxVar.f.b.setOnClickListener(new ia1(this));
        if (xt.f3961a.f0().isConnected()) {
            zxVar.f.b.setVisibility(0);
        } else {
            zxVar.f.b.setVisibility(4);
        }
        String string = context.getString(R.string.you_checked_in);
        n86.d(string, "context.getString(R.string.you_checked_in)");
        zxVar.b.b.setText(string);
        zxVar.d.setOnClickListener(onClickListener);
        MaterialTextView materialTextView = zxVar.g;
        n86.d(materialTextView, "viewBinding.shareTrip");
        materialTextView.setVisibility(8);
    }

    public final void a(Stop stop, Integer num) {
        if (num != null && num.intValue() == 18000) {
            String string = this.f2788a.getString(R.string.you_are_not_moving);
            n86.d(string, "context.getString(R.string.you_are_not_moving)");
            this.b.b.b.setText(string);
        } else if (num != null && num.intValue() == -1) {
            String string2 = this.f2788a.getString(R.string.please_wait_eta_fetching);
            n86.d(string2, "context.getString(R.stri…please_wait_eta_fetching)");
            this.b.b.b.setText(string2);
        } else if (num != null) {
            if (n86.a("<1 min", jh1.k((long) (num.intValue() * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)))) {
                String string3 = this.f2788a.getString(R.string.get_ready_step_out);
                n86.d(string3, "context.getString(R.string.get_ready_step_out)");
                this.b.b.b.setText(string3);
            } else {
                String string4 = this.f2788a.getString(R.string.you_checked_in);
                n86.d(string4, "context.getString(R.string.you_checked_in)");
                this.b.b.b.setText(string4);
            }
        }
        c(num);
        d(stop);
        if (xt.f3961a.f0().isConnected()) {
            this.b.f.b.setVisibility(0);
        }
    }

    public final void b() {
        this.b.c.d.setCompoundDrawables(null, null, null, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f2788a.getString(R.string.fetching));
        spannableStringBuilder.setSpan(vn.N(this.f2788a, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(q5.b(this.f2788a, R.color.real_time_fetching_string_color)), 0, spannableStringBuilder.length(), 17);
        this.b.c.d.setText(spannableStringBuilder);
    }

    public final void c(Integer num) {
        if (num != null && num.intValue() == -1) {
            b();
        } else if (num != null) {
            ui1.H0(this.b.c.d, ii1.d((long) (num.intValue() * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), this.f2788a), this.f2788a, 2);
        }
    }

    public final void d(Stop stop) {
        if (stop != null) {
            this.b.f.e.setText(stop.getName());
        }
    }
}
