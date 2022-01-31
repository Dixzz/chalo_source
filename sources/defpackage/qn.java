package defpackage;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import defpackage.kn;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: qn  reason: default package */
/* compiled from: TransitionSet */
public class qn extends kn {
    public ArrayList<kn> C = new ArrayList<>();
    public boolean D = true;
    public int E;
    public boolean F = false;
    public int G = 0;

    /* renamed from: qn$a */
    /* compiled from: TransitionSet */
    public class a extends nn {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kn f2963a;

        public a(qn qnVar, kn knVar) {
            this.f2963a = knVar;
        }

        @Override // defpackage.kn.d
        public void c(kn knVar) {
            this.f2963a.z();
            knVar.w(this);
        }
    }

    /* renamed from: qn$b */
    /* compiled from: TransitionSet */
    public static class b extends nn {

        /* renamed from: a  reason: collision with root package name */
        public qn f2964a;

        public b(qn qnVar) {
            this.f2964a = qnVar;
        }

        @Override // defpackage.nn, defpackage.kn.d
        public void a(kn knVar) {
            qn qnVar = this.f2964a;
            if (!qnVar.F) {
                qnVar.G();
                this.f2964a.F = true;
            }
        }

        @Override // defpackage.kn.d
        public void c(kn knVar) {
            qn qnVar = this.f2964a;
            int i = qnVar.E - 1;
            qnVar.E = i;
            if (i == 0) {
                qnVar.F = false;
                qnVar.m();
            }
            knVar.w(this);
        }
    }

    @Override // defpackage.kn
    public kn A(long j) {
        ArrayList<kn> arrayList;
        this.h = j;
        if (j >= 0 && (arrayList = this.C) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.C.get(i).A(j);
            }
        }
        return this;
    }

    @Override // defpackage.kn
    public void B(kn.c cVar) {
        this.x = cVar;
        this.G |= 8;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).B(cVar);
        }
    }

    @Override // defpackage.kn
    public kn C(TimeInterpolator timeInterpolator) {
        this.G |= 1;
        ArrayList<kn> arrayList = this.C;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.C.get(i).C(timeInterpolator);
            }
        }
        this.i = timeInterpolator;
        return this;
    }

    @Override // defpackage.kn
    public void D(hn hnVar) {
        if (hnVar == null) {
            this.y = kn.A;
        } else {
            this.y = hnVar;
        }
        this.G |= 4;
        if (this.C != null) {
            for (int i = 0; i < this.C.size(); i++) {
                this.C.get(i).D(hnVar);
            }
        }
    }

    @Override // defpackage.kn
    public void E(pn pnVar) {
        this.G |= 2;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).E(pnVar);
        }
    }

    @Override // defpackage.kn
    public kn F(long j) {
        this.g = j;
        return this;
    }

    @Override // defpackage.kn
    public String H(String str) {
        String H = super.H(str);
        for (int i = 0; i < this.C.size(); i++) {
            StringBuilder k0 = hj1.k0(H, "\n");
            k0.append(this.C.get(i).H(str + "  "));
            H = k0.toString();
        }
        return H;
    }

    public qn I(kn knVar) {
        this.C.add(knVar);
        knVar.n = this;
        long j = this.h;
        if (j >= 0) {
            knVar.A(j);
        }
        if ((this.G & 1) != 0) {
            knVar.C(this.i);
        }
        if ((this.G & 2) != 0) {
            knVar.E(null);
        }
        if ((this.G & 4) != 0) {
            knVar.D(this.y);
        }
        if ((this.G & 8) != 0) {
            knVar.B(this.x);
        }
        return this;
    }

    public kn J(int i) {
        if (i < 0 || i >= this.C.size()) {
            return null;
        }
        return this.C.get(i);
    }

    public qn K(int i) {
        if (i == 0) {
            this.D = true;
        } else if (i == 1) {
            this.D = false;
        } else {
            throw new AndroidRuntimeException(hj1.I("Invalid parameter for TransitionSet ordering: ", i));
        }
        return this;
    }

    @Override // defpackage.kn
    public kn a(kn.d dVar) {
        super.a(dVar);
        return this;
    }

    @Override // defpackage.kn
    public kn b(View view) {
        for (int i = 0; i < this.C.size(); i++) {
            this.C.get(i).b(view);
        }
        this.k.add(view);
        return this;
    }

    @Override // defpackage.kn
    public void cancel() {
        super.cancel();
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).cancel();
        }
    }

    @Override // defpackage.kn
    public void d(sn snVar) {
        if (t(snVar.b)) {
            Iterator<kn> it = this.C.iterator();
            while (it.hasNext()) {
                kn next = it.next();
                if (next.t(snVar.b)) {
                    next.d(snVar);
                    snVar.c.add(next);
                }
            }
        }
    }

    @Override // defpackage.kn
    public void f(sn snVar) {
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).f(snVar);
        }
    }

    @Override // defpackage.kn
    public void g(sn snVar) {
        if (t(snVar.b)) {
            Iterator<kn> it = this.C.iterator();
            while (it.hasNext()) {
                kn next = it.next();
                if (next.t(snVar.b)) {
                    next.g(snVar);
                    snVar.c.add(next);
                }
            }
        }
    }

    @Override // defpackage.kn
    /* renamed from: j */
    public kn clone() {
        qn qnVar = (qn) super.clone();
        qnVar.C = new ArrayList<>();
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            kn j = this.C.get(i).clone();
            qnVar.C.add(j);
            j.n = qnVar;
        }
        return qnVar;
    }

    @Override // defpackage.kn
    public void l(ViewGroup viewGroup, tn tnVar, tn tnVar2, ArrayList<sn> arrayList, ArrayList<sn> arrayList2) {
        long j = this.g;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            kn knVar = this.C.get(i);
            if (j > 0 && (this.D || i == 0)) {
                long j2 = knVar.g;
                if (j2 > 0) {
                    knVar.F(j2 + j);
                } else {
                    knVar.F(j);
                }
            }
            knVar.l(viewGroup, tnVar, tnVar2, arrayList, arrayList2);
        }
    }

    @Override // defpackage.kn
    public void v(View view) {
        super.v(view);
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).v(view);
        }
    }

    @Override // defpackage.kn
    public kn w(kn.d dVar) {
        super.w(dVar);
        return this;
    }

    @Override // defpackage.kn
    public kn x(View view) {
        for (int i = 0; i < this.C.size(); i++) {
            this.C.get(i).x(view);
        }
        this.k.remove(view);
        return this;
    }

    @Override // defpackage.kn
    public void y(View view) {
        super.y(view);
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).y(view);
        }
    }

    @Override // defpackage.kn
    public void z() {
        if (this.C.isEmpty()) {
            G();
            m();
            return;
        }
        b bVar = new b(this);
        Iterator<kn> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.E = this.C.size();
        if (!this.D) {
            for (int i = 1; i < this.C.size(); i++) {
                this.C.get(i - 1).a(new a(this, this.C.get(i)));
            }
            kn knVar = this.C.get(0);
            if (knVar != null) {
                knVar.z();
                return;
            }
            return;
        }
        Iterator<kn> it2 = this.C.iterator();
        while (it2.hasNext()) {
            it2.next().z();
        }
    }
}
