package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: t1  reason: default package */
/* compiled from: MenuPopup */
public abstract class t1 implements y1, v1, AdapterView.OnItemClickListener {
    public Rect f;

    public static int c(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        o1 o1Var = (o1) listAdapter;
        int count = o1Var.getCount();
        FrameLayout frameLayout = null;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = o1Var.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = o1Var.getView(i4, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean k(p1 p1Var) {
        int size = p1Var.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = p1Var.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void a(p1 p1Var);

    public boolean b() {
        return true;
    }

    @Override // defpackage.v1
    public boolean collapseItemActionView(p1 p1Var, r1 r1Var) {
        return false;
    }

    public abstract void d(View view);

    public abstract void e(boolean z);

    @Override // defpackage.v1
    public boolean expandItemActionView(p1 p1Var, r1 r1Var) {
        return false;
    }

    public abstract void f(int i);

    public abstract void g(int i);

    public abstract void h(PopupWindow.OnDismissListener onDismissListener);

    public abstract void i(boolean z);

    @Override // defpackage.v1
    public void initForMenu(Context context, p1 p1Var) {
    }

    public abstract void j(int i);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o1 o1Var;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            o1Var = (o1) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            o1Var = (o1) listAdapter;
        }
        o1Var.f.s((MenuItem) listAdapter.getItem(i), this, b() ? 0 : 4);
    }
}
