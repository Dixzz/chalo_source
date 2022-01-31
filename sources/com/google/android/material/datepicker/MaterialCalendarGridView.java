package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Objects;

public final class MaterialCalendarGridView extends GridView {
    public final Calendar f = pm4.g();
    public final boolean g;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (em4.f(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.g = em4.g(getContext(), R.attr.nestedScrollable);
        r8.v(this, new dm4(this));
    }

    /* renamed from: a */
    public im4 getAdapter() {
        return (im4) super.getAdapter();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        im4 a2 = getAdapter();
        DateSelector<?> dateSelector = a2.g;
        a2.getItem(a2.b());
        a2.getItem(a2.d());
        for (u7<Long, Long> u7Var : dateSelector.E()) {
            Objects.requireNonNull(u7Var);
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i, rect);
        } else if (i == 33) {
            setSelection(getAdapter().d());
        } else if (i == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    public void onMeasure(int i, int i2) {
        if (this.g) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, RtlSpacingHelper.UNDEFINED));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setSelection(int i) {
        if (i < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof im4) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), im4.class.getCanonicalName()));
        }
    }
}
