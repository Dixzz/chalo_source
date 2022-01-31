package defpackage;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.City;
import defpackage.wi0;

/* renamed from: ki0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ki0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ wi0.b f2062a;
    public final /* synthetic */ wi0 b;
    public final /* synthetic */ RecyclerView.a0 c;

    public /* synthetic */ ki0(wi0.b bVar, wi0 wi0, RecyclerView.a0 a0Var) {
        this.f2062a = bVar;
        this.b = wi0;
        this.c = a0Var;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        String str;
        wi0.b bVar = this.f2062a;
        wi0 wi0 = this.b;
        RecyclerView.a0 a0Var = this.c;
        String str2 = (String) obj;
        n86.e(wi0, "this$0");
        n86.e(a0Var, "$holder");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        City city = bVar.b;
        if (city == null) {
            str = null;
        } else {
            str = city.getDisplayName();
        }
        spannableStringBuilder.append((CharSequence) new SpannableString(vn.j(vn.g(str), str2, q5.b(wi0.c, R.color.view_schedule_color), false)));
        City city2 = bVar.b;
        boolean z = true;
        if (city2 == null || !city2.isBetaCity()) {
            z = false;
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) "  ");
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(wi0.c.getString(R.string.beta_caps));
            spannableStringBuilder2.setSpan(new SuperscriptSpan(), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(q5.b(wi0.c, R.color.chalo_primary)), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.setSpan(new RelativeSizeSpan(0.75f), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.setSpan(vn.N(wi0.c, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        ((wi0.d) a0Var).f3787a.c.setText(spannableStringBuilder);
    }
}
