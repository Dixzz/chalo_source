package defpackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.EtaModel;
import app.zophop.models.LiveRouteData;
import app.zophop.models.Route;
import app.zophop.models.SeatInfo;
import app.zophop.models.Stop;
import app.zophop.models.VehicleInfo;
import app.zophop.ui.views.summary_card.CardItem;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.appindexing.Indexable;
import defpackage.ii1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import server.zophop.models.Pair;

/* renamed from: x61  reason: default package */
/* compiled from: StopEtaUtil */
public class x61 {
    public static long f;
    public static Stop g;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, ii1.a> f3891a;
    public final Context b;
    public LiveRouteData c;
    public List<SeatInfo> d;
    public ci1 e = null;

    public x61(Context context) {
        this.b = context;
        this.f3891a = new HashMap<>();
    }

    public static void a(x61 x61, Route route, Stop stop) {
        Objects.requireNonNull(x61);
        ed1 ed1 = new ed1("eta screen open", Long.MIN_VALUE);
        ed1.a("route id", route.getRouteId());
        ed1.a("route name", route.getRouteName());
        ed1.a("stop name", stop.getName());
        ed1.a("stop id", stop.getId());
        jz5.b().g(ed1);
    }

    public static List<EtaModel> j(ii1.a aVar, int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        List<i10> list = aVar.b;
        if (list == null || list.size() == 0 || !s(aVar.f1519a)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = list.get(i2).f1460a;
            long j = list.get(i2).c;
            if (i > 0 && i3 != -1 && s(i3)) {
                arrayList.add(new EtaModel(list.get(i2).g, Integer.valueOf(i3), j, list.get(i2).h));
                i--;
                linkedHashMap.put(new Pair(list.get(i2).g, Integer.valueOf(i3)), Long.valueOf(j));
            }
        }
        return arrayList;
    }

    public static List<Integer> l(ii1.a aVar, int i) {
        ArrayList arrayList = new ArrayList(i);
        List<i10> list = aVar.b;
        if (list == null || list.size() == 0 || !s(aVar.f1519a)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = list.get(i2).f1460a;
            if (i > 0 && i3 != -1 && s(i3)) {
                i--;
                arrayList.add(Integer.valueOf(i3));
            }
        }
        return arrayList;
    }

    public static int o(int i) {
        return i % 2 == 0 ? 0 : 1;
    }

