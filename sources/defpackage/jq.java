package defpackage;

import android.os.Build;
import androidx.work.impl.WorkDatabase;
import com.rabbitmq.client.AMQP;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: jq  reason: default package */
/* compiled from: Schedulers */
public class jq {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1968a = tp.e("Schedulers");

    /* JADX INFO: finally extract failed */
    public static void a(kp kpVar, WorkDatabase workDatabase, List<iq> list) {
        int i;
        if (list != null && list.size() != 0) {
            ss f = workDatabase.f();
            workDatabase.beginTransaction();
            try {
                if (Build.VERSION.SDK_INT == 23) {
                    i = kpVar.h / 2;
                } else {
                    i = kpVar.h;
                }
                ts tsVar = (ts) f;
                List<rs> d = tsVar.d(i);
                List<rs> b = tsVar.b(AMQP.REPLY_SUCCESS);
                ArrayList arrayList = (ArrayList) d;
                if (arrayList.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        tsVar.l(((rs) it.next()).f3122a, currentTimeMillis);
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (arrayList.size() > 0) {
                    rs[] rsVarArr = (rs[]) arrayList.toArray(new rs[arrayList.size()]);
                    for (iq iqVar : list) {
                        if (iqVar.c()) {
                            iqVar.a(rsVarArr);
                        }
                    }
                }
                ArrayList arrayList2 = (ArrayList) b;
                if (arrayList2.size() > 0) {
                    rs[] rsVarArr2 = (rs[]) arrayList2.toArray(new rs[arrayList2.size()]);
                    for (iq iqVar2 : list) {
                        if (!iqVar2.c()) {
                            iqVar2.a(rsVarArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }
}
