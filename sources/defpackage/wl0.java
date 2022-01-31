package defpackage;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.navigation.NavController;
import app.zophop.ui.activities.HomeActivity;
import defpackage.qo;
import java.util.HashSet;

/* renamed from: wl0  reason: default package */
/* compiled from: BaseViewModelNavGraphActivity.kt */
public abstract class wl0<T extends qo> extends ol0<T> {
    public NavController k;
    public final rj l;

    /* renamed from: wl0$a */
    /* compiled from: AppBarConfiguration.kt */
    public static final class a extends o86 implements h76<Boolean> {
        public static final a f = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    public wl0() {
        d66 d66 = d66.f;
        a aVar = a.f;
        HashSet hashSet = new HashSet();
        hashSet.addAll(d66);
        rj rjVar = new rj(hashSet, null, new vl0(aVar), null);
        n86.b(rjVar, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        this.l = rjVar;
    }

    @Override // defpackage.ol0
    public void h0(Bundle bundle) {
    }

    @Override // defpackage.ol0
    public void j0() {
        registerReceiver(e0(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // defpackage.ol0
    public void n0() {
        unregisterReceiver(e0());
    }

    public abstract void o0();

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.k == null) {
            super.onBackPressed();
        } else {
            onSupportNavigateUp();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, defpackage.ol0
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o0();
        r0();
        q0();
    }

    @Override // defpackage.f0
    public boolean onSupportNavigateUp() {
        if (h.j0(p0(), this.l)) {
            return true;
        }
        if (isTaskRoot()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
            return true;
        } else if (super.onSupportNavigateUp()) {
            return true;
        } else {
            finish();
            return false;
        }
    }

    public final NavController p0() {
        NavController navController = this.k;
        if (navController != null) {
            return navController;
        }
        n86.l("navController");
        throw null;
    }

    public abstract void q0();

    public abstract void r0();
}
