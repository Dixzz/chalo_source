package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.utilities.R;
import java.util.List;

/* renamed from: rg1  reason: default package */
/* compiled from: LocationListItem */
public class rg1 extends LinearLayout {
    public rg1(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.location_list_item, (ViewGroup) this, true);
    }

    public void a(CharSequence charSequence, CharSequence charSequence2, int i) {
        c(charSequence, charSequence2, i, null, false, null, false);
    }

    public void b(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        c(charSequence, charSequence2, i, null, false, null, false);
        ImageView imageView = (ImageView) findViewById(R.id.settings_icon);
        if (i2 == 0) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        imageView.setImageResource(i2);
    }

    public void c(CharSequence charSequence, CharSequence charSequence2, int i, CharSequence charSequence3, boolean z, List<String> list, boolean z2) {
        TextView textView = (TextView) findViewById(R.id.title);
        TextView textView2 = (TextView) findViewById(R.id.subtext);
        ImageView imageView = (ImageView) findViewById(R.id.icon);
        TextView textView3 = (TextView) findViewById(R.id.agency_name);
        textView.setText(charSequence);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.padding_top_picker_item);
        getResources().getDimensionPixelSize(R.dimen.padding_bottom_picker_item);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i2 = 0;
        if (charSequence2 == null) {
            textView3.setVisibility(8);
            textView.setPadding(0, 0, 0, dimensionPixelSize);
            textView2.setVisibility(8);
        } else {
            textView.setPadding(0, 0, 0, 0);
            textView3.setVisibility(8);
            textView2.setPadding(0, 0, 0, dimensionPixelSize);
            textView2.setVisibility(0);
            textView2.setText(charSequence2);
        }
        if (z2) {
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            textView.setPadding(0, 0, 0, dimensionPixelSize);
        }
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(i);
        }
        if (z) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append(charSequence);
            spannableStringBuilder2.append((CharSequence) "   ");
            spannableStringBuilder2.setSpan(new ImageSpan(getContext(), R.drawable.ac_bg, 1), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
            textView.setText(spannableStringBuilder2);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        spannableStringBuilder.append(charSequence);
        while (list != null && i2 < list.size()) {
            Context context = getContext();
            String str = list.get(i2);
            int i3 = R.color.spf;
            int length = charSequence.length();
            spannableStringBuilder.append((CharSequence) new SpannableString("  "));
            SpannableString spannableString = new SpannableString(str);
            spannableStringBuilder.append((CharSequence) spannableString);
            int length2 = spannableStringBuilder.length() - spannableString.length();
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), length, length3, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), length2, length3, 33);
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.loader_thickness);
            if (str.contains("AC") || str.contains("FAST")) {
                spannableStringBuilder.setSpan(new sg1(context.getResources().getColor(R.color.real_time_fetching_string_color), context.getResources().getColor(R.color.white), dimensionPixelSize2, dimensionPixelSize2, -4, -10), length2, length3, 33);
            } else {
                spannableStringBuilder.setSpan(new sg1(context.getResources().getColor(i3), context.getResources().getColor(R.color.black_87), dimensionPixelSize2, dimensionPixelSize2, -4, -10), length2, length3, 33);
            }
            i2++;
        }
        textView.setText(spannableStringBuilder);
    }

    public ImageView getLeftSideIcon() {
        return (ImageView) findViewById(R.id.icon);
    }

    public ImageView getSettingsIconView() {
        return (ImageView) findViewById(R.id.settings_icon);
    }

    public TextView getTitleView() {
        return (TextView) findViewById(R.id.title);
    }
}
