package com.freshchat.consumer.sdk.ui;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

public class e extends RecyclerView.l {
    private final f pO;
    private int pP;

    public e(f fVar) {
        this.pO = fVar;
    }

    private View a(int i, RecyclerView recyclerView) {
        View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(this.pO.N(i), (ViewGroup) recyclerView, false);
        this.pO.c(inflate, i);
        return inflate;
    }

    private View a(RecyclerView recyclerView, int i, int i2) {
        int i3 = 0;
        while (i3 < recyclerView.getChildCount()) {
            View childAt = recyclerView.getChildAt(i3);
            if ((childAt.getTop() > 0 ? childAt.getBottom() + ((i2 == i3 || !this.pO.O(recyclerView.I(childAt))) ? 0 : this.pP - childAt.getHeight()) : childAt.getBottom()) > i && childAt.getTop() <= i) {
                return childAt;
            }
            i3++;
        }
        return null;
    }

    private void a(Canvas canvas, View view) {
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        view.draw(canvas);
        canvas.restore();
    }

    private void a(Canvas canvas, View view, View view2) {
        canvas.save();
        canvas.translate(0.0f, (float) (view2.getTop() - view.getHeight()));
        view.draw(canvas);
        canvas.restore();
    }

    private void a(ViewGroup viewGroup, View view) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), CommonUtils.BYTES_IN_A_GIGABYTE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(viewGroup.getHeight(), 0);
        view.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, viewGroup.getPaddingRight() + viewGroup.getPaddingLeft(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(makeMeasureSpec2, viewGroup.getPaddingBottom() + viewGroup.getPaddingTop(), view.getLayoutParams().height));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        this.pP = measuredHeight;
        view.layout(0, 0, measuredWidth, measuredHeight);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        int I;
        super.onDrawOver(canvas, recyclerView, xVar);
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null && (I = recyclerView.I(childAt)) != -1) {
            int M = this.pO.M(I);
            View a2 = a(M, recyclerView);
            a(recyclerView, a2);
            View a3 = a(recyclerView, a2.getBottom(), M);
            if (a3 == null || !this.pO.O(recyclerView.I(a3))) {
                a(canvas, a2);
            } else {
                a(canvas, a2, a3);
            }
        }
    }
}
