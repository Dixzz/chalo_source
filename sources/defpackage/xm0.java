package defpackage;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: xm0  reason: default package */
/* compiled from: RecentProductErrorDialog */
public class xm0 extends sn0 {
    public a g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public String l;
    public String m;
    public boolean n;

    /* renamed from: xm0$a */
    /* compiled from: RecentProductErrorDialog */
    public interface a {
        void a();

        void b();
    }

    public xm0(Context context, a aVar, String str, String str2, String str3, boolean z) {
        super(str);
        this.g = aVar;
        this.l = str2;
        this.m = str3;
        this.n = z;
    }

    public static void a(FragmentManager fragmentManager, Context context, a aVar, String str, String str2, String str3, boolean z) {
        xm0 xm0 = new xm0(context, aVar, str, str2, str3, z);
        xm0.show(fragmentManager, (String) null);
        xm0.setCancelable(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.recent_product_error_dialog, viewGroup, false);
        this.h = (TextView) inflate.findViewById(R.id.okay_button);
        this.i = (TextView) inflate.findViewById(R.id.dismiss_button);
        this.j = (TextView) inflate.findViewById(R.id.error_description);
        this.k = (TextView) inflate.findViewById(R.id.dialog_title);
        if (!TextUtils.isEmpty(this.l)) {
            this.j.setText(this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.k.setText(this.m);
        }
        if (this.n) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.h.setOnClickListener(new vm0(this));
        this.i.setOnClickListener(new wm0(this));
        a aVar = this.g;
        if (aVar != null) {
            aVar.a();
        }
        return inflate;
    }
}
