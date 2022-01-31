package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import app.zophop.R;

/* renamed from: d71  reason: default package */
/* compiled from: ViewUtils */
public class d71 {
    public static void a(Context context, SpannableStringBuilder spannableStringBuilder, String str, boolean z, int i) {
        if (!ui1.C0()) {
            if (z) {
                spannableStringBuilder.append(new SpannableString("  "));
            }
            SpannableString spannableString = new SpannableString(str);
            spannableStringBuilder.append((CharSequence) spannableString);
            int length = spannableStringBuilder.length() - spannableString.length();
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), i, length2, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), length, length2, 33);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.bus_agency_tag_padding);
            spannableStringBuilder.setSpan(new vb1(context.getResources().getColor(R.color.bus_agency_tag_background), context.getResources().getColor(R.color.black_60), dimensionPixelSize, dimensionPixelSize, -4, -10), length, length2, 33);
        }
    }

    public static void b(Context context, SpannableStringBuilder spannableStringBuilder, String str, boolean z, int i, int i2, int i3) {
        if (z) {
            spannableStringBuilder.append(new SpannableString("  "));
        }
        SpannableString spannableString = new SpannableString(str);
        spannableStringBuilder.append((CharSequence) spannableString);
        int length = spannableStringBuilder.length() - spannableString.length();
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), i2, length2, 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), length, length2, 33);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.bus_agency_tag_padding);
        spannableStringBuilder.setSpan(new vb1(context.getResources().getColor(i), context.getResources().getColor(i3), dimensionPixelSize, dimensionPixelSize, -4, -10), length, length2, 33);
    }

    public static int c(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? R.drawable.alert_icon_orange : R.drawable.bus_service_cancelled : R.drawable.bus_deviated : R.drawable.alert_icon_red : R.drawable.alert_icon_orange;
    }
}
