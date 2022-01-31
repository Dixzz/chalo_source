package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.ScanPayTicket;
import butterknife.ButterKnife;
import butterknife.InjectView;
import defpackage.ut;
import j$.util.DesugarTimeZone;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ActiveScanPayScreen extends au implements Animation.AnimationListener {
    @InjectView(R.id.actual_fare_val)
    public TextView _actualFare;
    @InjectView(R.id.amount_paid_val)
    public TextView _amountPaid;
    @InjectView(R.id.tv_booking_id)
    public TextView _bookingId;
    @InjectView(R.id.btn_tap_qr_code)
    public TextView _btnTapQrCode;
    @InjectView(R.id.bus_info)
    public TextView _busInfo;
    @InjectView(R.id.scan_pay_qr_code)
    public ImageView _qrCodeImageView;
    @InjectView(R.id.validity)
    public TextView _validity;
    public boolean k;
    public Animation l;
    public boolean m;
    public String n;
    public ScanPayTicket o;
    public SharedPreferences p;
    public Handler q;
    public Runnable r;
    public View s;
    public View t;
    public boolean u;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            x supportActionBar = ActiveScanPayScreen.this.getSupportActionBar();
            StringBuilder sb = new StringBuilder();
            long Q = ui1.Q();
            TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
            sb.append(new SimpleDateFormat("hh:mm:ss a").format(new Date(Q)).replace("am", "AM").replace("pm", "PM"));
            sb.append(", ");
            sb.append(jh1.d(ui1.Q()));
            supportActionBar.z(sb.toString());
            ActiveScanPayScreen.this.q.postDelayed(this, 1000);
        }
    }

    public static void h0(Context context, ScanPayTicket scanPayTicket, String str, boolean z) {
        Intent intent = new Intent(context, ActiveScanPayScreen.class);
        intent.putExtra("scanPayInfo", scanPayTicket);
        intent.putExtra("src", str);
        intent.putExtra("shouldLaunchNew", z);
        if (z) {
            intent.setFlags(268468224);
        }
        context.startActivity(intent);
    }

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        int i;
        this.t = getLayoutInflater().inflate(R.layout.activity_active_scan_pay, (ViewGroup) null);
        this.s = getLayoutInflater().inflate(R.layout.activity_active_scan_pay_zoomed, (ViewGroup) null);
        setContentView(this.t);
        ut.a aVar = ut.f3552a;
        getWindow().setFlags(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        ButterKnife.inject(this);
        this.q = new Handler();
        i0();
        SharedPreferences sharedPreferences = getSharedPreferences("activateTicket", 0);
        this.p = sharedPreferences;
        sharedPreferences.getBoolean("isTicketActivated", true);
        this.n = getIntent().getStringExtra("src");
        this.o = (ScanPayTicket) getIntent().getParcelableExtra("scanPayInfo");
        this.k = getIntent().getBooleanExtra("shouldLaunchNew", false);
        new lc0(this, this._qrCodeImageView).run();
        this.l = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_mticket);
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out_mticket);
        this.l.setAnimationListener(this);
        this._btnTapQrCode.setOnClickListener(new kc0(this, (ImageView) this.t.findViewById(R.id.scan_pay_qr_code)));
        this._qrCodeImageView.setOnClickListener(new kc0(this, null));
        double d = this.o.get_discountedFare();
        double d2 = this.o.get_fare();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        TextView textView = this._actualFare;
        textView.setText(ui1.H() + decimalFormat.format(d2));
        TextView textView2 = this._amountPaid;
        textView2.setText(ui1.H() + decimalFormat.format(d));
        TextView textView3 = this._busInfo;
        StringBuilder i0 = hj1.i0(" ");
        i0.append(this.o.get_bookingDetails().getBusInfo());
        textView3.append(i0.toString());
        TextView textView4 = this._bookingId;
        textView4.setText(getString(R.string.tv_booking_id) + " " + this.o.get_transactionId());
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(jh1.f(this.o.get_expirationTime()));
        this._validity.append(sb.toString().replace(",", "on"));
        ed1 ed1 = new ed1("scan pay active screen opened", Long.MIN_VALUE);
        if (getIntent().hasExtra("src")) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        try {
            i = Settings.System.getInt(getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
            i = -1;
        }
        ed1.a("screen brightness", Integer.valueOf(i));
        jz5.b().g(ed1);
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
    }

    public final void i0() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        Runnable runnable = this.r;
        if (runnable != null) {
            this.q.removeCallbacks(runnable);
        }
        a aVar = new a();
        this.r = aVar;
        this.q.post(aVar);
    }

    public final void j0(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes != null && attributes.screenBrightness != f) {
            attributes.screenBrightness = f;
            getWindow().setAttributes(attributes);
        }
    }

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.m) {
            j0(-1.0f);
            this.m = false;
            setContentView(this.t);
            i0();
        } else if (!this.k) {
            super.onBackPressed();
        } else {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
        }
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.booking_info, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        jz5.b().o(this);
    }

    public void onEvent(if1 if1) {
        if (this.o.get_transactionId().equalsIgnoreCase(if1.f1514a)) {
            this.u = true;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (this.m || !(getIntent() == null || this.n == null)) {
                onBackPressed();
                return true;
            }
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            return true;
        } else if (itemId != R.id.booking_info) {
            return false;
        } else {
            ScanPayBookingSummary.h0(this, this.o, "mticket active menu");
            return true;
        }
    }
}
