package defpackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.TransitMode;
import app.zophop.ui.views.summary_card.CardItem;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.LegMode;
import zophop.models.TripAndArrivalInfoTuple;

/* renamed from: wc1  reason: default package */
/* compiled from: OfflineSchedulerCard */
public class wc1 extends LinearLayout {
    public static final /* synthetic */ int j = 0;
    public Context f;
    public Itinerary g;
    public LinearLayout h = ((LinearLayout) findViewById(R.id.field_description));
    public int i;

    public wc1(Context context) {
        super(context);
        this.f = context;
        LayoutInflater.from(context).inflate(R.layout.offline_scheduler_card, (ViewGroup) this, true);
    }

    private View getDivider() {
        View view = new View(this.f);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.home_screen_divider)));
        return view;
    }

    private int getItemCount() {
        return this.g.legs.size();
    }

    private View getSeparator() {
        View inflate = LayoutInflater.from(this.f).inflate(R.layout.card_item_separator, (ViewGroup) null, false);
        inflate.setPadding(this.f.getResources().getDimensionPixelSize(R.dimen.scheduler_description_item_left_padding), 0, this.f.getResources().getDimensionPixelSize(R.dimen.scheduler_description_divider_right_padding), 0);
        return inflate;
    }

    public final void a(int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f).inflate(R.layout.offline_scheduler_card_change_description, (ViewGroup) this, false);
        TextView textView = (TextView) linearLayout.findViewById(R.id.change_description);
        getContext().getString(R.string.change_at);
        if (i2 == 0) {
            String string = this.f.getString(R.string.start_from);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.g.legs.get(i2).start_place_name);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f.getResources().getColor(R.color.black)), 0, spannableStringBuilder.length(), 17);
            textView.setText(String.format(string, spannableStringBuilder));
            linearLayout.findViewById(R.id.divider).setVisibility(0);
        } else if (i2 == getItemCount()) {
            textView.setText(String.format(this.f.getString(R.string.end_at), this.g.legs.get(i2 - 1).last_stop.getStop_name()));
            linearLayout.findViewById(R.id.divider).setVisibility(8);
        } else {
            textView.setText(String.format(this.f.getString(R.string.change_at), this.g.legs.get(i2).start_place_name));
            linearLayout.findViewById(R.id.divider).setVisibility(0);
        }
        this.h.addView(linearLayout);
    }

    public final void b(String str, LegMode legMode) {
        ui1.r0(str, "scheduler", TransitMode.getTransitMode(legMode.name().toLowerCase()).name());
    }

    public void c(Itinerary itinerary, int i2) {
        int i3;
        SpannableStringBuilder spannableStringBuilder;
        this.g = itinerary;
        this.i = i2;
        this.h.removeAllViews();
        for (int i4 = 0; i4 < getItemCount(); i4++) {
            a(i4);
            int i5 = 0;
            while (true) {
                try {
                    i3 = this.g.legs.get(i4).extraTrips.extraTrips.size();
                } catch (Exception unused) {
                    i3 = 0;
                }
                if (i3 > 2) {
                    i3 = 2;
                }
                if (i5 >= i3) {
                    break;
                }
                Leg leg = this.g.legs.get(i4);
                TripAndArrivalInfoTuple tripAndArrivalInfoTuple = leg.extraTrips.extraTrips.get(i5);
                CardItem cardItem = new CardItem(this.f);
                Leg leg2 = this.g.legs.get(i4);
                TripAndArrivalInfoTuple tripAndArrivalInfoTuple2 = leg2.extraTrips.extraTrips.get(i5);
                boolean z = true;
                String format = String.format(getContext().getString(R.string.to), tripAndArrivalInfoTuple2.getTrip().getLast_stop().getStop_name());
                String format2 = String.format(getContext().getString(R.string.from), tripAndArrivalInfoTuple2.getTrip().getFirst_stop().getStop_name());
                CharSequence F = ui1.F(this.f, tripAndArrivalInfoTuple2.getPlatform());
                LegMode legMode = leg2.mode;
                if (F != null || (!legMode.equals(LegMode.METRO) && !legMode.equals(LegMode.MONORAIL))) {
                    z = false;
                }
                if (z) {
                    F = "";
                }
                try {
                    spannableStringBuilder = vn.z0(this.f, new uv().d(new JSONObject(new Gson().toJson(tripAndArrivalInfoTuple2))), this.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                    spannableStringBuilder = null;
                }
                CardItem.b bVar = new CardItem.b(format, F, spannableStringBuilder, format2, vn.P(TransitMode.getTransitMode(leg2.mode.name())), TransitMode.getTransitMode(leg2.mode.name()));
                bVar.h = leg2.route_name;
                bVar.e = tripAndArrivalInfoTuple2.getTrip().getSpecial_features();
                cardItem.setContent(bVar);
                cardItem.setOnClickListener(new uc1(this, tripAndArrivalInfoTuple, leg));
                this.h.addView(cardItem);
                this.h.addView(getSeparator());
                i5++;
            }
            Leg leg3 = this.g.legs.get(i4);
            if (!leg3.isFrequencyLeg) {
                View inflate = LayoutInflater.from(this.f).inflate(R.layout.offline_footer, (ViewGroup) this, false);
                inflate.setOnClickListener(new vc1(this, leg3));
                this.h.addView(inflate);
            }
        }
        a(getItemCount());
    }
}
