package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: xf  reason: default package */
/* compiled from: FragmentTransitionImpl */
public class xf implements Runnable {
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ Map g;

    public xf(vf vfVar, ArrayList arrayList, Map map) {
        this.f = arrayList;
        this.g = map;
    }

    public void run() {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f.get(i);
            AtomicInteger atomicInteger = r8.f3055a;
            view.setTransitionName((String) this.g.get(view.getTransitionName()));
        }
    }
}
