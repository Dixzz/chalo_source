package app.zophop.scanPay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import app.zophop.ui.activities.HomeActivity;
import com.budiyev.android.codescanner.CodeScannerView;
import java.util.ArrayList;
import java.util.List;

public class ScanPayBaseActivity extends ze0 {
    public static final /* synthetic */ int p = 0;
    public qk1 m;
    public List<String> n;
    public boolean o;

    public class a implements sk1 {
        public a() {
        }
    }

    public class b implements wk1 {
        public b() {
        }

        @Override // defpackage.wk1
        public void a(Exception exc) {
            ScanPayBaseActivity scanPayBaseActivity = ScanPayBaseActivity.this;
            String exc2 = exc.toString();
            int i = ScanPayBaseActivity.p;
            scanPayBaseActivity.n0("scan pay invalid scan", null, exc2);
            ScanPayBaseActivity.k0(ScanPayBaseActivity.this);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ boolean f;
        public final /* synthetic */ lm0 g;

        public c(boolean z, lm0 lm0) {
            this.f = z;
            this.g = lm0;
        }

        public void onClick(View view) {
            ScanPayBaseActivity scanPayBaseActivity = ScanPayBaseActivity.this;
            int i = ScanPayBaseActivity.p;
            SharedPreferences.Editor edit = scanPayBaseActivity.getSharedPreferences("spDialogStatus", 0).edit();
            edit.putBoolean(scanPayBaseActivity.getResources().getString(R.string.sp_camera_permission_asked), true);
            edit.commit();
            if (this.f) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", ScanPayBaseActivity.this.getPackageName(), null));
                ScanPayBaseActivity.this.startActivityForResult(intent, 101);
            } else {
                ScanPayBaseActivity scanPayBaseActivity2 = ScanPayBaseActivity.this;
                if (!scanPayBaseActivity2.l0()) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        scanPayBaseActivity2.requestPermissions(new String[]{"android.permission.CAMERA"}, 102);
                        jz5.b().g(hj1.l("permission_popup", Long.MIN_VALUE, "element", "mTicket_proofs"));
                    } else {
                        Toast.makeText(scanPayBaseActivity2, "Please give camera permission", 1).show();
                    }
                }
            }
            this.g.dismiss();
            ScanPayBaseActivity.this.o = false;
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            ScanPayBaseActivity.this.finish();
        }
    }

    public static void k0(ScanPayBaseActivity scanPayBaseActivity) {
        scanPayBaseActivity.m0();
        lm0 b2 = lm0.b(scanPayBaseActivity.getFragmentManager(), scanPayBaseActivity.getString(R.string.invalid_qr_code_header), scanPayBaseActivity.getString(R.string.invalid_qr_code_details), scanPayBaseActivity.getString(R.string.ok), null, null);
        b2.setCancelable(false);
        q80 q80 = new q80(scanPayBaseActivity, b2);
        TextView textView = b2.i;
        if (textView != null) {
            textView.setOnClickListener(q80);
        } else {
            b2.q = q80;
        }
    }

    @Override // defpackage.ze0
    public void h0(Bundle bundle) {
        i0();
    }

    @Override // defpackage.ze0
    public void j0() {
        vk1 vk1;
        setContentView(R.layout.scan_pay_view);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().o(true);
        getSupportActionBar().y(R.string.title_scan_activity);
        this.m = new qk1(this, (CodeScannerView) findViewById(R.id.scanner_view));
        ArrayList arrayList = new ArrayList();
        arrayList.add(o25.QR_CODE);
        qk1 qk1 = this.m;
        synchronized (qk1.f2950a) {
            qk1.m = arrayList;
            if (qk1.t && (vk1 = qk1.r) != null) {
                uk1 uk1 = vk1.b;
                uk1.d.put(s25.POSSIBLE_FORMATS, arrayList);
                uk1.f3516a.e(uk1.d);
            }
        }
        n0("scan pay screen open", (getIntent() == null || TextUtils.isEmpty(getIntent().getStringExtra("source"))) ? null : getIntent().getStringExtra("source"), null);
    }

    public final boolean l0() {
        return ui1.T(this, "android.permission.CAMERA");
    }

    public final void m0() {
        if (this.m != null && l0()) {
            this.m.b();
        }
    }

    public final void n0(String str, String str2, String str3) {
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        if (!TextUtils.isEmpty(str2)) {
            ed1.a("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            ed1.a("qr details", str3);
        }
        jz5.b().g(ed1);
    }

    public void o0() {
        if (this.m != null && l0()) {
            this.m.h();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        if (isTaskRoot()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
            return;
        }
        super.onBackPressed();
    }

    @Override // defpackage.tf1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scan_pay, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        } else if (menuItem.getItemId() != R.id.menu_scan_pay_info) {
            return false;
        } else {
            new jn0().show(getSupportFragmentManager(), "d");
            n0("scan pay dialog open", "menu clicked", null);
            m0();
            return false;
        }
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onPause() {
        super.onPause();
        m0();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.t4.b, defpackage.ve
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 102) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            q0();
        } else if (iArr.length > 0 && iArr[0] == 0) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            p0();
            o0();
            if (r0()) {
                jn0 jn0 = new jn0();
                jn0.setCancelable(false);
                jn0.show(getSupportFragmentManager(), "d");
                n0("scan pay dialog open", "first open", null);
            }
        }
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        if (l0()) {
            p0();
            o0();
            if (r0()) {
                jn0 jn0 = new jn0();
                jn0.setCancelable(false);
                jn0.show(getSupportFragmentManager(), "d");
                n0("scan pay dialog open", "first open", null);
                return;
            }
            return;
        }
        q0();
    }

    public final void p0() {
        vk1 vk1;
        qk1 qk1 = this.m;
        if (qk1 != null) {
            a aVar = new a();
            synchronized (qk1.f2950a) {
                qk1.p = aVar;
                if (qk1.t && (vk1 = qk1.r) != null) {
                    vk1.b.f = aVar;
                }
            }
            this.m.q = new b();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q0() {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.scanPay.ScanPayBaseActivity.q0():void");
    }

    public final boolean r0() {
        SharedPreferences sharedPreferences = getSharedPreferences("spDialogStatus", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (sharedPreferences.contains(getResources().getString(R.string.sp_status))) {
            return false;
        }
        edit.putBoolean(getResources().getString(R.string.sp_status), true);
        edit.commit();
        return true;
    }
}
