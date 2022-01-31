package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.view.menu.ExpandedMenuView;
import defpackage.e0;
import defpackage.v1;
import defpackage.w1;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: n1  reason: default package */
/* compiled from: ListMenuPresenter */
public class n1 implements v1, AdapterView.OnItemClickListener {
    public Context f;
    public LayoutInflater g;
    public p1 h;
    public ExpandedMenuView i;
    public int j;
    public v1.a k;
    public a l;

    /* renamed from: n1$a */
    /* compiled from: ListMenuPresenter */
    public class a extends BaseAdapter {
        public int f = -1;

        public a() {
            a();
        }

        public void a() {
            p1 p1Var = n1.this.h;
            r1 r1Var = p1Var.v;
            if (r1Var != null) {
                p1Var.i();
                ArrayList<r1> arrayList = p1Var.j;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (arrayList.get(i) == r1Var) {
                        this.f = i;
                        return;
                    }
                }
            }
            this.f = -1;
        }

        /* renamed from: b */
        public r1 getItem(int i) {
            p1 p1Var = n1.this.h;
            p1Var.i();
            ArrayList<r1> arrayList = p1Var.j;
            Objects.requireNonNull(n1.this);
            int i2 = i + 0;
            int i3 = this.f;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return arrayList.get(i2);
        }

        public int getCount() {
            p1 p1Var = n1.this.h;
            p1Var.i();
            int size = p1Var.j.size();
            Objects.requireNonNull(n1.this);
            int i = size + 0;
            return this.f < 0 ? i : i - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                n1 n1Var = n1.this;
                view = n1Var.g.inflate(n1Var.j, viewGroup, false);
            }
            ((w1.a) view).a(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public n1(Context context, int i2) {
        this.j = i2;
        this.f = context;
        this.g = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.l == null) {
            this.l = new a();
        }
        return this.l;
    }

    @Override // defpackage.v1
    public boolean collapseItemActionView(p1 p1Var, r1 r1Var) {
        return false;
    }

    @Override // defpackage.v1
    public boolean expandItemActionView(p1 p1Var, r1 r1Var) {
        return false;
    }

    @Override // defpackage.v1
    public boolean flagActionItems() {
        return false;
    }

    @Override // defpackage.v1
    public void initForMenu(Context context, p1 p1Var) {
        if (this.f != null) {
            this.f = context;
            if (this.g == null) {
                this.g = LayoutInflater.from(context);
            }
        }
        this.h = p1Var;
        a aVar = this.l;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // defpackage.v1
    public void onCloseMenu(p1 p1Var, boolean z) {
        v1.a aVar = this.k;
        if (aVar != null) {
            aVar.onCloseMenu(p1Var, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.h.s(this.l.getItem(i2), this, 0);
    }

    @Override // defpackage.v1
    public boolean onSubMenuSelected(a2 a2Var) {
        if (!a2Var.hasVisibleItems()) {
            return false;
        }
        q1 q1Var = new q1(a2Var);
        e0.a aVar = new e0.a(a2Var.f2757a);
        n1 n1Var = new n1(aVar.f908a.f194a, R.layout.abc_list_menu_item_layout);
        q1Var.h = n1Var;
        n1Var.k = q1Var;
        p1 p1Var = q1Var.f;
        p1Var.b(n1Var, p1Var.f2757a);
        ListAdapter a2 = q1Var.h.a();
        AlertController.b bVar = aVar.f908a;
        bVar.o = a2;
        bVar.p = q1Var;
        View view = a2Var.o;
        if (view != null) {
            bVar.e = view;
        } else {
            bVar.c = a2Var.n;
            bVar.d = a2Var.m;
        }
        bVar.m = q1Var;
        e0 a3 = aVar.a();
        q1Var.g = a3;
        a3.setOnDismissListener(q1Var);
        WindowManager.LayoutParams attributes = q1Var.g.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        q1Var.g.show();
        v1.a aVar2 = this.k;
        if (aVar2 == null) {
            return true;
        }
        aVar2.onOpenSubMenu(a2Var);
        return true;
    }

    @Override // defpackage.v1
    public void setCallback(v1.a aVar) {
        this.k = aVar;
    }

    @Override // defpackage.v1
    public void updateMenuView(boolean z) {
        a aVar = this.l;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }
}
