package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public Map<View, Integer> i;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, com.google.android.material.transformation.ExpandableTransformationBehavior
    public boolean C(View view, View view2, boolean z, boolean z2) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.i = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                boolean z3 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f201a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z3) {
                    if (!z) {
                        Map<View, Integer> map = this.i;
                        if (map != null && map.containsKey(childAt)) {
                            int intValue = this.i.get(childAt).intValue();
                            AtomicInteger atomicInteger = r8.f3055a;
                            childAt.setImportantForAccessibility(intValue);
                        }
                    } else {
                        this.i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        AtomicInteger atomicInteger2 = r8.f3055a;
                        childAt.setImportantForAccessibility(4);
                    }
                }
            }
            if (!z) {
                this.i = null;
            }
        }
        super.C(view, view2, z, z2);
        return true;
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public FabTransformationBehavior.b N(Context context, boolean z) {
        int i2;
        if (z) {
            i2 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i2 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.b bVar = new FabTransformationBehavior.b();
        bVar.f647a = fk4.b(context, i2);
        bVar.b = new hk4(17, 0.0f, 0.0f);
        return bVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
