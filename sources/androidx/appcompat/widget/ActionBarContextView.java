package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class ActionBarContextView extends AbsActionBarView {
    private View mClose;
    private View mCloseButton;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void initTitle() {
        if (this.mTitleLayout == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleLayout = linearLayout;
            this.mTitleView = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean z = !TextUtils.isEmpty(this.mTitle);
        boolean z2 = !TextUtils.isEmpty(this.mSubtitle);
        int i = 0;
        this.mSubtitleView.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.mTitleLayout;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        if (this.mTitleLayout.getParent() == null) {
            addView(this.mTitleLayout);
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int i) {
        super.animateToVisibility(i);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.mClose == null) {
            killMode();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public void initForMode(final b1 b1Var) {
        View view = this.mClose;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, (ViewGroup) this, false);
            this.mClose = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.mClose);
        }
        View findViewById = this.mClose.findViewById(R.id.action_mode_close_button);
        this.mCloseButton = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class androidx.appcompat.widget.ActionBarContextView.AnonymousClass1 */

            public void onClick(View view) {
                b1Var.a();
            }
        });
        p1 p1Var = (p1) b1Var.c();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = actionMenuPresenter2;
        actionMenuPresenter2.setReserveOverflow(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        p1Var.b(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = actionMenuView;
        AtomicInteger atomicInteger = r8.f3055a;
        actionMenuView.setBackground(null);
        addView(this.mMenuView, layoutParams);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View view = this.mCloseButton;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.mTitle);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingRight = isLayoutRtl ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.mClose;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
            int i5 = isLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = isLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int next = AbsActionBarView.next(paddingRight, i5, isLayoutRtl);
            paddingRight = AbsActionBarView.next(next + positionChild(this.mClose, next, paddingTop, paddingTop2, isLayoutRtl), i6, isLayoutRtl);
        }
        int i7 = paddingRight;
        LinearLayout linearLayout = this.mTitleLayout;
        if (!(linearLayout == null || this.mCustomView != null || linearLayout.getVisibility() == 8)) {
            i7 += positionChild(this.mTitleLayout, i7, paddingTop, paddingTop2, isLayoutRtl);
        }
        View view2 = this.mCustomView;
        if (view2 != null) {
            positionChild(view2, i7, paddingTop, paddingTop2, isLayoutRtl);
        }
        int paddingLeft = isLayoutRtl ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            positionChild(actionMenuView, paddingLeft, paddingTop, paddingTop2, !isLayoutRtl);
        }
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int i3 = CommonUtils.BYTES_IN_A_GIGABYTE;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int i4 = this.mContentHeight;
            if (i4 <= 0) {
                i4 = View.MeasureSpec.getSize(i2);
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = i4 - paddingBottom;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, RtlSpacingHelper.UNDEFINED);
            View view = this.mClose;
            if (view != null) {
                int measureChildView = measureChildView(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
                paddingLeft = measureChildView - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.mTitleLayout;
            if (linearLayout != null && this.mCustomView == null) {
                if (this.mTitleOptional) {
                    this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.mTitleLayout.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.mTitleLayout.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = measureChildView(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.mCustomView;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i6 = layoutParams.width;
                int i7 = i6 != -2 ? CommonUtils.BYTES_IN_A_GIGABYTE : RtlSpacingHelper.UNDEFINED;
                if (i6 >= 0) {
                    paddingLeft = Math.min(i6, paddingLeft);
                }
                int i8 = layoutParams.height;
                if (i8 == -2) {
                    i3 = RtlSpacingHelper.UNDEFINED;
                }
                if (i8 >= 0) {
                    i5 = Math.min(i8, i5);
                }
                this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i7), View.MeasureSpec.makeMeasureSpec(i5, i3));
            }
            if (this.mContentHeight <= 0) {
                int childCount = getChildCount();
                int i9 = 0;
                for (int i10 = 0; i10 < childCount; i10++) {
                    int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingBottom;
                    if (measuredHeight > i9) {
                        i9 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i9);
                return;
            }
            setMeasuredDimension(size, i4);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.mCustomView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mCustomView = view;
        if (!(view == null || (linearLayout = this.mTitleLayout) == null)) {
            removeView(linearLayout);
            this.mTitleLayout = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        initTitle();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.mTitleOptional) {
            requestLayout();
        }
        this.mTitleOptional = z;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ y8 setupAnimatorToVisibility(int i, long j) {
        return super.setupAnimatorToVisibility(i, j);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.ActionMode, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActionMode_background);
        AtomicInteger atomicInteger = r8.f3055a;
        setBackground(drawable);
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }
}
