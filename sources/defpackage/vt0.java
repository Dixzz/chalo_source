package defpackage;

import android.app.Activity;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.AutoCabAggregatorInfo;
import app.zophop.models.AutoCabInfo;
import app.zophop.models.AutoCabResponse;
import app.zophop.models.LocationTripRequest;
import app.zophop.models.TripOptions;
import app.zophop.models.VehicleType;
import app.zophop.pubsub.eventbus.events.TripPlannerCabTripEvent;
import app.zophop.ui.fragments.ResultFragment;
import app.zophop.ui.views.SummaryView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: vt0  reason: default package */
/* compiled from: CabResultFragment */
public class vt0 extends ResultFragment {
    public AutoCabResponse r;
    public Map<String, AutoCabInfo> s;
    public Map<String, VehicleType> t;
    public List<String> u;

    @Override // app.zophop.ui.fragments.ResultFragment
    public void f() {
        this.m = false;
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void g() {
        this.m = true;
        this.r = null;
        this.s = null;
        this.l = null;
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void i(TripOptions tripOptions) {
        this.l = xt.f3961a.g().h(this.i);
        this.m = true;
        this.s = null;
        this.r = null;
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void l() {
        if (this.m) {
            o();
        } else if (this.r == null) {
            n();
        } else {
            q();
        }
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void m() {
        this._resultContainer.setVisibility(8);
        this._loader.b(R.drawable.alert_scheduler, getString(R.string.cab_failure_no_cabs_available));
        this._loader.c(true);
    }

    public void onEvent(TripPlannerCabTripEvent tripPlannerCabTripEvent) {
        String str;
        String.valueOf(tripPlannerCabTripEvent.getResponseType());
        if (this.m && (str = this.l) != null && str.equals(tripPlannerCabTripEvent.getRequestId())) {
            this.m = false;
            if (tripPlannerCabTripEvent.getResponseType().equals(ad1.SUCCESS)) {
                AutoCabResponse response = tripPlannerCabTripEvent.getResponse();
                this.r = response;
                HashMap hashMap = new HashMap();
                Iterator<AutoCabAggregatorInfo> it = response.getAutoCabs().iterator();
                while (true) {
                    AutoCabInfo autoCabInfo = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    AutoCabAggregatorInfo next = it.next();
                    String aggregatorName = next.getAggregatorName();
                    List<AutoCabInfo> autoCabs = next.getAutoCabs();
                    for (int i = 0; i < autoCabs.size(); i++) {
                        if (i == 0) {
                            autoCabInfo = autoCabs.get(i);
                        } else {
                            AutoCabInfo autoCabInfo2 = autoCabs.get(i);
                            if (autoCabInfo.getLowerFareAmount() >= autoCabInfo2.getLowerFareAmount()) {
                                autoCabInfo = autoCabInfo2;
                            }
                        }
                        hashMap.put(aggregatorName, autoCabInfo);
                    }
                }
                this.s = hashMap;
                ArrayList arrayList = new ArrayList();
                HashMap hashMap2 = new HashMap(hashMap);
                for (int i2 = 0; i2 < hashMap.size(); i2++) {
                    int i3 = Integer.MAX_VALUE;
                    String str2 = null;
                    for (String str3 : hashMap2.keySet()) {
                        int lowerFareAmount = ((AutoCabInfo) hashMap.get(str3)).getLowerFareAmount();
                        if (lowerFareAmount < i3) {
                            str2 = str3;
                            i3 = lowerFareAmount;
                        }
                    }
                    arrayList.add(str2);
                    hashMap2.remove(str2);
                }
                this.u = arrayList;
                AutoCabResponse autoCabResponse = this.r;
                HashMap hashMap3 = new HashMap();
                for (AutoCabAggregatorInfo autoCabAggregatorInfo : autoCabResponse.getAutoCabs()) {
                    hashMap3.put(autoCabAggregatorInfo.getAggregatorName(), autoCabAggregatorInfo.getVehicleType());
                }
                this.t = hashMap3;
                jz5.b().m(tripPlannerCabTripEvent);
            }
            l();
        }
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void p() {
        Map<String, AutoCabInfo> map;
        this._results.removeAllViews();
        if (this.r == null || (map = this.s) == null || map.size() <= 0) {
            m();
            return;
        }
        for (String str : this.u) {
            SummaryView summaryView = new SummaryView(getActivity());
            Activity activity = getActivity();
            AutoCabInfo autoCabInfo = this.s.get(str);
            this.t.get(str).toString();
            oa1 oa1 = new oa1(activity, str, autoCabInfo, "trip planner", true);
            oa1.f = (mf1) ((LocationTripRequest) this.i).getTo();
            oa1.e = (mf1) ((LocationTripRequest) this.i).getFrom();
            summaryView.a(oa1);
            CardView cardView = new CardView(getActivity());
            cardView.addView(summaryView);
            this._results.addView(cardView);
            ((LinearLayout.LayoutParams) cardView.getLayoutParams()).setMargins(0, 0, 0, this.k);
        }
    }
}
