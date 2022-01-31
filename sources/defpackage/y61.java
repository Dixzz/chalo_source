package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.TripSummary;
import app.zophop.ui.views.summary_card.CardItem;
import io.github.inflationx.calligraphy3.CalligraphyUtils;

/* renamed from: y61  reason: default package */
/* compiled from: TripSummaryCardGenerator */
public class y61 {
    public static CardItem.b a(TripSummary tripSummary, TransitMode transitMode, Context context) {
        if (TransitMode.bus.equals(transitMode)) {
            return b(tripSummary, context);
        }
        return c(tripSummary, context);
    }

    public static CardItem.b b(TripSummary tripSummary, Context context) {
        String str;
        SpannableStringBuilder spannableStringBuilder;
        String routeName = tripSummary.getRouteName();
        SpannableStringBuilder spannableStringBuilder2 = null;
        if (!ui1.Y()) {
            str = String.format(context.getString(R.string.to), tripSummary.getLastStop().getName());
        } else {
            str = null;
        }
        if (tripSummary.getTtStatus() == 1) {
            spannableStringBuilder = hj1.f(ui1.P(tripSummary.getTtStatus(), tripSummary.getTtStatusId()));
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(new ForegroundColorSpan((int) R.color.black_60), 0, spannableStringBuilder.length(), 17);
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
            if (tripSummary.isFrequencyTrip()) {
                int N = ui1.N();
                Pair<TimeInterval, Integer> z = ui1.z(N, tripSummary.getFrequencyList());
                if (z == null) {
                    String string = context.getString(R.string.no_more_trips_today);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) string);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#727171")), length, spannableStringBuilder.length(), 17);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), length, spannableStringBuilder.length(), 17);
                } else if (((TimeInterval) z.first).containsTime(N)) {
                    spannableStringBuilder = ii1.o(((Integer) z.second).toString(), R.color.route_connected_item_color, R.color.black_87, context);
                } else {
                    spannableStringBuilder.append((CharSequence) context.getString(R.string.after));
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder.length(), 17);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.route_connected_item_color)), 0, spannableStringBuilder.length(), 17);
                    spannableStringBuilder.append(jh1.l(jh1.g((long) ((Integer) ((Pair) ((TimeInterval) z.first)).first).intValue()), context));
                }
            } else {
                spannableStringBuilder.append(jh1.l(jh1.g((long) tripSummary.getArrivalTime()), context));
            }
            if (tripSummary.getTtStatus() == 2) {
                spannableStringBuilder.append((CharSequence) "  ");
                Drawable drawable = context.getResources().getDrawable(R.drawable.alert_icon_orange);
                drawable.setBounds(0, 0, 50, 50);
                spannableStringBuilder.setSpan(new ImageSpan(drawable, 2), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
            }
        }
        if (tripSummary.getAgencyName() != null) {
            SpannableStringBuilder f = hj1.f(tripSummary.getAgencyName().toUpperCase());
            f.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), 0, f.length(), 17);
            f.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.black)), 0, f.length(), 17);
            spannableStringBuilder2 = f;
        }
        TransitMode transitMode = TransitMode.bus;
        CardItem.b bVar = new CardItem.b(str, spannableStringBuilder2, spannableStringBuilder, routeName, vn.P(transitMode), transitMode);
        bVar.n = tripSummary.getAvailabilityLevel();
        bVar.e = tripSummary.getSpecialFeatures();
        return bVar;
    }

    public static CardItem.b c(TripSummary tripSummary, Context context) {
        CardItem.b bVar = new CardItem.b(String.format(context.getString(R.string.to), tripSummary.getLastStop().getName()), tripSummary.getPlatform() != null ? ui1.F(context, tripSummary.getPlatform()) : null, vn.z0(context, tripSummary, ui1.N()), String.format(context.getString(R.string.from), tripSummary.getFirstStop().getName()), vn.P(tripSummary.getFirstStop().getMode()), TransitMode.train);
        if (!ui1.Y()) {
            bVar.h = tripSummary.getRouteName();
        }
        bVar.e = tripSummary.getSpecialFeatures();
        return bVar;
    }

    public static CardItem d(TripSummary tripSummary, TransitMode transitMode, Context context) {
        if (TransitMode.bus.equals(transitMode)) {
            CardItem cardItem = new CardItem(context);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.bus_card_padding);
            cardItem.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            ((TextView) cardItem.findViewById(R.id.card_title)).setTextSize(14.0f);
            TextView textView = (TextView) cardItem.findViewById(R.id.card_title_from);
            textView.setTextSize(18.0f);
            cardItem.findViewById(R.id.card_timing).setAlpha(1.0f);
            CalligraphyUtils.applyFontToTextView(context, textView, context.getString(R.string.font_medium));
            cardItem.setContent(b(tripSummary, context));
            ((LinearLayout.LayoutParams) cardItem.findViewById(R.id.card_special_feature_view).getLayoutParams()).topMargin = context.getResources().getDimensionPixelSize(R.dimen.bus_card_above_agency_margin);
            if (ui1.S(tripSummary) && ui1.g0(tripSummary)) {
                cardItem.setAlpha(0.2f);
            }
            return cardItem;
        }
        CardItem cardItem2 = new CardItem(context);
        cardItem2.setContent(c(tripSummary, context));
        return cardItem2;
    }
}
