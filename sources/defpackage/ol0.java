package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import app.zophop.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import defpackage.qo;

/* renamed from: ol0  reason: default package */
/* compiled from: BaseActivity.kt */
public abstract class ol0<T extends qo> extends f0 {
    public static final /* synthetic */ int j = 0;
    public final j56 f = hd3.a2(new c(this));
    public final j56 g = hd3.a2(b.f);
    public final j56 h = hd3.a2(a.f);
    public Snackbar i;

    /* renamed from: ol0$a */
    /* compiled from: BaseActivity.kt */
    public static final class a extends o86 implements h76<he1> {
        public static final a f = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public he1 invoke() {
            return new he1();
        }
    }

    /* renamed from: ol0$b */
    /* compiled from: BaseActivity.kt */
    public static final class b extends o86 implements h76<fh1> {
        public static final b f = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public fh1 invoke() {
            return new fh1();
        }
    }

    /* renamed from: ol0$c */
    /* compiled from: BaseActivity.kt */
    public static final class c extends o86 implements h76<T> {
        public final /* synthetic */ ol0<T> f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ol0<T> ol0) {
            super(0);
            this.f = ol0;
        }

        @Override // defpackage.h76
        public Object invoke() {
            return this.f.g0();
        }
    }

    @Override // defpackage.f0
    public void attachBaseContext(Context context) {
        n86.e(context, "lNewBase");
        super.attachBaseContext(j26.c.a(context));
    }

    public final he1 d0() {
        return (he1) this.h.getValue();
    }

    public final fh1 e0() {
        return (fh1) this.g.getValue();
    }

    public final T f0() {
        return (T) ((qo) this.f.getValue());
    }

    public abstract T g0();

    public abstract void h0(Bundle bundle);

    public abstract void i0();

    public abstract void j0();

    public void k0() {
        Snackbar snackbar = this.i;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }

    public boolean l0(View view) {
        TextView textView;
        BaseTransientBottomBar.i iVar;
        BaseTransientBottomBar.i iVar2;
        BaseTransientBottomBar.i iVar3;
        jz5.b().g(new ed1("home screen error - no internet", 3600000));
        if (view == null) {
            return false;
        }
        String string = getResources().getString(R.string.no_internet_live_timings);
        n86.d(string, "resources.getString(R.st…no_internet_live_timings)");
        SpannableStringBuilder k = vn.k(string, 0, string.length(), q5.b(this, R.color.white), false);
        String string2 = getResources().getString(R.string.okay);
        n86.d(string2, "resources.getString(R.string.okay)");
        int b2 = q5.b(this, R.color.chalo_primary);
        SpannableStringBuilder k2 = vn.k(string2, 0, string2.length(), b2, true);
        n86.d(k2, "colorPartialString(lActi…, lActionCopyColor, true)");
        int b3 = q5.b(this, R.color.black_route);
        Snackbar j2 = Snackbar.j(view, k, -2);
        this.i = j2;
        j2.k(k2, new nl0(this));
        Snackbar snackbar = this.i;
        if (!(snackbar == null || (iVar3 = snackbar.c) == null)) {
            iVar3.setBackgroundColor(b3);
        }
        Snackbar snackbar2 = this.i;
        if (snackbar2 != null) {
            snackbar2.l(b2);
        }
        Snackbar snackbar3 = this.i;
        TextView textView2 = null;
        if (snackbar3 == null || (iVar2 = snackbar3.c) == null) {
            textView = null;
        } else {
            textView = (TextView) iVar2.findViewById(R.id.snackbar_action);
        }
        if (textView != null) {
            textView.setTypeface(textView.getTypeface(), 1);
        }
        if (textView != null) {
            textView.setTextSize(14.0f);
        }
        Snackbar snackbar4 = this.i;
        if (!(snackbar4 == null || (iVar = snackbar4.c) == null)) {
            textView2 = (TextView) iVar.findViewById(R.id.snackbar_text);
        }
        if (textView2 != null) {
            textView2.setTextSize(14.0f);
        }
        Snackbar snackbar5 = this.i;
        if (snackbar5 != null) {
            snackbar5.m();
        }
        return true;
    }

    public abstract void m0();

    public abstract void n0();

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setContentView(f0().a());
            ui1.g(getBaseContext(), xt.f3961a.z().b());
            overridePendingTransition(17432576, 17432577);
            h0(bundle);
        } catch (Throwable th) {
            b00 b00 = b00.f358a;
            b00.a().b(th);
        }
    }

    @Override // defpackage.ve
    public void onPause() {
        super.onPause();
        n0();
    }

    @Override // defpackage.ve
    public void onResume() {
        super.onResume();
        j0();
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStart() {
        super.onStart();
        i0();
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStop() {
        m0();
        super.onStop();
    }
}
