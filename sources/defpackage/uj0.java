package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.R;

/* renamed from: uj0  reason: default package */
/* compiled from: LocationPickAdapter */
public class uj0 extends xj0 {
    public uj0(Context context) {
        super(context);
    }

    public static rg1 b(View view, mf1 mf1, Context context) {
        rg1 rg1;
        String str;
        String str2;
        if (view == null) {
            rg1 = new rg1(context);
        } else {
            rg1 = (rg1) view;
        }
        String str3 = mf1.c;
        int indexOf = str3.indexOf(",");
        if (indexOf != -1) {
            str2 = str3.substring(0, indexOf).trim();
            str = str3.substring(indexOf + 1).trim();
        } else {
            str2 = str3.trim();
            str = null;
        }
        rg1.a(str2, str, R.drawable.location_search);
        rg1.findViewById(R.id.bus_agency_name).setVisibility(8);
        return rg1;
    }
}
