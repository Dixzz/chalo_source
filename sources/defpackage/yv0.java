package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import defpackage.ut;
import java.util.Objects;

/* renamed from: yv0  reason: default package */
/* compiled from: QrCodeScannerFragment */
public class yv0 extends Fragment {
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public Handler k;
    public View l;
    public Handler m;
    public long n;
    public Runnable o;

    public static String d(yv0 yv0) {
        Objects.requireNonNull(yv0);
        String valueOf = String.valueOf(ui1.Q());
        int i2 = 0;
        if (valueOf.length() > 10) {
            valueOf = valueOf.substring(0, 10);
        } else if (valueOf.length() < 10) {
            int length = 10 - valueOf.length();
            for (int i3 = 0; i3 < length; i3++) {
                valueOf = valueOf.concat("i");
            }
        }
        String a0 = hj1.a0(new StringBuilder(), yv0.f, valueOf);
        if (!yv0.j) {
            return a0;
        }
        StringBuilder i0 = hj1.i0(a0);
        if (!xt.f3961a.c().Z(yv0.g) && !yv0.i && yv0.h) {
            i2 = 1;
        }
        i0.append(i2);
        return i0.toString();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            this.f = getArguments().getString("qr_code");
            this.g = getArguments().getString("product_id");
            this.h = getArguments().getBoolean("product_is_active");
            this.j = getArguments().getBoolean("is_ticket");
            this.n = getArguments().getLong("product_expiry_time");
        }
        ut.a aVar = ut.f3552a;
        c().getWindow().setFlags(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_active_mticket_zoomed, viewGroup, false);
        this.l = inflate;
        return inflate;
    }

    public void onEvent(if1 if1) {
        if (this.g.equalsIgnoreCase(if1.f1514a)) {
            this.i = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        c().onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ImageView imageView = (ImageView) this.l.findViewById(R.id.mticket_qr_code_zoomed);
        if (this.n != -1) {
            Handler handler = new Handler();
            this.m = handler;
            wv0 wv0 = new wv0(this);
            this.o = wv0;
            handler.post(wv0);
        }
        this.k = new Handler();
        this.k.post(new xv0(this, true, imageView, (int) ((float) getResources().getDisplayMetrics().widthPixels)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.m;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        super.onStop();
    }
}
