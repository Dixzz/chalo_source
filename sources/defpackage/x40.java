package defpackage;

import android.os.Handler;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.TripSummary;
import com.google.firebase.database.DataSnapshot;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: x40  reason: default package */
/* compiled from: ScheduleFeature */
public class x40 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ TransitMode g;
    public final /* synthetic */ Handler h;

    public x40(w40 w40, String str, TransitMode transitMode, Handler handler) {
        this.f = str;
        this.g = transitMode;
        this.h = handler;
    }

    public void run() {
        System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        bi1 bi1 = new bi1();
        Iterator<String> it = xt.f3961a.A().c(this.f).iterator();
        while (it.hasNext()) {
            String next = it.next();
            TransitMode transitMode = this.g;
            String str = this.f;
            ArrayList<TripSummary> arrayList2 = new ArrayList<>();
            xt.t1 t1Var = xt.f3961a;
            DataSnapshot j = t1Var.U().j(next, transitMode);
            DataSnapshot g2 = bi1.g(next, transitMode);
            if (ai1.a(j, g2)) {
                t1Var.A();
                ArrayList<String> p = t1Var.U().p(j);
                int indexOf = p.indexOf(str);
                if (indexOf == p.size() - 1) {
                    arrayList2 = new ArrayList<>();
                } else {
                    bi1.a(arrayList2, p, transitMode, j, g2, indexOf);
                }
            }
            arrayList.addAll(arrayList2);
        }
        Collections.sort(arrayList, new yi1());
        jz5.b().i(arrayList);
        System.currentTimeMillis();
        this.h.getLooper().quit();
    }
}
