package app.zophop.ui.views.summary_card;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.pubsub.eventbus.events.ReportProblemClickEvent;
import app.zophop.ui.views.summary_card.CardItem;
import defpackage.ii1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class RouteListCardItem extends CardItem {
    public static String l;
    public RelativeLayout g;
    public oc1 h;
    public LinearLayout i;
    public CardView j;
    public View k;

    public class a implements View.OnClickListener {
        public a(RouteListCardItem routeListCardItem) {
        }

        public void onClick(View view) {
            RouteListCardItem.l = UUID.randomUUID().toString();
            jz5.b().i(new ReportProblemClickEvent(RouteListCardItem.l));
        }
    }

    public RouteListCardItem(Context context) {
        super(context);
    }

    private RelativeLayout getCardLayout() {
        return this.g;
    }

    private RelativeLayout getDisruptionView() {
        return this.h.getDisruptionView();
    }

    private View getEtaCardView() {
        return this.h.getRootView();
    }

    private LinearLayout getMainLayout() {
        return this.i;
    }

    private View.OnClickListener getReportIssueHookClickListener() {
        return new a(this);
    }

    private TextView getSeatAvailabilityView() {
        return this.h.getSeatView();
    }

    @Override // app.zophop.ui.views.summary_card.CardItem
    public void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.route_list_card_item, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.drawer_item_selector);
    }

    @Override // app.zophop.ui.views.summary_card.CardItem
    public void b() {
        TextView textView = (TextView) findViewById(R.id.card_title);
        TextView textView2 = (TextView) findViewById(R.id.card_subtitle);
        TextView textView3 = (TextView) findViewById(R.id.card_timing);
        TextView textView4 = (TextView) findViewById(R.id.card_title_from);
        TextView textView5 = (TextView) findViewById(R.id.bus_agency_name);
        ImageView imageView = (ImageView) findViewById(R.id.card_item_icon);
        this.i = (LinearLayout) findViewById(R.id.main_layout);
        this.g = (RelativeLayout) findViewById(R.id.eta_card_container);
        oc1 oc1 = new oc1(getContext());
        this.h = oc1;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.eta_card, (ViewGroup) null, false);
        this.j = (CardView) linearLayout.findViewById(R.id.card_container);
        View findViewById = linearLayout.findViewById(R.id.report_problem_container);
        this.k = findViewById;
        findViewById.setOnClickListener(getReportIssueHookClickListener());
        this.j.addView(oc1);
        this.g.removeAllViews();
        this.g.addView(linearLayout);
        textView.setText(this.f.f318a);
        CardItem.b bVar = this.f;
        if (bVar.b == null) {
            textView2.setVisibility(8);
        } else if (TransitMode.bus.equals(bVar.i)) {
            textView5.setVisibility(0);
            textView5.setText(this.f.b.toString());
            textView2.setVisibility(8);
        } else {
            textView5.setVisibility(8);
            textView2.setVisibility(0);
            if (TransitMode.train.equals(this.f.i)) {
                textView2.setText(this.f.b.toString() + "    " + this.f.h);
            } else {
                textView2.setText(this.f.b.toString());
            }
        }
        if (this.f.k != -1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins((int) ui1.n(16.0f, getContext()), 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins((int) ui1.n(0.0f, getContext()), 0, 0, 0);
            this.j.setLayoutParams(layoutParams2);
        }
        if (this.f.c != null) {
            textView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView3.setVisibility(0);
            textView3.setText(this.f.c);
        } else {
            textView3.setVisibility(8);
        }
        int i2 = this.f.g;
        if (i2 != -1) {
            imageView.setImageResource(i2);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        CharSequence charSequence = this.f.f;
        if (charSequence != null) {
            textView4.setText(charSequence);
            textView4.setVisibility(0);
            return;
        }
        textView4.setVisibility(8);
    }

    public void c(x61 x61, Stop stop, Route route, boolean z) {
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        TextView textView;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        TextView textView2;
        LinearLayout linearLayout2;
        TextView textView3;
        RelativeLayout relativeLayout2;
        LinearLayout linearLayout3;
        TextView textView4 = (TextView) findViewById(R.id.card_title);
        TextView viewScheduledTextView = getViewScheduledTextView();
        LinearLayout timeDetailsContainer = getTimeDetailsContainer();
        Context context = getContext();
        List<Route.RouteTiming> routeTiming = route.getRouteTiming();
        String str = v40.d;
        Collections.sort(routeTiming, new m40());
        int N = ui1.N();
        Iterator<Route.RouteTiming> it = routeTiming.iterator();
        while (true) {
            if (!it.hasNext()) {
                spannableStringBuilder = new SpannableStringBuilder("");
                break;
            }
            Route.RouteTiming next = it.next();
            if (next._isFrequency) {
                if (!((TimeInterval) next._frequencyTuple.first).containsTime(N)) {
                    if (((TimeInterval) next._frequencyTuple.first).getLow() > N && z) {
                        spannableStringBuilder = ui1.I(context, ((TimeInterval) next._frequencyTuple.first).getLow());
                        break;
                    }
                } else {
                    String valueOf = String.valueOf(next._frequencyTuple.second);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
                    spannableStringBuilder3.append((CharSequence) context.getString(R.string.every));
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder3.length(), 17);
                    spannableStringBuilder3.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.route_connected_item_color)), 0, spannableStringBuilder3.length(), 17);
                    int length = spannableStringBuilder3.length();
                    spannableStringBuilder3.append((CharSequence) valueOf);
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(16, true), length, spannableStringBuilder3.length(), 17);
                    spannableStringBuilder3.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.black_87)), length, spannableStringBuilder3.length(), 17);
                    spannableStringBuilder3.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), length, spannableStringBuilder3.length(), 17);
                    int length2 = spannableStringBuilder3.length();
                    spannableStringBuilder3.append((CharSequence) " min");
                    spannableStringBuilder3.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), 0, spannableStringBuilder3.length(), 17);
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(14, true), length2, spannableStringBuilder3.length(), 17);
                    spannableStringBuilder3.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.route_connected_item_color)), length2, spannableStringBuilder3.length(), 17);
                    spannableStringBuilder2 = spannableStringBuilder3;
                    break;
                }
            } else {
                int i2 = next._startTime;
                if (i2 > N && z) {
                    spannableStringBuilder = ui1.I(context, i2);
                    break;
                }
            }
        }
        spannableStringBuilder2 = spannableStringBuilder;
        getSeatAvailabilityView();
        RelativeLayout disruptionView = getDisruptionView();
        LinearLayout mainLayout = getMainLayout();
        RelativeLayout cardLayout = getCardLayout();
        getTimeDetailsContainer();
        LinearLayout linearLayout4 = (LinearLayout) getEtaCardView();
        TextView timeView = getTimeView();
        TextView scheduledTimeView = getScheduledTimeView();
        ii1.a aVar = x61.f3891a.get(stop.getId());
        if (aVar != null && aVar.d.equals(ii1.a.EnumC0027a.NOT_ARRIVING_SOON)) {
            viewScheduledTextView.setVisibility(0);
            scheduledTimeView.setVisibility(0);
            x61.y(mainLayout, cardLayout, textView4, true);
            timeView.setText(x61.m(x61.b.getString(R.string.not_arriving_soon)));
            timeDetailsContainer.setVisibility(0);
            timeView.setVisibility(0);
            x61.b.getResources().getDimensionPixelSize(R.dimen.route_list_item_view_schedule_padding);
            return;
        }
        ii1.a aVar2 = x61.f3891a.get(stop.getId());
        if (aVar2 != null && aVar2.d.equals(ii1.a.EnumC0027a.PASSED)) {
            x61.m(x61.b.getString(R.string.not_available));
            x61.x(mainLayout, cardLayout, route, linearLayout4, timeView, textView4, timeDetailsContainer, viewScheduledTextView, spannableStringBuilder2);
            x61.b.getResources().getDimensionPixelSize(R.dimen.route_list_item_view_schedule_padding);
        } else if (x61.q(stop)) {
            x61.f = System.currentTimeMillis();
            viewScheduledTextView.setVisibility(8);
            x61.v(linearLayout4, timeView);
            scheduledTimeView.setVisibility(8);
            timeView.setVisibility(8);
            timeDetailsContainer.setVisibility(8);
            x61.y(mainLayout, cardLayout, textView4, true);
        } else {
            ii1.a aVar3 = x61.f3891a.get(stop.getId());
            if (aVar3 == null) {
                timeView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                timeView.setVisibility(8);
                scheduledTimeView.setVisibility(8);
                viewScheduledTextView.setVisibility(8);
                timeDetailsContainer.setVisibility(8);
                x61.y(mainLayout, cardLayout, textView4, false);
            } else if (aVar3.d.equals(ii1.a.EnumC0027a.FAILURE)) {
                x61.m(x61.b.getString(R.string.not_available));
                x61.x(mainLayout, cardLayout, route, linearLayout4, timeView, textView4, timeDetailsContainer, viewScheduledTextView, spannableStringBuilder2);
                x61.b.getResources().getDimensionPixelSize(R.dimen.route_list_item_view_schedule_padding);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                Stop stop2 = x61.g;
                if (stop2 == null || stop2 != stop) {
                    textView = scheduledTimeView;
                    ed1 ed1 = new ed1("live eta fetch", Long.MIN_VALUE);
                    ed1.a("response time", Long.valueOf(currentTimeMillis - x61.f));
                    ed1.a("stop name", stop.getName());
                    ed1.a("stop id", stop.getId());
                    ed1.a("route id", route.getRouteId());
                    jz5.b().g(ed1);
                    x61.g = stop;
                } else {
                    textView = scheduledTimeView;
                }
                timeView.setVisibility(0);
                timeDetailsContainer.setVisibility(0);
                List<i10> list = aVar3.b;
                List<i10> list2 = aVar3.c;
                if (list.size() == 0 || !x61.s(aVar3.f1519a)) {
                    if (list2 == null || list2.size() == 0) {
                        linearLayout2 = mainLayout;
                        textView3 = textView4;
                        textView.setVisibility(8);
                        x61.m(x61.b.getString(R.string.not_available));
                        x61.x(linearLayout2, cardLayout, route, linearLayout4, timeView, textView3, timeDetailsContainer, viewScheduledTextView, spannableStringBuilder2);
                        x61.b.getResources().getDimensionPixelSize(R.dimen.route_list_item_view_schedule_padding);
                    } else {
                        aVar3.c.size();
                        HashMap hashMap = new HashMap();
                        List<i10> list3 = aVar3.c;
                        int i3 = 0;
                        while (i3 < list3.size()) {
                            hashMap.put(Long.valueOf(list3.get(i3).c), ui1.R(list3.get(i3).e, list3.get(i3).f));
                            i3++;
                            textView4 = textView4;
                        }
                        textView3 = textView4;
                        linearLayout2 = mainLayout;
                        x61.b(linearLayout4, hashMap.size() >= 1 ? x61.p(x61.b, aVar3, 0) : null, hashMap.size() >= 2 ? x61.p(x61.b, aVar3, 1) : null, System.currentTimeMillis(), System.currentTimeMillis(), -1, -1, false, false);
                        linearLayout4.setVisibility(0);
                        disruptionView.setVisibility(route.isDisrupted() ? 0 : 8);
                        ((TextView) disruptionView.findViewById(R.id.disruptionText)).setText(x61.g());
                        TextView textView5 = (TextView) linearLayout4.findViewById(R.id.next_availability_header);
                        if (hashMap.size() == 1) {
                            textView5.setText(x61.b.getResources().getString(R.string.next_bus));
                            linearLayout4.findViewById(R.id.new_nearby_first_div).setVisibility(4);
                            linearLayout4.findViewById(R.id.eta_card_more_container).setVisibility(8);
                        } else if (hashMap.size() == 2) {
                            textView5.setText(x61.b.getResources().getString(R.string.next_buses));
                            linearLayout4.findViewById(R.id.new_nearby_first_div).setVisibility(0);
                            linearLayout4.findViewById(R.id.eta_card_more_container).setVisibility(8);
                        } else {
                            textView5.setText(x61.b.getResources().getString(R.string.next_buses));
                            ((TextView) linearLayout4.findViewById(R.id.more_buses_prefix)).setText(x61.b.getResources().getString(R.string.see_more_buses));
                            linearLayout4.findViewById(R.id.new_nearby_first_div).setVisibility(0);
                            linearLayout4.findViewById(R.id.above_nearby_stop_trip_card_div).setVisibility(0);
                            linearLayout4.findViewById(R.id.eta_card_more_container).setVisibility(0);
                        }
                        linearLayout4.findViewById(R.id.eta_card_more_container).setOnClickListener(new u61(x61, route, stop, hashMap));
                        timeView.setVisibility(8);
                        x61.w(timeView, textView, timeDetailsContainer, viewScheduledTextView);
                    }
                    relativeLayout = cardLayout;
                    textView2 = textView3;
                    linearLayout = linearLayout2;
                } else {
                    if (aVar3.d.equals(ii1.a.EnumC0027a.FIRST_STOP)) {
                        linearLayout3 = mainLayout;
                        relativeLayout2 = cardLayout;
                        x61.u(disruptionView, linearLayout4, timeView, textView, timeDetailsContainer, viewScheduledTextView, aVar3, true, route, stop);
                    } else {
                        relativeLayout2 = cardLayout;
                        linearLayout3 = mainLayout;
                        x61.u(disruptionView, linearLayout4, timeView, textView, timeDetailsContainer, viewScheduledTextView, aVar3, false, route, stop);
                    }
                    linearLayout = linearLayout3;
                    textView2 = textView4;
                    relativeLayout = relativeLayout2;
                }
                x61.y(linearLayout, relativeLayout, textView2, true);
            }
        }
    }

    public View getReportHook() {
        return this.k;
    }

    public RouteListCardItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
