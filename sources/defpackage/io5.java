package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: io5  reason: default package */
/* compiled from: FrequencyLimitManager */
public class io5 implements Runnable {
    public final /* synthetic */ Collection f;
    public final /* synthetic */ ck5 g;
    public final /* synthetic */ jo5 h;

    public io5(jo5 jo5, Collection collection, ck5 ck5) {
        this.h = jo5;
        this.f = collection;
        this.g = ck5;
    }

    /* JADX INFO: finally extract failed */
    public void run() {
        try {
            List<ko5> b = ((mo5) this.h.d).b();
            HashMap hashMap = new HashMap();
            Iterator it = ((ArrayList) b).iterator();
            while (it.hasNext()) {
                ko5 ko5 = (ko5) it.next();
                hashMap.put(ko5.b, ko5);
            }
            for (go5 go5 : this.f) {
                ko5 ko52 = new ko5();
                String str = go5.f1290a;
                ko52.b = str;
                ko52.c = go5.c;
                ko52.d = go5.b;
                ko5 ko53 = (ko5) hashMap.remove(str);
                if (ko53 == null) {
                    ((mo5) this.h.d).c(ko52);
                } else if (ko53.d != ko52.d) {
                    mo5 mo5 = (mo5) this.h.d;
                    mo5.f2419a.assertNotSuspendingTransaction();
                    mo5.f2419a.beginTransaction();
                    try {
                        mo5.d.handle(ko53);
                        mo5.f2419a.setTransactionSuccessful();
                        mo5.f2419a.endTransaction();
                        ((mo5) this.h.d).c(ko52);
                    } catch (Throwable th) {
                        mo5.f2419a.endTransaction();
                        throw th;
                    }
                } else {
                    mo5 mo52 = (mo5) this.h.d;
                    mo52.f2419a.assertNotSuspendingTransaction();
                    mo52.f2419a.beginTransaction();
                    try {
                        mo52.e.handle(ko52);
                        mo52.f2419a.setTransactionSuccessful();
                    } finally {
                        mo52.f2419a.endTransaction();
                    }
                }
            }
            ((mo5) this.h.d).a(hashMap.keySet());
            this.g.d(Boolean.TRUE);
        } catch (Exception e) {
            yj5.e(e, "Failed to update constraints", new Object[0]);
            this.g.d(Boolean.FALSE);
        }
    }
}
