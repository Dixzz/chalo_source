package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import app.zophop.R;
import app.zophop.models.AutoCabAggregatorInfo;
import app.zophop.models.AutoCabInfo;
import app.zophop.pubsub.eventbus.events.NearByCabTripEvent;
import app.zophop.ui.views.summary_card.LoaderView;
import com.google.android.gms.maps.model.LatLng;
import defpackage.oa1;
import defpackage.u00;
import defpackage.xt;

public class CabActivity extends au {
    public static final /* synthetic */ int t = 0;
    public LayoutInflater k;
    public LinearLayout l;
    public Toolbar m;
    public LoaderView n;
    public View o;
    public LatLng p;
    public View q;
    public k00 r;
    public p5 s;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        this.s = new p5(this);
        xt.t1 t1Var = xt.f3961a;
        this.r = t1Var.y();
        g30 g30 = new g30(getIntent());
        if (g30.a()) {
            if (g30.f1208a.containsKey("source")) {
                this.r.a("cabResultsScreen", g30.f1208a.get("source"), g30.f1208a.get("tag"));
            }
            this.s.b(h.R(this));
        }
        setContentView(R.layout.cab_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.m = toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().z(getString(R.string.nearby_cabs));
        getSupportActionBar().o(true);
        this.k = LayoutInflater.from(this);
        this.l = (LinearLayout) findViewById(R.id.card_container);
        this.n = (LoaderView) findViewById(R.id.loader);
        this.o = findViewById(R.id.cab_view);
        this.n.setRetryHandler(new ad0(this));
        this.q = findViewById(R.id.no_internet_banner);
        if (t1Var.g().c == null) {
            k0();
            return;
        }
        this.q.setVisibility(8);
        m0();
    }

    public final void h0(String str, View.OnClickListener onClickListener) {
        this.q.setVisibility(0);
        ((TextView) this.q.findViewById(R.id.settings_not_available_description)).setText(str);
        this.q.setOnClickListener(onClickListener);
    }

    public final boolean i0() {
        LatLng h = xt.f3961a.B().h();
        this.p = h;
        return h == null;
    }

    public final boolean j0() {
        u00.l lVar = xt.f3961a.g().c;
        if (lVar == null) {
            return false;
        }
        if (System.currentTimeMillis() - lVar.c <= 120000) {
            return true;
        }
        return false;
    }

    public final void k0() {
        xt.t1 t1Var = xt.f3961a;
        this.p = t1Var.B().h();
        n0();
        if ((System.currentTimeMillis() - t1Var.g().b > 1000) && vn.K0(this) && !i0()) {
            this.q.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            this.n.d();
            t1Var.g().i(this.p, true);
        }
    }

    public void l0(String str) {
        this.o.setVisibility(8);
        this.n.setVisibility(0);
        if (str.equals(getResources().getString(R.string.cab_failure_network))) {
            this.n.a();
        } else {
            this.n.b(R.drawable.alert_scheduler, str);
        }
    }

    public final void m0() {
        int i;
        int i2;
        this.o.setVisibility(0);
        int i3 = 8;
        this.n.setVisibility(8);
        u00.l lVar = xt.f3961a.g().c;
        boolean j0 = j0();
        this.l.removeAllViews();
        if (lVar != null) {
            LatLng latLng = lVar.b;
            boolean z = false;
            for (AutoCabAggregatorInfo autoCabAggregatorInfo : lVar.f3437a.getAutoCabs()) {
                if (autoCabAggregatorInfo.getAutoCabs().size() != 0) {
                    LinearLayout linearLayout = this.l;
                    CardView cardView = new CardView(this);
                    LinearLayout linearLayout2 = (LinearLayout) this.k.inflate(R.layout.cab_category_card, (ViewGroup) this.l, false);
                    int size = autoCabAggregatorInfo.getAutoCabs().size();
                    if (size != 0) {
                        xa1 xa1 = new xa1(this);
                        String aggregatorName = autoCabAggregatorInfo.getAggregatorName();
                        if (aggregatorName.equalsIgnoreCase("OLA")) {
                            i2 = R.string.ola;
                        } else {
                            i2 = (!aggregatorName.equalsIgnoreCase("UBER") && aggregatorName.equalsIgnoreCase("JUGNOO")) ? R.string.jugnoo : R.string.uber;
                        }
                        String string = getString(i2);
                        int u = ui1.u(autoCabAggregatorInfo.getAggregatorName());
                        ImageView imageView = (ImageView) xa1.findViewById(R.id.icon);
                        ((TextView) xa1.findViewById(R.id.title)).setText(string);
                        if (u == 0) {
                            imageView.setVisibility(i3);
                        } else {
                            imageView.setVisibility(0);
                            imageView.setImageResource(u);
                        }
                        linearLayout2.addView(xa1);
                        int i4 = 0;
                        while (i4 < size) {
                            int i5 = i4 == size + -1 ? 8 : 0;
                            String aggregatorName2 = autoCabAggregatorInfo.getAggregatorName();
                            AutoCabInfo autoCabInfo = autoCabAggregatorInfo.getAutoCabs().get(i4);
                            int i6 = lc1.f;
                            oa1 oa1 = new oa1(this, aggregatorName2, autoCabInfo, "cab activity", false);
                            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.cab_details, (ViewGroup) linearLayout2, false);
                            oa1.h((TextView) relativeLayout.findViewById(R.id.cab_subtype), null, -1);
                            oa1.e((TextView) relativeLayout.findViewById(R.id.next_cab_available));
                            oa1.e = new mf1(latLng);
                            relativeLayout.setOnClickListener(new oa1.a());
                            relativeLayout.findViewById(R.id.cab_divider).setVisibility(i5);
                            linearLayout2.addView(relativeLayout);
                            i4++;
                            size = size;
                        }
                        i = -1;
                        cardView.addView(linearLayout2);
                    } else {
                        i = -1;
                        cardView = null;
                    }
                    linearLayout.addView(cardView);
                    LinearLayout linearLayout3 = this.l;
                    View view = new View(this);
                    view.setLayoutParams(new LinearLayout.LayoutParams(i, (int) getResources().getDimension(R.dimen.home_screen_divider)));
                    linearLayout3.addView(view);
                    z = true;
                }
                i3 = 8;
            }
            if (!z) {
                l0(getString(R.string.cab_failure_no_cabs_available));
            }
        }
        n0();
        if (!j0) {
            k0();
        }
    }

    public final void n0() {
        if (!vn.K0(this)) {
            h0(getString(R.string.internet_unavailable), new gh1(this));
        } else if (i0()) {
            h0(getString(R.string.location_unavailable), new ri1(this));
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            intent.toString();
            intent.getStringExtra("result");
        }
        if (intent != null) {
            Bundle extras = intent.getExtras();
            for (String str : extras.keySet()) {
                Object obj = extras.get(str);
                if (obj != null) {
                    String.format("%s %s (%s)", str, obj, obj.getClass().getName());
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ui1.F0(this.s);
        super.onBackPressed();
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cab_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(NearByCabTripEvent nearByCabTripEvent) {
        int ordinal = nearByCabTripEvent.getResponseType().ordinal();
        if (ordinal == 0) {
            m0();
        } else if (ordinal == 1) {
            if (j0()) {
                m0();
            } else {
                l0(getString(R.string.cab_failure_network));
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            ui1.F0(this.s);
            return true;
        } else if (itemId != R.id.refresh) {
            return false;
        } else {
            k0();
            return true;
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

    public void onEvent(pd1 pd1) {
        m0();
    }

    public void onEvent(qd1 qd1) {
        m0();
    }
}
