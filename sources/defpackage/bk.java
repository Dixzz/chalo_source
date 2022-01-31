package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.ik;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: bk  reason: default package */
/* compiled from: DefaultItemAnimator */
public class bk implements Runnable {
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ ik g;

    public bk(ik ikVar, ArrayList arrayList) {
        this.g = ikVar;
        this.f = arrayList;
    }

    public void run() {
        View view;
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ik.a aVar = (ik.a) it.next();
            ik ikVar = this.g;
            Objects.requireNonNull(ikVar);
            RecyclerView.a0 a0Var = aVar.f1525a;
            View view2 = null;
            if (a0Var == null) {
                view = null;
            } else {
                view = a0Var.itemView;
            }
            RecyclerView.a0 a0Var2 = aVar.b;
            if (a0Var2 != null) {
                view2 = a0Var2.itemView;
            }
            if (view != null) {
                ViewPropertyAnimator duration = view.animate().setDuration(ikVar.f);
                ikVar.r.add(aVar.f1525a);
                duration.translationX((float) (aVar.e - aVar.c));
                duration.translationY((float) (aVar.f - aVar.d));
                duration.alpha(0.0f).setListener(new gk(ikVar, aVar, duration, view)).start();
            }
            if (view2 != null) {
                ViewPropertyAnimator animate = view2.animate();
                ikVar.r.add(aVar.b);
                animate.translationX(0.0f).translationY(0.0f).setDuration(ikVar.f).alpha(1.0f).setListener(new hk(ikVar, aVar, animate, view2)).start();
            }
        }
        this.f.clear();
        this.g.n.remove(this.f);
    }
}
