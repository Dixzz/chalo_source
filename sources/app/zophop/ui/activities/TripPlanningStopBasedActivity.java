package app.zophop.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import app.zophop.R;
import app.zophop.models.Favourites.FavType;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Stop;
import app.zophop.models.StopTripRequest;
import app.zophop.models.TransitMode;
import app.zophop.models.TripRequest;
import app.zophop.models.UniversalSearchItem;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerInputLocationChangedEvent;
import app.zophop.pubsub.eventbus.events.UniversalSearchResponseEvent;
import app.zophop.ui.views.collapse_on_scroll.CollapseOnScrollViewPager;
import app.zophop.utilities.external.loader_view.LoadingSpinnerView;
import app.zophop.utilities.ui.views.sliding_tabs.HorizontalTabScrollWithViewPager;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.android.gms.maps.model.LatLng;
import defpackage.nn0;
import defpackage.sm0;
import defpackage.ut;
import io.github.inflationx.calligraphy3.TypefaceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class TripPlanningStopBasedActivity extends au {
    public static String z;
    @InjectView(R.id.clear_from_location)
    public ImageView _clearFromStopImageView;
    @InjectView(R.id.clear_to_location)
    public ImageView _clearToStopImageView;
    @InjectView(R.id.collpase_view)
    public CollapseOnScrollViewPager _collaspeScrollView;
    @InjectView(R.id.from_location_loading_spinner)
    public LoadingSpinnerView _fromStopLoadingSpinner;
    @InjectView(R.id.input_from)
    public EditText _inputFrom;
    @InjectView(R.id.input_to)
    public EditText _inputTo;
    @InjectView(R.id.pages)
    public ViewPager _pages;
    @InjectView(R.id.preference_hook)
    public RelativeLayout _preferenceHook;
    @InjectView(R.id.shadow_above_stop_picker_results)
    public View _shadowAboveStopResultsListView;
    @InjectView(R.id.stop_picker_results_container)
    public FrameLayout _stopPickerResultsContainer;
    @InjectView(R.id.stop_results_list_view)
    public ListView _stopResultsListView;
    @InjectView(R.id.swap_planner_button)
    public ImageButton _swapPlannerButton;
    @InjectView(R.id.tabs)
    public HorizontalTabScrollWithViewPager _tabs;
    @InjectView(R.id.time_container)
    public RelativeLayout _timeContainer;
    @InjectView(R.id.scheduler_time)
    public TextView _timeView;
    @InjectView(R.id.to_location_loading_spinner)
    public LoadingSpinnerView _toStopLoadingSpinner;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public Stop o;
    public Stop p;
    public TripRequest q;
    public int r = -1;
    public boolean s;
    public tk0 t;
    public bj0 u;
    public ih1 v;
    public boolean w;
    public boolean x;
    public p5 y;

    public static void h0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity, String str, LoadingSpinnerView loadingSpinnerView, ImageView imageView, boolean z2) {
        Objects.requireNonNull(tripPlanningStopBasedActivity);
        ui1.t0("universalSearchTried");
        if (str.length() != 0) {
            tripPlanningStopBasedActivity._stopResultsListView.setDividerHeight(0);
            tripPlanningStopBasedActivity._stopResultsListView.setAdapter((ListAdapter) tripPlanningStopBasedActivity.t);
            imageView.setVisibility(0);
            loadingSpinnerView.setVisibility(0);
            ih1 ih1 = tripPlanningStopBasedActivity.v;
            ng0 ng0 = new ng0(tripPlanningStopBasedActivity, str, z2);
            ih1.removeCallbacksAndMessages(null);
            ih1.postDelayed(ng0, ih1.f1518a);
            return;
        }
        tripPlanningStopBasedActivity.v0(imageView, loadingSpinnerView);
    }

    public static void i0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity, boolean z2) {
        bj0 bj0 = tripPlanningStopBasedActivity.u;
        if (bj0 != null) {
            bj0.q = z2;
        }
        tk0 tk0 = tripPlanningStopBasedActivity.t;
        if (tk0 != null) {
            tk0.l = z2;
        }
    }

    public static boolean j0(TripPlanningStopBasedActivity tripPlanningStopBasedActivity, EditText editText) {
        Objects.requireNonNull(tripPlanningStopBasedActivity);
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            return false;
        }
        return true;
    }

    public static void r0(Activity activity, Stop stop, Stop stop2, String str) {
        Intent intent = new Intent(activity, TripPlanningStopBasedActivity.class);
        if (stop != null) {
            intent.putExtra("extra:from", stop.toJSON());
        }
        if (stop2 != null) {
            intent.putExtra("extra:to", stop2.toJSON());
        }
        intent.putExtra("extra:source", str);
        activity.startActivity(intent);
    }

    public static void w0(ed1 ed1, String str, boolean z2, String str2, boolean z3, boolean z4) {
        if (str2 != null) {
            ed1.a("length", Integer.valueOf(str2.length()));
        }
        ed1.a("itemType", str);
        ed1.a("fromRecentList", String.valueOf(z3));
        ed1.a("isPopularRoute", String.valueOf(z4));
        if (!z3 && !z4) {
            ed1.a("searchString", str2);
        }
        StringBuilder i0 = hj1.i0("");
        i0.append(jh1.j(System.currentTimeMillis()));
        ed1.a("hourOfEvent", i0.toString());
        ed1.a("networkStatus", String.valueOf(z2));
        jz5.b().g(ed1);
        ui1.t0("universalSearchUsed");
    }

    public static void x0(TextView textView, String str, Context context) {
        if (str != null) {
            SpannableStringBuilder f = hj1.f(str);
            int length = f.length();
            f.setSpan(new AbsoluteSizeSpan(14, true), length, f.length(), 17);
            f.setSpan(TypefaceUtils.getSpan(TypefaceUtils.load(context.getAssets(), "fonts/NotoSans-Regular.ttf")), length, f.length(), 17);
            textView.setText(f);
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.trip_planning_stop_based_screen);
        ButterKnife.inject(this);
        jz5.b().l(TripPlannerInputLocationChangedEvent.class);
        this.r = ui1.N();
        ui1.z0(this, "tripPlannerPreferences");
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().z(getString(R.string.find_my_bus));
        this.y = new p5(this);
        this.r = ui1.N();
        Intent intent = getIntent();
        if (!new g30(intent).a()) {
            String stringExtra = intent.getStringExtra("extra:from");
            String stringExtra2 = intent.getStringExtra("extra:to");
            z = intent.getStringExtra("extra:source");
            if (stringExtra != null) {
                this.o = Stop.fromJson(stringExtra);
            }
            if (stringExtra2 != null) {
                this.p = Stop.fromJson(stringExtra2);
            }
            if (n0(this.o) || n0(this.p)) {
                this.o = null;
                this.p = null;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("fromStop");
            if (string != null) {
                this.o = Stop.fromJson(string);
            }
            String string2 = bundle.getString("toStop");
            if (string2 != null) {
                this.p = Stop.fromJson(string2);
            }
            if (n0(this.o) || n0(this.p)) {
                this.o = null;
                this.p = null;
            }
        }
        this.v = new ih1(Looper.getMainLooper(), 500);
        this._collaspeScrollView.setScrollable(false);
        this._inputFrom.setOnTouchListener(new tg0(this));
        this._inputTo.setOnTouchListener(new ug0(this));
        vg0 vg0 = new vg0(this);
        wg0 wg0 = new wg0(this);
        this._timeContainer.setOnClickListener(vg0);
        this._preferenceHook.setOnClickListener(wg0);
        ImageView imageView = this._clearFromStopImageView;
        imageView.setOnClickListener(new kg0(this, imageView, this._inputFrom, this._fromStopLoadingSpinner));
        ImageView imageView2 = this._clearToStopImageView;
        imageView2.setOnClickListener(new kg0(this, imageView2, this._inputTo, this._toStopLoadingSpinner));
        this._swapPlannerButton.setOnClickListener(new jg0(this));
        Stop stop = this.o;
        if (stop != null) {
            x0(this._inputFrom, stop.getName(), this);
        } else {
            this._inputFrom.setHint(getString(R.string.hint_start_stop));
        }
        Stop stop2 = this.p;
        if (stop2 != null) {
            x0(this._inputTo, stop2.getName(), this);
        } else {
            this._inputTo.setHint(getString(R.string.hint_end_stop));
        }
        int i = this.r;
        if (i == -1) {
            i = ui1.N();
        }
        this.r = i;
        this._timeView.setText(jh1.g((long) i));
        this._inputFrom.addTextChangedListener(new lg0(this));
        this._inputTo.addTextChangedListener(new mg0(this));
        m0();
        this.u = new bj0(this, TransitMode.bus, new pg0(this), null, new qg0(this), new rg0(this), RouteStoreType.RECENT, "universal screen");
        this.t = new tk0(this, new qg0(this), new rg0(this), new sg0(this), new og0(this));
        if (k0()) {
            u0();
        } else {
            p0();
            l0(this._inputFrom);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cityName", xt.f3961a.k().d().getName());
        hashMap.put("source", z);
        t0("stop based tripPlanner opened", hashMap);
    }

    public final boolean k0() {
        return (this.o == null || this.p == null) ? false : true;
    }

    public final void l0(EditText editText) {
        if (TextUtils.isEmpty(editText.getText())) {
            if (editText.equals(this._inputFrom)) {
                y0(true);
                v0(this._clearFromStopImageView, this._fromStopLoadingSpinner);
            } else {
                y0(false);
                v0(this._clearToStopImageView, this._toStopLoadingSpinner);
            }
            editText.requestFocus();
            if (editText.equals(this._inputFrom)) {
                this.w = true;
            } else {
                this.x = true;
            }
            getWindow().setSoftInputMode(4);
        }
    }

    public final void m0() {
        if (vn.K0(this)) {
            e0();
            this.s = false;
        } else if (!this.s) {
            this.s = f0(this._stopResultsListView);
        }
    }

    public final boolean n0(Stop stop) {
        boolean z2;
        if (stop == null) {
            return true;
        }
        LatLng latLong = stop.getLatLong();
        String name = stop.getName();
        if (latLong == null) {
            xt.f3961a.B().e(new md1(name, null));
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || xt.f3961a.k().d().containsLocation(latLong)) {
            return false;
        }
        Toast.makeText(this, getString(R.string.location_outside_city_toast), 0).show();
        return true;
    }

    public final void o0(boolean z2) {
        if (z2) {
            this._fromStopLoadingSpinner.setVisibility(8);
        } else {
            this._toStopLoadingSpinner.setVisibility(8);
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (!xt.f3961a.G().d(getFragmentManager(), "tripPlannerScreen", TripPlanningStopBasedActivity.class.getSimpleName())) {
            if (!this.m || !this.n) {
                ui1.F0(this.y);
                super.onBackPressed();
                return;
            }
            q0();
        }
    }

    public void onEvent(nn0.a aVar) {
        if (aVar != null) {
            int i = ((aVar.f2577a * 60) + aVar.b) * 60;
            this.r = i;
            this._timeView.setText(jh1.g((long) i));
        }
    }

    public void onEventMainThread(UniversalSearchResponseEvent universalSearchResponseEvent) {
        universalSearchResponseEvent.getSearchQuery();
        String requestId = universalSearchResponseEvent.getRequestId();
        ut.a aVar = ut.f3552a;
        if (requestId != null) {
            if (requestId.equals(this.k)) {
                o0(true);
            } else if (requestId.equals(this.l)) {
                o0(false);
            }
        }
        tk0 tk0 = this.t;
        tk0.g.g = universalSearchResponseEvent.getResponseType();
        tk0.f(universalSearchResponseEvent.getItemList(), universalSearchResponseEvent.getSearchQuery());
        this.t.e(false);
        ed1 ed1 = new ed1("Search results shown", Long.MIN_VALUE);
        ed1.a("loadingTime", String.valueOf(universalSearchResponseEvent.getQueryTimeMillis()));
        ed1.a("queryString", universalSearchResponseEvent.getSearchQuery());
        ed1.a("queryLength", Integer.valueOf(universalSearchResponseEvent.getSearchQuery().length()));
        if (universalSearchResponseEvent.getResponseType().equals(TripPlannerEvent.ResponseType.FAILED)) {
            ed1.a("error message", universalSearchResponseEvent.getErrorMessage());
        } else if (universalSearchResponseEvent.getItemList().size() > 0) {
            ed1.a("result shown", "true");
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < universalSearchResponseEvent.getItemList().size(); i6++) {
                int ordinal = universalSearchResponseEvent.getItemList().get(i6).getType().ordinal();
                if (ordinal == 0) {
                    i++;
                } else if (ordinal == 1) {
                    i2++;
                } else if (ordinal == 2) {
                    i3++;
                } else if (ordinal == 3) {
                    i5++;
                } else if (ordinal == 4) {
                    i4++;
                }
            }
            ed1.a(UniversalSearchItem.UniversalSearchItemType.LOCATION.toString(), Integer.valueOf(i));
            ed1.a(UniversalSearchItem.UniversalSearchItemType.STOP.toString(), Integer.valueOf(i2));
            ed1.a(UniversalSearchItem.UniversalSearchItemType.ROUTE.toString(), Integer.valueOf(i3));
            ed1.a(UniversalSearchItem.UniversalSearchItemType.TRIPS_LOCATIONS.toString(), Integer.valueOf(i4));
            ed1.a(UniversalSearchItem.UniversalSearchItemType.TRIPS_STOPS.toString(), Integer.valueOf(i5));
        } else {
            ed1.a("result shown", "false");
        }
        jz5.b().g(ed1);
        jz5.b().m(universalSearchResponseEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        if (!this.m || !this.n) {
            ui1.F0(this.y);
            finish();
            return true;
        }
        q0();
        return true;
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        xt.f3961a.G().n();
        super.onPause();
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        xt.f3961a.G().h("tripPlannerScreen", getFragmentManager(), TripPlanningStopBasedActivity.class.getSimpleName());
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        Stop stop = this.o;
        if (stop != null) {
            bundle.putString("fromStop", stop.toJSON());
        }
        Stop stop2 = this.p;
        if (stop2 != null) {
            bundle.putString("toStop", stop2.toJSON());
        }
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        xt.f3961a.G().k();
    }

    public final void p0() {
        this.n = true;
        findViewById(R.id.dummyView).setVisibility(8);
        if (this._stopPickerResultsContainer.getVisibility() == 8) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom_up);
            this._stopPickerResultsContainer.startAnimation(loadAnimation);
            this._shadowAboveStopResultsListView.startAnimation(loadAnimation);
            this._shadowAboveStopResultsListView.setVisibility(0);
            this._stopPickerResultsContainer.setVisibility(0);
        }
        this._collaspeScrollView.setScrollable(false);
    }

    public final void q0() {
        this.n = false;
        findViewById(R.id.dummyView).setVisibility(0);
        if (this._stopPickerResultsContainer.getVisibility() == 0) {
            this._stopPickerResultsContainer.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_up_bottom));
            this._stopPickerResultsContainer.setVisibility(8);
            this._shadowAboveStopResultsListView.setVisibility(8);
        }
        this._pages.setVisibility(0);
        this._tabs.setVisibility(0);
        this._collaspeScrollView.setScrollable(true);
    }

    /* JADX WARN: Incorrect args count in method signature: (Ljava/util/List<Ll90;>;)V */
    public final void s0() {
        this._pages.setCurrentItem(0);
    }

    public final void t0(String str, Map<String, String> map) {
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ed1.a(entry.getKey(), entry.getValue());
        }
        jz5.b().g(ed1);
    }

    public final void u0() {
        if (k0()) {
            EditText editText = this._inputFrom;
            if (editText != null) {
                editText.requestFocus();
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this._inputFrom.getWindowToken(), 0);
                this._inputFrom.clearFocus();
            }
            EditText editText2 = this._inputTo;
            if (editText2 != null) {
                editText2.clearFocus();
            }
            ImageView imageView = this._clearFromStopImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            LoadingSpinnerView loadingSpinnerView = this._fromStopLoadingSpinner;
            if (loadingSpinnerView != null) {
                loadingSpinnerView.setVisibility(8);
            }
            ImageView imageView2 = this._clearToStopImageView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            LoadingSpinnerView loadingSpinnerView2 = this._toStopLoadingSpinner;
            if (loadingSpinnerView2 != null) {
                loadingSpinnerView2.setVisibility(8);
            }
            if (k0()) {
                this.m = true;
                jz5.b().l(sm0.b.class);
                jz5.b().l(nn0.a.class);
                this.q = new StopTripRequest(this.o, this.p, this.r);
                if (k0()) {
                    jz5.b().i(new TripPlannerInputLocationChangedEvent(TripPlannerInputLocationChangedEvent.RESPONSE_TYPE.TRIP_REQUEST, this.q));
                }
                if (k0()) {
                    xt.f3961a.i0().a(new StopBasedTripFavourite(FavType.STOP_BASED_TRIP, UUID.randomUUID().toString(), TransitMode.bus, System.currentTimeMillis(), RouteStoreType.RECENT, this.o, this.p));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("cityName", xt.f3961a.k().d().getName());
                hashMap.put("origin stop", this.o.getName());
                hashMap.put("destination stop", this.p.getName());
                t0("stop based tripPlanner search done", hashMap);
            }
            q0();
            ArrayList arrayList = new ArrayList();
            arrayList.add(l90.DIRECT_BUSES);
            arrayList.add(l90.CONNECTING);
            this._collaspeScrollView.setResultTabItems(arrayList);
            this._pages.setAdapter(new ck0(getFragmentManager(), this, arrayList, this.q));
            this._tabs.setSelectedIndicatorColors(getResources().getColor(R.color.orange_primary));
            this._tabs.c(R.layout.trip_planner_tabs, R.id.tab_title);
            this._tabs.setViewPager(this._pages);
            s0();
            getSupportActionBar().z(getString(R.string.trip_planner_result_activity_label));
        }
    }

    public final void v0(ImageView imageView, LoadingSpinnerView loadingSpinnerView) {
        bj0 bj0 = this.u;
        bj0.l();
        bj0.notifyDataSetChanged();
        this._stopResultsListView.setAdapter((ListAdapter) this.u);
        this._stopResultsListView.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.universal_recent_divider_height));
        imageView.setVisibility(4);
        loadingSpinnerView.setVisibility(4);
    }

    public final void y0(boolean z2) {
        bj0 bj0 = this.u;
        if (bj0 != null) {
            bj0.q = z2;
        }
        tk0 tk0 = this.t;
        if (tk0 != null) {
            tk0.l = z2;
        }
    }

    public void onEvent(qd1 qd1) {
        m0();
    }
}
