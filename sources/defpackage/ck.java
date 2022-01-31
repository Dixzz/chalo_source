package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: ck  reason: default package */
/* compiled from: DefaultItemAnimator */
public class ck implements Runnable {
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ ik g;

    public ck(ik ikVar, ArrayList arrayList) {
        this.g = ikVar;
        this.f = arrayList;
    }

    public void run() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            RecyclerView.a0 a0Var = (RecyclerView.a0) it.next();
            ik ikVar = this.g;
            Objects.requireNonNull(ikVar);
            View view = a0Var.itemView;
            ViewPropertyAnimator animate = view.animate();
            ikVar.o.add(a0Var);
            animate.alpha(1.0f).setDuration(ikVar.c).setListener(new ek(ikVar, a0Var, view, animate)).start();
        }
        this.f.clear();
        this.g.l.remove(this.f);
    }
}
