package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import app.zophop.R;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* renamed from: f71  reason: default package */
/* compiled from: ViewUtilsKT.kt */
public final class f71 {

    /* renamed from: a  reason: collision with root package name */
    public static final f71 f1097a = new f71();
    public static final ca6 b = new ca6("[^\\d]");

    public static String b(f71 f71, String str, int i, int i2) {
        String str2;
        if ((i2 & 2) != 0) {
            i = 6;
        }
        n86.e(str, "lNumberString");
        int i3 = 0;
        if (str.length() == 0) {
            return str;
        }
        if (str.length() == 16) {
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i4 = i3 + 1;
                    if (i3 == 2 || i3 == 6 || i3 == 10) {
                        sb.append(' ');
                    }
                    if (i3 >= str.length() - i) {
                        sb.append(str.charAt(i3));
                    } else {
                        sb.append("*");
                    }
                    if (i4 > length) {
                        break;
                    }
                    i3 = i4;
                }
            }
            str2 = sb.toString();
            n86.d(str2, "StringBuilder().apply(builderAction).toString()");
        } else {
            StringBuilder sb2 = new StringBuilder();
            int length2 = str.length() - 1;
            if (length2 >= 0) {
                while (true) {
                    int i5 = i3 + 1;
                    if (i3 % 4 == 0 && i3 > 0) {
                        sb2.append(' ');
                    }
                    if (i3 >= str.length() - i) {
                        sb2.append(str.charAt(i3));
                    } else {
                        sb2.append("*");
                    }
                    if (i5 > length2) {
                        break;
                    }
                    i3 = i5;
                }
            }
            str2 = sb2.toString();
            n86.d(str2, "StringBuilder().apply(builderAction).toString()");
        }
        return str2;
    }

    public final void a(Context context, SpannableStringBuilder spannableStringBuilder, String str, boolean z, int i, int i2, int i3) {
        if (context != null) {
            if (z) {
                spannableStringBuilder.append(new SpannableString(" "));
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
    }

    public final String c(long j) {
        TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        String format = new SimpleDateFormat("dd MMM yyyy, hh:mm a").format(new Date(j));
        n86.d(format, "text");
        String x = ea6.x(ea6.x(format, "am", "AM", false, 4), "pm", "PM", false, 4);
        n86.d(x, "text");
        return x;
    }

    public final SpannableStringBuilder d(Context context, List<String> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (list == null || list.isEmpty()) {
            return spannableStringBuilder;
        }
        for (String str : list) {
            if (str != null && !ea6.f(str, "non-ac", true)) {
                if (ea6.f(str, "ac", true)) {
                    a(context, spannableStringBuilder, str, true, R.color.real_time_fetching_string_color, 0, R.color.white);
                    spannableStringBuilder.append(" ");
                } else {
                    a(context, spannableStringBuilder, str, true, R.color.spf, 0, R.color.black_87);
                    spannableStringBuilder.append(" ");
                }
            }
        }
        return spannableStringBuilder;
    }
}
