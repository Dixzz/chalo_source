package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import app.zophop.models.TransitMode;
import app.zophop.models.VehicleInfo;
import app.zophop.models.http_response.TripSummary;
import app.zophop.ui.views.summary_card.CardItem;
import com.google.firebase.appindexing.Indexable;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: kk0  reason: default package */
/* compiled from: SchedulesAdapter */
public class kk0 extends BaseAdapter {
    public final Context f;
    public List<TripSummary> g;
    public final ci1<TripSummary> h;
    public final TransitMode i;
    public Map<String, j10> j;
    public Map<String, Integer> k;
    public final String l;

    /* renamed from: kk0$a */
    /* compiled from: SchedulesAdapter */
    public class a implements Comparator<TripSummary>, j$.util.Comparator {
        public a(kk0 kk0) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(TripSummary tripSummary, TripSummary tripSummary2) {
            return tripSummary.getArrivalTime() - tripSummary2.getArrivalTime();
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<TripSummary> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<TripSummary> thenComparing(java.util.Comparator<? super TripSummary> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: kk0$b */
    /* compiled from: SchedulesAdapter */
    public class b implements View.OnClickListener {
        public final /* synthetic */ int f;

        public b(int i) {
            this.f = i;
        }

        public void onClick(View view) {
            kk0 kk0 = kk0.this;
            kk0.h.a(kk0.b(this.f));
        }
    }

    /* renamed from: kk0$c */
    /* compiled from: SchedulesAdapter */
    public class c implements java.util.Comparator<TripSummary>, j$.util.Comparator {
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(TripSummary tripSummary, TripSummary tripSummary2) {
            TripSummary tripSummary3 = tripSummary;
            TripSummary tripSummary4 = tripSummary2;
            if (!kk0.this.j.containsKey(tripSummary3.getRouteId()) && !kk0.this.j.containsKey(tripSummary4.getRouteId())) {
                return ui1.h(tripSummary3, tripSummary4);
            }
            kk0 kk0 = kk0.this;
            Integer valueOf = Integer.valueOf(kk0.a(kk0, kk0.j, tripSummary3.getRouteId()));
            kk0 kk02 = kk0.this;
            return valueOf.intValue() - Integer.valueOf(kk0.a(kk02, kk02.j, tripSummary4.getRouteId())).intValue();
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<TripSummary> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<TripSummary> thenComparing(java.util.Comparator<? super TripSummary> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public kk0(Context context, List<TripSummary> list, ci1<TripSummary> ci1, TransitMode transitMode, String str) {
        TripSummary tripSummary;
        this.f = context;
        this.g = list;
        this.h = ci1;
        this.i = transitMode;
        if (TransitMode.bus.equals(transitMode)) {
            this.g.size();
            HashMap hashMap = new HashMap();
            for (TripSummary tripSummary2 : this.g) {
                String routeId = tripSummary2.getRouteId();
                if (hashMap.containsKey(routeId)) {
                    ((ArrayList) hashMap.get(routeId)).add(tripSummary2);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(tripSummary2);
                    hashMap.put(routeId, arrayList);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str2);
                if (arrayList3.size() == 1) {
                    tripSummary = (TripSummary) arrayList3.get(0);
                } else {
                    Iterator it = arrayList3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            TripSummary tripSummary3 = (TripSummary) it.next();
                            if (tripSummary3.isFrequencyTrip() && !ui1.S(tripSummary3)) {
                                tripSummary = tripSummary3;
                                break;
                            }
                        } else {
                            int binarySearch = Collections.binarySearch(arrayList3, new TripSummary(null, ui1.N(), null, null, null, null, null, false, null), new yi1());
                            tripSummary = (TripSummary) arrayList3.get(binarySearch < 0 ? ((arrayList3.size() * 2) + ((binarySearch + 1) * -1)) % arrayList3.size() : binarySearch);
                        }
                    }
                }
                arrayList2.add(tripSummary);
            }
            this.g = arrayList2;
            arrayList2.size();
            Collections.sort(this.g, new zi1());
        }
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = str;
    }

    public static int a(kk0 kk0, Map map, String str) {
        Objects.requireNonNull(kk0);
        if (!map.containsKey(str)) {
            return Integer.MAX_VALUE;
        }
        j10 j10 = (j10) map.get(str);
        if (j10.a() != Integer.MAX_VALUE) {
            return j10.a();
        }
        return j10.b().get(0).e;
    }

    public TripSummary b(int i2) {
        return this.g.get(i2);
    }

    public int c(int i2) {
        int binarySearch = Collections.binarySearch(this.g, new TripSummary(null, i2, null, null, null, null, null, false, null), new a(this));
        if (binarySearch < 0) {
            binarySearch = ((this.g.size() * 2) + ((binarySearch + 1) * -1)) % this.g.size();
        }
        if (ui1.S(b(binarySearch))) {
            return 0;
        }
        return binarySearch;
    }

    public boolean d(Map<String, j10> map, Map<String, VehicleInfo> map2) {
        this.j = map;
        Collections.sort(this.g, new c());
        notifyDataSetChanged();
        boolean z = false;
        for (TripSummary tripSummary : this.g) {
            String routeId = tripSummary.getRouteId();
            if (this.j.containsKey(routeId)) {
                List<i10> c2 = this.j.get(routeId).c();
                if (c2.size() != 0) {
                    String str = c2.get(0).g;
                    long j2 = c2.get(0).b;
                    if (str != null) {
                        z = true;
                        VehicleInfo vehicleInfo = new VehicleInfo(str, j2);
                        vehicleInfo.setRouteId(routeId);
                        vehicleInfo.setStopId(tripSummary.getDirectionStop().getId());
                        map2.put(str, vehicleInfo);
                    }
                }
            }
        }
        return z;
    }

    public int getCount() {
        List<TripSummary> list = this.g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int i2) {
        return this.g.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        TripSummary tripSummary = this.g.get(i2);
        String routeId = tripSummary.getRouteId();
        if (view == null) {
            view = y61.d(tripSummary, this.i, this.f);
        } else {
            ((CardItem) view).setContent(y61.a(tripSummary, this.i, this.f));
        }
        if (this.j.containsKey(routeId)) {
            CardItem cardItem = (CardItem) view;
            TextView timeView = cardItem.getTimeView();
            List<i10> c2 = this.j.get(routeId).c();
            if (c2.size() != 0) {
                int i3 = c2.get(0).f1460a;
                String str = c2.get(0).g;
                ui1.H0(timeView, ii1.d((long) (i3 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL), this.f), this.f, 2);
                ImageView seatAvailabilityIconView = cardItem.getSeatAvailabilityIconView();
                if (this.k.containsKey(str)) {
                    int intValue = this.k.get(str).intValue();
                    if (intValue != -1) {
                        seatAvailabilityIconView.setVisibility(0);
                        seatAvailabilityIconView.setImageResource(vn.v0(intValue));
                    } else {
                        seatAvailabilityIconView.setVisibility(8);
                    }
                } else {
                    seatAvailabilityIconView.setVisibility(8);
                }
            } else {
                ui1.G0(timeView, this.j.get(routeId).b().get(0), this.f);
                cardItem.getSeatAvailabilityIconView().setVisibility(8);
            }
            ui1.s0(this.l, "stop routes screen", tripSummary.getRouteName());
        } else {
            CardItem cardItem2 = (CardItem) view;
            cardItem2.getScheduledTimeView().setVisibility(8);
            cardItem2.getSeatAvailabilityIconView().setVisibility(8);
        }
        if (!ui1.S(tripSummary) || this.j.containsKey(routeId)) {
            view.setAlpha(1.0f);
        } else if (ui1.g0(tripSummary)) {
            view.setAlpha(0.4f);
        }
        view.setOnClickListener(new b(i2));
        return view;
    }

    public boolean isEnabled(int i2) {
        return true;
    }
}
