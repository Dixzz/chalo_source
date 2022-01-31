package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.AutoCabInfo;
import app.zophop.ui.views.SummaryView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.appindexing.Indexable;
import defpackage.ii1;

/* renamed from: oa1  reason: default package */
/* compiled from: CabSummaryRenderer */
public class oa1 implements SummaryView.a {

    /* renamed from: a  reason: collision with root package name */
    public final String f2669a;
    public final String b;
    public final AutoCabInfo c;
    public final Context d;
    public mf1 e;
    public mf1 f;
    public final String g;
    public final boolean h;

    /* renamed from: oa1$a */
    /* compiled from: CabSummaryRenderer */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|13|14|15) */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x008a, code lost:
            r7 = r7.d;
            r7.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("https://play.google.com/store/apps/details?id=" + "com.olacabs.customer")));
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0078 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r7) {
            /*
            // Method dump skipped, instructions count: 302
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.oa1.a.onClick(android.view.View):void");
        }
    }

    public oa1(Context context, String str, AutoCabInfo autoCabInfo, String str2, boolean z) {
        this.d = context;
        this.b = str;
        this.c = autoCabInfo;
        this.f2669a = str2;
        this.g = hj1.S(str2, " cab result clicked");
        this.h = z;
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void a(TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ii1.a aVar, int i) {
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void b() {
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void c(FlexboxLayout flexboxLayout) {
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void d(TextView textView) {
        textView.setVisibility(8);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void e(TextView textView) {
        ui1.H0(textView, ii1.d((long) (this.c.getEta() * 60 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), this.d), this.d, 2);
        textView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.addRule(15);
        textView.setLayoutParams(layoutParams);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void f(TextView textView) {
        textView.setVisibility(8);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public View.OnClickListener g() {
        return new a();
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void h(TextView textView, ii1.a aVar, int i) {
        if (this.h) {
            textView.setLineSpacing(0.0f, 1.0f);
            textView.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(ui1.u(this.b)), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(this.d.getResources().getDimensionPixelSize(R.dimen.cab_summary_drawable_padding));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.c.getName());
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableStringBuilder.length(), 17);
            textView.setText(spannableStringBuilder);
        } else {
            textView.setText(this.c.getName());
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.addRule(15);
        textView.setLayoutParams(layoutParams);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void i(TextView textView, View view) {
        textView.setVisibility(0);
        Resources resources = this.d.getResources();
        view.setPadding(resources.getDimensionPixelSize(R.dimen.cab_trip_results_left_padding), resources.getDimensionPixelSize(R.dimen.cab_trip_results_top_padding), resources.getDimensionPixelSize(R.dimen.cab_trip_results_right_padding), resources.getDimensionPixelSize(R.dimen.cab_trip_results_bottom_padding));
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void j(TextView textView) {
        textView.setVisibility(8);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void k(TextView textView) {
        String str = this.c.getLowerFareAmount() + " - " + ui1.H() + this.c.getUpperFareAmount();
        if (this.c.getLowerFareAmount() == this.c.getUpperFareAmount()) {
            str = String.valueOf(this.c.getLowerFareAmount());
        }
        textView.setText(ui1.H() + str);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void l(LinearLayout linearLayout) {
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void m(TextView textView) {
        textView.setText(jh1.k((long) (this.c.getMinJourneyTime() * 60 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void n(TextView textView) {
        textView.setVisibility(8);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public boolean o() {
        return true;
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void p(TextView textView) {
        textView.setVisibility(8);
    }

    public final Uri q() {
        mf1 mf1 = this.e;
        LatLng latLng = mf1 != null ? mf1.f2368a : null;
        StringBuilder sb = new StringBuilder("jungooautos://app?");
        if (latLng != null) {
            sb.append("pickup_lat=");
            sb.append(latLng.latitude);
            sb.append("&pickup_lng=");
            sb.append(latLng.longitude);
        }
        Uri parse = Uri.parse(sb.toString());
        parse.toString();
        return parse;
    }
}
