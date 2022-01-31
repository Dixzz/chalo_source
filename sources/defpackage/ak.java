package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.ik;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: ak  reason: default package */
/* compiled from: DefaultItemAnimator */
public class ak implements Runnable {
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ ik g;

    public ak(ik ikVar, ArrayList arrayList) {
        this.g = ikVar;
        this.f = arrayList;
    }

    public void run() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ik.b bVar = (ik.b) it.next();
            ik ikVar = this.g;
            RecyclerView.a0 a0Var = bVar.f1526a;
            int i = bVar.b;
            int i2 = bVar.c;
            int i3 = bVar.d;
            int i4 = bVar.e;
            Objects.requireNonNull(ikVar);
            View view = a0Var.itemView;
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (i5 != 0) {
                view.animate().translationX(0.0f);
            }
            if (i6 != 0) {
                view.animate().translationY(0.0f);
            }
            ViewPropertyAnimator animate = view.animate();
            ikVar.p.add(a0Var);
            animate.setDuration(ikVar.e).setListener(new fk(ikVar, a0Var, i5, view, i6, animate)).start();
        }
        this.f.clear();
        this.g.m.remove(this.f);
    }
}
