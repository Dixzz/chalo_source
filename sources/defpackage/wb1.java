package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.RouteLevelAvailability;
import app.zophop.models.SeatInfo;
import app.zophop.models.VehicleInfo;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import app.zophop.ui.PaddingBackgroundColorSpan;
import app.zophop.ui.views.SummaryView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.firebase.appindexing.Indexable;
import defpackage.ii1;
import defpackage.nn0;
import defpackage.xt;
import io.github.inflationx.calligraphy3.CalligraphyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zophop.models.Itinerary;
import zophop.models.Leg;
import zophop.models.LegMode;
import zophop.models.Stop;

/* renamed from: wb1  reason: default package */
/* compiled from: TripSummaryRenderer */
public class wb1 implements SummaryView.a {
    public static int r;
    public static Map<String, VehicleInfo> s;

    /* renamed from: a  reason: collision with root package name */
    public final Itinerary f3755a;
    public final Context b;
    public View.OnClickListener c;
    public final b d;
    public boolean e;
    public boolean f;
    public qb1 g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public Map<String, Integer> m;
    public ii1.a n;
    public int o;
    public boolean p;
    public final ji1 q = new a();

    /* renamed from: wb1$a */
    /* compiled from: TripSummaryRenderer */
    public class a implements ji1 {
        public a() {
        }

        @Override // defpackage.ji1
        public void a(Object obj) {
            wb1.this.p = false;
        }

        @Override // defpackage.ji1
        public void onSuccess(Object obj) {
            wb1.this.p = true;
            HashMap hashMap = (HashMap) obj;
            Map.Entry entry = (Map.Entry) hashMap.entrySet().iterator().next();
            if (!b.TRIPPLANNER.equals(wb1.this.d)) {
                wb1 wb1 = wb1.this;
                wb1.h(wb1.h, (ii1.a) hashMap.get(entry.getKey()), ((Integer) entry.getKey()).intValue());
                return;
            }
            wb1.this.o = ((Integer) entry.getKey()).intValue();
            wb1.this.n = (ii1.a) hashMap.get(entry.getKey());
            wb1 wb12 = wb1.this;
            wb12.a(wb12.i, wb12.l, wb12.j, wb12.k, wb12.n, wb12.o);
        }
    }

    /* renamed from: wb1$b */
    /* compiled from: TripSummaryRenderer */
    public enum b {
        TRIPPLANNER,
        SCHEDULER
    }

