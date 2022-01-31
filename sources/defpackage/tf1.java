package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import app.zophop.utilities.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: tf1  reason: default package */
/* compiled from: BaseActionBarActivity */
public abstract class tf1 extends f0 {
    public final HashSet<b> f = new HashSet<>();
    public BroadcastReceiver g;
    public BroadcastReceiver h;
    public Snackbar i;

    /* renamed from: tf1$a */
    /* compiled from: BaseActionBarActivity */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            tf1.this.i.b(3);
        }
    }

    /* renamed from: tf1$b */
    /* compiled from: BaseActionBarActivity */
    public interface b {
        void a();
    }

    @Override // defpackage.f0
    public void attachBaseContext(Context context) {
        super.attachBaseContext(j26.c.a(context));
    }

    public abstract void d0();

    public abstract void e(Bundle bundle);

    public void e0() {
        Snackbar snackbar = this.i;
        if (snackbar != null) {
            snackbar.b(3);
        }
    }

    public boolean f0(View view) {
        jz5.b().g(new ed1("home screen error - no internet", 3600000));
        int i2 = R.string.no_internet_live_timings;
        int i3 = R.string.okay;
        a aVar = new a();
        int color = getResources().getColor(R.color.white);
        int color2 = getResources().getColor(R.color.chalo_primary);
        int color3 = getResources().getColor(R.color.black_route);
        if (view != null) {
            String string = getString(i2);
            Snackbar j = Snackbar.j(view, vn.k(string, 0, string.length(), color, false), -2);
            this.i = j;
            j.c.setBackgroundColor(color3);
            String string2 = getString(i3);
            this.i.k(vn.k(string2, 0, string2.length(), color2, true), aVar);
            this.i.l(color2);
            TextView textView = (TextView) this.i.c.findViewById(R.id.snackbar_action);
            textView.setTypeface(textView.getTypeface(), 1);
            textView.setTextSize(14.0f);
            ((TextView) this.i.c.findViewById(R.id.snackbar_text)).setTextSize(14.0f);
            this.i.m();
            return true;
        }
        e0();
        return false;
    }

    public abstract void g0();

    public boolean onCreateOptionsMenu(Menu menu) {
        synchronized (this.f) {
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f.clear();
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // defpackage.ve
    public void onPause() {
        super.onPause();
        g0();
    }

    @Override // defpackage.ve
    public void onResume() {
        super.onResume();
        d0();
    }
}
