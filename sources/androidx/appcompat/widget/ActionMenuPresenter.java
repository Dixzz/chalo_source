package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import defpackage.a8;
import defpackage.p1;
import defpackage.v1;
import defpackage.w1;
import java.util.ArrayList;

public class ActionMenuPresenter extends k1 implements a8.a {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    public ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    public int mOpenSubMenuId;
    public OverflowMenuButton mOverflowButton;
    public OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    public final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    public OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public class ActionButtonSubmenu extends u1 {
        public ActionButtonSubmenu(Context context, a2 a2Var, View view) {
            super(context, a2Var, view, false, R.attr.actionOverflowMenuStyle);
            if (!a2Var.A.g()) {
                View view2 = ActionMenuPresenter.this.mOverflowButton;
                setAnchorView(view2 == null ? (View) ActionMenuPresenter.this.mMenuView : view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // defpackage.u1
        public void onDismiss() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.mActionButtonPopup = null;
            actionMenuPresenter.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    public class ActionMenuPopupCallback extends ActionMenuItemView.b {
        public ActionMenuPopupCallback() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public y1 getPopup() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.mActionButtonPopup;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.getPopup();
            }
            return null;
        }
    }

    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        public void run() {
            p1 p1Var;
            p1.a aVar;
            if (!(ActionMenuPresenter.this.mMenu == null || (aVar = (p1Var = ActionMenuPresenter.this.mMenu).e) == null)) {
                aVar.onMenuModeChange(p1Var);
            }
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.mPopup.tryShow())) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                /* class androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.AnonymousClass1 */

                @Override // androidx.appcompat.widget.ForwardingListener
                public y1 getPopup() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.mOverflowPopup;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.getPopup();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean onForwardingStopped() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.mPostedOpenRunnable != null) {
                        return false;
                    }
                    actionMenuPresenter.hideOverflowMenu();
                    return true;
                }
            });
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class OverflowPopup extends u1 {
        public OverflowPopup(Context context, p1 p1Var, View view, boolean z) {
            super(context, p1Var, view, z, R.attr.actionOverflowMenuStyle);
            setGravity(8388613);
            setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // defpackage.u1
        public void onDismiss() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.c(true);
            }
            ActionMenuPresenter.this.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    public class PopupPresenterCallback implements v1.a {
        public PopupPresenterCallback() {
        }

        @Override // defpackage.v1.a
        public void onCloseMenu(p1 p1Var, boolean z) {
            if (p1Var instanceof a2) {
                p1Var.k().c(false);
            }
            v1.a callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(p1Var, z);
            }
        }

        @Override // defpackage.v1.a
        public boolean onOpenSubMenu(p1 p1Var) {
            if (p1Var == ActionMenuPresenter.this.mMenu) {
                return false;
            }
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.mOpenSubMenuId = ((a2) p1Var).A.f3022a;
            v1.a callback = actionMenuPresenter.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(p1Var);
            }
            return false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.appcompat.widget.ActionMenuPresenter.SavedState.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int openSubMenuId;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof w1.a) && ((w1.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // defpackage.k1
    public void bindItemView(r1 r1Var, w1.a aVar) {
        aVar.a(r1Var, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    @Override // defpackage.k1
    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.mOverflowButton) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x013a  */
    @Override // defpackage.k1, defpackage.v1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean flagActionItems() {
        /*
        // Method dump skipped, instructions count: 341
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuPresenter.flagActionItems():boolean");
    }

    @Override // defpackage.k1
    public View getItemView(r1 r1Var, View view, ViewGroup viewGroup) {
        View actionView = r1Var.getActionView();
        if (actionView == null || r1Var.f()) {
            actionView = super.getItemView(r1Var, view, viewGroup);
        }
        actionView.setVisibility(r1Var.C ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // defpackage.k1
    public w1 getMenuView(ViewGroup viewGroup) {
        w1 w1Var = this.mMenuView;
        w1 menuView = super.getMenuView(viewGroup);
        if (w1Var != menuView) {
            ((ActionMenuView) menuView).setPresenter(this);
        }
        return menuView;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        w1 w1Var;
        OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
        if (openOverflowRunnable == null || (w1Var = this.mMenuView) == null) {
            OverflowPopup overflowPopup = this.mOverflowPopup;
            if (overflowPopup == null) {
                return false;
            }
            overflowPopup.dismiss();
            return true;
        }
        ((View) w1Var).removeCallbacks(openOverflowRunnable);
        this.mPostedOpenRunnable = null;
        return true;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    @Override // defpackage.k1, defpackage.v1
    public void initForMenu(Context context, p1 p1Var) {
        super.initForMenu(context, p1Var);
        Resources resources = context.getResources();
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = true;
        }
        int i = 2;
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = context.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.mMaxItemsSet) {
            Configuration configuration = context.getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
                i = 5;
            } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
                i = 4;
            } else if (i2 >= 360) {
                i = 3;
            }
            this.mMaxItems = i;
        }
        int i4 = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.mSystemContext);
                this.mOverflowButton = overflowMenuButton;
                if (this.mPendingOverflowIconSet) {
                    overflowMenuButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = i4;
        this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.mOverflowPopup;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // defpackage.k1, defpackage.v1
    public void onCloseMenu(p1 p1Var, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(p1Var, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            Configuration configuration2 = this.mContext.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            this.mMaxItems = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
        }
        p1 p1Var = this.mMenu;
        if (p1Var != null) {
            p1Var.q(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.mMenu.findItem(i)) != null) {
            onSubMenuSelected((a2) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    @Override // defpackage.k1, defpackage.v1
    public boolean onSubMenuSelected(a2 a2Var) {
        boolean z = false;
        if (!a2Var.hasVisibleItems()) {
            return false;
        }
        a2 a2Var2 = a2Var;
        while (true) {
            p1 p1Var = a2Var2.z;
            if (p1Var == this.mMenu) {
                break;
            }
            a2Var2 = (a2) p1Var;
        }
        View findViewForItem = findViewForItem(a2Var2.A);
        if (findViewForItem == null) {
            return false;
        }
        this.mOpenSubMenuId = a2Var.A.f3022a;
        int size = a2Var.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = a2Var.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.mContext, a2Var, findViewForItem);
        this.mActionButtonPopup = actionButtonSubmenu;
        actionButtonSubmenu.setForceShowIcon(z);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(a2Var);
        return true;
    }

    @Override // defpackage.a8.a
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
            return;
        }
        p1 p1Var = this.mMenu;
        if (p1Var != null) {
            p1Var.c(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = drawable;
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    @Override // defpackage.k1
    public boolean shouldIncludeItem(int i, r1 r1Var) {
        return r1Var.g();
    }

    public boolean showOverflowMenu() {
        p1 p1Var;
        if (!this.mReserveOverflow || isOverflowMenuShowing() || (p1Var = this.mMenu) == null || this.mMenuView == null || this.mPostedOpenRunnable != null) {
            return false;
        }
        p1Var.i();
        if (p1Var.j.isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = openOverflowRunnable;
        ((View) this.mMenuView).post(openOverflowRunnable);
        return true;
    }

    @Override // defpackage.k1, defpackage.v1
    public void updateMenuView(boolean z) {
        ArrayList<r1> arrayList;
        w1 w1Var;
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        p1 p1Var = this.mMenu;
        boolean z2 = false;
        if (p1Var != null) {
            p1Var.i();
            ArrayList<r1> arrayList2 = p1Var.i;
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                a8 a8Var = arrayList2.get(i).A;
                if (a8Var != null) {
                    a8Var.setSubUiVisibilityListener(this);
                }
            }
        }
        p1 p1Var2 = this.mMenu;
        if (p1Var2 != null) {
            p1Var2.i();
            arrayList = p1Var2.j;
        } else {
            arrayList = null;
        }
        if (this.mReserveOverflow && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z2 = !arrayList.get(0).C;
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.mOverflowButton;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == (w1Var = this.mMenuView)) {
                ((ViewGroup) w1Var).removeView(this.mOverflowButton);
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
