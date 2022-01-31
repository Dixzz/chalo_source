package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: a8  reason: default package */
/* compiled from: ActionProvider */
public abstract class a8 {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private a mSubUiVisibilityListener;
    private b mVisibilityListener;

    /* renamed from: a8$a */
    /* compiled from: ActionProvider */
    public interface a {
        void onSubUiVisibilityChanged(boolean z);
    }

    /* renamed from: a8$b */
    /* compiled from: ActionProvider */
    public interface b {
    }

    public a8(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            b bVar = this.mVisibilityListener;
            isVisible();
            p1 p1Var = r1.this.n;
            p1Var.h = true;
            p1Var.q(true);
        }
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(a aVar) {
        this.mSubUiVisibilityListener = aVar;
    }

    public void setVisibilityListener(b bVar) {
        if (!(this.mVisibilityListener == null || bVar == null)) {
            getClass().getSimpleName();
        }
        this.mVisibilityListener = bVar;
    }

    public void subUiVisibilityChanged(boolean z) {
        a aVar = this.mSubUiVisibilityListener;
        if (aVar != null) {
            aVar.onSubUiVisibilityChanged(z);
        }
    }
}
