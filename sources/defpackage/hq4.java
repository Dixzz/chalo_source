package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;

/* renamed from: hq4  reason: default package */
/* compiled from: TimePickerView */
public class hq4 implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector f;

    public hq4(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.f = gestureDetector;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f.onTouchEvent(motionEvent);
        }
        return false;
    }
}
