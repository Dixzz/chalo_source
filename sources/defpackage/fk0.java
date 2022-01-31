package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.RouteInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import defpackage.k90;
import io.github.inflationx.calligraphy3.CalligraphyUtils;
import java.util.List;
import java.util.Objects;

/* renamed from: fk0  reason: default package */
/* compiled from: RoutePickerAdapter */
public class fk0 extends yf1<RouteInfo> {
    public final k90 j;
    public k90.a k;
    public final boolean l = xt.f3961a.c().K();
    public final boolean m;

    public fk0(Context context, k90 k90, boolean z) {
        super(context);
        this.m = z;
        this.j = k90;
    }

    public static View b(RouteInfo routeInfo, String str, Context context, boolean z, boolean z2) {
        int i = 0;
        View inflate = LayoutInflater.from(context).inflate(R.layout.free_ride_route, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.card_title_from);
        TextView textView2 = (TextView) inflate.findViewById(R.id.card_title);
        TextView textView3 = (TextView) inflate.findViewById(R.id.via_route);
        ((ImageView) inflate.findViewById(R.id.card_item_icon)).setImageResource(vn.P(routeInfo.getTransitMode()));
        inflate.findViewById(R.id.main_content_view).setPadding(0, 0, 0, 0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) new SpannableString(vn.j(routeInfo.getRouteName(), str, context.getResources().getColor(R.color.view_schedule_color), false)));
        boolean d0 = ui1.d0(routeInfo.getSpecialFeatures());
        List<String> list = routeInfo.get_updateSpecialFeaturesList();
        if (d0) {
            d71.b(context, spannableStringBuilder, "AC", true, R.color.real_time_fetching_string_color, routeInfo.getRouteName().length(), R.color.white);
        }
        if (ui1.Y()) {
            textView2.setVisibility(8);
            textView.setText(spannableStringBuilder);
            textView.setTextSize(18.0f);
            CalligraphyUtils.applyFontToTextView(context, textView, context.getString(R.string.font_medium));
        } else {
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    d71.b(context, spannableStringBuilder, list.get(i2), true, R.color.spf, routeInfo.getRouteName().length(), R.color.black_87);
                }
            }
            d71.a(context, spannableStringBuilder, routeInfo.getAgencyName().toUpperCase(), true, routeInfo.getRouteName().length());
            if (!routeInfo.isRoutePassEnabled() || !z2) {
                textView2.setText(routeInfo.getFirstStopName() + " - " + routeInfo.getLastStopName());
            } else {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(routeInfo.getFirstStopName() + " ");
                spannableStringBuilder2.append((CharSequence) ProductDiscountsObject.KEY_DELIMITER);
                Drawable drawable = context.getDrawable(R.drawable.direction_route);
                drawable.setBounds(0, 0, context.getResources().getDimensionPixelSize(R.dimen.route_bidirectional_icon_size), context.getResources().getDimensionPixelSize(R.dimen.route_bidirectional_icon_size));
                spannableStringBuilder2.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
                spannableStringBuilder2.append((CharSequence) (" " + routeInfo.getLastStopName()));
                textView2.setText(spannableStringBuilder2);
            }
            textView.setText(spannableStringBuilder);
            textView.setTextSize(18.0f);
            textView2.setTextSize(14.0f);
            CalligraphyUtils.applyFontToTextView(context, textView, context.getString(R.string.font_medium));
        }
        if (z) {
            View findViewById = inflate.findViewById(R.id.tag_container);
            if (!routeInfo.isFreeRide()) {
                i = 8;
            }
            findViewById.setVisibility(i);
        } else {
            inflate.findViewById(R.id.tag_container).setVisibility(8);
        }
        return inflate;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return b(this.g.get(i), this.i, this.f, this.l, this.m);
    }

    public void notifyDataSetChanged() {
        k90.a aVar;
        super.notifyDataSetChanged();
        if (getCount() == 0 && (aVar = this.k) != null) {
            ((de0) this.j).f825a.q0(aVar);
        } else if (getCount() != 0) {
            String str = this.i;
            if (str == null || str.length() == 0) {
                Objects.requireNonNull((de0) this.j);
            } else {
                Objects.requireNonNull((de0) this.j);
            }
        }
    }
}