    public wb1(Itinerary itinerary, Context context, b bVar) {
        this.f3755a = itinerary;
        this.b = context;
        this.d = bVar;
        this.e = false;
        this.f = false;
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void a(TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ii1.a aVar, int i2) {
        String str;
        int i3;
        int i4;
        boolean z;
        ImageView imageView3;
        ImageView imageView4;
        TextView textView3;
        int i5;
        boolean z2;
        String str2;
        Stop stop;
        TextView textView4 = textView2;
        ImageView imageView5 = imageView;
        ImageView imageView6 = imageView2;
        ii1.a aVar2 = aVar;
        if (b.TRIPPLANNER.equals(this.d)) {
            boolean z3 = this.f3755a.legs.size() == 1;
            int i6 = 0;
            while (true) {
                if (i6 >= this.f3755a.legs.size()) {
                    i6 = -1;
                    str = null;
                    break;
                }
                Leg leg = this.f3755a.legs.get(i6);
                if (leg != null && r(leg.mode) && (stop = leg.first_stop) != null) {
                    str = stop.getStop_name();
                    break;
                }
                i6++;
            }
            if (str != null) {
                textView.setText("");
                this.i = textView;
                this.l = textView4;
                this.j = imageView5;
                this.k = imageView6;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!ui1.e0()) {
                    spannableStringBuilder.append((CharSequence) (this.b.getString(R.string.trip_planner_from_prefix) + str + " "));
                }
                TextView textView5 = textView4;
                int i7 = 0;
                boolean z4 = true;
                int i8 = 0;
                while (i7 < this.f3755a.legs.size()) {
                    Leg leg2 = this.f3755a.legs.get(i7);
                    if (r(leg2.mode)) {
                        int length = spannableStringBuilder.length();
                        if (!z4 || aVar2 != null) {
                            z = z3;
                            i5 = length;
                        } else {
                            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) this.b.getResources().getString(R.string.trip_planner_eta_fetch));
                            i5 = spannableStringBuilder.length();
                            int i9 = length + 1;
                            spannableStringBuilder.setSpan(vn.N(this.b, wg1.NOTOSANS_MEDIUM), i9, i5, 17);
                            z = z3;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), i9, i5, 17);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(R.color.eta_blue)), i9, i5, 17);
                            qb1 qb1 = new qb1(this.f3755a, this.q, leg2);
                            this.g = qb1;
                            qb1.c();
                            z4 = false;
                        }
                        if (this.p && i7 == i2 && i7 == i6) {
                            int i10 = length + 1;
                            i10 q2 = q(aVar2, i8);
                            if (q2 != null) {
                                i4 = i6;
                                str2 = jh1.k((long) (q2.f1460a * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
                            } else {
                                i4 = i6;
                                str2 = null;
                            }
                            if (str2 != null) {
                                r++;
                                ui1.q0("trip planner results", "", "", 1);
                                spannableStringBuilder.replace(length, i5, (CharSequence) "");
                                spannableStringBuilder.append((CharSequence) "   ");
                                spannableStringBuilder.setSpan(new wa1(this.b, textView, R.drawable.real_time_indicator, 2.4f), i10, spannableStringBuilder.length() - 1, 17);
                                textView3 = textView2;
                                z2 = z4;
                                spannableStringBuilder.setSpan(new wa1(this.b, textView3, R.drawable.real_time_indicator, 2.4f), i10, spannableStringBuilder.length() - 1, 17);
                                if (str2.contains("sec")) {
                                    spannableStringBuilder.append((CharSequence) (this.b.getResources().getString(R.string.eta_in_minute) + "  "));
                                } else {
                                    spannableStringBuilder.append((CharSequence) "In ").append((CharSequence) str2).append((CharSequence) "  ");
                                }
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.b.getResources().getColor(R.color.eta_blue)), i10, spannableStringBuilder.length(), 17);
                                spannableStringBuilder.setSpan(vn.N(this.b, wg1.NOTOSANS_MEDIUM), i10, spannableStringBuilder.length(), 17);
                                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), i10, spannableStringBuilder.length(), 17);
                                spannableStringBuilder.setSpan(new PaddingBackgroundColorSpan(this.b.getResources().getColor(R.color.transparent), this.b.getResources().getInteger(R.integer.trip_planner_eta_baseline_shift_from_stop)), length, spannableStringBuilder.length(), 17);
                                String str3 = q2.g;
                                if (str3 != null) {
                                    VehicleInfo vehicleInfo = new VehicleInfo(str3, q2.b);
                                    vehicleInfo.setStopId(leg2.direction_stop_id);
                                    vehicleInfo.setRouteId(leg2.route_id);
                                    Map<String, VehicleInfo> map = s;
                                    if (map != null) {
                                        map.put(str3, vehicleInfo);
                                    }
                                }
                                Map<String, Integer> map2 = this.m;
                                if (map2 == null || !map2.containsKey(str3)) {
                                    imageView4 = imageView;
                                    imageView3 = imageView2;
                                    imageView3.setVisibility(8);
                                    imageView4.setVisibility(8);
                                } else {
                                    int intValue = this.m.get(str3).intValue();
                                    if (intValue == -1) {
                                        imageView4 = imageView;
                                        imageView3 = imageView2;
                                        imageView3.setVisibility(8);
                                        imageView4.setVisibility(8);
                                    } else if (!ui1.e0()) {
                                        imageView4 = imageView;
                                        imageView3 = imageView2;
                                        imageView3.setVisibility(8);
                                        imageView4.setVisibility(0);
                                        imageView4.setImageResource(vn.v0(intValue));
                                    } else if (z) {
                                        imageView4 = imageView;
                                        imageView4.setVisibility(8);
                                        imageView3 = imageView2;
                                        imageView3.setVisibility(0);
                                        imageView3.setImageResource(vn.v0(intValue));
                                    } else {
                                        imageView4 = imageView;
                                        imageView3 = imageView2;
                                        imageView3.setVisibility(8);
                                        imageView4.setVisibility(0);
                                        imageView4.setImageResource(vn.v0(intValue));
                                    }
                                }
                            } else {
                                textView3 = textView2;
                                imageView4 = imageView;
                                imageView3 = imageView2;
                                z2 = z4;
                                imageView3.setVisibility(8);
                                imageView4.setVisibility(8);
                            }
                        } else {
                            textView3 = textView2;
                            imageView4 = imageView;
                            z2 = z4;
                            i4 = i6;
                            imageView3 = imageView2;
                            spannableStringBuilder.replace(length, i5, (CharSequence) "");
                        }
                        textView5 = textView3;
                        z4 = z2;
                    } else {
                        textView3 = textView4;
                        z = z3;
                        i4 = i6;
                        imageView4 = imageView5;
                        imageView3 = imageView6;
                    }
                    i8 += leg2.end_time - leg2.start_time;
                    i7++;
                    textView4 = textView3;
                    imageView5 = imageView4;
                    imageView6 = imageView3;
                    z3 = z;
                    i6 = i4;
                    aVar2 = aVar;
                }
                String str4 = " tripPlannerstopBased setFrom: builder =" + ((Object) spannableStringBuilder) + "xxx";
                if (!ui1.e0()) {
                    if (spannableStringBuilder.length() > 0) {
                        textView.setText(spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1));
                    }
                    textView.setVisibility(0);
                    textView5.setVisibility(8);
                } else if (!z3) {
                    if (spannableStringBuilder.length() > 0) {
                        textView.setText(spannableStringBuilder.subSequence(0, spannableStringBuilder.length()));
                        textView.setVisibility(0);
                        i3 = 8;
                    } else {
                        i3 = 8;
                        textView.setVisibility(8);
                    }
                    textView5.setVisibility(i3);
                } else {
                    if (spannableStringBuilder.length() > 0) {
                        textView5.setText(spannableStringBuilder.subSequence(0, spannableStringBuilder.length()));
                        textView5.setVisibility(0);
                    } else {
                        textView5.setVisibility(8);
                    }
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
                textView4.setVisibility(8);
            }
        } else {
            textView.setVisibility(8);
            textView4.setVisibility(8);
            imageView6.setVisibility(8);
        }
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void b() {
        qb1 qb1 = this.g;
        if (qb1 != null) {
            qb1.b();
        }
        jz5.b().o(this);
        this.m = null;
        s = null;
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void c(FlexboxLayout flexboxLayout) {
        String str;
        Map<String, RouteLevelAvailability> G;
        if (b.TRIPPLANNER.equals(this.d)) {
            flexboxLayout.removeAllViews();
            int i2 = 0;
            boolean z = true;
            while (i2 < this.f3755a.legs.size()) {
                Leg leg = this.f3755a.legs.get(i2);
                boolean z2 = i2 < this.f3755a.legs.size() - 1;
                boolean z3 = z && LegMode.BUS.equals(this.f3755a.legs.get(i2).mode);
                LayoutInflater from = LayoutInflater.from(this.b);
                RouteLevelAvailability routeLevelAvailability = null;
                View inflate = from.inflate(R.layout.trip_sequence_layout, (ViewGroup) null, false);
                if (z3) {
                    if (ui1.e0()) {
                        View inflate2 = from.inflate(R.layout.trip_sequence_layout_via_routes, (ViewGroup) null, false);
                        String p2 = ui1.p(leg.route_name);
                        if (p2 == null) {
                            inflate2.findViewById(R.id.via).setVisibility(8);
                        } else {
                            ((TextView) inflate2.findViewById(R.id.via)).setText(p2);
                        }
                        String o2 = ui1.o(leg.route_name);
                        if (o2 != null) {
                            TextView textView = (TextView) inflate2.findViewById(R.id.to_stop);
                            textView.setText(o2);
                            Context context = this.b;
                            CalligraphyUtils.applyFontToTextView(context, textView, context.getString(R.string.font_medium));
                        }
                        inflate = inflate2;
                    } else {
                        inflate.findViewById(R.id.via).setVisibility(8);
                        ((TextView) inflate.findViewById(R.id.to_stop)).setText(leg.route_name);
                    }
                    inflate.findViewById(R.id.to_via_container).setVisibility(0);
                } else {
                    inflate.findViewById(R.id.to_via_container).setVisibility(8);
                }
                ((ImageView) inflate.findViewById(R.id.mode_icon)).setImageResource(vn.X(leg.mode));
                LegMode legMode = leg.mode;
                LegMode legMode2 = LegMode.BUS;
                if (!(!legMode.equals(legMode2) || (str = leg.availabilityLevel) == null || (G = xt.f3961a.c().G()) == null)) {
                    if (G.containsKey(str)) {
                        routeLevelAvailability = G.get(str);
                    }
                    if (routeLevelAvailability != null) {
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.disruption_icon);
                        if (routeLevelAvailability.isDisruption() == 0) {
                            imageView.setVisibility(8);
                        } else {
                            String imageUrl = routeLevelAvailability.getImageUrl();
                            if (!TextUtils.isEmpty(imageUrl)) {
                                ml1<Drawable> p3 = gl1.f(this.b).p(imageUrl);
                                p3.a(new rs1().j(d71.c(routeLevelAvailability.isDisruption())));
                                p3.e(imageView);
                            }
                            imageView.setVisibility(0);
                        }
                    }
                }
                if (!z2) {
                    inflate.findViewById(R.id.separator).setVisibility(8);
                }
                flexboxLayout.addView(inflate);
                if (legMode2.equals(this.f3755a.legs.get(i2).mode)) {
                    z = false;
                }
                i2++;
            }
            flexboxLayout.setVisibility(0);
            return;
        }
        flexboxLayout.setVisibility(8);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void d(TextView textView) {
        if (this.f) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void e(TextView textView) {
        textView.setVisibility(8);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void f(TextView textView) {
        if (!this.d.equals(b.SCHEDULER)) {
            textView.setVisibility(8);
            return;
        }
        int i2 = this.f3755a.number_of_transfers;
        if (i2 == 0) {
            textView.setVisibility(8);
        } else if (i2 == 1) {
            StringBuilder i0 = hj1.i0("1 ");
            i0.append(this.b.getResources().getString(R.string.scheduler_single_change));
            textView.setText(i0.toString());
        } else {
            textView.setText(i2 + this.b.getResources().getString(R.string.changes));
        }
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public View.OnClickListener g() {
        return this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0370  */
    @Override // app.zophop.ui.views.SummaryView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(android.widget.TextView r22, defpackage.ii1.a r23, int r24) {
        /*
        // Method dump skipped, instructions count: 920
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wb1.h(android.widget.TextView, ii1$a, int):void");
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void i(TextView textView, View view) {
        textView.setVisibility(8);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void j(TextView textView) {
        textView.setVisibility(0);
        if (b.TRIPPLANNER.equals(this.d)) {
            Iterator<Leg> it = this.f3755a.legs.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                Leg next = it.next();
                if (!next.mode.equals(LegMode.WALK) && !next.mode.equals(LegMode.AUTO) && next.mode.equals(LegMode.BUS)) {
                    i2++;
                }
                if (!next.mode.equals(LegMode.BUS)) {
                    i3++;
                }
            }
            if (i2 == 1 && i3 == 0) {
                textView.setText(R.string.btn_text_track_bus);
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.track_bus, 0, 0, 0);
                return;
            }
            textView.setText(R.string.btn_text_see_directions);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.navigate_trip, 0, 0, 0);
        }
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void k(TextView textView) {
        if (b.TRIPPLANNER.equals(this.d)) {
            textView.setText(jh1.k((long) (((int) this.f3755a.time_taken) * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
            return;
        }
        int D = ui1.D(this.f3755a.fares);
        if (this.f3755a.inCompleteFare || D == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(ui1.H() + D);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void l(LinearLayout linearLayout) {
        if (ui1.e0()) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void m(TextView textView) {
        if (b.SCHEDULER.equals(this.d)) {
            textView.setText(jh1.k((long) (ii1.r(this.f3755a) * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
        } else if (b.TRIPPLANNER.equals(this.d)) {
            int D = ui1.D(this.f3755a.fares);
            if (this.f3755a.inCompleteFare || D == 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(ui1.H() + ui1.D(this.f3755a.fares));
        } else {
            textView.setText(jh1.k((long) (((int) this.f3755a.time_taken) * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
        }
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void n(TextView textView) {
        String str;
        ArrayList<Leg> arrayList = this.f3755a.legs;
        if (b.TRIPPLANNER.equals(this.d)) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Leg leg = arrayList.get(i2);
                if (r(leg.mode)) {
                    if (!z) {
                        z = true;
                    } else {
                        String p0 = vn.p0(leg.start_place_name);
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(p0);
                    }
                }
            }
            str = sb.length() > 0 ? String.format(this.b.getResources().getString(R.string.change_at), sb.toString()) : null;
        } else if (arrayList.size() == 1) {
            str = this.b.getResources().getString(R.string.direct_trip);
        } else {
            StringBuilder sb2 = new StringBuilder(arrayList.get(1).start_place_name);
            for (int i3 = 2; i3 < arrayList.size(); i3++) {
                Leg leg2 = arrayList.get(i3);
                if (LegMode.isTrainish(leg2.mode) || LegMode.BUS.equals(leg2.mode)) {
                    String p02 = vn.p0(leg2.start_place_name);
                    sb2.append(", ");
                    sb2.append(p02);
                }
            }
            str = String.format(this.b.getResources().getString(R.string.change_at), sb2.toString());
        }
        if (str == null || ui1.e0()) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public boolean o() {
        return false;
    }

    public void onEvent(nn0.a aVar) {
        if (aVar != null) {
            jz5.b().m(aVar);
        }
    }

    @Override // app.zophop.ui.views.SummaryView.a
    public void p(TextView textView) {
        if (this.e) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    public final i10 q(ii1.a aVar, int i2) {
        if (aVar == null) {
            return null;
        }
        List<i10> list = aVar.b;
        if (aVar.f1519a != Integer.MAX_VALUE) {
            int i3 = 0;
            while (list != null && i3 < list.size()) {
                if (list.get(i3).f1460a > i2) {
                    return list.get(i3);
                }
                i3++;
            }
        }
        return null;
    }

    public final boolean r(LegMode legMode) {
        return !legMode.equals(LegMode.WALK) && !legMode.equals(LegMode.AUTO);
    }

    public void onEvent(SeatAvailabilityStatusEvent seatAvailabilityStatusEvent) {
        if (seatAvailabilityStatusEvent.getResponseType().equals(ad1.SUCCESS)) {
            List<SeatInfo> seatInfoList = seatAvailabilityStatusEvent.getSeatInfoList();
            xt.t1 t1Var = xt.f3961a;
            this.m = t1Var.Z().d(seatInfoList, this.m);
            t1Var.Z().c(seatInfoList, "Trip Planner");
            if (this.p) {
                a(this.i, this.l, this.j, this.k, this.n, this.o);
            }
        }
    }
}
