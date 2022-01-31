package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Objects;

/* renamed from: gq4  reason: default package */
/* compiled from: TimePickerView */
public class gq4 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView f;

    public gq4(TimePickerView timePickerView) {
        this.f = timePickerView;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView timePickerView = this.f;
        int i = TimePickerView.A;
        Objects.requireNonNull(timePickerView);
        return onDoubleTap;
    }
}
