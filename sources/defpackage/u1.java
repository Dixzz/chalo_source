package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import defpackage.v1;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: u1  reason: default package */
/* compiled from: MenuPopupHelper */
public class u1 {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final p1 mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private t1 mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private v1.a mPresenterCallback;

    /* renamed from: u1$a */
    /* compiled from: MenuPopupHelper */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public void onDismiss() {
            u1.this.onDismiss();
        }
    }

    public u1(Context context, p1 p1Var) {
        this(context, p1Var, null, false, R.attr.popupMenuStyle, 0);
    }

    private t1 createPopup() {
        t1 t1Var;
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
            t1Var = new m1(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        } else {
            t1Var = new z1(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        }
        t1Var.a(this.mMenu);
        t1Var.h(this.mInternalOnDismissListener);
        t1Var.d(this.mAnchorView);
        t1Var.setCallback(this.mPresenterCallback);
        t1Var.e(this.mForceShowIcon);
        t1Var.f(this.mDropDownGravity);
        return t1Var;
    }

    private void showPopup(int i, int i2, boolean z, boolean z2) {
        t1 popup = getPopup();
        popup.i(z2);
        if (z) {
            int i3 = this.mDropDownGravity;
            View view = this.mAnchorView;
            AtomicInteger atomicInteger = r8.f3055a;
            if ((Gravity.getAbsoluteGravity(i3, view.getLayoutDirection()) & 7) == 5) {
                i -= this.mAnchorView.getWidth();
            }
            popup.g(i);
            popup.j(i2);
            int i4 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.f = new Rect(i - i4, i2 - i4, i + i4, i2 + i4);
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    public t1 getPopup() {
        if (this.mPopup == null) {
            this.mPopup = createPopup();
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        t1 t1Var = this.mPopup;
        return t1Var != null && t1Var.isShowing();
    }

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        t1 t1Var = this.mPopup;
        if (t1Var != null) {
            t1Var.e(z);
        }
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setPresenterCallback(v1.a aVar) {
        this.mPresenterCallback = aVar;
        t1 t1Var = this.mPopup;
        if (t1Var != null) {
            t1Var.setCallback(aVar);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }

    public u1(Context context, p1 p1Var, View view) {
        this(context, p1Var, view, false, R.attr.popupMenuStyle, 0);
    }

    public u1(Context context, p1 p1Var, View view, boolean z, int i) {
        this(context, p1Var, view, z, i, 0);
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public u1(Context context, p1 p1Var, View view, boolean z, int i, int i2) {
        this.mDropDownGravity = 8388611;
        this.mInternalOnDismissListener = new a();
        this.mContext = context;
        this.mMenu = p1Var;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(i, i2, true, true);
        return true;
    }
}
