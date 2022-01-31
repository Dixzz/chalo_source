package defpackage;

import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockFaceView;
import defpackage.e9;

/* renamed from: dq4  reason: default package */
/* compiled from: ClockFaceView */
public class dq4 extends z7 {
    public final /* synthetic */ ClockFaceView d;

    public dq4(ClockFaceView clockFaceView) {
        this.d = clockFaceView;
    }

    @Override // defpackage.z7
    public void d(View view, e9 e9Var) {
        this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
        int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (intValue > 0) {
            TextView textView = this.d.C.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                e9Var.f942a.setTraversalAfter(textView);
            }
        }
        e9Var.n(e9.c.a(0, 1, intValue, 1, false, view.isSelected()));
    }
}
