package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.TintTypedArray;
import defpackage.p1;

public final class ExpandedMenuView extends ListView implements p1.b, w1, AdapterView.OnItemClickListener {
    public static final int[] g = {16842964, 16843049};
    public p1 f;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, g, 16842868, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            setDivider(obtainStyledAttributes.getDrawable(1));
        }
        obtainStyledAttributes.recycle();
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // defpackage.w1
    public void initialize(p1 p1Var) {
        this.f = p1Var;
    }

    @Override // defpackage.p1.b
    public boolean invokeItem(r1 r1Var) {
        return this.f.s(r1Var, null, 0);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        invokeItem((r1) getAdapter().getItem(i));
    }
}
