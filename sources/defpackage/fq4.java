package defpackage;

import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Objects;

/* renamed from: fq4  reason: default package */
/* compiled from: TimePickerView */
public class fq4 implements MaterialButtonToggleGroup.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerView f1159a;

    public fq4(TimePickerView timePickerView) {
        this.f1159a = timePickerView;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
    public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        TimePickerView timePickerView = this.f1159a;
        int i2 = TimePickerView.A;
        Objects.requireNonNull(timePickerView);
    }
}
