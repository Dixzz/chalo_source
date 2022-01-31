package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.urbanairship.automation.Trigger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: rm5  reason: default package */
/* compiled from: AutomationEngine */
public class rm5 implements Runnable {
    public final /* synthetic */ List f;
    public final /* synthetic */ cu5 g;
    public final /* synthetic */ double h;
    public final /* synthetic */ mm5 i;

    public rm5(mm5 mm5, List list, cu5 cu5, double d) {
        this.i = mm5;
        this.f = list;
        this.g = cu5;
        this.h = d;
    }

    public void run() {
        if (!(this.i.l.get() || this.f.isEmpty())) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (xo5 xo5 : this.f) {
                bu5 bu5 = xo5.d;
                if (bu5 == null || bu5.apply(this.g)) {
                    arrayList.add(xo5);
                    double d = xo5.f + this.h;
                    xo5.f = d;
                    if (d >= xo5.c) {
                        xo5.f = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        if (xo5.e) {
                            hashSet2.add(xo5.g);
                            mm5.d(this.i, Collections.singletonList(xo5.g));
                        } else {
                            hashSet.add(xo5.g);
                            hashMap.put(xo5.g, new pn5(new Trigger(xo5.b, xo5.c, xo5.d), this.g.b()));
                        }
                    }
                }
            }
            this.i.w.s(arrayList);
            if (!hashSet2.isEmpty()) {
                mm5 mm5 = this.i;
                List<so5> i2 = mm5.w.i(hashSet2);
                if (!i2.isEmpty()) {
                    for (so5 so5 : i2) {
                        mm5.u(so5, 0);
                    }
                    mm5.w.r(i2);
                }
            }
            if (!hashSet.isEmpty()) {
                mm5 mm52 = this.i;
                List<so5> i3 = mm52.w.i(hashSet);
                if (!(mm52.l.get() || i3.isEmpty())) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    for (so5 so52 : i3) {
                        if (so52.f3238a.n == 0) {
                            arrayList2.add(so52);
                            wo5 wo5 = so52.f3238a;
                            wo5.p = (pn5) hashMap.get(wo5.b);
                            if (mm52.k(so52)) {
                                arrayList3.add(so52);
                            } else {
                                for (xo5 xo52 : so52.b) {
                                    if (xo52.e) {
                                        xo52.f = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                                    }
                                }
                                if (so52.f3238a.s > 0) {
                                    mm52.u(so52, 5);
                                    mm52.p(so52, TimeUnit.SECONDS.toMillis(so52.f3238a.s));
                                } else {
                                    mm52.u(so52, 6);
                                    arrayList4.add(so52);
                                }
                            }
                        }
                    }
                    mm52.w.r(arrayList2);
                    mm52.o(arrayList4);
                    mm52.i(arrayList3);
                }
            }
        }
    }
}
