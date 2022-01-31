package app.zophop.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.UserProfile;
import butterknife.InjectView;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class ActiveMTicketScreen extends au implements Animation.AnimationListener {
    public SharedPreferences A;
    public Handler B;
    public Handler C;
    public Runnable D;
    public Runnable E;
    public View F;
    public View G;
    public boolean H;
    public boolean I;
    public UserProfile J;
    public rf1 K;
    @InjectView(R.id.agency_text_id)
    public TextView _agencyId;
    @InjectView(R.id.btn_tap_qr_code)
    public TextView _btnTapQrCode;
    @InjectView(R.id.partner_text_id)
    public TextView _partnerId;
    @InjectView(R.id.mticket_qr_code)
    public ImageView _qrCodeImageView;
    public MTicket k;
    public long l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public ProgressBar r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public Animation w;
    public Animation x;
    public boolean y;
    public String z;

    public class a implements Runnable {
        public final z25 f = new z25();
        public final /* synthetic */ boolean g;
        public final /* synthetic */ ImageView h;
        public final /* synthetic */ int i;

        public a(boolean z, ImageView imageView, int i2) {
            this.g = z;
            this.h = imageView;
            this.i = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r3 = r11.f;
            r4 = new java.lang.StringBuilder();
            r4.append(r11.j.k.getQrCode());
            r4.append(r0);
            r0 = r11.j;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
            r1 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
            r4.append(r1);
            r0 = r3.b(r4.toString(), defpackage.o25.QR_CODE, 300, 300);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
            if (defpackage.ut.a() != false) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a0, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a3, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a4, code lost:
            r1 = defpackage.b00.f358a;
            r1 = defpackage.b00.a();
            r4 = defpackage.hj1.i0("qr code not generated ");
            r4.append(r11.j.k.getMTicketId());
            r1.b(new java.lang.Throwable(r4.toString()));
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0065 */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00fd  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0109  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 278
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.ActiveMTicketScreen.a.run():void");
        }
    }

    public ActiveMTicketScreen() {
        UUID.randomUUID().toString();
    }

    public static void i0(Context context, MTicket mTicket, String str, boolean z2) {
        Intent N0 = hj1.N0(context, ActiveMTicketScreen.class, "src", str);
        N0.putExtra("mticket_info", mTicket);
        N0.putExtra("shouldLaunchNew", z2);
        context.startActivity(N0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0498  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0511  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0520  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fa A[SYNTHETIC, Splitter:B:30:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ac A[SYNTHETIC, Splitter:B:51:0x01ac] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0441  */
    @Override // defpackage.tf1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 1331
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.ActiveMTicketScreen.e(android.os.Bundle):void");
    }

    public final void h0(ImageView imageView, boolean z2) {
        new a(z2, imageView, (int) ((float) getResources().getDisplayMetrics().widthPixels)).run();
    }

    public final void j0() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        String string = getString(R.string.tag_text_ticket_type);
        x supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.z(string);
        getSupportActionBar().o(true);
    }

    public final void k0(Bitmap bitmap) {
        this.s.setImageBitmap(bitmap);
    }

    public final void l0(float f) {
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
        if (this.y) {
            l0(-1.0f);
            this.y = false;
            setContentView(this.G);
            j0();
            this._qrCodeImageView.startAnimation(this.x);
        } else if (!xt.f3961a.G().d(getFragmentManager(), "activeMticketScreen", ActiveMTicketScreen.class.getSimpleName())) {
            if (!this.m) {
                super.onBackPressed();
                return;
            }
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
        }
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.booking_info, menu);
        getMenuInflater().inflate(R.menu.report_issue, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
        if (jz5.b().f(this)) {
            jz5.b().o(this);
        }
        ed1 ed1 = new ed1("mticket active screen closed", Long.MIN_VALUE);
        ed1.a("bookingId", this.k.getMTicketId());
        jz5.b().g(ed1);
        this.C.removeCallbacks(this.D);
        this.B.removeCallbacks(this.E);
    }

    public void onEvent(if1 if1) {
        if (this.k.getMTicketId().equalsIgnoreCase(if1.f1514a)) {
            this.H = true;
            rf1 rf1 = this.K;
            rf1.g(if1.f1514a + "_isExpired", true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (this.y || !(getIntent() == null || this.z == null)) {
                onBackPressed();
                return true;
            }
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.report_issue) {
            y20 R = xt.f3961a.R();
            HashMap hashMap = new HashMap();
            MTicket mTicket = this.k;
            if (mTicket != null) {
                if (mTicket.getCityName() != null) {
                    hashMap.put("userPropertyCity", this.k.getCityName());
                }
                if (this.k.get_userProfile() != null) {
                    UserProfile userProfile = this.k.get_userProfile();
                    String firstName = userProfile.getFirstName();
                    String lastName = userProfile.getLastName();
                    if (firstName != null) {
                        if (lastName != null) {
                            firstName = hj1.T(firstName, " ", lastName);
                        }
                        hashMap.put("userPropertyUserName", firstName);
                    } else if (lastName != null) {
                        hashMap.put("userPropertyUserName", lastName);
                    }
                    if (userProfile.getPhone() != null) {
                        hashMap.put("userPropertyPhoneNo", userProfile.getPhone());
                    }
                    if (userProfile.getUserId() != null) {
                        hashMap.put("userPropertyUserID", userProfile.getUserId());
                    }
                }
                if (this.k.getAgency() != null) {
                    hashMap.put("userPropertyAgencyName", this.k.getAgency());
                }
                if (this.k.getUpTripRouteStopsInfo() != null) {
                    if (this.k.getUpTripRouteStopsInfo().getRouteId() != null) {
                        hashMap.put("userPropertyRouteId", this.k.getUpTripRouteStopsInfo().getRouteId());
                    }
                    if (this.k.getUpTripRouteStopsInfo().getRouteName() != null) {
                        hashMap.put("userPropertyRouteName", this.k.getUpTripRouteStopsInfo().getRouteName());
                    }
                }
                if (this.k.getMTicketId() != null) {
                    hashMap.put("userPropertyMTicketId", this.k.getMTicketId());
                }
                if (this.k.getOrderId() != null) {
                    hashMap.put("userPropertyOrderId", this.k.getOrderId());
                }
            }
            R.b(this, "transactionRelatedScreen", "activeMticketScreen", hashMap, false);
            ed1 l2 = hj1.l("report problem clicked v2", Long.MIN_VALUE, "type", "qrCodeScreenTicketingProblemsV2");
            hj1.K0(l2, "problemSource", "ActiveMticket", l2);
            return true;
        } else if (itemId != R.id.booking_info) {
            return false;
        } else {
            jz5.b().g(hj1.l("menu see booking info clicked", Long.MIN_VALUE, "problemSource", "ActiveMticket"));
            MTicketBookingSummary.i0(this, this.k, "validation Screen");
            return true;
        }
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        xt.f3961a.G().n();
        super.onPause();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.k = (MTicket) bundle.getParcelable("mticket_info");
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        xt.f3961a.G().h("activeMticketScreen", getFragmentManager(), ActiveMTicketScreen.class.getSimpleName());
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onSaveInstanceState(Bundle bundle) {
        MTicket mTicket = this.k;
        if (mTicket != null) {
            bundle.putParcelable("mticket_info", mTicket);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        xb0 xb0 = new xb0(this);
        this.D = xb0;
        this.C.post(xb0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        Handler handler = this.C;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onStop();
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        xt.f3961a.G().k();
    }

    public void onEvent(z80 z80) {
        jz5.b().m(z80);
    }
}
