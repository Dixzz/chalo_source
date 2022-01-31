package defpackage;

import android.content.Context;

/* renamed from: v1  reason: default package */
/* compiled from: MenuPresenter */
public interface v1 {

    /* renamed from: v1$a */
    /* compiled from: MenuPresenter */
    public interface a {
        void onCloseMenu(p1 p1Var, boolean z);

        boolean onOpenSubMenu(p1 p1Var);
    }

    boolean collapseItemActionView(p1 p1Var, r1 r1Var);

    boolean expandItemActionView(p1 p1Var, r1 r1Var);

    boolean flagActionItems();

    void initForMenu(Context context, p1 p1Var);

    void onCloseMenu(p1 p1Var, boolean z);

    boolean onSubMenuSelected(a2 a2Var);

    void setCallback(a aVar);

    void updateMenuView(boolean z);
}
