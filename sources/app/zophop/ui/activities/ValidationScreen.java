package app.zophop.ui.activities;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import defpackage.j50;
import defpackage.ut;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class ValidationScreen extends au implements g90, j50.a {
    public static final /* synthetic */ int u = 0;
    public FragmentManager k;
    public Handler l;
    public long m;
    public Runnable n;
    public a o;
    public MTicket p;
    public MPass q;
    public ScanPayTicket r;
    public String s;
    public rf1 t;

    public class a extends BroadcastReceiver {
        public a(jh0 jh0) {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.getIntExtra(RemoteConfigConstants.ResponseFieldKey.STATE, -1) == 1) {
                ValidationScreen validationScreen = ValidationScreen.this;
                int i = ValidationScreen.u;
                hw0 hw0 = (hw0) validationScreen.getSupportFragmentManager().I("sound_fragment");
                if (hw0 != null) {
                    hw0.f();
                }
            }
        }
    }

    public static void j0(Context context, ScanPayTicket scanPayTicket, String str, boolean z) {
        Intent N0 = hj1.N0(context, ValidationScreen.class, "src", str);
        N0.putExtra("scanPay_info", scanPayTicket);
        N0.putExtra("shouldLaunchNew", z);
        context.startActivity(N0);
    }

    public static void k0(Context context, MPass mPass, String str, boolean z) {
        Intent N0 = hj1.N0(context, ValidationScreen.class, "src", str);
        N0.putExtra("mpass_info", mPass);
        N0.putExtra("shouldLaunchNew", z);
        context.startActivity(N0);
    }

    public static void l0(Context context, MTicket mTicket, String str, boolean z) {
        Intent N0 = hj1.N0(context, ValidationScreen.class, "src", str);
        N0.putExtra("mticket_info", mTicket);
        N0.putExtra("shouldLaunchNew", z);
        context.startActivity(N0);
    }

    public static void n0() {
        ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "activationScreenTicketingProblemsV2");
        hj1.K0(l2, "problemSource", "validationScreen", l2);
    }

    @Override // defpackage.j50.a
    public void a(int i) {
        hw0 hw0 = (hw0) getSupportFragmentManager().I("sound_fragment");
    }

    @Override // defpackage.j50.a
    public void d(int i) {
        hw0 hw0 = (hw0) getSupportFragmentManager().I("sound_fragment");
        if (hw0 != null) {
            hw0.d(i);
        }
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        setContentView(R.layout.validation_main);
        this.l = new Handler();
        MTicket mTicket = (MTicket) getIntent().getParcelableExtra("mticket_info");
        this.p = mTicket;
        if (mTicket != null) {
            this.m = this.p.getUpTripActivationTime() + vn.y(mTicket.getMTicketConfiguration().getId());
            this.s = this.p.getMTicketId();
        }
        this.q = (MPass) getIntent().getParcelableExtra("mpass_info");
        ScanPayTicket scanPayTicket = (ScanPayTicket) getIntent().getParcelableExtra("scanPay_info");
        this.r = scanPayTicket;
        MPass mPass = this.q;
        if (mPass != null) {
            this.s = mPass.getBookingPassId();
            this.m = xt.f3961a.c().x(vn.y(this.q.getConfigId()), this.s);
        } else if (scanPayTicket != null) {
            this.s = scanPayTicket.get_transactionId();
        }
        this.t = new rf1(this, "OTP_STORAGE");
        this.o = new a(null);
        this.k = getSupportFragmentManager();
        xt.f3961a.g0().c(h0(), this, UUID.randomUUID().toString());
        hw0 hw0 = new hw0();
        MTicket mTicket2 = this.p;
        if (mTicket2 != null) {
            hw0.g = mTicket2;
        } else {
            MPass mPass2 = this.q;
            if (mPass2 != null) {
                hw0.h = mPass2;
            } else {
                ScanPayTicket scanPayTicket2 = this.r;
                if (scanPayTicket2 != null) {
                    hw0.i = scanPayTicket2;
                }
            }
        }
        hw0.f = this;
        ke keVar = new ke(this.k);
        keVar.g(R.id.fragment_container, hw0, "sound_fragment");
        keVar.d();
        i0("sound details screen open");
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        if (toolbar != null) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolbar);
            ((ImageView) findViewById(R.id.back_pressed)).setBackground(getResources().getDrawable(R.drawable.pressed_state));
            ((ImageView) findViewById(R.id.help)).setVisibility(0);
            findViewById(R.id.back_pressed).setOnClickListener(new jh0(this));
            findViewById(R.id.help).setOnClickListener(new kh0(this));
        }
        ut.a aVar = ut.f3552a;
        getWindow().setFlags(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
    }

    public final String h0() {
        MTicket mTicket = this.p;
        if (mTicket != null) {
            return mTicket.getMTicketId();
        }
        MPass mPass = this.q;
        if (mPass != null) {
            return mPass.getBookingPassId();
        }
        ScanPayTicket scanPayTicket = this.r;
        return scanPayTicket != null ? scanPayTicket.get_transactionId() : "";
    }

    public final void i0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("bookingId", this.s);
        jz5.b().g(new ed1(str, Long.MIN_VALUE, hashMap));
    }

    public final void m0() {
        ((ImageView) findViewById(R.id.back_pressed)).setBackground(getResources().getDrawable(R.drawable.pressed_state));
    }

    public final void o0(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes != null && attributes.screenBrightness != f) {
            attributes.screenBrightness = f;
            getWindow().setAttributes(attributes);
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        o0(-1.0f);
        m0();
        ArrayList<ke> arrayList = getSupportFragmentManager().d;
        if (arrayList != null) {
            arrayList.size();
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) getSystemService("activity")).getRunningTasks(10);
        if (runningTasks.get(0).numActivities != 1 || !runningTasks.get(0).topActivity.getClassName().equals(getClass().getName())) {
            super.onBackPressed();
            return;
        }
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        this.t.k(this.s);
    }

    public void onEvent(bf1 bf1) {
        jz5.b().m(bf1);
        try {
            JSONObject jSONObject = new JSONObject(bf1.c);
            String optString = jSONObject.optString("ticketId", "");
            MTicketTripReceipt t2 = ov.t(jSONObject);
            ed1 ed1 = new ed1("mTicket trip punch", Long.MIN_VALUE);
            gi1.c(ed1, t2);
            if (t2 != null && t2.isReceiptAvailable()) {
                ed1.a("punch notification delay", Long.valueOf(ui1.Q() - t2.getPunchTimeStamp()));
            }
            ui1.m0(ed1);
            MTicket mTicket = this.p;
            if (mTicket != null && mTicket.getMTicketId() != null && this.p.getMTicketId().equals(optString)) {
                new Handler(Looper.getMainLooper()).post(new qh0(this, t2));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        unregisterReceiver(this.o);
        super.onPause();
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        registerReceiver(this.o, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        super.onResume();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
        if (!(this.p == null && this.q == null)) {
            lh0 lh0 = new lh0(this);
            this.n = lh0;
            this.l.post(lh0);
        }
        getWindow().addFlags(128);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        jz5.b().o(this);
        super.onStop();
        getWindow().clearFlags(128);
        this.l.removeCallbacksAndMessages(null);
    }
}
