package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RecentlyNonNull;
import defpackage.jc2;
import java.util.LinkedList;

/* renamed from: hc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class hc2<T extends jc2> {

    /* renamed from: a  reason: collision with root package name */
    public T f1357a;
    public Bundle b;
    public LinkedList<sc2> c;
    public final lc2<T> d = new lc2(this);

    public abstract void a(@RecentlyNonNull lc2<T> lc2);

    @RecentlyNonNull
    public View b(@RecentlyNonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        d(bundle, new oc2(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f1357a == null) {
            Object obj = q22.c;
            q22 q22 = q22.d;
            Context context = frameLayout.getContext();
            int e = q22.e(context);
            String b2 = d92.b(context, e);
            String c2 = d92.c(context, e);
            LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            frameLayout.addView(linearLayout);
            TextView textView = new TextView(frameLayout.getContext());
            textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            textView.setText(b2);
            linearLayout.addView(textView);
            Intent a2 = q22.a(context, e, null);
            if (a2 != null) {
                Button button = new Button(context);
                button.setId(16908313);
                button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                button.setText(c2);
                linearLayout.addView(button);
                button.setOnClickListener(new pc2(context, a2));
            }
        }
        return frameLayout;
    }

    public final void c(int i) {
        while (!this.c.isEmpty() && this.c.getLast().d() >= i) {
            this.c.removeLast();
        }
    }

    public final void d(Bundle bundle, sc2 sc2) {
        T t = this.f1357a;
        if (t != null) {
            sc2.a(t);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList<>();
        }
        this.c.add(sc2);
        if (bundle != null) {
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.d);
    }
}
