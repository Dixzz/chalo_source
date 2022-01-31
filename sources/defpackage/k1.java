package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.v1;
import defpackage.w1;
import java.util.ArrayList;

/* renamed from: k1  reason: default package */
/* compiled from: BaseMenuPresenter */
public abstract class k1 implements v1 {
    private v1.a mCallback;
    public Context mContext;
    private int mId;
    public LayoutInflater mInflater;
    private int mItemLayoutRes;
    public p1 mMenu;
    private int mMenuLayoutRes;
    public w1 mMenuView;
    public Context mSystemContext;
    public LayoutInflater mSystemInflater;

    public k1(Context context, int i, int i2) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
        this.mMenuLayoutRes = i;
        this.mItemLayoutRes = i2;
    }

    public void addItemView(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.mMenuView).addView(view, i);
    }

    public abstract void bindItemView(r1 r1Var, w1.a aVar);

    @Override // defpackage.v1
    public boolean collapseItemActionView(p1 p1Var, r1 r1Var) {
        return false;
    }

    public w1.a createItemView(ViewGroup viewGroup) {
        return (w1.a) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    @Override // defpackage.v1
    public boolean expandItemActionView(p1 p1Var, r1 r1Var) {
        return false;
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // defpackage.v1
    public abstract boolean flagActionItems();

    public v1.a getCallback() {
        return this.mCallback;
    }

    public int getId() {
        return this.mId;
    }

    public View getItemView(r1 r1Var, View view, ViewGroup viewGroup) {
        w1.a aVar;
        if (view instanceof w1.a) {
            aVar = (w1.a) view;
        } else {
            aVar = createItemView(viewGroup);
        }
        bindItemView(r1Var, aVar);
        return (View) aVar;
    }

    public w1 getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            w1 w1Var = (w1) this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false);
            this.mMenuView = w1Var;
            w1Var.initialize(this.mMenu);
            updateMenuView(true);
        }
        return this.mMenuView;
    }

    @Override // defpackage.v1
    public void initForMenu(Context context, p1 p1Var) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMenu = p1Var;
    }

    @Override // defpackage.v1
    public void onCloseMenu(p1 p1Var, boolean z) {
        v1.a aVar = this.mCallback;
        if (aVar != null) {
            aVar.onCloseMenu(p1Var, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [p1] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.v1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSubMenuSelected(defpackage.a2 r2) {
        /*
            r1 = this;
            v1$a r0 = r1.mCallback
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            p1 r2 = r1.mMenu
        L_0x0009:
            boolean r2 = r0.onOpenSubMenu(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k1.onSubMenuSelected(a2):boolean");
    }

    @Override // defpackage.v1
    public void setCallback(v1.a aVar) {
        this.mCallback = aVar;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public abstract boolean shouldIncludeItem(int i, r1 r1Var);

    @Override // defpackage.v1
    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup != null) {
            p1 p1Var = this.mMenu;
            int i = 0;
            if (p1Var != null) {
                p1Var.i();
                ArrayList<r1> l = this.mMenu.l();
                int size = l.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    r1 r1Var = l.get(i3);
                    if (shouldIncludeItem(i2, r1Var)) {
                        View childAt = viewGroup.getChildAt(i2);
                        r1 itemData = childAt instanceof w1.a ? ((w1.a) childAt).getItemData() : null;
                        View itemView = getItemView(r1Var, childAt, viewGroup);
                        if (r1Var != itemData) {
                            itemView.setPressed(false);
                            itemView.jumpDrawablesToCurrentState();
                        }
                        if (itemView != childAt) {
                            addItemView(itemView, i2);
                        }
                        i2++;
                    }
                }
                i = i2;
            }
            while (i < viewGroup.getChildCount()) {
                if (!filterLeftoverView(viewGroup, i)) {
                    i++;
                }
            }
        }
    }
}