    public static boolean r(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static boolean s(int i) {
        return i <= 7200;
    }

    public static boolean t(j10 j10) {
        if (j10.a() > 7200 && j10.b().size() == 0) {
            return false;
        }
        return true;
    }

    public static List<VehicleInfo> z(ii1.a aVar) {
        ArrayList arrayList = new ArrayList();
        List<i10> list = aVar.b;
        if (!(list == null || list.size() == 0)) {
            int i = 0;
            while (i < list.size() && i < 2) {
                int i2 = list.get(i).f1460a;
                if (i2 != -1 && s(i2)) {
                    arrayList.add(new VehicleInfo(list.get(i).g, System.currentTimeMillis() + ((long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL))));
                }
                i++;
            }
        }
        return arrayList;
    }

    public final void b(LinearLayout linearLayout, SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2, long j, long j2, int i, int i2, boolean z, boolean z2) {
        CardItem cardItem = new CardItem(this.b);
        CardItem.b bVar = new CardItem.b(spannableStringBuilder, null, null, null, String.valueOf((System.currentTimeMillis() - j) / DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL));
        bVar.j = 0;
        bVar.m = z;
        bVar.l = i;
        bVar.o = this.e;
        cardItem.setBackgroundColor(this.b.getResources().getColor(R.color.white));
        cardItem.setContent(bVar);
        if (linearLayout.getChildAt(1) instanceof CardItem) {
            linearLayout.removeViewAt(1);
        }
        if (TextUtils.isEmpty(spannableStringBuilder) && linearLayout.getChildAt(1) != null && (linearLayout.getChildAt(1) instanceof CardItem)) {
            linearLayout.removeViewAt(1);
        }
        linearLayout.addView(cardItem, 1);
        if (!TextUtils.isEmpty(spannableStringBuilder2)) {
            CardItem cardItem2 = new CardItem(this.b);
            CardItem.b bVar2 = new CardItem.b(spannableStringBuilder2, null, null, null, String.valueOf((System.currentTimeMillis() - j2) / DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL));
            bVar2.j = 0;
            bVar2.l = i2;
            bVar2.m = z2;
            bVar2.o = this.e;
            cardItem2.setContent(bVar2);
            cardItem2.setBackgroundColor(this.b.getResources().getColor(R.color.white));
            if (linearLayout.getChildAt(3) instanceof CardItem) {
                linearLayout.removeViewAt(3);
            }
            linearLayout.addView(cardItem2, 3);
        } else if (linearLayout.getChildAt(3) != null && (linearLayout.getChildAt(3) instanceof CardItem)) {
            linearLayout.removeViewAt(3);
        }
    }

    public void c(Stop stop, ii1.a aVar) {
        this.f3891a.clear();
        this.f3891a.put(stop.getId(), aVar);
    }

    public void d(Stop stop) {
        ii1.a aVar = new ii1.a();
        aVar.d = ii1.a.EnumC0027a.SUCCESS;
        aVar.f1519a = -1;
        this.f3891a.put(stop.getId(), aVar);
    }

    public final int e(String str) {
        if (this.d == null) {
            return -1;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).getVehicleNo().equalsIgnoreCase(str)) {
                return this.d.get(i).getSeatStatus();
            }
        }
        return -1;
    }

    public final SpannableStringBuilder f(String str, int i) {
        SpannableStringBuilder f2 = hj1.f(str);
        f2.setSpan(vn.N(this.b, wg1.NOTOSANS_MEDIUM), 0, f2.length(), 17);
        f2.setSpan(new AbsoluteSizeSpan(14, true), 0, f2.length(), 17);
        f2.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(i)), 0, f2.length(), 17);
        return f2;
    }

    public final SpannableStringBuilder g() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) xt.f3961a.t().f("disruptionCopy"));
        spannableStringBuilder.setSpan(vn.N(this.b, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(R.color.black_70)), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.length();
        return spannableStringBuilder;
    }

    public ii1.a h(Stop stop) {
        return this.f3891a.get(stop.getId());
    }

    public SpannableStringBuilder i(LinearLayout linearLayout, int i, Context context, int i2) {
        SpannableStringBuilder f2 = hj1.f("  ");
        f2.setSpan(new wa1(context, linearLayout.getChildAt((i2 * 2) + 1), R.drawable.real_time_indicator, 2.0f), 0, 1, 17);
        f2.append((CharSequence) ii1.d((long) (i * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), this.b));
        f2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.eta_blue)), 0, f2.length(), 17);
        f2.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, f2.length(), 17);
        f2.setSpan(new AbsoluteSizeSpan(16, true), 0, f2.length(), 17);
        return f2;
    }

    public final SpannableStringBuilder k(int i, Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) ii1.d((long) (i * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), context));
        spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder m(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) f(str, R.color.real_time_status_hook_background_color_unavailable));
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder n(String str) {
        SpannableStringBuilder f2 = hj1.f(str);
        f2.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(R.color.black_60)), 0, f2.length(), 17);
        f2.setSpan(vn.N(this.b, wg1.NOTOSANS_REGULAR), 0, f2.length(), 17);
        f2.setSpan(new AbsoluteSizeSpan(14, true), 0, f2.length(), 17);
        return f2;
    }

    public SpannableStringBuilder p(Context context, ii1.a aVar, int i) {
        List<i10> list = aVar.c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "In ").append((CharSequence) ui1.R(list.get(i).e, list.get(i).f));
        spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public boolean q(Stop stop) {
        ii1.a aVar = this.f3891a.get(stop.getId());
        return aVar != null && aVar.d.equals(ii1.a.EnumC0027a.SUCCESS) && aVar.f1519a == -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(android.widget.RelativeLayout r22, android.widget.LinearLayout r23, android.widget.TextView r24, android.widget.TextView r25, android.widget.LinearLayout r26, android.widget.TextView r27, defpackage.ii1.a r28, boolean r29, app.zophop.models.Route r30, app.zophop.models.Stop r31) {
        /*
        // Method dump skipped, instructions count: 514
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x61.u(android.widget.RelativeLayout, android.widget.LinearLayout, android.widget.TextView, android.widget.TextView, android.widget.LinearLayout, android.widget.TextView, ii1$a, boolean, app.zophop.models.Route, app.zophop.models.Stop):void");
    }

    public void v(LinearLayout linearLayout, TextView textView) {
        if (linearLayout != null) {
            ((TextView) linearLayout.findViewById(R.id.more_buses_prefix)).setText(f(this.b.getString(R.string.fetching), R.color.real_time_fetching_string_color));
            linearLayout.setVisibility(0);
            linearLayout.findViewById(R.id.next_availability_header).setVisibility(8);
            linearLayout.findViewById(R.id.above_nearby_stop_trip_card_div).setVisibility(8);
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(f(this.b.getString(R.string.fetching), R.color.real_time_fetching_string_color));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public final void w(TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3) {
        textView3.setVisibility(8);
        textView2.setVisibility(8);
        textView.setAlpha(1.0f);
        if (linearLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.weight = 0.5f;
            linearLayout.setLayoutParams(layoutParams);
        }
        linearLayout.setVisibility(8);
        textView3.setVisibility(8);
        textView.setGravity(5);
    }

    public final void x(LinearLayout linearLayout, RelativeLayout relativeLayout, Route route, LinearLayout linearLayout2, TextView textView, TextView textView2, LinearLayout linearLayout3, TextView textView3, CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder;
        if (route.getTtStatus() == 1) {
            textView.setVisibility(8);
            textView3.setPadding(0, 0, 0, 0);
            linearLayout2.setVisibility(0);
            linearLayout2.findViewById(R.id.next_availability_header).setVisibility(8);
            linearLayout2.findViewById(R.id.above_nearby_stop_trip_card_div).setVisibility(8);
            linearLayout2.findViewById(R.id.new_nearby_first_div).setVisibility(8);
            linearLayout2.findViewById(R.id.more_buses_prefix).setVisibility(8);
            linearLayout2.findViewById(R.id.eta_card_more_container).setVisibility(8);
            linearLayout2.findViewById(R.id.next_availability_header).setVisibility(0);
            CardItem cardItem = new CardItem(this.b);
            String P = ui1.P(route.getTtStatus(), route.getTtStatusId());
            if (TextUtils.isEmpty(P)) {
                spannableStringBuilder = n(this.b.getResources().getString(R.string.timing_not_available));
            } else {
                spannableStringBuilder = n(P);
            }
            CardItem.b bVar = new CardItem.b(spannableStringBuilder, null, null, null, null);
            bVar.j = 0;
            cardItem.setBackgroundColor(this.b.getResources().getColor(R.color.white));
            cardItem.setContent(bVar);
            if (linearLayout2.getChildAt(1) instanceof CardItem) {
                linearLayout2.removeViewAt(1);
            }
            linearLayout2.addView(cardItem, 1);
            textView3.setVisibility(8);
            linearLayout3.setVisibility(8);
            y(linearLayout, relativeLayout, textView2, true);
            return;
        }
        textView.setVisibility(8);
        textView3.setPadding(0, 0, 0, 0);
        linearLayout2.setVisibility(0);
        linearLayout2.findViewById(R.id.next_availability_header).setVisibility(8);
        linearLayout2.findViewById(R.id.above_nearby_stop_trip_card_div).setVisibility(8);
        ((TextView) linearLayout2.findViewById(R.id.more_buses_prefix)).setText(this.b.getResources().getString(R.string.view_timetable));
        linearLayout2.findViewById(R.id.more_buses_prefix).setOnClickListener(new w61(this, route));
        if (!TextUtils.isEmpty(charSequence)) {
            linearLayout2.findViewById(R.id.next_availability_header).setVisibility(0);
            CardItem cardItem2 = new CardItem(this.b);
            if (route.getTtStatus() != 2 || TextUtils.isEmpty(ui1.P(route.getTtStatus(), route.getTtStatusId()))) {
                cardItem2.findViewById(R.id.time_table_disclaimer_layout).setVisibility(8);
            } else {
                cardItem2.findViewById(R.id.time_table_disclaimer_layout).setVisibility(0);
                ((TextView) cardItem2.findViewById(R.id.timetable_disclaimer_text)).setText(ui1.P(route.getTtStatus(), route.getTtStatusId()));
            }
            SpannableStringBuilder n = n(this.b.getResources().getString(R.string.schedule_freq));
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence);
            spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder2.length(), 17);
            n.append((CharSequence) spannableStringBuilder2);
            CardItem.b bVar2 = new CardItem.b(n, null, null, null, null);
            bVar2.j = 0;
            cardItem2.setBackgroundColor(this.b.getResources().getColor(R.color.white));
            cardItem2.setContent(bVar2);
            if (linearLayout2.getChildAt(1) instanceof CardItem) {
                linearLayout2.removeViewAt(1);
            }
            linearLayout2.findViewById(R.id.new_nearby_first_div).setVisibility(0);
            linearLayout2.addView(cardItem2, 1);
        } else {
            linearLayout2.findViewById(R.id.eta_card_more_container).setVisibility(0);
            if (linearLayout2.getChildCount() >= 1 && (linearLayout2.getChildAt(1) instanceof CardItem)) {
                linearLayout2.removeViewAt(1);
            }
        }
        textView3.setVisibility(8);
        linearLayout3.setVisibility(8);
        y(linearLayout, relativeLayout, textView2, true);
    }

    public final void y(LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) textView.getText().toString());
        if (!(relativeLayout == null || linearLayout == null)) {
            if (z) {
                linearLayout.setPadding((int) ui1.n(16.0f, this.b), 0, 0, (int) ui1.n(10.0f, this.b));
            } else {
                linearLayout.setPadding((int) ui1.n(16.0f, this.b), 0, 0, (int) ui1.n(16.0f, this.b));
            }
            relativeLayout.setVisibility(z ? 0 : 8);
        }
        if (z) {
            spannableStringBuilder.setSpan(vn.N(this.b, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
            textView.setAlpha(1.0f);
        } else {
            spannableStringBuilder.setSpan(vn.N(this.b, wg1.NOTOSANS_REGULAR), 0, spannableStringBuilder.length(), 17);
            textView.setAlpha(0.87f);
        }
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder.length(), 17);
        textView.setText(spannableStringBuilder);
    }
}
