package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: wf  reason: default package */
/* compiled from: FragmentTransitionImpl */
public class wf implements Runnable {
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ Map g;

    public wf(vf vfVar, ArrayList arrayList, Map map) {
        this.f = arrayList;
        this.g = map;
    }

    public void run() {
        String str;
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f.get(i);
            AtomicInteger atomicInteger = r8.f3055a;
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                Iterator it = this.g.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (transitionName.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                view.setTransitionName(str);
            }
        }
    }
}
