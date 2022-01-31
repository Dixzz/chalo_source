package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import defpackage.w1;
import java.util.ArrayList;

/* renamed from: o1  reason: default package */
/* compiled from: MenuAdapter */
public class o1 extends BaseAdapter {
    public p1 f;
    public int g = -1;
    public boolean h;
    public final boolean i;
    public final LayoutInflater j;
    public final int k;

    public o1(p1 p1Var, LayoutInflater layoutInflater, boolean z, int i2) {
        this.i = z;
        this.j = layoutInflater;
        this.f = p1Var;
        this.k = i2;
        a();
    }

    public void a() {
        p1 p1Var = this.f;
        r1 r1Var = p1Var.v;
        if (r1Var != null) {
            p1Var.i();
            ArrayList<r1> arrayList = p1Var.j;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList.get(i2) == r1Var) {
                    this.g = i2;
                    return;
                }
            }
        }
        this.g = -1;
    }

    /* renamed from: b */
    public r1 getItem(int i2) {
        ArrayList<r1> arrayList;
        if (this.i) {
            p1 p1Var = this.f;
            p1Var.i();
            arrayList = p1Var.j;
        } else {
            arrayList = this.f.l();
        }
        int i3 = this.g;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return arrayList.get(i2);
    }

    public int getCount() {
        ArrayList<r1> arrayList;
        if (this.i) {
            p1 p1Var = this.f;
            p1Var.i();
            arrayList = p1Var.j;
        } else {
            arrayList = this.f.l();
        }
        if (this.g < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.j.inflate(this.k, viewGroup, false);
        }
        int i3 = getItem(i2).b;
        int i4 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f.m() && i3 != (i4 >= 0 ? getItem(i4).b : i3));
        w1.a aVar = (w1.a) view;
        if (this.h) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
