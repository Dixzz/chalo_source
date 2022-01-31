package defpackage;

import android.view.View;
import app.zophop.ui.activities.UniversalPickerActivity;

/* renamed from: ih0  reason: default package */
/* compiled from: UniversalPickerActivity */
public class ih0 implements View.OnClickListener {
    public final /* synthetic */ UniversalPickerActivity f;

    public ih0(UniversalPickerActivity universalPickerActivity) {
        this.f = universalPickerActivity;
    }

    public void onClick(View view) {
        this.f.clear(view);
    }
}
