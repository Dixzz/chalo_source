package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import java.util.Objects;
import server.zophop.logging.LoggingConstants;

/* renamed from: sk0  reason: default package */
/* compiled from: TripDetailsAdapter */
public class sk0 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ TextView h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ ok0 k;

    public sk0(ok0 ok0, String str, String str2, TextView textView, String str3, String str4) {
        this.k = ok0;
        this.f = str;
        this.g = str2;
        this.h = textView;
        this.i = str3;
        this.j = str4;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f)) {
            ok0 ok0 = this.k;
            String str = this.g;
            int i2 = ok0.r;
            Objects.requireNonNull(ok0);
            ed1 ed1 = new ed1("disruption info banner cta clicked", Long.MIN_VALUE);
            ed1.a("availability priority", str);
            jz5.b().g(ed1);
            this.h.setText(this.i);
            if (this.f.equalsIgnoreCase("dialog")) {
                FragmentManager fragmentManager = ((Activity) this.k.f).getFragmentManager();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag("dialog");
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
                beginTransaction.addToBackStack(null);
                Context context = this.k.f;
                hn0.l = Integer.parseInt(this.g);
                hn0 hn0 = new hn0();
                Bundle bundle = new Bundle();
                bundle.putInt("status", hn0.l);
                hn0.setArguments(bundle);
                hn0.show(beginTransaction, "dialog");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f));
            intent.putExtra(LoggingConstants.ROUTE_ID, this.j);
            intent.putExtra("mode", "bus");
            this.k.f.startActivity(intent);
        }
    }
}
