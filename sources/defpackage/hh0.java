package defpackage;

import android.view.View;
import app.zophop.ui.activities.UniversalPickerActivity;

/* renamed from: hh0  reason: default package */
/* compiled from: UniversalPickerActivity */
public class hh0 implements View.OnClickListener {
    public final /* synthetic */ UniversalPickerActivity f;

    public hh0(UniversalPickerActivity universalPickerActivity) {
        this.f = universalPickerActivity;
    }

    public void onClick(View view) {
        this.f.upPressed(view);
    }
}
