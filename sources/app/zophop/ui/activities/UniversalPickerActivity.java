package app.zophop.ui.activities;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import app.zophop.R;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.TransitMode;
import app.zophop.models.UniversalSearchItem;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.pubsub.eventbus.events.DatabaseSyncEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import app.zophop.pubsub.eventbus.events.UniversalSearchResponseEvent;
import app.zophop.service.LocationTrackingService;
import java.util.HashMap;
import java.util.Objects;

public class UniversalPickerActivity extends tf1 {
    public static final /* synthetic */ int s = 0;
    public EditText j;
    public View k;
    public ListView l;
    public wk0 m;
    public bj0 n;
    public View o;
    public boolean p;
    public String q;
    public ih1 r;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            UniversalPickerActivity.h0(UniversalPickerActivity.this);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static void h0(UniversalPickerActivity universalPickerActivity) {
        Objects.requireNonNull(universalPickerActivity);
        ui1.t0("universalSearchTried");
        String trim = universalPickerActivity.j.getText().toString().trim();
        universalPickerActivity.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if (trim.length() != 0) {
            universalPickerActivity.l.setDividerHeight(0);
            universalPickerActivity.l.setAdapter((ListAdapter) universalPickerActivity.m);
            universalPickerActivity.o.setVisibility(0);
            universalPickerActivity.findViewById(R.id.loading_spinner).setVisibility(0);
            ih1 ih1 = universalPickerActivity.r;
            fh0 fh0 = new fh0(universalPickerActivity, trim);
            ih1.removeCallbacksAndMessages(null);
            ih1.postDelayed(fh0, ih1.f1518a);
            return;
        }
        bj0 bj0 = universalPickerActivity.n;
        bj0.l();
        bj0.notifyDataSetChanged();
        universalPickerActivity.l.setAdapter((ListAdapter) universalPickerActivity.n);
        universalPickerActivity.l.setDividerHeight(universalPickerActivity.getResources().getDimensionPixelSize(R.dimen.universal_recent_divider_height));
        universalPickerActivity.o.setVisibility(4);
        universalPickerActivity.findViewById(R.id.loading_spinner).setVisibility(4);
    }

    public static void k0(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        ed1 l2 = hj1.l("universal item clicked", Long.MIN_VALUE, "agency", str);
        l2.a("routeName", str2);
        l2.a(DigitalTripReceiptJsonKeys.KEY_START_STOP, str3);
        l2.a("isFreeRide", String.valueOf(z3));
        l0(l2, "route", z, str4, z2, false);
    }

    public static void l0(ed1 ed1, String str, boolean z, String str2, boolean z2, boolean z3) {
        if (str2 != null) {
            ed1.a("length", Integer.valueOf(str2.length()));
        }
        ed1.a("itemType", str);
        ed1.a("fromRecentList", String.valueOf(z2));
        ed1.a("isPopularRoute", String.valueOf(z3));
        if (!z2 && !z3) {
            ed1.a("searchString", str2);
        }
        StringBuilder i0 = hj1.i0("");
        i0.append(jh1.j(System.currentTimeMillis()));
        ed1.a("hourOfEvent", i0.toString());
        ed1.a("networkStatus", String.valueOf(z));
        jz5.b().g(ed1);
        ui1.t0("universalSearchUsed");
    }

    public void clear(View view) {
        this.j.setText((CharSequence) null);
        this.o.setVisibility(4);
        this.m.a();
        wk0 wk0 = this.m;
        z61 z61 = wk0.g;
        z61.f4136a = false;
        z61.i();
        z61 z612 = wk0.g;
        z612.h = false;
        z612.i();
        bj0 bj0 = this.n;
        bj0.l();
        bj0.notifyDataSetChanged();
        this.l.setAdapter((ListAdapter) this.n);
    }

    @Override // defpackage.tf1
    public void d0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        intentFilter.addAction("android.location.PROVIDER_CHANGED_ACTION");
        this.g = new fh1();
        he1 he1 = new he1();
        this.h = he1;
        registerReceiver(he1, intentFilter);
        registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        String str;
        getSupportActionBar().f();
        String stringExtra = getIntent().getStringExtra("extra:source");
        ed1 l2 = hj1.l("universal screen opened", Long.MIN_VALUE, "source", stringExtra);
        StringBuilder i0 = hj1.i0("");
        i0.append(jh1.j(System.currentTimeMillis()));
        l2.a("hourOfEvent", i0.toString());
        jz5.b().g(l2);
        zz zzVar = new zz("universal search clicked", new HashMap());
        zzVar.a("source", stringExtra);
        ui1.l0(zzVar);
        setContentView(R.layout.universal_picker_activity);
        this.n = new bj0(this, TransitMode.bus, new gh0(this), null, null, null, RouteStoreType.RECENT, "universal screen");
        this.m = new wk0(this, new eh0(this));
        this.k = findViewById(R.id.back);
        this.o = findViewById(R.id.location_clear);
        EditText editText = (EditText) findViewById(R.id.location_input);
        this.j = editText;
        vn.X0(this, editText);
        this.k.setOnClickListener(new hh0(this));
        this.o.setOnClickListener(new ih0(this));
        ListView listView = (ListView) findViewById(R.id.universal_list_view);
        this.l = listView;
        listView.setAdapter((ListAdapter) this.n);
        i0();
        j0();
        if (ui1.Y() || ui1.X()) {
            str = getString(R.string.universal_picker_hint_kochi);
        } else {
            str = getString(R.string.universal_picker_hint);
        }
        this.r = new ih1(Looper.getMainLooper(), 500);
        int intExtra = getIntent().getIntExtra("extra:search_color", R.color.black);
        this.j.setHint(str);
        this.j.setHintTextColor(getResources().getColor(intExtra));
        this.j.addTextChangedListener(new a());
    }

    @Override // defpackage.tf1
    public void g0() {
        if (!LocationTrackingService.l) {
            unregisterReceiver(this.g);
            unregisterReceiver(this.h);
        }
    }

    public final void i0() {
        if (vn.K0(this)) {
            e0();
            this.p = false;
        } else if (!this.p) {
            this.p = f0(this.l);
        }
    }

    public void j0() {
        findViewById(R.id.loading_spinner).setVisibility(8);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    public void onCreate(Bundle bundle) {
        getIntent().putExtra("extra:search_color", R.color.black_40);
        super.onCreate(bundle);
        ui1.g(this, xt.f3961a.z().b());
        e(bundle);
    }

    public void onEvent(qd1 qd1) {
        i0();
    }

    public void onEventMainThread(DatabaseSyncEvent databaseSyncEvent) {
        i0();
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStart() {
        super.onStart();
        bj0 bj0 = this.n;
        bj0.l();
        bj0.notifyDataSetChanged();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    public void upPressed(View view) {
        finish();
    }

    public void onEventMainThread(qd1 qd1) {
        i0();
    }

    public void onEventMainThread(od1 od1) {
        EditText editText = this.j;
        if (editText != null && od1.f2678a.equals(editText.getText().toString())) {
            findViewById(R.id.loading_spinner).setVisibility(8);
        }
    }

    public void onEventMainThread(UniversalSearchResponseEvent universalSearchResponseEvent) {
        String searchQuery = universalSearchResponseEvent.getSearchQuery();
        if (!TextUtils.isEmpty(searchQuery) && searchQuery.equals(this.q)) {
            wk0 wk0 = this.m;
            wk0.g.g = universalSearchResponseEvent.getResponseType();
            wk0.h(universalSearchResponseEvent.getItemList(), universalSearchResponseEvent.getSearchQuery());
            j0();
            this.m.f(false);
        }
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
}
