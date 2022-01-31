package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: ez1  reason: default package */
public final class ez1 implements nz1 {
    public static final Uri g;
    public final LogPrinter f = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        g = builder.build();
    }

    @Override // defpackage.nz1
    public final Uri l() {
        return g;
    }

    @Override // defpackage.nz1
    public final void m(gz1 gz1) {
        ArrayList arrayList = new ArrayList(gz1.j.values());
        Collections.sort(arrayList, new fz1());
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String obj2 = ((iz1) obj).toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj2);
            }
        }
        this.f.println(sb.toString());
    }
}
