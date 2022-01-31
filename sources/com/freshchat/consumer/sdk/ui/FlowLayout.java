package com.freshchat.consumer.sdk.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.freshchat.consumer.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    private static final String md = FlowLayout.class.getSimpleName();
    private boolean me;
    private int mf;
    private int mg;
    private int mh;
    private float mi;
    private float mj;
    private boolean mk;
    private int ml;
    private int mm;
    private int mn;
    private int mo;
    private List<Float> mp;
    private List<Integer> mq;
    private List<Integer> mr;
    private List<Integer> ms;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.me = true;
        this.mf = 0;
        this.mg = 0;
        this.mh = -65538;
        this.mi = 0.0f;
        this.mj = 0.0f;
        this.mk = false;
        this.ml = Integer.MAX_VALUE;
        this.mm = -1;
        this.mn = -65536;
        this.mp = new ArrayList();
        this.mq = new ArrayList();
        this.mr = new ArrayList();
        this.ms = new ArrayList();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.freshchatFlowLayout, 0, 0);
        try {
            this.me = obtainStyledAttributes.getBoolean(R.styleable.freshchatFlowLayout_freshchatFlFlow, true);
            try {
                this.mf = obtainStyledAttributes.getInt(R.styleable.freshchatFlowLayout_freshchatFlChildSpacing, 0);
            } catch (NumberFormatException unused) {
                this.mf = obtainStyledAttributes.getDimensionPixelSize(R.styleable.freshchatFlowLayout_freshchatFlChildSpacing, (int) a(0.0f));
            }
            try {
                this.mg = obtainStyledAttributes.getInt(R.styleable.freshchatFlowLayout_freshchatFlMinChildSpacing, 0);
            } catch (NumberFormatException unused2) {
                this.mg = obtainStyledAttributes.getDimensionPixelSize(R.styleable.freshchatFlowLayout_freshchatFlMinChildSpacing, (int) a(0.0f));
            }
            try {
                this.mh = obtainStyledAttributes.getInt(R.styleable.freshchatFlowLayout_freshchatFlChildSpacingForLastRow, -65538);
            } catch (NumberFormatException unused3) {
                this.mh = obtainStyledAttributes.getDimensionPixelSize(R.styleable.freshchatFlowLayout_freshchatFlChildSpacingForLastRow, (int) a(0.0f));
            }
            try {
                this.mi = (float) obtainStyledAttributes.getInt(R.styleable.freshchatFlowLayout_freshchatFlRowSpacing, 0);
            } catch (NumberFormatException unused4) {
                this.mi = obtainStyledAttributes.getDimension(R.styleable.freshchatFlowLayout_freshchatFlRowSpacing, a(0.0f));
            }
            this.ml = obtainStyledAttributes.getInt(R.styleable.freshchatFlowLayout_freshchatFlMaxRows, Integer.MAX_VALUE);
            this.mk = obtainStyledAttributes.getBoolean(R.styleable.freshchatFlowLayout_freshchatFlRtl, false);
            this.mm = obtainStyledAttributes.getInt(R.styleable.freshchatFlowLayout_android_gravity, -1);
            this.mn = obtainStyledAttributes.getInt(R.styleable.freshchatFlowLayout_freshchatFlRowVerticalGravity, -65536);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private float a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private int a(int i, int i2, int i3, int i4) {
        if (this.mf == -65536 || i4 >= this.mr.size() || i4 >= this.ms.size() || this.ms.get(i4).intValue() <= 0) {
            return 0;
        }
        if (i == 1) {
            return ((i2 - i3) - this.mr.get(i4).intValue()) / 2;
        }
        if (i != 5) {
            return 0;
        }
        return (i2 - i3) - this.mr.get(i4).intValue();
    }

    private float b(int i, int i2, int i3, int i4) {
        if (i != -65536) {
            return (float) i;
        }
        if (i4 > 1) {
            return (float) ((i2 - i3) / (i4 - 1));
        }
        return 0.0f;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.mf;
    }

    public int getChildSpacingForLastRow() {
        return this.mh;
    }

    public int getMaxRows() {
        return this.ml;
    }

    public int getMinChildSpacing() {
        return this.mg;
    }

    public float getRowSpacing() {
        return this.mi;
    }

    public int getRowsCount() {
        return this.ms.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
        // Method dump skipped, instructions count: 361
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.ui.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x025e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r27, int r28) {
        /*
        // Method dump skipped, instructions count: 611
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.ui.FlowLayout.onMeasure(int, int):void");
    }

    public void setChildSpacing(int i) {
        this.mf = i;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i) {
        this.mh = i;
        requestLayout();
    }

    public void setFlow(boolean z) {
        this.me = z;
        requestLayout();
    }

    public void setGravity(int i) {
        if (this.mm != i) {
            this.mm = i;
            requestLayout();
        }
    }

    public void setMaxRows(int i) {
        this.ml = i;
        requestLayout();
    }

    public void setMinChildSpacing(int i) {
        this.mg = i;
        requestLayout();
    }

    public void setRowSpacing(float f) {
        this.mi = f;
        requestLayout();
    }

    public void setRowVerticalGravity(int i) {
        if (this.mn != i) {
            this.mn = i;
            requestLayout();
        }
    }

    public void setRtl(boolean z) {
        this.mk = z;
        requestLayout();
    }
}
