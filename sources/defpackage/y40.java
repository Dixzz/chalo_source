package defpackage;

import android.os.Handler;
import android.os.Process;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.TripSummary;
import com.google.firebase.database.DataSnapshot;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: y40  reason: default package */
/* compiled from: ScheduleFeature */
public class y40 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ TransitMode h;
    public final /* synthetic */ Handler i;

    public y40(w40 w40, String str, String str2, TransitMode transitMode, Handler handler) {
        this.f = str;
        this.g = str2;
        this.h = transitMode;
        this.i = handler;
    }

    public void run() {
        ArrayList<String> p;
        int indexOf;
        Process.setThreadPriority(10);
        ArrayList arrayList = new ArrayList();
        i30 A = xt.f3961a.A();
        HashSet<String> c = ii1.c(A.c(this.f), A.c(this.g));
        bi1 bi1 = new bi1();
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            TransitMode transitMode = this.h;
            String str = this.f;
            String str2 = this.g;
            ArrayList<TripSummary> arrayList2 = new ArrayList<>();
            xt.t1 t1Var = xt.f3961a;
            DataSnapshot j = t1Var.U().j(next, transitMode);
            DataSnapshot g2 = bi1.g(next, transitMode);
            if (ai1.a(j, g2) && p.indexOf(str2) > (indexOf = (p = t1Var.U().p(j)).indexOf(str))) {
                bi1.a(arrayList2, p, transitMode, j, g2, indexOf);
            }
            arrayList.addAll(arrayList2);
        }
        Collections.sort(arrayList, new yi1());
        jz5.b().i(arrayList);
        this.i.getLooper().quit();
    }
}
